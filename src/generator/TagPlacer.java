package generator;

import java.awt.geom.Point2D;

public class TagPlacer{
	
	float theta = 0;
	float radius = 0;
	Point2D currentLocation = null;
	 TagPlacer(){
		 
	 }
	
	//Capitalize the first letter of the word
	
	// Return the location to place the first tag in the center of the field
	/*public Point2D placeFirst(int tagWidth, int tagHeight, int fieldWidth, int fieldHeight){
		Point2D first = new Point2D.Double((fieldWidth-tagWidth)/2, (fieldHeight-tagHeight)/2);
		return first;
	}*/
	
	// Return the location to place the tag along an ever-increasing spiral path
	public Point2D place(int tagWidth, int tagHeight, int fieldWidth, int fieldHeight){
		float theaIncrement = (float) Math.toRadians(9);		
		
		
		float centreX = (fieldWidth-tagWidth)/2;
		float centreY = (fieldHeight-tagHeight)/2;
		
		float x = (float) (Math.cos(theta) * radius + centreX);
		float y = (float) (Math.sin(theta) * radius + centreY);
		
		Point2D placement = new Point2D.Double(x,y);
		radius += (float) Math.PI*0.1;
		theta += theaIncrement; 
		return placement;
	}
	
	/*public static void main(String[] args){
		TagPlacer test = new TagPlacer();
		for(int i = 0; i< 50 ;i++) {
		//System.out.println(test.place(800, 800).getX() + ", " + test.place(800, 800).getY());
		}
	}*/
}