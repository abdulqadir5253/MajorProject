$(document).on("click", "#submitBtn", function(){
		var username = $('#username').val();		
		var password = $('#password').val();
		$.ajax({
			type : "post",
			url : "LoginCheck",
			data :	"userName="+  username+
				"&passWord=" + password,
			success : function(msg){
				
				if(msg.localeCompare("error") == 0){
					printError(msg);
				}
					
				else if(msg.localeCompare("executive") == 0){
					location.replace("executiveLeaveMenuJSP.jsp");
				}
				
				else if(msg.localeCompare("manager") == 0){
					location.replace("managerLeaveMenuJSP.jsp");
				}
				
				else if(msg.localeCompare("lead") == 0){
					location.replace("leadLeaveMenuJSP.jsp");
				}	
			}
		});
		});

function printError(msg){	
	$("#somediv").text("Incorrect Credentials");
}

function validate(){

	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value;	
	var pass = true;
	
	if(username == "" | password == ""){		
		pass =  false;
	}
	
	document.getElementById("submitBtn").disabled = false;
			
}