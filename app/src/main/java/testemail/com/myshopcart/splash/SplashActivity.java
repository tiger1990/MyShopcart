package testemail.com.myshopcart.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import testemail.com.myshopcart.HomeActivity;
import testemail.com.myshopcart.R;

public class SplashActivity extends Activity //implements AnimationListener
{
//    private Animation animFadein;
//    private ImageView imageloader;
//    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        dialog = new Dialog(getApplicationContext());
//        dialog.getWindow().setBackgroundDrawable(
//                new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        imageloader = (ImageView) findViewById(R.id.imageloader);
//
//        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
//                R.anim.blink);
//
//        // set animation listener
//        animFadein.setAnimationListener(this);
//        imageloader.startAnimation(animFadein);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);

    }

//    @Override
//    public void onAnimationEnd(Animation animation)
//    {
//
//        if (animation == animFadein)
//        {
//
//        }
//
//    }
//
//    @Override
//    public void onAnimationRepeat(Animation animation)
//    {
//
//    }
//
//    @Override
//    public void onAnimationStart(Animation animation)
//    {
//
//    }
}
