package compioneerx1.github.whattopack.adapters;


import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v4.view.MotionEventCompat;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import butterknife.Bind;
import butterknife.ButterKnife;
import compioneerx1.github.whattopack.R;
import compioneerx1.github.whattopack.models.Trip;
import compioneerx1.github.whattopack.util.ItemTouchHelperAdapter;
import compioneerx1.github.whattopack.util.OnStartDragListener;

public class FirebaseTripListAdapter extends FirebaseRecyclerAdapter<Trip, FirebaseTripViewHolder> implements ItemTouchHelperAdapter {

    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;
    private int mOrientation;

    public FirebaseTripListAdapter(Class<Trip> modelClass, int modelLayout, Class<FirebaseTripViewHolder> viewHolderClass,
                                   Query ref, OnStartDragListener onStartDragListener, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;
    }

    @Override
    protected void populateViewHolder(final FirebaseTripViewHolder viewHolder, Trip model, int position) {
        viewHolder.bindTrip(model);

        mOrientation = viewHolder.itemView.getResources().getConfiguration().orientation;
        if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            createLandscapeFragment();
        }

        viewHolder.mTripLocationTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mOnStartDragListener.onStartDrag(viewHolder);
                }
                return false;
            }
        });
    }

    private void createLandscapeFragment() {
        FragmentTransaction ft = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
        ft.commit();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        notifyItemMoved(fromPosition, toPosition);
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        getRef(position).removeValue();
    }
}
