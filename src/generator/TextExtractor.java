package generator;
import java.io.*;
import java.util.StringTokenizer;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.POITextExtractor;
import org.apache.poi.extractor.ExtractorFactory;



public class TextExtractor{
	//generate Tag Map for collection of tags
	TagMap tm = new TagMap();
	
	public TextExtractor(){}
	
	//Read MS Office file
		public void readDocFile(String file) {
			try {
				 File in = new File(file);
				 POITextExtractor extractor = ExtractorFactory.createExtractor(in);
				 Writer writer = new FileWriter(file+".txt");
				 writer.append(extractor.getText());
				 writer.flush();
				 writer.close();
			}
			 catch (Exception e) {
				e.printStackTrace();
			} 
			
		}

		//Read PDF file
		public void readPdfFile(String file) {
			try{
				PDDocument doc = PDDocument.load(file);
				Writer writer = new FileWriter(file+".txt");
				PDFTextStripper stripper = new PDFTextStripper();
				stripper.writeText(doc,writer);
				writer.close();
				doc.close();
			}
			catch (Exception e){
		        e.printStackTrace();
			}
		}
		
		//Read text file and collect words from it
		public void collectWord(String file) {
			try {
				BufferedReader in;
				if(!file.endsWith(".txt")){
					in = new BufferedReader(new FileReader(file+".txt"));
				}
				else {
					//Read text file directly
					in = new BufferedReader(new FileReader(file));
				}
				String line;
				while ((line = in.readLine()) != null){	
					if(line.trim().length()!=0){
						tm.processLine(line);
					}
			    }
			    in.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		//Delete temp text file
		public void deleteTempFile(String file) {
			File tempFile = new File(file);
			if(tempFile.delete()){
				System.out.println("Successfully delete the temp file");
			}
			else {
				System.out.println("Failed to delete temp.");
			}
		}
		
		//Main
		
		public static void main(String[] args){
			/*TextExtractor tx = new TextExtractor();
			TextExtractor tx2 = new TextExtractor();
			String filename = "Project Design.docx";
			String filename2 ="word.pdf";
			tx.readDocFile(filename);
			tx.readPdfFile(filename2);
			tx.collectWord(filename);
			tx.collectWord(filename2);
			System.out.println("---------------------Only File2!!!-----------------");
			tx2.collectWord(filename2);
			tx2.tm.printTagByOrder();
			System.out.println("---------------------Test!!!-----------------------");
			tx.tm.printTagByOrder();
			tx.deleteTempFile(filename);
			tx.deleteTempFile(filename2);

		}
		*/
		StringTokenizer st = new StringTokenizer("Project ");
	    while(st.hasMoreTokens()){
	    	System.out.print(st.nextToken());
	    	

	    }
}
}