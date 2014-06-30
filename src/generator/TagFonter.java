package generator;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import org.apache.commons.lang3.text.WordUtils;

public class TagFonter{
	String capitalizeTag;
	double fontSize;
	int direction;
	float minFontSize = 10;//need to specify
	float maxFontSize = 72;//same
	double maxWeight;
	double weight;
	String word;
	
	TagFonter(){}
	
	TagFonter(double maxWeight, double weight, String word){
		this.maxWeight= maxWeight;
		this.weight = weight;
		this.word= word;
		this.fontSize = computeFontSize(minFontSize,maxFontSize);
	}

	public String toCapitalize(String word){
		capitalizeTag = WordUtils.capitalize(word);
		return capitalizeTag;
	}
	
	public double getFontSize(){
		return fontSize;
	}
	
	public void setFontSize(float size){
		
	}
	
	public Font setFontStyle(String font){
		// For the size will be resized in TagShaper,
		// so the font size here can be anything
		return new Font(font, Font.BOLD, 1);
	}
	
	public Color randomColor(){
		Random rand = new Random();
		float red = rand.nextFloat();
		float green = rand.nextFloat();
		float blue = rand.nextFloat();
		Color randomColor = new Color(red, green, blue);
		return randomColor;
	}
	
	public void chooseFontDirection(){
		
	}
	
	private double computeFontSize(double min, double max){
		double size;
		if(maxWeight>1){
			size = (Math.log(weight)/Math.log(maxWeight)*(max-min)+min);
		}
		else{
			size = max;
		}
		//System.out.println(size);
		return size;
	}
	
	public static void main(String[] args){
		TagFonter tf = new TagFonter(100,1,"Cut");
		System.out.println(tf.computeFontSize(10, 72));
	}
}