<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
  <tr bgcolor="#000066">
    <td width="20%"></td>
  </tr>
  <tr>
    <td></td>
  </tr>
  <tr>
    <td width="20%" colspan="4" rowspan="3"></td>
    <td colspan="4" align="center" width="30%"><h3>Upload Files</h3></td>
    <td colspan="4" align="center" width="30%"><h3>Preference</h3></td>
    <td width="20%" colspan="4" rowspan="3"></td>
  </tr>
  
<tr>
<td colspan="8" valign="top">
<form id="form2" name="form2" enctype="multipart/form-data" method="post" action="multi-upload.jsp" onSubmit="return validateForm();">
<table width="100%">
  <tr>
    <td colspan="4" align="center" valign="top"> 
      <label>
        <input name="fileField" type="file" id="file" size="35" onChange="beforeSubmit(this.value,'button');" />
        <br />
        <input name="fileField2" type="file" id="file" size="35" onChange="beforeSubmit(this.value,'button');" />
        <br />
        <font color="#999999"><em>pdf, txt, MS Office files, up to 5MB</em></font><br />
      </label>
    </td>
    <td colspan="4" align="center" valign="top">
      <table width="250">
        <tr>
          <td align="left"><label>
            <input type="checkbox" name="Preference" value="single" id="Preference_0" alt="Separate Tag Cloud for Two Files" />
            Tag Clouds for Each File</label></td>
        </tr>
        <tr>
          <td align="left"><label>
            <input type="checkbox" name="Preference" value="total" id="Preference_1" alt="Total Tag Cloud for Two Files" />
            Total Tag Cloud</label></td>
        </tr>
        <tr>
          <td align="left"><label>
            <input type="checkbox" name="Preference" value="common" id="Preference_2" alt="Tag Clouds with Common Tags for Two Files" />
            Common Tag Cloud</label></td>
        </tr>
        <tr>
          <td align="left"><label>
            <input type="checkbox" name="Preference" value="different" id="Preference_3" alt="Tag Cloud for Different Tags in Two Files" />
            Different Tag Cloud</label></td>
        </tr>
        <tr>
          <td align="Center">
              <input type="submit" name="submit" id="button" value="Submit" disabled="disabled"/>
            </td>
        </tr>
      </table>
    
      
  </td>
  </tr>
</table>
</form>
</td>
   </tr>

  <tr>
    <td></td>
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