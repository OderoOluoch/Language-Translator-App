package co.ke.snilloc.translatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.snilloc.translatorapp.ui.TranslatorActivity;

public class MainActivity extends AppCompatActivity {
    //hook views
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.MainAppNameTextView) TextView mMainAppNameTextView;
    @SuppressLint("NonConstantResourceId")
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

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, TranslatorActivity.class);
            startActivity(intent);
            //kill this
            finish();
        },5000);
    }
}