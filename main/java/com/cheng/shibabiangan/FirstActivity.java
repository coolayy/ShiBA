package com.cheng.shibabiangan;

import com.cheng.shibabiangan.utils.AssetsLoad;
import com.cheng.shibabiangan.utils.Constant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

public class FirstActivity extends Activity {
	public static Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  //����ȫ��  
		  setContentView(R.layout.first_activity);
		  DisplayMetrics dm = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(dm);
			Constant.SCREENWIDTH = dm.widthPixels;
			Constant.SCREENHEIGHT = dm.heightPixels;
		  handler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				if(msg.what == 0){
					Intent intent = new Intent();
					intent.setClass(FirstActivity.this,WelcomeActivity.class);
					startActivity(intent);
					FirstActivity.this.finish();
				}
				
				super.handleMessage(msg);
			}
			  
		  };
		  new LoadConstantThread().start();
	}
	
	
	class LoadConstantThread extends Thread{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub

			Constant.RECT_R = Constant.SCREENWIDTH/20;
			Constant.CHESS_R = Constant.SCREENWIDTH*3/80;
			AssetsLoad.load(getApplicationContext());
			
			try {
				this.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Message msg = handler.obtainMessage(0);
			handler.sendMessage(msg);
			super.run();
		}
		
	}

}
