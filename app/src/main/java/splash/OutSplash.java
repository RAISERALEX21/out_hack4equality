package splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.hack4equality.out.R;

import login.LoginOut;

/**
 * Created by RaiserAlex on 20/02/16.
 */
public class OutSplash extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.out_splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(OutSplash.this, LoginOut.class);
                startActivity(intent);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
