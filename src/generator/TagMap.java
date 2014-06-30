package generator;
/*
 * 
 * 
 * 
 */

import java.util.*;


public class TagMap {
	Hashtable<String, Integer> map;
	private Hashtable[] bucket;
	ArrayList<String> tagList = new ArrayList<String>();
	private int tableSize;
	private static final int DEFAULT_SIZE = 11;
	public boolean validated = false;
	//Load word filter for stopping bad words
	WordFilter wf = new WordFilter();

	//Constructor
	TagMap(){
		this(DEFAULT_SIZE);
	}
	
	TagMap(int size){
		int index;
		tableSize = size;
		bucket = new Hashtable[tableSize];
		for(index = 0; index < tableSize ;++index){
			bucket[index] = new Hashtable<String, Integer>();
		}
	}

	
	//Add tag and its occurrence to the map
	private void addTag(Hashtable<String, Integer> map, String word) {
		Object obj = map.get(word);
	    if (obj == null) {
	    		tagList.add(word);
	    		map.put(word, 1);
	    } 
	    else {
	    	int i = ((Integer) obj).hashCode() + 1;
	    	map.put(word, new Integer(i));
	    }
	
	}
	
	//Add tag and its occurrence to the map from other class
	public void putTag(String word, int count){
		map = bucket[hash(word)];
		Object obj = map.get(word);
		if (obj==null){
		tagList.add(word);
		map.put(word, count);
		}
	}
	
	//Remove tag
	public boolean removeTag(String word){
		if(getCount(word)>0){
			int currentBucket = hash(word);
			map = bucket[currentBucket];
			map.remove(word);
			return true;
		}
		else{
			return false;
		}
	}
	

	//Get current occurrence for this tag
	public int getCount(String word){
		int count = 0;
		if(tagList.contains(word)==true){
			int currentBucket = hash(word);
			map = bucket[currentBucket];
			count = map.get(word);
		}
		return count;
	}
	
	//Collect tags from line
	public void processLine(String line) {
		line = line.toLowerCase();
		line = line.replaceAll("[^a-z]"," ");//spit symbols and numbers
		if(line.trim().length()==0){
			validated = false;
		}
		else{
		    StringTokenizer st = new StringTokenizer(line);
		    while (st.hasMoreTokens()) {
		    	String tag = st.nextToken();
		    	map = bucket[hash(tag)];
		    	//Tag is not stop word and not one alphabet
		    if((wf.stopWordsList.contains(tag)==false)&&(tag.length()>1)){
		    		addTag(map, tag);
		    		validated = true;
		    	}
		    }
		}
	  }
	
	//Test if it is empty
	public boolean isEmpty(){
		return tagList == null;
	}
	
	//Hash Function
	private int hash(String word) {
        int hashVal = 0;
        
        for (int i = 0; i < word.length(); i++) {
            hashVal = 37 * hashVal + word.charAt(i);
        }
        
        hashVal %= bucket.length;
        if (hashVal < 0) {
            hashVal += bucket.length;
        }
        
        return hashVal;
    }
	
	//Compare occurrence
	public void sortByOccurrence(){
		Collections.sort(tagList,getTagCountComparator());
	}
	
	//Create count comparator
	private Comparator<String> getTagCountComparator() {
		return new Comparator<String>(){
			public int compare(String s1, String s2){
				//Sort in descending order by occurrence
				return((Integer) getCount(s2)).compareTo((Integer) getCount(s1));
			}
		};
	}
	
	
	//Test Method
	protected void printTag(){
		for(int i = 0; i<bucket.length;i++){
			map = bucket[i];
			Enumeration<String> e = map.keys();
		    while (e.hasMoreElements()) {
		      String key = e.nextElement();
		      System.out.println(key + " : " + map.get(key));
		    }
		}
	}
	
	//Test Method 2
	protected void printTagByOrder(){
		sortByOccurrence();
		for(int i = 0; i<tagList.size();i++){
			String tmp = tagList.get(i);
			System.out.println(tmp+ " : " +getCount(tmp));
		}
	}
	
	
	
}