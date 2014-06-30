package generator;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class BBTreeBuilder {
	
	public BBTree makeTree(Shape shape){
		Rectangle2D boundingBox = shape.getBounds2D();
		int x = (int) boundingBox.getX();// get the x-coordinate of the upper-left point of this rectangle
		int y = (int) boundingBox.getY();// get the y-coordinate of the upper-left point of this rectangle
		int height = (int) boundingBox.getHeight();
		int width = (int) boundingBox.getWidth();
		int bottom = y + height;// y-coordinate of the lower-right point
		int right = x + width;// x-coordinate of the lower-right point
		BBTree tree = makeTree(shape,x,y,right,bottom);
		return tree;
	}
    
	private BBTree makeTree(Shape shape, int left, int top, int right, int bottom){
		int height = bottom - top;
		int width = right - left;
		
		BBTree tree = new BBTree(left, top, right, bottom);
		if (shape.contains(left, top, width, height)){
			return tree;
		}
		else if (shape.intersects(left, top, width, height)){
			// make smaller BBTrees
			if ((width > 1) && (height > 1)) {// not too small
				BBTree upperLeft = makeTree(shape, left, top, (left+right)/2, (top+bottom)/2);
				BBTree upperRight = makeTree(shape, (left+right)/2, top, right, (top+bottom)/2);
				BBTree lowerLeft = makeTree(shape, left, (top+bottom)/2, (left+right)/2, bottom);
				BBTree lowerRight = makeTree(shape, (left+right)/2, (top+bottom)/2, right, bottom);
				// add these four child trees to the parent tree
				tree.addChildren(upperLeft, upperRight, lowerLeft, lowerRight);
			}
			return tree;
		}
		else {
			return null;
		}
	}
}