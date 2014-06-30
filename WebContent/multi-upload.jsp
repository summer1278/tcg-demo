<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <%@ page import="java.util.List" %>
   <%@ page import="java.util.Iterator" %>
   <%@ page import="java.io.*,java.util.*" %>
   <%@ page import="java.io.*" %>
   <%@ page import="java.awt.*" %>
   <%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
   <%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
   <%@ page import="org.apache.commons.fileupload.*"%>
   <%@ page import="generator.TCGRunner" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Tag Cloud Generator</title>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
</head>
<body>
<table align="center" border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <th colspan="20"><h1>Tag Cloud Generator</h1></th>
  </tr>
  <tr>
    <th colspan="20" scope="col" bgcolor="#000066"> <div id="MenuBar1">
      <ul class="MenuBarHorizontal">
        <li><a href="index.jsp"> Start</a></li>
        <li><a href="intro.jsp">What's it?</a></li>
        <li><a href="help.jsp">Help</a></li>
        <li><a href="contact.jsp">Contact</a></li>
      </ul>
    </div>
    </th>
  </tr>
  <tr bgcolor="#000066">
   
  </tr>
  <tr>
    <td></td>
  </tr>
  <tr>
    <td colspan="12" align="center">
        <tr><td align="center"><h3>Your files  uploaded</h3></td></tr>
        <tr><td>
      
 <%

 //preference process
 /*selected = request.getParameterValues("Preference");
 if(selected != null) {
	 out.println("You choose:");
	for (int i = 0; i <selected.length ; i++) {
		 out.println(selected[i]);
	 }
 }
 else {
	 out.println("nothing");
 }*/
 //file upload
