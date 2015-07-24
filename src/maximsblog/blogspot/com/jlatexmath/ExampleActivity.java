package maximsblog.blogspot.com.jlatexmath;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import maximsblog.blogspot.com.jlatexmath.core.Insets;
import maximsblog.blogspot.com.jlatexmath.core.TeXConstants;
import maximsblog.blogspot.com.jlatexmath.core.TeXFormula;
import maximsblog.blogspot.com.jlatexmath.core.TeXIcon;
import maximsblog.blogspot.com.jlatexmath.core.AjLatexMath;
import maximsblog.blogspot.com.jlatexmath.core.TeXFormula.TeXIconBuilder;
import android.app.Activity;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class ExampleActivity extends FragmentActivity implements
		OnPageChangeListener, OnClickListener {

	private ViewPager mPager;
	private PagesAdapter mAdapter;
	private String[] mExamples;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AjLatexMath.init(this);
		mExamples = ExampleFormula.getFormulaArray();
		mPager = (ViewPager) findViewById(R.id.pager);
		mAdapter = new PagesAdapter(getSupportFragmentManager());
		mPager.setAdapter(mAdapter);
		mPager.addOnPageChangeListener(this);
		setTitle(getString(R.string.app_name) + ": About");
		

	}

	private class PagesAdapter extends FragmentPagerAdapter {

		public PagesAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
		}

		@Override
		public android.support.v4.app.Fragment getItem(int position) {
			if(position == 0)
				return AboutFragment.newInstance();
			else
				return ExampleFragment
					.newInstance(mExamples[position], position );
		}

		@Override
		public int getCount() {
			return mExamples.length;
		}

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int position) {
		if(position == 0)
			setTitle(getString(R.string.app_name) + ": About");
		else
			setTitle(getString(R.string.app_name) + ": Example" + (position));

	}


	@Override
	public void onClick(View v) {
		mAdapter.notifyDataSetChanged();
	}

}
