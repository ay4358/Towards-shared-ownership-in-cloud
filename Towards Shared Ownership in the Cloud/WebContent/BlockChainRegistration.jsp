<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BlockChainRegistration.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link href="css/a.css" rel="stylesheet" type="text/css" media="all" />


		<link href="css/a.css" rel="stylesheet" type="text/css" media="all" />
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js">
</script>









<script type="text/javascript">

              var password = document.getElementById("password")
            , confirm_password = document.getElementById("confirm_password");
            function validatePassword(){
                if(password.value != confirm_password.value) {
                confirm_password.setCustomValidity("Passwords Don't Match");
                } else {
                confirm_password.setCustomValidity('');
                }
            }
            password.onchange = validatePassword;
            confirm_password.onkeyup = validatePassword;   

function validator() {
  var x = document.forms["myform"]["loginid"].value;
  if (x == "") {
    alert("Name must be filled out");
    return false;
  }
   var x = document.forms["myform"]["password"].value;
  if (x == "") {
    alert("password must be filled out");
    return false;
  }
  
   var x = document.forms["myform"]["confirmpassword"].value;
  if (x == "") {
    alert("confirm password must be filled out");
    return false;
  }

  if (document.forms["myform"]["username"].value== "") {
    alert("username must be filled out");
    return false;
  }
  if (document.forms["myform"]["lastname"].value== "") {
    alert("lastname must be filled out");
    return false;
  }
    if (document.forms["myform"]["email"].value== "") {
    alert("email must be filled out");
    return false;
  }
  
   if (document.forms["myform"]["mobileno"].value== "") {
    alert("mobileno must be filled out");
    return false;
  }
   if (document.forms["myform"]["role"].value== "") {
    alert("role must be filled out");
    return false;
  }
}


</script>

