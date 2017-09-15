package compioneerx1.github.whattopack;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import compioneerx1.github.whattopack.models.DailyForecast;
import compioneerx1.github.whattopack.services.OpenWeatherService;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ResultsActivity extends AppCompatActivity {

    public static final String TAG = ResultsActivity.class.getSimpleName();

    @Bind(R.id.inputSummaryTextView) TextView mInputSummaryTextView;

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
                        String[] forecastPreviews = new String[mForecasts.size()];
                        for (int i = 0; i < forecastPreviews.length; i++) {
                            forecastPreviews[i] = mForecasts.get(i).getDate();  // might need more than date here, conditions?
                        }
                        ArrayAdapter adapter = new ArrayAdapter(ResultsActivity.this, android.R.layout.simple_list_item_1, forecastPreviews);

                    }
                });

            }

        });
    }


}
