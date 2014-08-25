package net.bilkan.plants;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

public class ShowImage extends Activity implements ViewFactory {
	private ImageSwitcher imageswitcher;
	private myImageAdapter imageadapter;
	private boolean slideShow = false;
	private MediaPlayer mMediaPlayer;
	private boolean sound = true;
	private AudioManager audioMa;
	private int i = ShowImages.myImagePosition;
	private int xTouch = 0, xClickOffset = 0;
	TextView plant_name;

	final ScaleAnimation animation = new ScaleAnimation(0.0f, 1f, 0.0f, 1f,
			Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
	int plantsNamePosition = ShowImages.myImagePosition;
	ImagesAdapter imagesAdapter = new ImagesAdapter(this);

	@SuppressWarnings("deprecation")
	public View makeView() {
		ImageView imageview = new ImageView(this);
		imageview.setScaleType(ImageView.ScaleType.FIT_XY);
		imageview.setLayoutParams(new ImageSwitcher.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		return imageview;
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.showimage);

		audioMa = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		audioMa.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		audioMa.getStreamVolume(AudioManager.STREAM_MUSIC);
		plant_name = (TextView) findViewById(R.id.plantsName);

		plant_name.setText(imagesAdapter.name[i]);

		imageadapter = new myImageAdapter(this);
		imageswitcher = (ImageSwitcher) findViewById(R.id.imageswitcher);
		imageswitcher.setFactory(this);
		initAnimation(imageswitcher);
		imageswitcher
				.setBackgroundResource(imageadapter.myImageIds[ShowImages.myImagePosition]);
		plant_name.setText(imagesAdapter.name[i]);

		imageswitcher.setOnTouchListener(new ImageSwitcher.OnTouchListener() {
			public boolean onTouch(View arg0, MotionEvent event) {

				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					xTouch = (int) event.getX();
					xClickOffset = xTouch;
				} else if (event.getAction() == MotionEvent.ACTION_MOVE) {
					xTouch = (int) event.getX();
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					if (event.getX() - xClickOffset > 40)// onggha surulgenni
					{

						aldigha();
					}
					if (event.getX() - xClickOffset < -40)// solgha surulgenni
					{

						Next();
					}
					if (event.getX() - xClickOffset < 40
							&& event.getX() - xClickOffset > -40) {

						slideShow = false;
						player(i);

					}

				}
				return true;
			}

		});

//		imageswitcher.setInAnimation(AnimationUtils.loadAnimation(this,
//				android.R.anim.fade_in));
//		imageswitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
//				android.R.anim.fade_out));

	}

	public void Next() {
		i++;
		if (i > imagesAdapter.myImages.length - 1) {
			i = 0;
		}
		imageswitcher.setBackgroundResource(imageadapter.myImageIds[i]);
		initAnimation(imageswitcher);
		plant_name.setText(imagesAdapter.name[i]);
		player(i);

	}

	public void aldigha() {
		i--;
		if (i < 0) {
			i = imagesAdapter.myImages.length - 1;
		}

		imageswitcher.setBackgroundResource(imageadapter.myImageIds[i]);
		initAnimation(imageswitcher);
		plant_name.setText(imagesAdapter.name[i]);
		player(i);
	}

	public boolean onCreateOptionsMenu(Menu menu) {

		super.onCreateOptionsMenu(menu);

		menu.add(0, 1, 1, getString(R.string.sound)).setIcon(R.drawable.sound);
		if (slideShow) {
			menu.add(0, 2, 2, getString(R.string.stop))
					.setIcon(R.drawable.stop);
		} else {
			menu.add(0, 2, 2, getString(R.string.play))
					.setIcon(R.drawable.play);
		}

		menu.add(0, 3, 3, getString(R.string.about)).setIcon(
				R.drawable.about_icon);

		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		if (item.getItemId() == 1) {
			if (sound == true) {

				if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
					mMediaPlayer.stop();
				}
				Toast toast = new Toast(this);
				ImageView view = new ImageView(this);
				view.setImageResource(R.drawable.off);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.setView(view);
				toast.show();
				sound = false;
			} else {
				Toast toast = new Toast(this);
				ImageView view = new ImageView(this);
				view.setImageResource(R.drawable.on);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.setView(view);
				toast.show();
				sound = true;
			}

		}
		if (item.getItemId() == 2) {
			slideShow = true;
			play();
		}

		if (item.getItemId() == 3) {

			appInfo();
		}
		return slideShow;

	}

	private void appInfo() {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setClass(this, About.class);
		startActivity(intent);
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

			Intent intent = new Intent();
			intent.setClass(ShowImage.this, ShowImages.class);
			ShowImage.this.startActivity(intent);
			if (mMediaPlayer != null) {
				mMediaPlayer.stop();
			}
			finish();
		}

		return super.onKeyDown(keyCode, event);
	}

	public void player(int i) {

		if (sound == true) {
			if (mMediaPlayer != null) {

				mMediaPlayer.release();

			}

			mMediaPlayer = MediaPlayer.create(ShowImage.this,
					imagesAdapter.mysounds[i]);

			mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

			mMediaPlayer.start();

		} else {

			mMediaPlayer.stop();
		}
	}

	public void play() {

		player(i);
		mMediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer arg0) {
				arg0.reset();
				i++;
				if (i == imagesAdapter.mysounds.length - 1) {

					i = 0;
				}

				if (i <= imagesAdapter.mysounds.length - 1) {
					imageswitcher
							.setBackgroundResource(imageadapter.myImageIds[i]);
					plant_name.setText(imagesAdapter.name[i]);

					play();
				}
			}

		});
	}

	private Animation animation_scale;
	private AnimationSet animationSet;

	private void initAnimation(ImageSwitcher imageswitcher) {

		animation_scale = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);

		animation_scale.setDuration(500);

		animationSet = new AnimationSet(true);

		animationSet.addAnimation(animation_scale);

		imageswitcher.startAnimation(animationSet);
	}
}
