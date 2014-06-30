function beforeSubmit(fname,submitId)
{
	var submitEl = document.getElementById(submitId);
    fname = fname.toLowerCase();
    fileType = ['doc','docx','xls','xlsx','ppt','pptx','pub','pubx','vsd','vsdx','txt','pdf'];
    dots = fname.split(".");
    currentFileType = "."+dots[dots.length-1];
    if (fileType.join(".").indexOf(currentFileType) != -1) {
    	submitEl.disabled = false;
        return true;
    }
    else{
    	alert("Please only upload files that end in types: \n\n" + (fileType.join(",")) + "\n\nPlease select a new file and try again.");
    	submitEl.disabled = true;
    	return false;
    }
}
function validateForm()
{
	var x=document.forms["form2"]["fileField"].value;
	var y=document.forms["form2"]["fileField2"].value;
	if (x==null || x=="" || y==null || y=="")
	  {
	  alert("You must upload both files.");
	  return false;
	  }
	var count = 0;
	for(var i=0; i < document.form2.Preference.length; i++){
		if (document.form2.Preference[i].checked){
			return true;
		}
	}
	if(count!=1){
		alert("You must select at least one type for Tag Cloud.");
		return false;
	}
}
function validateTextarea(x,submitId)
{
	
	var submitEl = document.getElementById(submitId);
	if (x==null || x=="" ){
		alert("You must enter some words");
		submitEl.disabled = true;
		return false;
	}
	else{
		submitEl.disabled = false;
        return true;
	}
}