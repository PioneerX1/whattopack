package compioneerx1.github.whattopack.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.Bind;
import butterknife.ButterKnife;
import compioneerx1.github.whattopack.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    public String developerWebsite = "https://github.com/PioneerX1/whattopack";

    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    @Bind(R.id.startButton) Button mStartButton;
    @Bind(R.id.githubButton) Button mGithubButton;


    @Override
    public void onClick(View v) {
        // Visit Mick's GitHub page to see code
        if (v == mGithubButton) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(developerWebsite));
            startActivity(webIntent);
        }
        // Run the app
        if (v == mStartButton) {
            Intent intent = new Intent(MainActivity.this, LocationActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Custom font text for "What To Pack"
        Typeface pacificoFont = Typeface.createFromAsset(getAssets(), "fonts/pacifico.ttf");
        mAppNameTextView.setTypeface(pacificoFont);

        mStartButton.setOnClickListener(this);
        mGithubButton.setOnClickListener(this);

    }

    // menu functions for logging out
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


}
