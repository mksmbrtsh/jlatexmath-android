package org.scilab.forge.jlatexmath;

import android.content.Context;
import android.content.res.AssetManager;

public class jLatexMath {

	private static Context mContext;
	
	public static void init(Context context) {
		mContext = context;
	}

	public static AssetManager getAssetManager() {
		AssetManager mng = mContext.getAssets();
		return mng;
	}

	public static Context getContext() {
		// TODO Auto-generated method stub
		return mContext;
	}
	
	
	
}
