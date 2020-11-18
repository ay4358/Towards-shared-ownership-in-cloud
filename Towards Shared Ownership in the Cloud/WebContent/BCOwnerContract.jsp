<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>



<%@ page import="com.blockchain.bean.*,com.blockchain.dao.*,java.util.*"%>


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
response.sendRedirect("BlockChainLogin.jsp?status=Please Enter username and password");
}
%>
  
  
  
  
  <%
  BCFileRequestDao dao=new BCFileRequestDao();
  List<String> stList=dao.getStorage();
  
  List<String> duList=dao.getDuration();
  
  List<String> usersList=dao.getFileUsers();
  
  
  
   %>
  
  
<body >
    
    <center>
    
    <h2><font color=blue size="5">OwnerShip Payment</font></h2>
    
  
<!--    <form action="./CategoryServlet" method="post">-->

<form action="./BCContractOwnerShipServlet">

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
								Storage
							</td>
							
							<td>
								<select name="storage"  align='center'  style="width:250px"; required>
									<%
									for(String str:stList)
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
								Duration
							</td>
							
							<td>
								<select name="duration"  align='center'  style="width:250px"; required>
									<%
									for(String str1:duList)
									{
									
									 %>
									 <option width=100><%=str1 %></option>
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
									for(String str2:usersList)
									{
									
									 %>
									 <option><%=str2 %></option>
									 <%
									 }
									  %>
									
									
									

									</select>
		  		</td>
		  		</tr>
		  		
		  		
		  		<tr>
		  		
		  		<td>payment</td>
		  		
		  		
		  		<td><input type="text" name="pay" /></td>
		  		
		  		
		  		
		  		
		  		
		  		
									<!--<td>Select Request:</td>
									<td>
                                    
	<select id="role" name="wraction" required> 
      
    
     <option value="ReadWrite">ReadWrite</option> 
       <option value="Reject">Reject</option> 
   
     
      </select> 
  
									</td>-->
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
									
									
									
									
									
								