package compioneerx1.github.whattopack.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import compioneerx1.github.whattopack.R;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    //@Bind(R.id.appDescriptionTextView) TextView mAppDescriptionTextView;
    @Bind(R.id.startButton) Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Custom font text for "What To Pack"
        Typeface pacificoFont = Typeface.createFromAsset(getAssets(), "fonts/pacifico.ttf");
        mAppNameTextView.setTypeface(pacificoFont);
        //mAppDescriptionTextView.setTypeface(pacificoFont);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String location = mLocationEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, LocationActivity.class);
                //intent.putExtra("location", location);
                startActivity(intent);
            }
        });

    }


}
