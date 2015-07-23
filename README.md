## Android JLaTeXMath
Android JLaTeXMath Library - Displays LaTeX commands.
### About
Android JLaTeXMath is an fork with a lot of modifications to support JLaTeXMath library in Android OS.<br>
Minimal SDK is 9. Tested on Android 2.3.4, 4.4, 5.0.1<br>
© 2015 Maksim Bartosh <mksm.brtsh@gmail.com><br>
See AUTHORS file for all contributors' information.
### Usage
Assets not support in android library. This project is a skeleton application.<br>
To used JLaTeXMath need init it by command:<br>
```
jLatexMath.init(Context context); \\ init library: load fonts, create paint, etc.
```
<br>To compilite math formula used TeXFormula class:<br>
```
TeXFormula formula = new TeXFormula(mLatex);
```
<br>To create bitmap used TeXIcon class:<br>
```
TeXIcon icon = formula.new TeXIconBuilder()
.setStyle(TeXConstants.STYLE_DISPLAY)
.setSize(12)
.setWidth(TeXConstants.UNIT_PIXEL, 100, TeXConstants.ALIGN_LEFT)
.setIsMaxWidth(true)
.setInterLineSpacing(TeXConstants.UNIT_PIXEL,5).build();
icon.setInsets(new Insets(5, 5, 5, 5));
Bitmap image = Bitmap.createBitmap(icon.getIconWidth(), icon.getIconHeight(),Config.ARGB_8888);
Canvas g2 = new Canvas(image);
g2.drawColor(Color.WHITE);
icon.paintIcon(g2, 0, 0);
```

### Fealture

