package maximsblog.blogspot.com.jlatexmath;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.scilab.forge.jlatexmath.Insets;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;
import org.scilab.forge.jlatexmath.TeXFormula.TeXIconBuilder;
import org.scilab.forge.jlatexmath.jLatexMath;





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
import android.widget.ImageView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class ExampleActivity extends FragmentActivity implements OnPageChangeListener, OnClickListener {

	private ViewPager mPager;
	private PagesAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		jLatexMath.init(this);
		mPager = (ViewPager) findViewById(R.id.pager);
		mAdapter = new PagesAdapter(getSupportFragmentManager());
		mPager.setAdapter(mAdapter);
		mPager.addOnPageChangeListener (this);
		findViewById(R.id.save).setOnClickListener(this);
	}

	private class PagesAdapter extends FragmentPagerAdapter {

		public PagesAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
		}

		@Override
		public android.support.v4.app.Fragment getItem(int position) {
			return ExampleFragment.newInstance(ExampleFormula.getFormulaArray()[position]);
		}

		@Override
		public int getCount() {
			return ExampleFormula.getFormulaArray().length;
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
		setTitle(getString(R.string.app_name) + ": Example" + (position + 1));
		
	}

	@Override
	public void onClick(View v) {
		mPager.getCurrentItem();
	}

}
