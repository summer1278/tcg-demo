package generator;
import java.io.*;
import java.util.ArrayList;

import com.ibm.icu.util.StringTokenizer;

public class WordFilter{
	ArrayList<String> stopWordsList = new ArrayList<String>();
	
	//Constructor
	public WordFilter(){
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(TagMap.class.getResourceAsStream("stopwordslist.txt")));
			String line;
		while ((line = in.readLine()) != null){ 
			
			StringTokenizer st = new StringTokenizer(line);
		    while (st.hasMoreTokens()) {
		      stopWordsList.add(st.nextToken());
		    }
		}
		in.close();
		}
		catch (Exception e){
	        e.printStackTrace();
		}
	}
	
	
	//Test Method
	public static void main(String[] args){
		WordFilter wf = new WordFilter();
		for(int i = 0;i < wf.stopWordsList.size();i++){
			String tmp = wf.stopWordsList.get(i);
			System.out.println(tmp);
		}
		if(wf.stopWordsList.contains("about")==true){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}
}