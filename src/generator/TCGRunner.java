package generator;

import generator.ProcessMultipleFiles.ResultTwoMap;
import java.io.IOException;

public class TCGRunner{
	ProcessMultipleFiles pf;
	TagCloudGenerator tcg1;
	TagCloudGenerator tcg2;
	TagMap map1;
	TagMap map2;
	public boolean drawn;
	
	//TCGRunner for single file
	public TCGRunner(){
		
	}
	
	public boolean singleFileProcessing(String filename, String filepath){
		drawn = false;
		pf = new ProcessMultipleFiles();
		map1 = pf.singleTagMap(filepath+"uploadedFiles/"+filename);
		if(!map1.isEmpty() && map1.validated==true){
			tcg1 = new TagCloudGenerator(map1);
			try {
				tcg1.drawCloud(filepath, filename);
				drawn = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return drawn;
	}
	
	public boolean multipleFileProcessing(String file1, String file2, String filepath, String option, int index){
		drawn = false;
		pf = new ProcessMultipleFiles();
		if((option.equals("single"))||(option.equals("common"))){
			if(option.equals("single")){
				map1 = pf.singleTagMap(filepath+"uploadedFiles/"+file1);
				map2 = pf.singleTagMap(filepath+"uploadedFiles/"+file2);
			}
			else{ // Common
				ResultTwoMap maps = pf.commonTagMap(filepath+"uploadedFiles/"+file1, filepath+"uploadedFiles/"+file2);
				map1 = maps.getMap1();
				map2 = maps.getMap2();
			}
			if(!map1.isEmpty() && map1.validated==true && !map2.isEmpty() && map2.validated==true){
				tcg1 = new TagCloudGenerator(map1);
				tcg2 = new TagCloudGenerator(map2);
				try {
					if (index>0){
						file1 = file1+Integer.toString(index);
						file2 = file2+Integer.toString(index);
					}
					tcg1.drawCloud(filepath, file1);
					tcg2.drawCloud(filepath, file2);
					drawn = true;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if((option.equals("total"))||(option.equals("different"))){
			if(option.equals("total")){
				map1 = pf.totalTagMap(filepath+"uploadedFiles/"+file1, filepath+"uploadedFiles/"+file2);	
			}
			else{ // Different
				map1 = pf.differentTagList(filepath+"uploadedFiles/"+file1, filepath+"uploadedFiles/"+file2);

			}
			if(!map1.isEmpty() && map1.validated==true){
				tcg1 = new TagCloudGenerator(map1);
				try {
					if (index>0){
						file1 = file1+Integer.toString(index);
					}
					tcg1.drawCloud(filepath, file1);
					drawn = true;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return drawn;
	}
}