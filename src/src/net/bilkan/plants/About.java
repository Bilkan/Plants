package net.bilkan.plants;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;

public class About extends Activity {
	RelativeLayout splashlayout;

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		//for animation
		final ScaleAnimation animation = new ScaleAnimation(0.0f, 1f, 0.0f, 1f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		animation.setDuration(1000);
		//for full screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		splashlayout = (RelativeLayout) findViewById(R.id.splashlayout);
		splashlayout.setAnimation(animation);
		Button close = (Button) findViewById(R.id.btnclose);
		close.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}

		});

	}
}
