<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <%@ page import="java.io.*" %>
   <%@ page import="org.apache.commons.io.*"%>
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
    <th colspan="20" scope="col"><h2>Choose Your Text Source:</h2></th>
  </tr>
  <tr bgcolor="#000066">
    <td width="20%"></td>
  </tr>
  <tr>
    <td></td>
  </tr>
  <tr>
    <td width="20%" colspan="4" rowspan="2"></td>
    <td colspan="4" align="center" width="30%"><h3>Upload File</h3></td>
    <td colspan="4" align="center" width="30%"><h3>Insert Text</h3></td>
    <td width="20%" colspan="4" rowspan="2"></td>
  </tr>
  <tr>
    <td colspan="4" valign="top" align="center" width="30%">
    <form id="form2" name="form2" enctype="multipart/form-data" method="post" action="upload.jsp">
      <label>
      <p>
        <input name="fileField" type="file" id="file" size="35" onChange="beforeSubmit(this.value,'button');"/>
        <a href="multi-preference.jsp">Add More File</a></p>
      <p><font color="#999999" size="+1"><em>pdf, txt, MS Office files, up to 5MB</em></font>
      </p>
      <p><input type="submit" name="button" id="button" value="Submit" disabled="disabled"/></p>
        </label>
    </form></td>
    <td colspan="4" align="center" valign="top" width="30%">
    <form id="form1" name="form1" method="post" action="text-upload.jsp">
      <label>
        <textarea name="textarea" id="textarea" cols="45" rows="8" onChange="validateTextarea(this.value,'button2');"></textarea>
        <br />
        <p><input type="submit" name="button2" id="button2" value="Send"  disabled="disabled"/></p>
        </label>
    </form></td>
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