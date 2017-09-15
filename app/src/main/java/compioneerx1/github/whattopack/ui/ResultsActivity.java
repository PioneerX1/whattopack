package compioneerx1.github.whattopack.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import compioneerx1.github.whattopack.R;
import compioneerx1.github.whattopack.adapters.ForecastListAdapter;
import compioneerx1.github.whattopack.models.DailyForecast;
import compioneerx1.github.whattopack.services.OpenWeatherService;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ResultsActivity extends AppCompatActivity {

    public static final String TAG = ResultsActivity.class.getSimpleName();

    @Bind(R.id.inputSummaryTextView) TextView mInputSummaryTextView;
    @Bind(R.id.forecastListView) ListView mForecastListView;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private ForecastListAdapter mAdapter;

    public ArrayList<DailyForecast> mForecasts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        Intent oldIntent = getIntent();
        final String location = oldIntent.getStringExtra("location");

        getWeather(location);

        String dates = oldIntent.getStringExtra("dates");
        String purpose = oldIntent.getStringExtra("purpose");
        mInputSummaryTextView.setText("Location Specified: " + location + "\n" + "Dates Specified: " + dates + "\n"+ "Purpose: " + purpose);

    }

    private void getWeather(String location) {
        final OpenWeatherService openWeatherService = new OpenWeatherService();
        openWeatherService.findWeather(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {

                mForecasts = openWeatherService.processResults(response);
                ResultsActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        mAdapter = new ForecastListAdapter(getApplicationContext(), mForecasts);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ResultsActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);

                    }
                });

            }

        });
    }


}
