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

public class LocationActivity extends AppCompatActivity {

    @Bind(R.id.locationButton) Button mLocationButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        ButterKnife.bind(this);

        mLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = mLocationEditText.getText().toString();
                if (location.equals("")) {
                    Toast.makeText(LocationActivity.this, "Please input a location", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(LocationActivity.this, DatesActivity.class);
                    intent.putExtra("location", location);
                    startActivity(intent);
                }
            }
        });

    }
}
