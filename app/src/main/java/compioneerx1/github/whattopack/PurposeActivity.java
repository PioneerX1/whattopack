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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;

public class PurposeActivity extends AppCompatActivity {

    @Bind(R.id.purposeListView) ListView mPurposeListView;
    @Bind(R.id.purposeButton) Button mPurposeButton;

    private String[] purposeArray = new String[] {
            "Business", "Casual Fun", "Active Outdoors"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purpose);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, purposeArray);
        mPurposeListView.setAdapter(adapter);

    }
}
