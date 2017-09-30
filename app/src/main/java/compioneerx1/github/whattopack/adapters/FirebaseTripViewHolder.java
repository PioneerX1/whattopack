package compioneerx1.github.whattopack.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

import compioneerx1.github.whattopack.Constants;
import compioneerx1.github.whattopack.R;
import compioneerx1.github.whattopack.models.Trip;
import compioneerx1.github.whattopack.ui.ResultsActivity;

public class FirebaseTripViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;
    public TextView mTripLocationTextView;

    public FirebaseTripViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindTrip(Trip trip) {
        mTripLocationTextView = (TextView) mView.findViewById(R.id.tripLocationTextView);
        TextView tripPurposeTextView = (TextView) mView.findViewById(R.id.tripPurposeTextView);

        tripPurposeTextView.setText(trip.getPurpose());
        mTripLocationTextView.setText(trip.getLocation());
    }

    @Override
    public void onClick(View view) {
        // NO REAL EVENT LISTENERS NEEDED RIGHT NOW
//        final ArrayList<Trip> trips = new ArrayList<>();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_TRIP);
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//
//           @Override
//           public void onDataChange(DataSnapshot dataSnapshot) {
//               for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                   trips.add(snapshot.getValue(Trip.class));
//               }
//               int itemPosition = getLayoutPosition();
//
//               Intent intent = new Intent(mContext, ResultsActivity.class);  // this will need to be refactored, other wise they could save it twice
//               intent.putExtra("position", itemPosition + "");
//               intent.putExtra("trips", Parcels.wrap(trips));
//
//               mContext.startActivity(intent);
//           }
//
//           @Override
//           public void onCancelled(DatabaseError databaseError) {
//               // nothing yet
//           }
//
//        });
    }

}
