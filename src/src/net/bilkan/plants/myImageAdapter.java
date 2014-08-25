package net.bilkan.plants;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class myImageAdapter extends BaseAdapter {
	ImagesAdapter myIAdapter;

	int mGalleryItemBackground;
	private Context context;

	public myImageAdapter(Context context) {

		this.context = context;
		TypedArray typed_array = context
				.obtainStyledAttributes(R.styleable.Gallery);
		mGalleryItemBackground = typed_array.getResourceId(
				R.styleable.Gallery_android_galleryItemBackground, 0);
		typed_array.recycle();
	}

	public int getCount() {
		// return myImageIds.length;
		return Integer.MAX_VALUE;

	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		
	
		
		ImageView imageview = new ImageView(context);
		imageview.setImageResource(myImageIds[position % myImageIds.length]);
		imageview.setScaleType(ImageView.ScaleType.FIT_XY);
		imageview.setBackgroundResource(mGalleryItemBackground);
		
		return imageview;
	}

	public Integer[] myImageIds = { R.drawable.alma, R.drawable.anar,
			R.drawable.aptapperes, R.drawable.badam, R.drawable.boljurgen,
			R.drawable.budushqaq, R.drawable.bughday, R.drawable.buya,
			R.drawable.chamghur, R.drawable.chilan, R.drawable.chuluk,
			R.drawable.enjur, R.drawable.eynula, R.drawable.gilas,
			R.drawable.hasing, R.drawable.heshqipichek, R.drawable.jigde,
			R.drawable.kaktos, R.drawable.kerepshe, R.drawable.kommuqunaq,
			R.drawable.kiwez, R.drawable.kude, R.drawable.kunjut,
			R.drawable.laza, R.drawable.mudengul, R.drawable.neshput,
			R.drawable.niloper, R.drawable.osma, R.drawable.palek,
			R.drawable.pemidur, R.drawable.pidgen, R.drawable.piste,
			R.drawable.piyaz, R.drawable.qarighay, R.drawable.qughun,
			R.drawable.samsaq, R.drawable.sebdegul, R.drawable.sewze,
			R.drawable.shaptol, R.drawable.simizot, R.drawable.suget,
			R.drawable.tajigul, R.drawable.tawuz, R.drawable.terhemek,
			R.drawable.tirek, R.drawable.ujme, R.drawable.uzum,
			R.drawable.uruk, R.drawable.yangaq, R.drawable.yangyo,
			R.drawable.yesimen, R.drawable.zenjiwil, R.drawable.zire };

}
