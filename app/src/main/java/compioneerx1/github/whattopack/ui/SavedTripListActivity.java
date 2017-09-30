package compioneerx1.github.whattopack.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;
import compioneerx1.github.whattopack.Constants;
import compioneerx1.github.whattopack.R;
import compioneerx1.github.whattopack.adapters.FirebaseTripListAdapter;
import compioneerx1.github.whattopack.adapters.FirebaseTripViewHolder;
import compioneerx1.github.whattopack.models.Trip;
import compioneerx1.github.whattopack.util.OnStartDragListener;
import compioneerx1.github.whattopack.util.SimpleItemTouchHelperCallback;

public class SavedTripListActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_trip_list);
    }

}
