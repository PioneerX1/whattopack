package compioneerx1.github.whattopack.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import compioneerx1.github.whattopack.Constants;
import compioneerx1.github.whattopack.R;
import compioneerx1.github.whattopack.adapters.ForecastListAdapter;
import compioneerx1.github.whattopack.models.DailyForecast;
import compioneerx1.github.whattopack.models.Trip;
import compioneerx1.github.whattopack.services.OpenWeatherService;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ResultsActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference mSavedTripReference;
    private ValueEventListener mSavedTripReferenceListener;

    public static final String TAG = ResultsActivity.class.getSimpleName();

    @Bind(R.id.inputSummaryTextView) TextView mInputSummaryTextView;
    @Bind(R.id.forecastListView) ListView mForecastListView;
    @Bind(R.id.saveTripButton) Button mSaveTripButton;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private ForecastListAdapter mAdapter;

    public ArrayList<DailyForecast> mForecasts = new ArrayList<>();

    String saveLocation;
    String savePurpose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        Intent oldIntent = getIntent();
        final String location = oldIntent.getStringExtra("location");
        final String purpose = oldIntent.getStringExtra("purpose");

        saveLocation = location;
        savePurpose = purpose;

        getWeather(location);

        mInputSummaryTextView.setText("Location: " + location + "\n"+ "Purpose: " + purpose);
        mSaveTripButton.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        if (v == mSaveTripButton) {
            saveTrip();
        }
    }

    private void saveTrip() {

        mSavedTripReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_TRIP);

        mSavedTripReferenceListener = mSavedTripReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot tripSnapshot : dataSnapshot.getChildren()) {
                    String individualTrip = tripSnapshot.getValue().toString();
                    Log.d("Trip updated", "individualTrip: " + individualTrip);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Trip newTrip = new Trip(saveLocation, savePurpose);
        Toast.makeText(ResultsActivity.this, "Trip Saved with Location: " + newTrip.getLocation() + ", Purpose: " + newTrip.getPurpose(), Toast.LENGTH_SHORT).show();
        mSavedTripReference.push().setValue(newTrip);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSavedTripReference.removeEventListener(mSavedTripReferenceListener);
    }


}
