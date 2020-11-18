<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.blockchain.bean.*"%>

<%@page import="com.blockchain.dao.*"%>
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

		<title>My JSP 'Productcomment.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		<!--<link rel="stylesheet" type="text/css" href="css/tables.css">
		
	--><script type="text/javascript">
function validator() {

		document.getElementById("msgimage").innerHTML = "";
		if (document.getElementById("image").value == "") {

		document.getElementById("msgimage").innerHTML = "Please Upload File";
		return false;
	}
		</script>
	</head>

	<body>

<%
				String u = (String) session.getAttribute("userid");
				if (u == null) {
					String target = "BlockChainLogin.jsp?status=Please Enter UserName and Password";
					RequestDispatcher rd = request.getRequestDispatcher(target);
					rd.forward(request, response);
				}
			%>
			
			
			 <%
  
  BCFileRequestDao dao=new BCFileRequestDao();
  
  
  List<String> fileList=dao.getFileNameDetails();
  
  
  List<String> usersList=dao.getFileUsers();
  
  
  
   %>
			
			
			
		<center>
			<div style="width: 1000px; height: auto; margin-top: -15px;">
				<jsp:include page="Header.jsp"></jsp:include>
				
				<div class="signup" style="margin-top: -1px; width: 100%;">
					<h2>
						<font color="blue">User Request Here</font>
					</h2>
					<center>
						
						<table border="2" align="center">

							<tr>
								<form action="./BCUserVoteServlet">
									
									
									
										<table border="1" width="530" height="186">
										
										
										
										 <tr>
    
							<td>
								File Name
							</td>
							
							<td>
								<select name="filename"  align='left'  style="width:250px"; required>
									<%
									for(String str:fileList)
									{
									
									 %>
									 <option width=100><%=str %></option>
									 <%
									 }
									  %>
									
									
									

									</select>
		  		</td>
		  		</tr>
										
										
										
										
										 <tr>
    
							<td>
								LoginId
							</td>
							
							<td>
								<select name="loginid"  align='center'  style="width:250px"; required>
									<%
									for(String str:usersList)
									{
									
									 %>
									 <option width=100><%=str %></option>
									 <%
									 }
									  %>
									
									
									

									</select>
		  		</td>
		  		</tr>
										
										
										
										
										
										
										
										
										

											<tr>
												<td align='left'>
													File Directory
												</td>
												<td align="left">
				<font color="#0080ff"><input type="text" name="directory"	value="FDrive" readonly="readonly">
													</font>
													<br>
												</td>
											</tr>

											
											
											<tr>
		  		
		  		                 <td align='left'>
													Select Request
												</td>
									
									<td>
                                    
	<font color="#0080ff"><select id="role" name="uaction" required> 
      
    
     <option value="SingleUser">SingleUser</option> 
       <option value="MultiUser">MultiUser</option> 
   
     
      </select> </font>
  
									</td>
									</tr>
									<br/>
									<br/>
									
									<tr>
											
												<td align='left'>
													FilePermision
												</td>
											<td>
										<select id="role" name="reqaction" required> 
      
    
     <option value="ReadWrite">ReadWrite</option> 
       <option value="Reject">Reject</option> 
   
     
      </select> 
  
									</td>
									</tr>
									<br/>
									<br/>
									
									<tr>												
												
													
											<tr>
												<td></td>
												<td>
													<input type="submit" value="submit" />
												</td>
											</tr>
										</table>
								</form>

							</tr>
							
						</table>
					</center>
				</div>
				</div>
				</center>
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
				
	</body>
</html>
