<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <%@ page import="java.io.*,java.util.*" %>
   <%@ page import="java.io.*" %>
   <%@ page import="java.awt.*" %>
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
	StringBuffer text = new StringBuffer(request.getParameter("textarea"));
	String filePath = config.getServletContext().getRealPath("/");
	String itemName = "test.txt";
	try {		
		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath+"uploadedFiles/"+itemName));
		writer.write(text.toString());
		writer.flush();
		writer.close();
		out.println("<tr><td colspan=\"20\" align=\"center\" valign=\"top\"><b>Your file has been saved at the loaction:</b></td></tr>"+
				   "<tr><td  align=\"center\" valign=\"top\"><b>"+filePath+"uploadedFiles"+"\\"+itemName+"</td></tr>");
		TCGRunner runner = new TCGRunner();
		runner.singleFileProcessing(itemName, filePath);
		out.println("<tr><td colspan=\"20\" align=\"center\" valign=\"top\">"+"Your tag cloud is here:</td></tr>");
		out.println("<tr><td  align=\"center\" valign=\"top\"><img src=\""+filePath+"uploadedFiles\\"+
			itemName+".png\" width=\"800\" height=\"800\" /></td></tr>");
	} catch (Exception e) {
		   e.printStackTrace();
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