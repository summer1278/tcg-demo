package generator;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class TagCloudGenerator {
	final int maxTagsToDisplay = 50;// Initialize
	TagMap currentMap;
	ArrayList<String> outputWordList;
	ArrayList<TagCloud> outputTagList;
	//int tagListNo;
	private int cloudIndex = 0;
	final int fieldWidth = 800;
	final int fieldHeight = 800;
	TagFonter choser = new TagFonter();
	
	private BufferedImage bi = new BufferedImage(fieldWidth, fieldHeight, BufferedImage.TYPE_INT_ARGB);
	private Graphics2D output = bi.createGraphics();

	TagPlacer tp = new TagPlacer();
	int attempt = 0;
	
	TagCloudGenerator(TagMap map) {
		currentMap = map;
		outputWordList = map.tagList;
		outputTagList = tagToTagCloud(map);
	}
	
	private ArrayList<TagCloud> tagToTagCloud(TagMap map){
		ArrayList<String> tagList = limitMax(map.tagList);
		ArrayList<TagCloud> cloudList = new ArrayList<TagCloud>();
		for (int i = 0; i < tagList.size(); i++) {
			String word = tagList.get(i);
			TagCloud tempCloud = new TagCloud(map, word);
			cloudList.add(tempCloud);
		}
		
		return cloudList;
	}
	
	// Limit the output list as the size what we expected
	private ArrayList<String> limitMax(ArrayList<String> list) {
		ArrayList<String> tempList = new ArrayList<String>();
		if(list.size() > maxTagsToDisplay) {
			for(int i = 0; i < maxTagsToDisplay; i++) {
				String word = list.get(i);
				tempList.add(word);
			}
			return tempList;
		}
		else {
			return list;
		}
		
	}
	
	public boolean placeTag(TagCloud cloud) {
		Rectangle2D box = cloud.getShape().getBounds2D();
		int tagHeight = (int) box.getHeight();
		int tagWidth = (int) box.getWidth();
		
		TagCloud lastCollidedCloud = null;
		/*if(attempt == 0) {
			cloud.setFirstLocation(tp,tagWidth,tagHeight,fieldWidth, fieldHeight);
			attempt ++;// First word has been placed
			cloud.moveToFinalLocation();
			lastCollidedCloud = cloud;
			return true;
		}
		else {*/
			cloud.setDesiredLocation(tp, tagWidth,tagHeight,fieldWidth, fieldHeight);
			
			boolean foundCollide = false;
			//do {
			for(int j= 0;j<1000;j++){
				//cloud.setDesiredLocation(tp, tagWidth,tagHeight,fieldWidth, fieldHeight);
				cloud.move(tp.place(tagWidth,tagHeight,fieldWidth, fieldHeight));// Place word again
				Point2D tmpLocation = cloud.getCurentLocation();
				if ((lastCollidedCloud != null)&&(cloud.testAllCollide(lastCollidedCloud))) 
					continue;
				if((tmpLocation.getX() < 0)||(tmpLocation.getY() < 0)||
				((tmpLocation.getX()+tagWidth) >= fieldWidth)||
				((tmpLocation.getY()+tagHeight) >= fieldHeight))// Exceed the field
					continue;
				
				foundCollide = false;
			
					for(int i = 0; !foundCollide&&i < cloudIndex; i++) {
						TagCloud otherCloud = outputTagList.get(i);
						//System.out.println("Testing");
						if(cloud.testAllCollide(otherCloud)) {
							//System.out.println("Collide");
							foundCollide = true;
							lastCollidedCloud = otherCloud;
						}
					}
				// After test all clouds still not found collision
				if(!foundCollide){
					cloud.moveToFinalLocation();
					//System.out.println("Not Collide");
					return true;
				}
			}
			//} while(foundCollide);
			/*} while((tmpLocation.getX() < 0)||(tmpLocation.getY() < 0)||
					((tmpLocation.getX()+tagWidth) >= fieldWidth)||
					((tmpLocation.getY()+tagHeight) >= fieldHeight)||// Exceed the field
					((lastCollidedCloud != null)&&(cloud.testAllCollide(lastCollidedCloud))));// Collide
					*/
		//}
		
		return false;
	}
	
	public void drawTag(TagCloud cloud){
		GeneralPath path = new GeneralPath(cloud.getShape());
		//Point2D location = cloud.getCurentLocation();
		output.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//output.translate(location.getX(), location.getY());
		//System.out.println(cloud.word);
		//System.out.println(location.getX()+"," +location.getY());
		output.setPaint(cloud.getColor(choser));
		output.fill(path);
	}
	
	public void drawCloud(String path, String file) throws IOException{
		while(cloudIndex < outputTagList.size()) {
			TagCloud tempCloud = outputTagList.get(cloudIndex);
			//System.out.println(cloudIndex);
			boolean wasPlaced = placeTag(tempCloud);
			if(wasPlaced) {
				drawTag(tempCloud);	
				cloudIndex++;
			}
		}
		File f = new File(path + "uploadedFiles\\"+file+".png");
        ImageIO.write(bi, "PNG", f);
		
	}
	
	/*
	public static void main(String[] args) {
		ProcessMultipleFiles pf = new ProcessMultipleFiles();
		String filename = "Project Design.docx";
		TagMap tm = pf.singleTagMap(filename);
		tm.sortByOccurrence();
		//pf.printMethodForOneList(tm);
		TagCloudGenerator tcg = new TagCloudGenerator(tm);
		try {
			tcg.drawCloud();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}*/
	
	
}