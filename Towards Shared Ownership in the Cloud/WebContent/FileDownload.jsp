<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.RegistrationBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ViewUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/table.css">
  </head>
  
  <body>
  <%
				String u = (String) session.getAttribute("userid");
				if (u == null) {
					String target = "Login.jsp?status=Please Enter UserName and Password";
					RequestDispatcher rd = request.getRequestDispatcher(target);
					rd.forward(request, response);
				}
			%>
   <center>
<div style="width: 1000px; height: auto; margin-top: -15px;">
			<jsp:include page="Header.jsp"></jsp:include>
			
			<div class="signup" style="margin-top: -1px; width: 100%;">
			
			<center>
  <%
    ArrayList<RegistrationBean> al=new ArrayList<RegistrationBean>();
    al=(ArrayList)session.getAttribute("list");
     %>
   <center><h1><font style="color: rgb(0, 0, 136)" face="Algerian">View Download File</font></h1></center>
<table border='1px' align='center' bordercolor="black">
<tr>
<th><font color="blue" >FILEID</font></th>

 <th><font color="blue">FILENAME</font></th>
 <th><font color="blue">SUBJECT</font></th>
 <th><font color="blue">FILES</font></th>


 
  </tr>
 
  <% for(RegistrationBean rb:al){ %>
<tr>
<td>
  <font color="green"><%=rb.getFileid()%></font>
</td>
 <td>
  <font color="green"><%=rb.getFilename()%></font>
</td>
  
 <td>
<font color="green"><%=rb.getSubject()%></font>
 </td>
 
  
  <td>
  <font color="green"><a href="F:\<%=rb.getFile()%>"><%=rb.getFile()%></a></font>
  </td>
  
  
 
 </tr>
  
  
  
  
  <%  } %>
  
  
  
  
  
</table>
 </center>
 </div>
 </div>
 </center>

   <div style="margin-top: -3px;">
				<jsp:include page="Footer.jsp"></jsp:include>
		</div>
 
  
  
  </body>
</html>
