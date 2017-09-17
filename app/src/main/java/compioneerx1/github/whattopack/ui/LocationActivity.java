package compioneerx1.github.whattopack.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import compioneerx1.github.whattopack.R;

public class LocationActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.locationButton) Button mLocationButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.ideasButton) Button mIdeasButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        ButterKnife.bind(this);

        mLocationButton.setOnClickListener(this);
        mIdeasButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mLocationButton) {
            String location = mLocationEditText.getText().toString();
            if (location.equals("")) {
                Toast.makeText(LocationActivity.this, "Please input a location", Toast.LENGTH_LONG).show();
            } else {
                //Intent intent = new Intent(LocationActivity.this, DatesActivity.class);
                Intent intent = new Intent(LocationActivity.this, PurposeActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        } else if (v == mIdeasButton) {
            Intent intent = new Intent(LocationActivity.this, IdeasActivity.class);
            startActivity(intent);
        }
    }
}
