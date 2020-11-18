<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>



<%@ page import="com.bean.*,com.dao.*,java.util.*"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ViewCategory.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
  		<link href="css/styles.css" rel="stylesheet" type="text/css" media="all" />


<style type="text/css">


select
{
width:250px;
    }

 

</style>



  </head>
  <jsp:include page="Header.jsp"></jsp:include>
  
  
  
  
  
  
  <%
String user=(String)session.getAttribute("role");
if(user==null)
{
response.sendRedirect("Login.jsp?status=Please Enter username and password");
}
%>
  
  
  
  
  <%
  FileRequestDao dao=new FileRequestDao();
  List<String> fileList=dao.getFileNames();
  
  List<String> usersList=dao.getFileUsers();
  
 
  
   %>
  
  
<body >
    
    <center>
    
    <h2><font color=blue size="5">Delegate and Revoke Request</font></h2>
    
  
<!--    <form action="./CategoryServlet" method="post">-->

<form action="./DelegateRevokeServlet">

    <table>
    
    
    <tr>
    
							<td>
								File Name
							</td>
							
							<td>
								<select name="filename"  align='center'  style="width:250px"; required>
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
								Select User Name
							</td>
							
							<td>
								<select name="loginid" align='center'  style="width:250px" required>
									<%
									for(String str:usersList)
									{
									
									 %>
									 <option><%=str %></option>
									 <%
									 }
									  %>
									
									
									

									</select>
		  		</td>
		  		</tr>
		  		
		  		
		  		<tr>
		  		
		  		
									<td>Select Request:</td>
									<td>
                                    
	<select id="role" name="draction" required> 
      
    
     <option value="Delegate">Delegate</option> 
       <option value="Revoke">Revoke</option> 
   
     
      </select> 
  
									</td>
									</tr>
									<br/>
									<br/>
									
									<tr>
		  		<td></td>
		  		
		  		
		  		<td>
		  		
		  		<input type="submit" value="Submit"/>
		  		</td>
		  		</tr>
		  		
		  		</table>
		  		</form>
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
									
									
									
									
									
								