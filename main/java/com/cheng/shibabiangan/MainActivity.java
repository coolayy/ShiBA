package com.cheng.shibabiangan;

import java.io.IOException;

import com.cheng.shibabiangan.gameviews.MyGameView;
import com.cheng.shibabiangan.utils.AssetsLoad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;

public class MainActivity extends Activity {
	private MyGameView gameview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Intent intent = this.getIntent();
		switch (intent.getIntExtra("viewType", 1)) {
		case 1:
			gameview = new MyGameView(this);
			setContentView(gameview);
			break;
		/*
		 * case 2: setContentView( new MyGameViewServer(this)); break;
		 */
		/*case 2:
			// setContentView(new BluetoothGameView(this));
		case 3:
			setContentView(new MyGameViewClient(this));*/
		default:
			break;
		}
		

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		//AssetsLoad.player.start();
		super.onResume();
	}
	@Override
	protected void onPause()
	{
		// TODO Auto-generated method stub
		/*if(AssetsLoad.player.isPlaying())
		{
			AssetsLoad.player.pause();
		}*/
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

}
