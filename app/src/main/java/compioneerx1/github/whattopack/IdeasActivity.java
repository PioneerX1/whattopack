package compioneerx1.github.whattopack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class IdeasActivity extends AppCompatActivity {

    @Bind(R.id.ideasListView)
    ListView mIdeaListView;

    private String[] ideaPlaces = new String[] {
            "Venice, Italy", "Buenos Aires, Argentina", "Reyjkavik, Iceland", "San Diego, CA"
    };
    private String[] ideaActivities = new String[] {
            "Gondola rides", "Museums", "Arctic trek", "Relaxing by the Beach"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideas);
        ButterKnife.bind(this);


    }
}
