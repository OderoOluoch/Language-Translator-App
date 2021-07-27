package co.ke.snilloc.translatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.snilloc.translatorapp.ui.LoginActivity;

public class MainActivity extends AppCompatActivity {
    //hook views
    @BindView(R.id.MainAppNameTextView) TextView mMainAppNameTextView;
    @BindView(R.id.MainAppLoadingTextView) TextView mMainAppLoadingTextView;

    Animation topAnim,blinkAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        blinkAnim = AnimationUtils.loadAnimation(this,R.anim.blink_animation);

        mMainAppNameTextView.setAnimation(topAnim);
        mMainAppLoadingTextView.setAnimation(blinkAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                //kill this
                finish();
            }
        },5000);
    }
}