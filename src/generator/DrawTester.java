package generator;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class DrawTester{
	int fieldWidth = 800;
	int fieldHeight = 600;
	
	BufferedImage bi = new BufferedImage(fieldWidth, fieldHeight, BufferedImage.TYPE_INT_ARGB);
	public Graphics2D g = bi.createGraphics();
	Font font = new Font("TimesRoman", Font.BOLD, 20);
	
	
	public void drawStrings(String path, ArrayList<String> ln, int x, int y, Graphics2D g) throws IOException
    {
        int h = g.getFontMetrics().getHeight();
        g.setPaint(Color.black);
        for (int i=0; i<ln.size(); i++)
        {
            g.drawString(ln.get(i), x, y+(h*i) + h);
 
        }
        File f = new File(path+"uploadedFiles\\test.png");
        ImageIO.write(bi, "PNG", f);
        System.out.println("YES!");
        System.out.println(f.getAbsolutePath());
    }
	/*public static void main(String[] args){
		ProcessMultipleFiles pf = new ProcessMultipleFiles();
		String filename = "Project Design.docx";
		pf.printMethodForOneList(pf.singleTagMap(filename));
		DrawTester dt = new DrawTester();
	    try {
			//dt.drawStrings(,pf.lineOfString, 20, 20, dt.g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}