// out.println(request.getParameter("fileField"));
 
 boolean isMultipart = ServletFileUpload.isMultipartContent(request);
 int fileCount = 0;
 String option = "";
 ArrayList<String> options = new ArrayList<String>();
 String itemName1 = "";
 String itemName2 = "";
 String filePath ="";
 if (!isMultipart) {
 } else {
		List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	    Iterator<FileItem> itr = items.iterator();
	    while (itr.hasNext()) {
		    FileItem item = (FileItem) itr.next();
		    //test file size
		    if(item.getSize()>(5*1024*1024)){
			   response.sendRedirect("error.jsp");
		   }
		   else{
			   if (item.isFormField()) {
				   // Process normal fields
				   if(item.getFieldName().equals("Preference")){
					   option = item.getString();
					   options.add(option);
					   System.out.println(item.getString());
				   }
			   } 
			   // Process <input type="file">
			   else {
				   try {
					   filePath = config.getServletContext().getRealPath("/");
					   //System.out.println("What happaned?");
					   if(fileCount==0){
						   itemName1 = item.getName();
						   File savedFile = new File(filePath+"uploadedFiles/"+itemName1);
						   item.write(savedFile);  
						   out.println("<tr><td colspan=\"20\" align=\"center\" valign=\"top\"><b>Your file has been saved at the loaction:</b></td></tr>"+
								   "<tr><td  align=\"center\" valign=\"top\"><b>"+filePath+"uploadedFiles"+"\\"+itemName1+"</td></tr>");
						   fileCount++;
						   System.out.println("file1 "+itemName1);
					   }
					   if(fileCount==1){
						   itemName2 = item.getName();
						   File savedFile = new File(filePath+"uploadedFiles/"+itemName2);
						   item.write(savedFile);  
						   out.println("<tr><td colspan=\"20\" align=\"center\" valign=\"top\"><b>Your file has been saved at the loaction:</b></td></tr>"+
								   "<tr><td  align=\"center\" valign=\"top\"><b>"+filePath+"uploadedFiles"+"\\"+itemName2+"</td></tr>");
						   fileCount++;
						   System.out.println("file2 "+fileCount+itemName2);
					   }
				   } catch (Exception e) {
					   e.printStackTrace();
				   }
			  }
		   }
   }
 }
 //System.out.println(option);
 if(fileCount >1) {
	 //System.out.println("file processing");
	 for(int i = 0; i < options.size(); i++) {
	   option = options.get(i);
	   TCGRunner runner = new TCGRunner();
	   runner.multipleFileProcessing(itemName1, itemName2, filePath, option, i);
	   String picName1=itemName1;
	   String picName2=itemName2;
	   if(i>0){
		   picName1 = itemName1 +Integer.toString(i);
		   picName2 = itemName2 +Integer.toString(i);
	   }
	   if(runner.drawn==true){
		   if((option.equals("total"))||(option.equals("different"))) {
			   //System.out.println("file processing!!");
			    out.println("<tr><td colspan=\"20\" align=\"center\" valign=\"top\">"
			   			+"Your "+option+" tag cloud is here:</td></tr>");
		   		out.println("<tr><td align=\"center\" valign=\"top\"><img src=\""+
		   			filePath+"uploadedFiles\\"+picName1+".png\" width=\"800\" height=\"800\" /></td></tr>"); 
		   }
		   if((option.equals("single"))||(option.equals("common"))){
			   out.println("<tr><td colspan=\"20\" align=\"center\" valign=\"top\">"
			   			+"Your "+option+" tag cloud for <b>"+itemName1+"</b> is here:</td></tr>");
			   out.println("<tr><td align=\"center\" valign=\"top\"><img src=\""+
				   		filePath+"uploadedFiles\\"+picName1+".png\" width=\"800\" height=\"800\" /></td></tr>");
			   out.println("<tr><td colspan=\"20\" align=\"center\" valign=\"top\">"
			   			+"Your "+option+" tag cloud for <b>"+itemName2+"</b> is here:</td></tr>");
			   out.println("<tr><td align=\"center\" valign=\"top\"><img src=\""+
				   		filePath+"uploadedFiles\\"+picName2+".png\" width=\"800\" height=\"800\" /></td></tr>");
		   }
	   }
	   else{
		   out.println("<tr><td colspan=\"20\" align=\"center\" valign=\"top\" style=\"color:red\"><b>"
				   +"***YOUR "+option.toUpperCase()+" TAG CLOUD "
				   +"IS EMPTY OR YOU UPLOAD A FILE WITH INVALID LANGUAGE***</b></td></tr>");
	   }
	 }
   }
 
   %>
</td>
  </tr>
 <tr>
    <td colspan="20" align="center">
    <form action="index.jsp">
    	<input type="submit" name="back" id="back" value="Back to Homepage" />
    	<%     	
    	   //String filePath = config.getServletContext().getRealPath("/");
	    	File file = new File(filePath+"uploadedFiles/");        
	        String[] myFiles;      
	            if(file.isDirectory()){  
	                myFiles = file.list();  
	                for (int i=0; i<myFiles.length; i++) {  
	                    File myFile = new File(file, myFiles[i]);
	                    if(!myFile.getName().endsWith(".png")){
	                    	myFile.delete();  
	                    	System.out.println("Sever DELETE: " + myFile.getName());
	                    }
	                }  
	             }  
	         
	    	 %>
    </form>
    </td>
 </tr>
  <tr>
    <td colspan="20" bgcolor="#000066"><div id="MenuBar2">
      <ul class="MenuBarHorizontal">
        <li ><a href="#" class="MenuBarHorizontal2">Terms of Service</a></li>
        <li><a href="#" class="MenuBarHorizontal2">Privacy Policy</a></li>
        <li><a href="#" class="MenuBarHorizontal2">Use Manual</a></li>
      </ul>
    </div></td>
  </tr>
  <tr>
  <td colspan="20" align="center">
  	©2012-2013 Xia Cui</td>
  </tr>
</table>
<script type="text/javascript">
<!--
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"SpryAssets/SpryMenuBarDownHover.gif", imgRight:"SpryAssets/SpryMenuBarRightHover.gif"});
//-->
</script>
</body>
</html>
