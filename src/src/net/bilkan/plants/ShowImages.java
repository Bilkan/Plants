package net.bilkan.plants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class ShowImages extends Activity {

	static int myImagePosition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// for full screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.showimages);

		final GridView myGridView = (GridView) findViewById(R.id.plants_gridview);
		myGridView.setAdapter(new ImagesAdapter(this));

		myGridView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// TODO Auto-generated method stub
				myImagePosition = position;

				Intent intent = new Intent();

				intent.setClass(ShowImages.this, ShowImage.class);
				ShowImages.this.startActivity(intent);
				finish();

			}

		});
	}

}
