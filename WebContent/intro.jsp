<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tag Cloud Generator</title>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<script src="JS/FileTypeLimit.js" type="text/javascript"></script>
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
    <tr>
    <th colspan="20" scope="col"><h2>Introduction</h2></th>
  </tr>
  <tr bgcolor="#000066">
    <td width="20%"></td>
  </tr>
  <tr>
    <td></td>
  </tr>
    <tr>
    <td width="20%" colspan="4" rowspan="2"></td>
    <td colspan="8" align="left" width="60%"><p>Tag Cloud is a visual representation for text data and typically used to keyword metadata(tags) from text. This project, Tag Cloud Generator is done for my supervisor, Russell Martin, and members of Computer Science Department who wish to generate a Tag Cloud using their published papers. The aim is to allow users to upload various types of one or more document files(e.g. pdf) and then produce a pleasant graphical result output in the format as PNG on the web page.</p>
      <p>This project is providing users a web based interface which has the functionality to allow uploading files and insert text, and display final output result. It also provides main program to extract text, collect tags and produce image output of tag cloud. This interface is implemented in JSP and the main program is implemented in Java.</p>
      <p>The main algorithm using in this web application is based on Wordle.</p>
      <p>&nbsp;</p></td>
    <td width="20%" colspan="4" rowspan="2"></td>
  </tr>
   <tr>
    <td colspan="4" valign="top" align="center" width="30%">
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