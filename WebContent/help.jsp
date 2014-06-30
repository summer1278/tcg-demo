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
    <th colspan="20" scope="col"><h2>FAQ</h2></th>
  </tr>
  <tr bgcolor="#000066">
    <td width="20%"></td>
  </tr>
  <tr>
    <td></td>
  </tr>
    <tr>
    <td width="21%" colspan="4" rowspan="2"></td>
    <td colspan="8" align="left" width="58%"><p>1. How do I generate a Tag Cloud?<br>
     &nbsp;&nbsp;&nbsp;&nbsp;Two main ways are provided in this project:<br>
     &nbsp;&nbsp;&nbsp;&nbsp;(1) Upoad File<br>
     &nbsp;&nbsp;&nbsp;&nbsp;(2) Insert Text<br>
     &nbsp;&nbsp;&nbsp;&nbsp;Only <em><strong>English</strong></em> is compatable for this web application.<br>
	 &nbsp;&nbsp;&nbsp;&nbsp;The maximum of words showing on the graphical output is up to <em><strong>50</strong></em> by program default.<br>
     &nbsp;&nbsp;&nbsp;&nbsp;<strong><em>Sadly</em></strong>, no function to group similar words.
    </p>
      <p>2. What types of file are supported?<br>
	&nbsp;&nbsp;&nbsp;&nbsp;You're allowed to upload PDF, MS Office files and plain text files.<br>
	&nbsp;&nbsp;&nbsp;&nbsp;If you upload a file with undefined type, the upload page will alert.<br>
	&nbsp;&nbsp;&nbsp;&nbsp;And, you must NOT upload an empty file!</p>
      <p>3. How large is the file allowed to upload?<br>
	&nbsp;&nbsp;&nbsp;&nbsp;Up to 5MB.
      </p>
      <p>4. What types of tag clouds can you generate from our site for two files?<br>
      &nbsp;&nbsp;&nbsp;&nbsp;<strong>Single Tag Cloud:</strong> Separate Tag Cloud for Two Files.<br>
      &nbsp;&nbsp;&nbsp;&nbsp;<strong>Total Tag Cloud:</strong> Total Tag Cloud for Two Files.<br>
      &nbsp;&nbsp;&nbsp;&nbsp;<strong>Common Tag Cloud:</strong> Tag Clouds with Common Tags for Two Files.<br>
      &nbsp;&nbsp;&nbsp;&nbsp;<strong>Different Tag Cloud:</strong> Tag Cloud for Different Tags in Two Files.<br>
      </p>
      <p>&nbsp;</p></td>
    <td width="21%" colspan="4" rowspan="2"></td>
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