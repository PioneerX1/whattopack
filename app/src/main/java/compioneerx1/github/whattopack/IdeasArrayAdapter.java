package compioneerx1.github.whattopack;


import android.content.Context;
import android.widget.ArrayAdapter;

public class IdeasArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mPlaces;
    private String[] mActivities;

    public IdeasArrayAdapter(Context mContext, int resource, String[] mPlaces, String[] mActivities) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mPlaces = mPlaces;
        this.mActivities = mActivities;
    }

    @Override
    public Object getItem(int position) {
        String place = mPlaces[position];
        String activity = mActivities[position];
        return String.format("%s in %s", activity, place);
    }

    @Override
    public int getCount() {
        return mPlaces.length;
    }
}
