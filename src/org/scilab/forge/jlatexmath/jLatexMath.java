package org.scilab.forge.jlatexmath;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class jLatexMath {

	private static Context mContext;
	private static Paint st;
	
	public static void init(Context context) {
		mContext = context;
		st = new Paint();
		st.setStyle(Style.FILL_AND_STROKE);
		st.setColor(Color.BLACK);
		st.setStrokeWidth(1);
	}

	public static AssetManager getAssetManager() {
		AssetManager mng = mContext.getAssets();
		
		return mng;
	}

	public static Context getContext() {
		// TODO Auto-generated method stub
		return mContext;
	}
	
	public static Paint getPaint(){
		return st;
	}
	
	
}
