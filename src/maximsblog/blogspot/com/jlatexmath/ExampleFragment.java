package maximsblog.blogspot.com.jlatexmath;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

import org.scilab.forge.jlatexmath.Insets;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;
import org.scilab.forge.jlatexmath.jLatexMath;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ExampleFragment extends Fragment implements OnClickListener {

	public static android.support.v4.app.Fragment newInstance(String latex, int tag) {
		ExampleFragment fragment = new ExampleFragment();
		fragment.setTag(tag);
		fragment.setFormula(latex);
		return fragment;
	}

	private ImageView mImageView;
	Bitmap mImage;
	private String mLatex;
	private float mTextSize = 10;
	private int mTag;
	private EditText mSizeText;

	private void setFormula(String latex) {
		mLatex = latex;
	}


	private void setTag(int tag) {
		mTag = tag;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putString("latex", mLatex);
		outState.putFloat("textsize", mTextSize);
		outState.putInt("tag", mTag);
		super.onSaveInstanceState(outState);
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null) {
			mLatex = savedInstanceState.getString("latex");
			mTextSize = savedInstanceState.getFloat("textsize");
			mTag = savedInstanceState.getInt("tag");
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		LinearLayout layout = (LinearLayout) inflater.inflate(
				R.layout.fragment_example, container, false);
		mImageView = (ImageView) layout.findViewById(R.id.imageView1);
		mSizeText = (EditText) layout.findViewById(R.id.size);
		layout.findViewById(R.id.button1).setOnClickListener(this);
		setformula();

		return layout;
	}

	private void setformula() {
		int w = getResources().getDisplayMetrics().widthPixels;
		int h = getResources().getDisplayMetrics().heightPixels;
		TeXFormula formula = new TeXFormula(mLatex);
		TeXIcon icon = formula.new TeXIconBuilder()
				.setStyle(TeXConstants.STYLE_DISPLAY).setSize(mTextSize)
				.setWidth(TeXConstants.UNIT_PIXEL, w, TeXConstants.ALIGN_LEFT).setIsMaxWidth(true).setInterLineSpacing(TeXConstants.UNIT_PIXEL, jLatexMath.getLeading(mTextSize))
				.build();
		icon.setInsets(new Insets(5, 5, 5, 5));

		mImage = Bitmap.createBitmap(icon.getIconWidth(), icon.getIconHeight(),
				Config.ARGB_8888);

		Canvas g2 = new Canvas(mImage);
		g2.drawColor(Color.WHITE);
		icon.paintIcon(g2, 0, 0);

		Bitmap scaleimage = scaleBitmapAndKeepRation(mImage, h, w);

		mImageView.setImageBitmap(scaleimage);
	}
	
	public Bitmap scaleBitmapAndKeepRation(Bitmap targetBmp,
			int reqHeightInPixels, int reqWidthInPixels) {
		Bitmap bitmap = Bitmap.createBitmap(reqWidthInPixels, reqHeightInPixels, Config.ARGB_8888);
		Canvas g =new Canvas(bitmap);
		g.drawBitmap(targetBmp, 0, 0, null);
		targetBmp.recycle();
		return bitmap;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	};

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.button1) {
			mTextSize = Integer.valueOf(mSizeText.getText().toString());
			setformula();
		} else {
			File dir = getActivity().getExternalCacheDir();
			String r;
			if (dir != null) {
				dir.mkdirs();
				String fname = "Example" + (mTag + 1) + ".png";
				File file = new File(dir, fname);
				if (file.exists())
					file.delete();

				try {
					FileOutputStream out = new FileOutputStream(file);
					mImage.compress(Bitmap.CompressFormat.PNG, 90, out);
					out.flush();
					out.close();
					r = getString(R.string.saved) + ' '
							+ file.getAbsolutePath();
				} catch (Exception e) {
					e.printStackTrace();
					r = getString(R.string.err) + ' ' + e.toString();
				}
			} else
				r = getString(R.string.err);
			Toast.makeText(getActivity(), r, Toast.LENGTH_LONG).show();
		}
	}
}
