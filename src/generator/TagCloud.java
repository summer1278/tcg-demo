package generator;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;

public class TagCloud {	
	final String fontStyle = "Arial";
	TagMap currentMap;
	ArrayList<String> currentTagList;
	String word;
	BBTree bbTree;
	BBTreeBuilder builder;
	
	Point2D currentLocation;
	Point2D desiredLocation;
	Point2D finalLocation;
	Shape shape;
	double maxWeight;
	double weight;
	TagFonter tf;
	
	TagCloud(TagMap map,String word) {
		currentMap = map;
		currentTagList = map.tagList;
		this.word = word;
		this.maxWeight = getMaxWeight();
		this.weight = getWeight(word);
		this.builder = new BBTreeBuilder();	
		this.tf= new TagFonter(maxWeight,weight,word);
		setShape();
	}
	
	private double getMaxWeight(){
		currentMap.sortByOccurrence();
		String maxWord = currentTagList.get(0);
		float currentMaxWeight = (float) currentMap.getCount(maxWord);
		return currentMaxWeight;
	}
	
	private float getWeight(String word){
		return currentMap.getCount(word);
	}
	
	
	public void setShape(){
		TagShaper ts = new TagShaper();
		//System.out.println(word);
		this.shape = ts.generateShape(tf.setFontStyle(fontStyle), tf.getFontSize(), tf.toCapitalize(word));
		this.bbTree = builder.makeTree(shape);
	}
	
	public Shape getShape(){
		return shape;
	}
	
	public Color getColor(TagFonter choser){
		return choser.randomColor();
	}
	
	public boolean testAllCollide(TagCloud otherTag) {
		return bbTree.testAllCollide(otherTag.bbTree);
	}
	
	/*
	public void setFirstLocation(TagPlacer tp, int tagWidth, int tagHeight, int fieldWidth, int fieldHeight){
		desiredLocation = tp.placeFirst(tagWidth,tagHeight,fieldWidth, fieldHeight);
		currentLocation = desiredLocation;
		System.out.println((int)currentLocation.getX()+"  "+ (int)currentLocation.getY());
	}*/
	
	public void setDesiredLocation(TagPlacer tp, int tagWidth, int tagHeight, int fieldWidth, int fieldHeight){
		desiredLocation = tp.place(tagWidth,tagHeight,fieldWidth, fieldHeight);
		currentLocation = desiredLocation;
		//bbTree.setRootLocation((int)currentLocation.getX(), (int)currentLocation.getY());
	}
	
	public void move(Point2D placement){
		currentLocation = placement;
		bbTree.setRootLocation((int)currentLocation.getX(), (int)currentLocation.getY());
		//System.out.println((int)currentLocation.getX()+"  "+ (int)currentLocation.getY());
	}
	
	public void moveToFinalLocation(){
		AffineTransform transform = AffineTransform.getTranslateInstance(currentLocation.getX(), 
				currentLocation.getY());
		// move the shape to our current location
		shape = transform.createTransformedShape(shape);
		bbTree.setRootLocation((int)currentLocation.getX(), (int)currentLocation.getY());
		finalLocation = currentLocation;
	}
	
	public Point2D getCurentLocation(){
		return currentLocation;
	}
	
	public boolean wasPlaced(){
		return finalLocation != null;
	}
	
	
	// Sort list in a random order
	public void sortRandom(ArrayList<String> list) {
		Collections.shuffle(list);
	}

}