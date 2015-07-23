## Android JLaTeXMath
![MainScreen](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141601.png)
Android JLaTeXMath Library - Displays LaTeX commands.
### About
Android JLaTeXMath is an fork with a lot of modifications to support JLaTeXMath library in Android OS.<br>
Minimal SDK is 9. Tested on Android 2.3.4, 4.4.4 and 5.0.1<br>
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
* support russian and greek fonts;<br>
* Library create bitmaps. If bitmap draw in screen, then OS core may be throw exception Out of memory;<br>
* Text size set in SP (look android docs);<br>
* If InterLineSpacing setup, then formula may be create in multiline mode (Example7);<br>
* Library support GraphicsBox, set absolutly path to file. Bitmap not scaled! OS core may be throw exception Out of memory.
### Project base
android-support-v4.jar not must field. You can delete this lib.
### Screenshots
![Screen1](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141629.png)
![Screen2](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141710.png)
![Screen3](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141738.png)
![Screen4](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141754.png)
![Screen5](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141814.png)
![Screen6](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141823.png)
![Screen7](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141833.png)


