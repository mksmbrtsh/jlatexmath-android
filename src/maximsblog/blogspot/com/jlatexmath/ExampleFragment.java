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
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ExampleFragment extends Fragment {

	public static android.support.v4.app.Fragment newInstance(String latex) {
		ExampleFragment fragment = new ExampleFragment();
		fragment.setFormula(latex);
		return fragment;
	}

	private String mLatex;
	private float mTextSize = 16;
	private void setFormula(String latex) {
		mLatex = latex;
	}
	private void setTextSize(float size) {
		mTextSize = size;
	}

	private ImageView mImageView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_example,
				container, false);
		mImageView = (ImageView)layout.findViewById(R.id.imageView1);
		

		TeXFormula formula = new TeXFormula(mLatex);
		TeXIcon icon = formula.new TeXIconBuilder()
				.setStyle(TeXConstants.STYLE_DISPLAY).setSize(mTextSize).setWidth(TeXConstants.UNIT_PIXEL, getResources().getDisplayMetrics().widthPixels, TeXConstants.ALIGN_LEFT).setIsMaxWidth(true).build();
		icon.setInsets(new Insets(5, 5, 5, 5));

		Bitmap image = Bitmap.createBitmap(icon.getIconWidth(),
				icon.getIconHeight(), Config.ARGB_8888);

		Canvas g2 = new Canvas(image);
		g2.drawColor(Color.WHITE);
		icon.paintIcon(g2, 0, 0);
		mImageView.setImageBitmap(image);
		/*String root = Environment.getExternalStorageDirectory().toString();
		File myDir = new File(root + "/saved_images");
		myDir.mkdirs();
		Random generator = new Random();
		int n = 10000;
		n = generator.nextInt(n);
		String fname = "Image" + ".png";
		File file = new File(myDir, fname);
		if (file.exists())
			file.delete();
		try {
			FileOutputStream out = new FileOutputStream(file);
			image.compress(Bitmap.CompressFormat.PNG, 90, out);
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		return layout;
	}
}
