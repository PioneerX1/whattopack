package compioneerx1.github.whattopack.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import compioneerx1.github.whattopack.R;

public class PurposeActivity extends AppCompatActivity {

    @Bind(R.id.purposeListView) ListView mPurposeListView;
    @Bind(R.id.purposeButton) Button mPurposeButton;

    String purposeSelection = "";

    private String[] purposeArray = new String[] {
            "Business", "Casual Fun", "Active Outdoors"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purpose);
        ButterKnife.bind(this);

        Intent oldIntent = getIntent();
        final String location = oldIntent.getStringExtra("location");
        final String dates = oldIntent.getStringExtra("dates");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, purposeArray);
        mPurposeListView.setAdapter(adapter);

        mPurposeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                purposeSelection = ((TextView)view).getText().toString();
            }
        });

        mPurposeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (purposeSelection.equals("")) {
                    Toast.makeText(PurposeActivity.this, "Please choose an option", Toast.LENGTH_LONG).show();
                } else {
                    Intent newIntent = new Intent(PurposeActivity.this, ResultsActivity.class);
                    newIntent.putExtra("dates", dates);
                    newIntent.putExtra("location", location);
                    newIntent.putExtra("purpose", purposeSelection);
                    startActivity(newIntent);
                }
            }
        });

    }
}
