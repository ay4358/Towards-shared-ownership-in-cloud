<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'ChangePassword.jsp' starting page</title>

		<link href="css/a.css" rel="stylesheet" type="text/css" media="all" />

		<script type="text/javascript">
function validator() {

	document.getElementById("msgoldpass").innerHTML = "";
	document.getElementById("msgnewpass").innerHTML = "";
	document.getElementById("msgchangedpass").innerHTML = "";
	document.getElementById("alertmsg").innerHTML = "";

	if (document.getElementById("opass").value == "") {

		document.getElementById("msgoldpass").innerHTML = "Plealse Enter Old Password";
		return false;
	} else if (document.getElementById("pass").value == "") {

		document.getElementById("msgnewpass").innerHTML = "Plealse Enter New Password";
		return false;
	} else if (document.getElementById("cpass").value == "") {
		document.getElementById("msgchangedpass").innerHTML = "Plealse Enter Confirm Password";
		return false;
	} else if (document.getElementById("cpass").value != document
			.getElementById("pass").value) {
		document.getElementById("alertmsg").innerHTML = "New Password is not matched with confirm password";
		return false;

	}

}
</script>

	</head>
	
	<body>
	 <div style="background:#D8BFD8;text-align:center;padding:30px;width:100%"/>
  <b><i><font color="blue" size="8">Towards Shared Ownership in the Cloud</font></i></b> 
  </div>
  <br/>
<center>
		<%
			String u = (String) session.getAttribute("userid");
			if (u == null) {
				String target = "BlockChainLogin.jsp?status=Please enter username and password";
				RequestDispatcher rd = request.getRequestDispatcher(target);
				rd.forward(request, response);
			}
		%>
		<div style="width: 1000px; height: auto; margin-top: -15px;">
			
			<%
					String role = (String) session.getAttribute("role");
					if (role.equals("BLOCKCHAIN")) {
				%>
				<div style="margin-top: -5px;"><jsp:include page="BCMenu.jsp"></jsp:include></div>
				<%
					}
					if (role.equals("BCOWNER")) {
				%>
				<div style="margin-top: -3px;"><jsp:include page="BCOwnerMenu.jsp"></jsp:include></div>
				
			<%
					}
					if (role.equals("BCUSER")) {
				%>
				<div style="margin-top: -3px;"><jsp:include page="BCUserMenu.jsp"></jsp:include></div>
				<%
					}
					if (role.equals("CPROVIDER")) {
				%>
				<div style="margin-top: -3px;"><jsp:include page="BCProviderMenu.jsp"></jsp:include></div>
					
<%
}
 %>
 
 
 
 
			<div class="signup" style="margin-top: -1px; width: 100%;">
				<center>
				

<form action="./BCChangePasswordServlet" ">
<br/>
<br/>
<br/>
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
						<tr><td>Change Password</td></tr>
						<tr>
							<td>
								<p>
									Old Password :
									<span class="dot">*</span>
								</p>
							</td>
							<td>
								<input type="password" name="password" id="opass"
									class="input_password" value="" required>
								<label id="msgoldpass"
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
									New Password :
									<span class="dot">*</span>
								</p>
							</td>


							<td>
								<input type="password" name="npassword" id="npass"
									class="input_password" value=""  required>
								<label id="msgnewpass"
									style="color: red; font-size: 16px; font-style: italic;">
								</label>
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
									<span class="dot">*</span>
								</p>
							</td>
							<td>
								<input type="password" name="confirmpassword" id="cpass"
									class="input_password" value=""  required>
								<label id="msgchangedpass"
									style="color: red; font-size: 16px; font-style: italic;"></label>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;
							</td>
							<td>
								<label id="alertmsg"
									style="color: red; font-size: 16px; font-style: italic;"></label>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input type="submit" class="submit" value="Change Password">
							</td>
						</tr>
					</table>
				</form> 
				</center>
			</div>
			<div style="margin-top: -3px;">
				
			</div>
		</div>
		</center>
	</body>
	<br/>
				<br/>
				<br/>
				<br/>
				<br/>
				<br>
				<br/>
				<br/>

				<div style="margin-top: -3px;">
				<jsp:include page="Footer.jsp"></jsp:include>
		</div>
				
</html>
