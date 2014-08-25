package net.bilkan.plants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity{
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.splash_activity);
		waitingThread();
	}

	private void waitingThread() {
		// TODO Auto-generated method stub
		Handler hand = new Handler();
		hand.postDelayed(new Runnable() {
			public void run() {

				Intent list = new Intent();
				list.setClass(SplashActivity.this, ShowImages.class);
				SplashActivity.this.startActivity(list);
				finish();

			}
		}, 1000);

	}
}
