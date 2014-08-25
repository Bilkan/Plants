package net.bilkan.plants;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;

public class ImagesAdapter extends BaseAdapter {
	
			
	private Context mContext;

	public ImagesAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return myImages.length;
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
		// TODO Auto-generated method stub

		ImageView imageview;
		final ScaleAnimation animation =new ScaleAnimation(0.0f, 1f, 0.0f, 1f, 
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f); 
				animation.setDuration(1000);
		if (convertView == null) {
			imageview = new ImageView(mContext);
			
			imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageview.setImageResource(myImages[position]);
			
			
		} else {
			imageview = (ImageView) convertView;
		}
		imageview.setImageResource(myImages[position]);
		imageview.setAnimation(animation);
		return imageview;
	}

	public Integer[] myImages = { R.drawable.alma1, R.drawable.anar2,
			R.drawable.aptapperes3, R.drawable.badam4, R.drawable.boljurgen5,
			R.drawable.budushqaq6, R.drawable.bughday7, R.drawable.buya8,
			R.drawable.chamghur9, R.drawable.chilan10, R.drawable.chuluk11,
			R.drawable.enjur12, R.drawable.eynula13, R.drawable.gilas14,
			R.drawable.hasing15, R.drawable.heshqipichek16, R.drawable.jigde17,
			R.drawable.kaktos18, R.drawable.kerepshe19, R.drawable.kiwez20,
			R.drawable.kommuqunaq21, R.drawable.kude22, R.drawable.kunjut23,
			R.drawable.laza24, R.drawable.mudengul25, R.drawable.neshput26,
			R.drawable.niloper27, R.drawable.osma28, R.drawable.palek29,
			R.drawable.pemidur30, R.drawable.pidgen31, R.drawable.piste32,
			R.drawable.piyaz33, R.drawable.qarighay34, R.drawable.qughun35,
			R.drawable.samsaq36, R.drawable.sebdegul37, R.drawable.sewze38,
			R.drawable.shaptol39, R.drawable.simizot40, R.drawable.suget41,
			R.drawable.tajigul42, R.drawable.tawuz43, R.drawable.terhemek44,
			R.drawable.tirek45, R.drawable.ujme46, R.drawable.uruk47,
			R.drawable.uzum48, R.drawable.yangaq49, R.drawable.yangyo50,
			R.drawable.yesimen51, R.drawable.zenjiwil52, R.drawable.zire53 };
	public String[] name = { "ئالما", "ئانار", "ئاپتاپپەرەس", "بادام",
			"بۆلجۈرگەن", "بۇدۇشقاق", "بۇغداي", "بۇيا", "چامغۇر", "چىلان",
			"چۈلۈك", "ئەنجۈر", "ئەينۇلا", "گىلاس", "خاسىڭ", "ھەشقىپىچەك",
			"جىگدە", "كاكتۇس", "كەرەپشە", "كۆممىقوناق", "كېۋەز", "كۈدە",
			"كۈنجۈت", "لازا", "مودەن گۈل", "نەشپۈت", "نېلۇپەر", "ئوسما",
			"پالەك", "پەمىدۇر", "پېدىگەن", "پىستە", "پىياز", "قارىغاي",
			"قوغۇن", "سامساق", "سەبدە گۈل ", "سەۋزە", "شاپتۇل", "سېمىز ئوت",
			"سۆگەت", "تاجىگۈل", "تاۋۇز", "تەرخەمەك", "تېرەك", "ئۈجمە", "ئۈزۈم",
			"ئۆرۈك", "ياڭاق", "ياڭيۇ", "يەسىمەن", "زەنجىۋىل", "زىرە" };
	public Integer[] mysounds = { R.raw.at, R.raw.bore, R.raw.chiwin,
			R.raw.chuje, R.raw.eshek, R.raw.eyiq, R.raw.ghaz, R.raw.here,
			R.raw.heselherisi, R.raw.horaz, R.raw.it, R.raw.kakkuk, R.raw.kala,
			R.raw.kepter, R.raw.maymun, R.raw.mishyaplaq, R.raw.mushuk,
			R.raw.ochke, R.raw.odek, R.raw.paqa, R.raw.pil, R.raw.qagha,
			R.raw.qaraqushqach, R.raw.qarlighach, R.raw.qoy, R.raw.shir,
			R.raw.sopisopiyang, R.raw.tohu, R.raw.torghay, R.raw.toshqan,
			R.raw.yolwas, R.raw.zirape, R.raw.maymun, R.raw.mishyaplaq,
			R.raw.mushuk, R.raw.ochke, R.raw.odek, R.raw.paqa, R.raw.pil,
			R.raw.qagha, R.raw.qaraqushqach, R.raw.qarlighach, R.raw.qoy,
			R.raw.shir, R.raw.sopisopiyang, R.raw.tohu, R.raw.torghay,
			R.raw.toshqan, R.raw.yolwas, R.raw.zirape,  R.raw.torghay,
			R.raw.toshqan, R.raw.yolwas, R.raw.zirape,};
}
