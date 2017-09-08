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
public class DatesActivity extends AppCompatActivity {

    @Bind(R.id.locationTextView) TextView mLocationTextView;
    @Bind(R.id.datesEditText) EditText mDatesEditText;
    @Bind(R.id.datesButton) Button mDatesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dates);
        ButterKnife.bind(this);
        Intent oldIntent = getIntent();
        String location = oldIntent.getStringExtra("location");
        mLocationTextView.setText("What dates are you traveling to " + location + "?");

        mDatesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dates = mDatesEditText.getText().toString();
                Intent newIntent = new Intent(DatesActivity.this, ResultsActivity.class);
                newIntent.putExtra("dates", dates);
                startActivity(newIntent);
            }
        });

    }
}
