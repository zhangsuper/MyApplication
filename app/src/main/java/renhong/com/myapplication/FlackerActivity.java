package renhong.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FlackerActivity extends AppCompatActivity implements View.OnClickListener {

    private View mRedLight;
    private View mPurpleLight;
    private View mBlueLight;
    private View mBetLight;
    private Button mStartBtn;
    private Button mEndBtn;
    private AnimatorSet animatorSet1;
    private AnimatorSet animatorSet2;
    private AnimatorSet animatorSet3;
    private AnimatorSet animatorSet4;
    private AnimatorSet animatorSet5;
    private AnimatorSet animatorSet6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flacker);
        initView();
    }

    private void initView() {
        mRedLight = findViewById(R.id.red_light);
        mPurpleLight = findViewById(R.id.purple_light);
        mBlueLight = findViewById(R.id.blue_light);
        mBetLight = findViewById(R.id.bet_light);

        mStartBtn = (Button) findViewById(R.id.bt_start);
        mStartBtn.setOnClickListener(this);
        mEndBtn = (Button) findViewById(R.id.bt_end);
        mEndBtn.setOnClickListener(this);


    }

    private void startFlacker(){
        ObjectAnimator alphaAnimator1 = ObjectAnimator.ofFloat(mRedLight, "alpha", 0f, 1f);
        ObjectAnimator alphaAnimator2 = ObjectAnimator.ofFloat(mRedLight, "alpha", 1f, 0f);
        ObjectAnimator alphaAnimator3 = ObjectAnimator.ofFloat(mPurpleLight, "alpha", 0f, 1f);
        ObjectAnimator alphaAnimator4 = ObjectAnimator.ofFloat(mPurpleLight, "alpha", 1f, 0f);
        ObjectAnimator alphaAnimator5 = ObjectAnimator.ofFloat(mBlueLight, "alpha", 0f, 1f);
        ObjectAnimator alphaAnimator6 = ObjectAnimator.ofFloat(mBlueLight, "alpha", 1f, 0f);

        ObjectAnimator alphaAnimator7 = ObjectAnimator.ofFloat(mBetLight, "alpha", 0f, 1f);
        ObjectAnimator alphaAnimator8 = ObjectAnimator.ofFloat(mBetLight, "alpha", 1f, 0f);

        animatorSet6 = new AnimatorSet();
        animatorSet6.playSequentially(alphaAnimator7,alphaAnimator8);
        animatorSet6.setDuration(150);
        animatorSet6.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if(animatorSet1!=null)
                animatorSet1.start();
            }
        });

        animatorSet5 = new AnimatorSet();
        animatorSet5.playSequentially(alphaAnimator7,alphaAnimator8);
        animatorSet5.setDuration(150);
        animatorSet5.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if(animatorSet6!=null)
                animatorSet6.start();
            }
        });

        animatorSet4 = new AnimatorSet();
        animatorSet4.playSequentially(alphaAnimator7,alphaAnimator8);
        animatorSet4.setDuration(150);
        animatorSet4.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if(animatorSet5!=null)
                animatorSet5.start();
            }
        });

        animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(alphaAnimator1,alphaAnimator2,alphaAnimator3,alphaAnimator4,alphaAnimator5,alphaAnimator6);
        animatorSet3.setDuration(150);
        animatorSet3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if(animatorSet4!=null)
                animatorSet4.start();
            }
        });

        animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(alphaAnimator1,alphaAnimator2,alphaAnimator3,alphaAnimator4,alphaAnimator5,alphaAnimator6);
        animatorSet2.setDuration(150);
        animatorSet2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if(animatorSet3!=null)
                animatorSet3.start();
            }
        });

        animatorSet1 = new AnimatorSet();
        animatorSet1.playSequentially(alphaAnimator1,alphaAnimator2,alphaAnimator3,alphaAnimator4,alphaAnimator5,alphaAnimator6);
        animatorSet1.setDuration(150);
        animatorSet1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if(animatorSet2!=null)
                animatorSet2.start();
            }
        });
        animatorSet1.start();

    }

    @Override
    public void onClick(View v) {
        if(v==mStartBtn){
            startFlacker();
        }
        if(v==mEndBtn){
            animatorSet1.end();
            animatorSet1 =null;
            animatorSet2.end();
            animatorSet2 =null;
            animatorSet3.end();
            animatorSet3 =null;
            animatorSet4.end();
            animatorSet4 =null;
            animatorSet5.end();
            animatorSet5 =null;
            animatorSet6.end();
            animatorSet6 =null;
        }
    }
}
