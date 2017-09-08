package compioneerx1.github.whattopack;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ResultsActivity extends AppCompatActivity {

    @Bind(R.id.inputSummaryTextView) TextView mInputSummaryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        Intent oldIntent = getIntent();
        String location = oldIntent.getStringExtra("location");
        String dates = oldIntent.getStringExtra("dates");
        String purpose = oldIntent.getStringExtra("purpose");
        mInputSummaryTextView.setText("Location Specified: " + location + "\n" + "Dates Specified: " + dates + "Purpose: " + purpose);

    }
}
