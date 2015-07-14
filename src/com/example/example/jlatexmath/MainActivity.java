package com.example.example.jlatexmath;

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
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView i = (ImageView) findViewById(R.id.imageView1);
		jLatexMath.init(this);
		
/*		String latex = "\\begin{array}{lr}\\mbox{\\textcolor{Blue}{Russian}}&\\mbox{\\textcolor{Melon}{Greek}}\\\\";
		latex += "\\mbox{" + "привет мир".toUpperCase() + "}&\\mbox{" + "γειά κόσμο".toUpperCase() + "}\\\\";
		latex += "\\mbox{привет мир}&\\mbox{γειά κόσμο}\\\\";
		latex += "\\mathbf{\\mbox{привет мир}}&\\mathbf{\\mbox{γειά κόσμο}}\\\\";
		latex += "\\mathit{\\mbox{привет мир}}&\\mathit{\\mbox{γειά κόσμο}}\\\\";
		latex += "\\mathsf{\\mbox{привет мир}}&\\mathsf{\\mbox{γειά κόσμο}}\\\\";
		latex += "\\mathtt{\\mbox{привет мир}}&\\mathtt{\\mbox{γειά κόσμο}}\\\\";
		latex += "\\mathbf{\\mathit{\\mbox{привет мир}}}&\\mathbf{\\mathit{\\mbox{γειά κόσμο}}}\\\\";
		latex += "\\mathbf{\\mathsf{\\mbox{привет мир}}}&\\mathbf{\\mathsf{\\mbox{γειά κόσμο}}}\\\\";
		latex += "\\mathsf{\\mathit{\\mbox{привет мир}}}&\\mathsf{\\mathit{\\mbox{γειά κόσμο}}}\\\\";
		latex += "&\\\\";
		latex += "\\mbox{\\textcolor{Salmon}{Bulgarian}}&\\mbox{\\textcolor{Tan}{Serbian}}\\\\";
		latex += "\\mbox{здравей свят}&\\mbox{Хелло уорлд}\\\\";
		latex += "&\\\\";
		latex += "\\mbox{\\textcolor{Turquoise}{Bielorussian}}&\\mbox{\\textcolor{LimeGreen}{Ukrainian}}\\\\";
		latex += "\\mbox{прывітаньне Свет}&\\mbox{привіт світ}\\\\";
		latex += "\\end{array}";
		*/
		String latex = "2*2=4";

		TeXFormula formula = new TeXFormula(latex);
		// Note: Old interface for creating icons:
		//TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20);
		// Note: New interface using builder pattern (inner class):
		TeXIcon icon = formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY).setSize(20).build();
		icon.setInsets(new Insets(5, 5, 5, 5));

		Bitmap image = Bitmap.createBitmap(icon.getIconWidth(), icon.getIconHeight(), Config.ARGB_8888);
		
		Canvas g2 = new Canvas(image);
		g2.drawColor(Color.WHITE);
		icon.paintIcon(g2, 0, 0);
		i.setImageBitmap(image);
		String root = Environment.getExternalStorageDirectory().toString();
		File myDir = new File(root + "/saved_images");    
		myDir.mkdirs();
		Random generator = new Random();
		int n = 10000;
		n = generator.nextInt(n);
		String fname = "Image"+".png";
		File file = new File (myDir, fname);
		if (file.exists ()) file.delete (); 
		try {
		       FileOutputStream out = new FileOutputStream(file);
		       image.compress(Bitmap.CompressFormat.PNG, 90, out);
		       out.flush();
		       out.close();

		} catch (Exception e) {
		       e.printStackTrace();
		}
	}

	
}
