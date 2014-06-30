package generator;
import java.util.ArrayList;
import java.util.HashMap;


public class ProcessMultipleFiles{
	ArrayList<String> tagList = new ArrayList<String>();
	ArrayList<String> tagList2 = new ArrayList<String>();
	TextExtractor tx;
	TagMap tmpMap = new TagMap();
	TagMap tmpMap1 = new TagMap();
	TagMap tmpMap2 = new TagMap();
	//TextExtractor tx2 = new TextExtractor();
	//For draw tester strings
	public ArrayList<String> lineOfString = new ArrayList<String>();
	
	
	//Return number of tag list needed to be generated
	public int getTagMapNo(){
		int count = 0;
		
		return count;
	}
	
	protected void readFile(String file){
		if(file.endsWith(".pdf")) {
			tx.readPdfFile(file);
		}
		else if(file.endsWith(".txt")) {
		    System.out.println("You are reading a text file, skip format convention.");
		}
		else if((file.endsWith(".doc"))||(file.endsWith(".docx"))||
				(file.endsWith(".xls"))||(file.endsWith(".xlsx"))||
				(file.endsWith(".ppt"))||(file.endsWith(".pptx"))||
				(file.endsWith(".pub"))||(file.endsWith(".pubx"))||
				(file.endsWith(".vsd"))||(file.endsWith(".vsdx"))) {
			tx.readDocFile(file);
		}
		else
			System.out.println("ERROR");
	}
	
	public TagMap singleTagMap(String file){
		//TextExtractor tx = new TextExtractor();
		tx = new TextExtractor();
		readFile(file);
		tx.collectWord(file);
		tx.tm.sortByOccurrence();
		//tx.deleteTempFile(file);
		return tmpMap = tx.tm;
	}
	
	public TagMap totalTagMap(String file1, String file2){
		//TextExtractor tx = new TextExtractor();
		tx = new TextExtractor();
		readFile(file1);
		readFile(file2);
		tx.collectWord(file1);
		tx.collectWord(file2);
		tx.tm.sortByOccurrence();
		//tx.deleteTempFile(file1);
		//tx.deleteTempFile(file2);
		return tmpMap = tx.tm;
		
	}
	
	public  ResultTwoMap commonTagMap(String file1, String file2){
		tmpMap = totalTagMap(file1,file2);
		tmpMap.sortByOccurrence();
		tagList = tmpMap.tagList;
		tmpMap1 = singleTagMap(file1);
		tmpMap2 = singleTagMap(file2);
		TagMap newMap1 = new TagMap();
		TagMap newMap2 = new TagMap();
		for(int i = 0; i<tagList.size();i++){
			String tmp = tagList.get(i);
			if((tmpMap1.tagList.contains(tmp)==true)&&(tmpMap2.tagList.contains(tmp)==true)){
				//tagList2.add(tmp);
				newMap1.putTag(tmp, tmpMap1.getCount(tmp));
				newMap2.putTag(tmp, tmpMap2.getCount(tmp));
				System.out.println(tmp);
			}
		}	
		newMap1.sortByOccurrence();
		newMap2.sortByOccurrence();
		//System.out.println("_____________________");
		//printMethodForOneList(tmpMap2);
		//tx.deleteTempFile(file1);
		//tx.deleteTempFile(file2);
		return new ResultTwoMap(newMap1,newMap2);	
	}
	
	protected TagMap differentTagList(String file1, String file2){
		tmpMap = totalTagMap(file1,file2);
		tmpMap.sortByOccurrence();
		tagList = tmpMap.tagList;
		tmpMap1 = singleTagMap(file1);
		tmpMap2 = singleTagMap(file2);
		TagMap newMap = new TagMap();
		for(int i = 0; i<tagList.size();i++){
			String tmp = tagList.get(i);
			if((tmpMap1.tagList.contains(tmp)==true)&&(tmpMap2.tagList.contains(tmp)==false)){
				//tagList2.add(tmp);
				newMap.putTag(tmp, tmpMap1.getCount(tmp));
			}
			else if((tmpMap2.tagList.contains(tmp)==true)&&(tmpMap1.tagList.contains(tmp)==false)){
				//tagList2.add(tmp);
				newMap.putTag(tmp, tmpMap2.getCount(tmp));
			}
		}
		newMap.sortByOccurrence();
		//tx.deleteTempFile(file1);
		//tx.deleteTempFile(file2);
		return newMap;
	}
	
	public void printMethodForOneList(TagMap map){
		map.sortByOccurrence();
		tagList = map.tagList;
		//Test
		for(int i = 0; i<tagList.size();i++){
			String tmp = tagList.get(i);
			System.out.println(tmp+ " : " +map.getCount(tmp));
			lineOfString.add(tmp+ " : " +map.getCount(tmp));
		}
	}
	
	public void printMethodForTwoLists(ResultTwoMap doubleMap){
		tagList = tagList2;
		//Test first Map
		for(int i = 0; i<tagList.size();i++){
			String tmp = tagList.get(i);
			System.out.println(tmp+ " : " +doubleMap.map1.getCount(tmp));
		}
		System.out.println("---------------------Divided line-----------------------");
		//Test Second Map
		for(int i = 0; i<tagList.size();i++){
			String tmp = tagList.get(i);
			System.out.println(tmp+ " : " +doubleMap.map2.getCount(tmp));
		}
		tagList2.clear();
	}
	
	protected void printDifferentTagList(HashMap<String,Integer> map){
		for(int i = 0; i<tagList2.size();i++){
			String tmp = tagList2.get(i);
			System.out.println(tmp+ " : " +map.get(tmp));
		}
		tagList2.clear();
	}
	
	public class ResultTwoMap{
		private TagMap map1;
		private TagMap map2;
		ResultTwoMap(TagMap m1,TagMap m2){
			map1 = m1;
			map2 = m2;
		}
		
		public TagMap getMap1(){
			return map1;
		}

		public TagMap getMap2() {
			return map2;
		}
		
	}
	/*public static void main(String[] args){
		ProcessMultipleFiles pf = new ProcessMultipleFiles();
		String filename = "Project Design.docx";
		String filename2 ="word.pdf";
		//pf.printMethodForTwoLists(pf.commonTagMap(filename, filename2));
		System.out.println("---------------------Test!!!-----------------------");
		pf.printMethodForOneList(pf.differentTagList(filename, filename2));
	}*/
	
}