<script type="text/javascript">
function validator() {

		
	if (document.getElementById("uid").value == "") {

		document.getElementById("msguid").innerHTML = "Plealse Enter Login name";
		return false;
	}  
	if (document.getElementById("pass").value == "") {

		document.getElementById("msgpass").innerHTML = "Plealse Enter Password";
		return false;
	}



 if (document.getElementById("cpass").value == "") {

		document.getElementById("msgcpass").innerHTML = "Plealse Enter Confirm Password";
		return false;
	}
	
	if (document.getElementById("cpass").value != document
			.getElementById("pass").value) {
		document.getElementById("msgcpass").innerHTML = "These passwords don't match. Try again?";
		return false;
	}
	
	

 if (document.getElementById("uname").value == "") {

		document.getElementById("msguname").innerHTML = "Plealse Enter User name";
		return false;
	}
	
	var username = document.getElementById("uname");
	var filter = /^([a-zA-Z])+$/;
	if (!filter.test(username.value)) {
		document.getElementById("msguname").innerHTML = "Please Enter valid User Name";
		return false;
	}
	
	

 if (document.getElementById("lname").value == "") {

		document.getElementById("msglname").innerHTML = "Plealse Enter last name";
		return false;
	}

 if (document.getElementById("email").value == "") {

		document.getElementById("msgemail").innerHTML = "Plealse Enter email";
		return false;
	}
	if (document.getElementById("email").value != "") {
		var email = document.getElementById('email');
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (!filter.test(email.value)) {
			document.getElementById("msgemail").innerHTML = "Please provide a valid email address";

			return false;
		}
	

 if (document.getElementById("mob").value == "") {

		document.getElementById("msgmob").innerHTML = "Plealse Enter Mobile number";
		return false;
	}

if (document.getElementById("mob").value != "") {
		var inputtxt = document.getElementById("mob").value;
		var phoneno = /^\d{10}$/;
		if (inputtxt.match(phoneno)) {
			return true;
		} else {
			document.getElementById("msgmob").innerHTML = "Not a valid Phone Number";
			return false;
		}

}



 if (document.getElementById("g").value == "") {

		document.getElementById("msgg").innerHTML = "Plealse select gender";
		return false;
	}

 if (document.getElementById("role").value == "") {

		document.getElementById("msgrole").innerHTML = "Plealse select role";
		return false;
	}



}
</script>







		<script type="text/javascript">
function validate() {

	document.getElementById("msguid").innerHTML = "";
	document.getElementById("msgpass").innerHTML = "";
	document.getElementById("msgcpass").innerHTML = "";
	document.getElementById("msguname").innerHTML = "";
	document.getElementById("msgemail").innerHTML = "";
	document.getElementById("msgmob").innerHTML = "";
	document.getElementById("msgeventdate").innerHTML = "";
	document.getElementById("msguaddress").innerHTML = "";
	if (document.getElementById("uid").value == "") {

		document.getElementById("msguid").innerHTML = "Please Enter Login ID";
		return false;
	}
	if (document.getElementById("pass").value == "") {

		document.getElementById("msgpass").innerHTML = "Please Enter Password";
		return false;
	}
	if (document.getElementById("cpass").value == "") {
		document.getElementById("msgcpass").innerHTML = "Please Enter Confirm Password";
		return false;
	}
	if (document.getElementById("cpass").value != document
			.getElementById("pass").value) {
		document.getElementById("msgcpass").innerHTML = "These passwords don't match. Try again?";
		return false;
	}
	var username = document.getElementById("uname");
	var filter = /^([a-zA-Z])+$/;
	if (!filter.test(username.value)) {
		document.getElementById("msguname").innerHTML = "Please Enter valid User Name";
		return false;
	}
	
	var lname = document.getElementById("lname");
	var filter = /^([a-zA-Z])+$/;
	if (!filter.test(username.value)) {
		document.getElementById("msglname").innerHTML = "Please Enter Last Name";
		return false;
	}
	

	if (document.getElementById("email").value == "") {
		document.getElementById("msgemail").innerHTML = "Please Enter Email ID";
		return false;
	}
	if (document.getElementById("email").value != "") {
		var email = document.getElementById('email');
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (!filter.test(email.value)) {
			document.getElementById("msgemail").innerHTML = "Please provide a valid email address";

			return false;
		}
	}

	if (document.getElementById("mob").value == "") {
		document.getElementById("msgmob").innerHTML = "Please Enter Mobile Number";
		return false;
	}
	if (document.getElementById("eventdate").value == "") {
		document.getElementById("msgeventdate").innerHTML = "Plealse Enter Date of Birth";
		return false;
	}
	if (document.getElementById("uaddress").value == "") {
		document.getElementById("msguaddress").innerHTML = "Plealse Enter Address";
		return false;
	}
	if (document.getElementById("mob").value != "") {
		var inputtxt = document.getElementById("mob").value;
		var phoneno = /^\d{10}$/;
		if (inputtxt.match(phoneno)) {
			return true;
		} else {
			document.getElementById("msgmob").innerHTML = "Not a valid Phone Number";
			return false;
		}

	}

}
</script>








			</head>
	<jsp:include page="Header.jsp"></jsp:include>

	<body>


		<center>
			<div style="width: 1000px; height: auto; margin-top: -15px;">
				
				<div style="margin-top: -3px;">
					

				</div>
			</div>
		</center>
		<center>
			<h3>
				<font color=green size="6">BLOCK CHAIN REGISTER HERE</font>
			</h3>
			<form action="./BCRegistrationServlet" name="myform" onsubmit="return validator();">
				<table>
					<tr>
						<td colspan="2" style="">
							<label
								style="color: red; font-style: italic; text-align: center;">
								<%
									String status = request.getParameter("status");
									if (status != null) {
										out.println(status);
									}
								%>
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<p>
								Login ID :
							</p>
						</td>
						<td>
							<input type="text" name="loginid" id="uid" class="input_text"
								value="" placeholder="Create Loginid" required="">
							<label id="msguid"
								style="color: red; font-size: 16px; font-style: italic;"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<p>
								Password :
							</p>
						</td>
						<td>
							<input type="password" name="password" id="pass"
								class="input_password" value="" placeholder="Create Password"
								required="">
							<label id="msgpass"
								style="color: red; font-size: 16px; font-style: italic;"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<p>
								Confirm Password :
							</p>
						</td>
						<td>
							<input type="password" name="confirmpassword" id="cpass"
								class="input_password" value="" placeholder="ReEnter Password"
								required="">
							<label id="msgcpass"
								style="color: red; font-size: 16px; font-style: italic;"></label>

						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<p>
								User Name :
							</p>
						</td>
						<td>
							<input type="text" name="username" id="uname" class="input_text"
								value="" placeholder="Enter Your Good Name" required="">
							<label id="msguname"
								style="color: red; font-size: 16px; font-style: italic;"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					
					<tr>
						<td>
							<p>
								Last Name :
							</p>
						</td>
						<td>
							<input type="text" name="lastname" id="lname" class="input_text"
								value="" placeholder="Enter Your Last Name" required="">
							<label id="msglname"
								style="color: red; font-size: 16px; font-style: italic;"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					
					<tr>
						<td>
							<p>
								Email :
							</p>
						</td>
						<td>
							<input type="text" name="email" id="email" class="input_text"
								value="" placeholder="Enter EmailId" required="">
							<label id="msgemail"
								style="color: red; font-size: 16px; font-style: italic;"></label>

						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<p>
								Mobile No :
							</p>
						</td>
						<td>
							<input type="text" name="mobileno" id="mob" class="input_text"
								value="" placeholder="Plz Enter Valid Mobile Number" required="">
							<label id="msgmob"
								style="color: red; font-size: 16px; font-style: italic;"></label>

						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					
					
					<tr>
						<td>
							<p>
								Gender :
							</p>
						</td>
						<td class="input_text">
							M
							<input type="radio" name="gender" id="g" value="M" checked="checked" />
							&nbsp; F
							<input type="radio" name="gender" id="g" value="F" />
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<!--<tr>
						<td>
							<p>
								Address :
							</p>
						</td>
						<td>
							<textarea name="uaddress" id="uaddress" class="input_a"></textarea>

						</td>
					</tr>
					<tr>
						<td>

						</td>
						<td>
							<label id="msguaddress"
								style="color: red; font-size: 16px; font-style: italic;"></label>
						</td>

					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					-->
					<tr>
									<td>Role:</td>
                                    <td>
	<select id="role" name="role" required> 
      <option value="">---Select Role---</option> 
    
     <option value="BCOWNER">BCOWNER</option> 
   
      <option value="BCUSER">BCUSER</option> 
      
        <option value="CPROVIDER">CPROVIDER</option> 
      </select> 
  
									</td>
									<tr>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
									<tr>
						<td></td>
						<td>
							<input type="submit" class="submit" value="Register">
						</td>
					</tr>
				</table>
			</form>
		</center>
		</div>

		</div>
		</center>
		<div style="margin-top: -3px;">
			
		</div>
	</body>
</html>
