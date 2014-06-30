package generator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TagShaper {
	// This method to genertateShape for the tag is picked up 
	// from Steele & Iliinsky(2010:53), and change a bit to fit this program
	private static final FontRenderContext FRC
	= new FontRenderContext(null, true, true);

	public Shape generateShape(Font font, double fontSize, String word) {
		final Font sizedFont = font.deriveFont((float)fontSize);
		final char[] chars = word.toCharArray();
		//final int direction = Bidi.requiresBidi(chars, 0, chars.length) ?
			//	Font.LAYOUT_RIGHT_TO_LEFT : Font.LAYOUT_LEFT_TO_RIGHT;
		final GlyphVector gv =
				sizedFont.layoutGlyphVector(FRC, chars, 0, chars.length, Font.LAYOUT_LEFT_TO_RIGHT);
		Shape result = gv.getOutline();
		
		return result;
	}
	
	
	public Shape rotate(Shape shape, double rotation) {
		if (rotation==0){
			return shape;
		}
		else {
			return AffineTransform.getRotateInstance(rotation).createTransformedShape(shape);
		}
		
	}
	public static void main(String[] args) {
		TagShaper ts = new TagShaper();
		Shape s = ts.generateShape(new Font("TimesRoman",Font.BOLD, 1), 13, "LALALA");
		BufferedImage bi = new BufferedImage(800,800, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = bi.createGraphics();
		GeneralPath path = new GeneralPath(s);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.RED);
		g.translate(400, 400);
		g.fill(path);
		File f = new File("test.png");
        try {
			ImageIO.write(bi, "PNG", f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("YES!");
        System.out.println(s.getBounds2D().getWidth());
	}
}