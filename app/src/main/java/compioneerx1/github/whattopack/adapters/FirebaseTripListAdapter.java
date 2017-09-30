package compioneerx1.github.whattopack.adapters;


import android.content.Context;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import compioneerx1.github.whattopack.models.Trip;
import compioneerx1.github.whattopack.util.ItemTouchHelperAdapter;
import compioneerx1.github.whattopack.util.OnStartDragListener;

public class FirebaseTripListAdapter extends FirebaseRecyclerAdapter<Trip, FirebaseTripViewHolder> implements ItemTouchHelperAdapter {

    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;

    public FirebaseTripListAdapter(Class<Trip> modelClass, int modelLayout, Class<FirebaseTripViewHolder> viewHolderClass,
                                   Query ref, OnStartDragListener onStartDragListener, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;
    }

    @Override
    protected void populateViewHolder(FirebaseTripViewHolder viewHolder, Trip model, int position) {
        viewHolder.bindTrip(model);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {

    }
}
