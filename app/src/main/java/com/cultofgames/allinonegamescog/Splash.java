package com.cultofgames.allinonegamescog;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.cultofgames.allinonegamescog.activities.MainActivity;
import com.github.ybq.android.spinkit.style.ThreeBounce;

public class Splash extends AppCompatActivity {

    private static int SPLASH_TIME = 5000;
    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        bar = (ProgressBar)findViewById(R.id.ThreeBounce);
        ThreeBounce threeBounce = new ThreeBounce();
        bar.setIndeterminateDrawable(threeBounce);
        bar.setMax(100);

        new Handler().postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void run() {
                Intent mySuperIntent = new Intent(Splash.this, MainActivity.class);

//                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, mySuperIntent, PendingIntent.FLAG_IMMUTABLE);
//
//                mySuperIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mySuperIntent);
//                CustomIntent.customType(Splash.this,"fadein-to-fadeout");
//                finish();
            }
        }, SPLASH_TIME);
    }
}
