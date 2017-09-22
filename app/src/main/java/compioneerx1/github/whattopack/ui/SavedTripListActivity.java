package compioneerx1.github.whattopack.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;
import compioneerx1.github.whattopack.Constants;
import compioneerx1.github.whattopack.R;
import compioneerx1.github.whattopack.adapters.FirebaseTripViewHolder;
import compioneerx1.github.whattopack.models.Trip;

public class SavedTripListActivity extends AppCompatActivity {

    private DatabaseReference mTripsReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.tripsRecyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_trip_list);
        ButterKnife.bind(this);

        mTripsReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_TRIP);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Trip, FirebaseTripViewHolder>
                (Trip.class, R.layout.trip_list_item, FirebaseTripViewHolder.class, mTripsReference) {

            @Override
            protected void populateViewHolder(FirebaseTripViewHolder viewHolder, Trip model, int position) {
                viewHolder.bindTrip(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

}