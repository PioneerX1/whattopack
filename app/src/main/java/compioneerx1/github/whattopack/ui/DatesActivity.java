package compioneerx1.github.whattopack.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import compioneerx1.github.whattopack.R;

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
        final String location = oldIntent.getStringExtra("location");
        mLocationTextView.setText("What dates are you traveling to " + location + "?");

        mDatesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dates = mDatesEditText.getText().toString();
                if (dates.equals("")) {
                    Toast.makeText(DatesActivity.this, "Please enter a date.", Toast.LENGTH_LONG).show();

                } else {
                    Intent newIntent = new Intent(DatesActivity.this, PurposeActivity.class);
                    newIntent.putExtra("dates", dates);
                    newIntent.putExtra("location", location);
                    startActivity(newIntent);
                }
            }
        });

    }
}
