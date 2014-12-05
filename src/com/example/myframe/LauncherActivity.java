package com.example.myframe;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.FeatureInfo;
import android.view.Menu;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class LauncherActivity extends Activity {
    private RelativeLayout mLaunchLayout;
    private Animation mFadeIn;
    private Animation mFadeInScale;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.launcher);
		
		mLaunchLayout=(RelativeLayout)findViewById(R.id.launch);
		
		init();
		setListen();
		
	}
	public void setListen(){
		
		mFadeIn.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				mLaunchLayout.startAnimation(mFadeInScale);
			}
		});
		
		mFadeInScale.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(LauncherActivity.this,MainActivity.class);
				startActivity(intent);
				finish();
				
			}
		});
		
		
	}

	private void init() {
		initAnim();
		mLaunchLayout.startAnimation(mFadeIn);
	}

	private void initAnim() {
		mFadeIn = AnimationUtils.loadAnimation(LauncherActivity.this,
				R.anim.welcome_fade_in);
		mFadeIn.setDuration(500);
		mFadeIn.setFillAfter(true);
		mFadeInScale = AnimationUtils.loadAnimation(LauncherActivity.this,
				R.anim.welcome_fade_in_scale);
		mFadeInScale.setDuration(3000);
		mFadeInScale.setFillAfter(true);
	}


}
