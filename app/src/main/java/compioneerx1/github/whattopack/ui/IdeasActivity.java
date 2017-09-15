package compioneerx1.github.whattopack.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import compioneerx1.github.whattopack.adapters.IdeasArrayAdapter;
import compioneerx1.github.whattopack.R;

public class IdeasActivity extends AppCompatActivity {

    @Bind(R.id.ideasListView)
    ListView mIdeaListView;

    private String[] ideaPlaces = new String[] {
            "Venice, Italy", "Buenos Aires, Argentina", "Reyjkavik, Iceland", "San Diego, CA", "Osaka, Japan",
            "Kenya, Africa", "Chernobyl, Russia", "Chicago, IL", "Miami, FL", "Mars", "The Moon",
            "Kentucky"
    };
    private String[] ideaActivities = new String[] {
            "Gondola cruising", "Museum touring", "Arctic treking", "Relaxing by the Beach", "Dolphin clubbing",
            "Lion hunting", "Nuclear dumpster diving", "Hot dog eating contests", "Hurricane watching", "Terraforming", "Crater rolling",
            "Cave spelunking"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideas);
        ButterKnife.bind(this);

        IdeasArrayAdapter adapter = new IdeasArrayAdapter(this, android.R.layout.simple_list_item_1, ideaPlaces, ideaActivities);

        mIdeaListView.setAdapter(adapter);
    }
}
