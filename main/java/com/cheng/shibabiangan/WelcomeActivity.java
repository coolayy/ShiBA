package com.cheng.shibabiangan;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.cheng.shibabiangan.utils.AssetsLoad;
import com.cheng.shibabiangan.utils.Constant;

public class WelcomeActivity extends Activity {
	private Button buttonOffline;
	private Button buttonAbout;
	private Button buttonExit;
	private BluetoothAdapter adapter;
	private BluetoothDevice device;
	private Animation animation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置无标题
		setContentView(R.layout.welcome_activity);
		animation = AnimationUtils.loadAnimation(this, R.anim.welcome_button);
		buttonOffline = (Button) findViewById(R.id.offline_button);
		buttonAbout = (Button) findViewById(R.id.about);
		buttonExit = (Button) findViewById(R.id.exit);
		
		// 注册BroadcastReceiver
		/*
		 * IntentFilter filterFound = new
		 * IntentFilter(BluetoothDevice.ACTION_FOUND);
		 * filterFound.addAction(BluetoothAdapter .ACTION_DISCOVERY_STARTED);
		 * filterFound.addAction(BluetoothAdapter .ACTION_DISCOVERY_FINISHED);
		 * registerReceiver(mReceiver, filterFound);
		 */
		buttonOffline.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				animation.setAnimationListener(new AnimationListener() {

					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						buttonOffline.setClickable(false);
						buttonAbout.setClickable(false);
						buttonExit.setClickable(false);
					}

					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onAnimationEnd(Animation animation) {
						// TODO Auto-generated method stub
						buttonOffline.setVisibility(View.INVISIBLE);
						Intent intent = new Intent();
						intent.putExtra("viewType", 1);
						intent.setClass(getApplicationContext(),
								MainActivity.class);
						startActivity(intent);
					}
				});
				AssetsLoad.playSound(getApplicationContext(), AssetsLoad.dropSoundId);
				buttonOffline.startAnimation(animation);
			}
		});
		buttonAbout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				animation.setAnimationListener(new AnimationListener() {

					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						buttonOffline.setClickable(false);
						buttonAbout.setClickable(false);
						buttonExit.setClickable(false);
					}

					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onAnimationEnd(Animation animation) {
						// TODO Auto-generated method stub
						buttonAbout.setVisibility(View.INVISIBLE);
						Intent intent = new Intent(WelcomeActivity.this,AboutActivity.class);
						startActivity(intent);
					}
				});
				AssetsLoad.playSound(getApplicationContext(), AssetsLoad.dropSoundId);
				buttonAbout.startAnimation(animation);
				/*Toast.makeText(WelcomeActivity.this, "not yet",
						Toast.LENGTH_SHORT).show();*/
			}
		});
		buttonExit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				animation.setAnimationListener(new AnimationListener() {

					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						buttonOffline.setClickable(false);
						buttonAbout.setClickable(false);
						buttonExit.setClickable(false);
					}

					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onAnimationEnd(Animation animation) {
						// TODO Auto-generated method stub
						buttonExit.setVisibility(View.INVISIBLE);
						finish();
					}
				});
				AssetsLoad.playSound(getApplicationContext(), AssetsLoad.dropSoundId);
				buttonExit.startAnimation(animation);
			}
		});

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		buttonOffline.setVisibility(View.VISIBLE);
		buttonAbout.setVisibility(View.VISIBLE);
		buttonExit.setVisibility(View.VISIBLE);
		buttonOffline.setClickable(true);
		buttonAbout.setClickable(true);
		buttonExit.setClickable(true);
		super.onRestart();
	}

}
