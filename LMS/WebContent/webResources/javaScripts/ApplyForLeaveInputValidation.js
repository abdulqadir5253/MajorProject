function validateInput(){
	var fromDate = document.forms['applyForleave']['fromDate'].value;
	var toDate = document.forms['applyForleave']['toDate'].value;
	
	if(fromDate == "" | toDate == ""){
		alert('Please Select the Dates');
		return false;
	}
	
		
}