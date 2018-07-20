## aJLaTeXMath
[![](https://owncloud.org/wp-content/themes/owncloudorgnew/assets/img/clients/buttons/googleplay.png)](https://play.google.com/store/apps/details?id=maximsblog.blogspot.com.jlatexmath)    
aJLaTeXMath Library - Displays LaTeX commands.  
[![Tweet](https://img.shields.io/twitter/url/http/shields.io.svg?style=social)](https://twitter.com/intent/tweet?text=Get%20jlatexmath-android%20170%20free%204&url=https://github.com/mksmbrtsh/jlatexmath-android&via=mksmbrtsh&hashtags=timestatistic,android,androidapp)  
[![](https://upload.wikimedia.org/wikipedia/ru/d/d6/Sberbank.svg)](https://www.sberbank.ru/ru/person)  
Russian bank card: 4817 7601 3803 3687
![MainScreen](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141601.png)  
## About
I find [this page](http://forge.scilab.org/index.php/p/jlatexmath/page/GSOC-2014) and think, why not?<br>
aJLaTeXMath is an fork with a lot of modifications to support [jlatexmath](https://github.com/opencollab/jlatexmath) in Android OS.<br>
Minimal SDK is 9. Tested on Android 2.3.4, 4.0.2, 4.4.4 and 5.0.1<br>
© 2015 Maksim Bartosh <mksm.brtsh@gmail.com><br>
See AUTHORS file for all contributors' information.
## Usage
Assets not support in android library. This project is a skeleton application.<br>
To used JLaTeXMath need init it by command:<br>
```java
AjLatexMath.init(context); \\ init library: load fonts, create paint, etc.
```
<br>To compilite math formula used TeXFormula class:<br>
```java
TeXFormula formula = new TeXFormula(formulaString);
```
<br>To create bitmap used TeXIcon class:<br>
```java
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
## Fealture
1. Support russian and greek fonts;
2. Library create bitmaps. If bitmap draw in screen, then OS core may be throw exception Out of memory;
3. Text size set in SP (look android docs);
4. If InterLineSpacing setup, then formula may be create in multiline mode (Example7);
5. Library support GraphicsBox, set absolutly path to file. Bitmap not scaled! OS core may be throw exception Out of memory.


## Project base
android-support-v4.jar not must field. You can delete this lib.
## Screenshots
![Screen1](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141629.png)<br>
![Screen2](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141710.png)<br>
![Screen3](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141738.png)<br>
![Screen4](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141754.png)<br>
![Screen5](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141814.png)<br>
![Screen6](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141823.png)<br>
![Screen7](https://raw.githubusercontent.com/mksmbrtsh/jlatexmath-android/master/device-2015-07-23-141833.png)
### Examples
```jave
private static String mExample1 = "\\begin{array}{lr}\\mbox{\\textcolor{Blue}{Russian}}&\\mbox{\\textcolor{Melon}{Greek}}\\\\"
			+ "\\mbox{"
			+ "привет мир".toUpperCase()
			+ "}&\\mbox{"
			+ "γειά κόσμο".toUpperCase()
			+ "}\\\\"
			+ "\\mbox{привет мир}&\\mbox{γειά κόσμο}\\\\"
			+ "\\mathbf{\\mbox{привет мир}}&\\mathbf{\\mbox{γειά κόσμο}}\\\\"
			+ "\\mathit{\\mbox{привет мир}}&\\mathit{\\mbox{γειά κόσμο}}\\\\"
			+ "\\mathsf{\\mbox{привет мир}}&\\mathsf{\\mbox{γειά κόσμο}}\\\\"
			+ "\\mathtt{\\mbox{привет мир}}&\\mathtt{\\mbox{γειά κόσμο}}\\\\"
			+ "\\mathbf{\\mathit{\\mbox{привет мир}}}&\\mathbf{\\mathit{\\mbox{γειά κόσμο}}}\\\\"
			+ "\\mathbf{\\mathsf{\\mbox{привет мир}}}&\\mathbf{\\mathsf{\\mbox{γειά κόσμο}}}\\\\"
			+ "\\mathsf{\\mathit{\\mbox{привет мир}}}&\\mathsf{\\mathit{\\mbox{γειά κόσμο}}}\\\\"
			+ "&\\\\"
			+ "\\mbox{\\textcolor{Salmon}{Bulgarian}}&\\mbox{\\textcolor{Tan}{Serbian}}\\\\"
			+ "\\mbox{здравей свят}&\\mbox{Хелло уорлд}\\\\"
			+ "&\\\\"
			+ "\\mbox{\\textcolor{Turquoise}{Bielorussian}}&\\mbox{\\textcolor{LimeGreen}{Ukrainian}}\\\\"
			+ "\\mbox{прывітаньне Свет}&\\mbox{привіт світ}\\\\"
			+ "\\end{array}";

	private static String mExample2 = "\\begin{array}{l}"
			+ "\\forall\\varepsilon\\in\\mathbb{R}_+^*\\ \\exists\\eta>0\\ |x-x_0|\\leq\\eta\\Longrightarrow|f(x)-f(x_0)|\\leq\\varepsilon\\\\"
			+ "\\det\\begin{bmatrix}a_{11}&a_{12}&\\cdots&a_{1n}\\\\a_{21}&\\ddots&&\\vdots\\\\\\vdots&&\\ddots&\\vdots\\\\a_{n1}&\\cdots&\\cdots&a_{nn}\\end{bmatrix}\\overset{\\mathrm{def}}{=}\\sum_{\\sigma\\in\\mathfrak{S}_n}\\varepsilon(\\sigma)\\prod_{k=1}^n a_{k\\sigma(k)}\\\\"
			+ "\\sideset{_\\alpha^\\beta}{_\\gamma^\\delta}{\\begin{pmatrix}a&b\\\\c&d\\end{pmatrix}}\\\\"
			+ "\\int_0^\\infty{x^{2n} e^{-a x^2}\\,dx} = \\frac{2n-1}{2a} \\int_0^\\infty{x^{2(n-1)} e^{-a x^2}\\,dx} = \\frac{(2n-1)!!}{2^{n+1}} \\sqrt{\\frac{\\pi}{a^{2n+1}}}\\\\"
			+ "\\int_a^b{f(x)\\,dx} = (b - a) \\sum\\limits_{n = 1}^\\infty  {\\sum\\limits_{m = 1}^{2^n  - 1} {\\left( { - 1} \\right)^{m + 1} } } 2^{ - n} f(a + m\\left( {b - a} \\right)2^{-n} )\\\\"
			+ "\\int_{-\\pi}^{\\pi} \\sin(\\alpha x) \\sin^n(\\beta x) dx = \\textstyle{\\left \\{ \\begin{array}{cc} (-1)^{(n+1)/2} (-1)^m \\frac{2 \\pi}{2^n} \\binom{n}{m} & n \\mbox{ odd},\\ \\alpha = \\beta (2m-n) \\\\ 0 & \\mbox{otherwise} \\\\ \\end{array} \\right .}\\\\"
			+ "L = \\int_a^b \\sqrt{ \\left|\\sum_{i,j=1}^ng_{ij}(\\gamma(t))\\left(\\frac{d}{dt}x^i\\circ\\gamma(t)\\right)\\left(\\frac{d}{dt}x^j\\circ\\gamma(t)\\right)\\right|}\\,dt\\\\"
			+ "\\begin{array}{rl} s &= \\int_a^b\\left\\|\\frac{d}{dt}\\vec{r}\\,(u(t),v(t))\\right\\|\\,dt \\\\ &= \\int_a^b \\sqrt{u'(t)^2\\,\\vec{r}_u\\cdot\\vec{r}_u + 2u'(t)v'(t)\\, \\vec{r}_u\\cdot\\vec{r}_v+ v'(t)^2\\,\\vec{r}_v\\cdot\\vec{r}_v}\\,\\,\\, dt. \\end{array}\\\\"
			+ "\\end{array}";
	
	private static String mExample3 = "\\definecolor{gris}{gray}{0.9}"
    + "\\definecolor{noir}{rgb}{0,0,0}"
    + "\\definecolor{bleu}{rgb}{0,0,1}\\newcommand{\\pa}{\\left|}"
    + "\\begin{array}{c}"
    + "\\JLaTeXMath\\\\"
    + "\\begin{split}"
    + " &Тепловой\\ поток\\ \\mathrm{Тепловой\\ поток}\\ \\mathtt{Тепловой\\ поток}\\\\"
    + " &\\boldsymbol{\\mathrm{Тепловой\\ поток}}\\ \\mathsf{Тепловой\\ поток}\\\\"
    + "|I_2| &= \\pa\\int_0^T\\psi(t)\\left\\{ u(a,t)-\\int_{\\gamma(t)}^a \\frac{d\\theta}{k} (\\theta,t) \\int_a^\\theta c(\\xi) u_t (\\xi,t)\\,d\\xi\\right\\}dt\\right|\\\\"
    + "&\\le C_6 \\Bigg|\\pa f \\int_\\Omega \\pa\\widetilde{S}^{-1,0}_{a,-} W_2(\\Omega, \\Gamma_1)\\right|\\ \\right|\\left| |u|\\overset{\\circ}{\\to} W_2^{\\widetilde{A}}(\\Omega;\\Gamma_r,T)\\right|\\Bigg|\\\\"
    + "&\\\\"
    + "&\\textcolor{magenta}{\\mathrm{Produit\\ avec\\ Java\\ et\\ \\LaTeX\\ par\\ }\\mathscr{C}\\mathcal{A}\\mathfrak{L}\\mathbf{I}\\mathtt{X}\\mathbb{T}\\mathsf{E}}\\\\"
    + "&\\begin{pmatrix}\\alpha&\\beta&\\gamma&\\delta\\\\\\aleph&\\beth&\\gimel&\\daleth\\\\\\mathfrak{A}&\\mathfrak{B}&\\mathfrak{C}&\\mathfrak{D}\\\\\\boldsymbol{\\mathfrak{a}}&\\boldsymbol{\\mathfrak{b}}&\\boldsymbol{\\mathfrak{c}}&\\boldsymbol{\\mathfrak{d}}\\end{pmatrix}\\quad{(a+b)}^{\\frac{n}{2}}=\\sqrt{\\sum_{k=0}^n\\tbinom{n}{k}a^kb^{n-k}}\\quad \\Biggl(\\biggl(\\Bigl(\\bigl(()\\bigr)\\Bigr)\\biggr)\\Biggr)\\\\"
    + "&\\forall\\varepsilon\\in\\mathbb{R}_+^*\\ \\exists\\eta>0\\ |x-x_0|\\leq\\eta\\Longrightarrow|f(x)-f(x_0)|\\leq\\varepsilon\\\\"
    + "&\\det\\begin{bmatrix}a_{11}&a_{12}&\\cdots&a_{1n}\\\\a_{21}&\\ddots&&\\vdots\\\\\\vdots&&\\ddots&\\vdots\\\\a_{n1}&\\cdots&\\cdots&a_{nn}\\end{bmatrix}\\overset{\\mathrm{def}}{=}\\sum_{\\sigma\\in\\mathfrak{S}_n}\\varepsilon(\\sigma)\\prod_{k=1}^n a_{k\\sigma(k)}\\\\"
    + "&\\Delta f(x,y)=\\frac{\\partial^2f}{\\partial x^2}+\\frac{\\partial^2f}{\\partial y^2}\\qquad\\qquad \\fcolorbox{noir}{gris}{n!\\underset{n\\rightarrow+\\infty}{\\sim} {\\left(\\frac{n}{e}\\right)}^n\\sqrt{2\\pi n}}\\\\"
    + "&\\sideset{_\\alpha^\\beta}{_\\gamma^\\delta}{\\begin{pmatrix}a&b\\\\c&d\\end{pmatrix}}\\xrightarrow[T]{n\\pm i-j}\\sideset{^t}{}A\\xleftarrow{\\overrightarrow{u}\\wedge\\overrightarrow{v}}\\underleftrightarrow{\\iint_{\\mathds{R}^2}e^{-\\left(x^2+y^2\\right)}\\,\\mathrm{d}x\\mathrm{d}y}"
    + "\\end{split}\\\\"
    + "\\rotatebox{30}{\\sum_{n=1}^{+\\infty}}\\quad\\mbox{Mirror rorriM}\\reflectbox{\\mbox{Mirror rorriM}}"
    + "\\end{array}";
	
	private static String mExample4 = "\\lim_{x \\to \\infty} \\left(1 + \\frac{1}{n} \\right)^n = e ";
	
	private static String mExample5 = "\\begin{array}{|c|l|||r|c|}"
	+ "\\hline"
	+ "\\text{Matrix}&\\multicolumn{2}{|c|}{\\text{Multicolumns}}&\\text{Font sizes commands}\\cr"
	+ "\\hline"
	+ "\\begin{pmatrix}\\alpha_{11}&\\cdots&\\alpha_{1n}\\cr\\hdotsfor{3}\\cr\\alpha_{n1}&\\cdots&\\alpha_{nn}\\end{pmatrix}&\\Large \\text{Large Right}&\\small \\text{small Left}&\\tiny \\text{tiny Tiny}\\cr"
	+ "\\hline"
	+ "\\multicolumn{4}{|c|}{\\Huge \\text{Huge Multicolumns}}\\cr"
	+ "\\hline"
	+ "\\end{array}";
	
	private static String mExample6 = "\\begin{array}{cc}"
	+ "\\fbox{\\text{A framed box with \\textdbend}}&\\shadowbox{\\text{A shadowed box}}\\cr"
	+ "\\doublebox{\\text{A double framed box}}&\\ovalbox{\\text{An oval framed box}}\\cr"
	+ "\\end{array}";
	
	private static String mExample7 = "\\mbox{abc abc abc abc abc abc abc abc abc abc abc abc abc abc\\\\abc abc abc abc abc abc abc\\\\abc abc abc abc abc abc abc}\\\\1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1";
```
See you again, dude:) 2015. 
