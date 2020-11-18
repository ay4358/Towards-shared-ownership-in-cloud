<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

	<body>
  <center><div style="width: 1000px; height: auto; margin-top: -15px;">
			<jsp:include page="Header.jsp"></jsp:include>
			
			<div style="margin-top: -3px;"></div>
			<div style="margin-top: -20px;">
				<img src="images/welcome2.png" style="width: 1000px; height: 400px;">
			</div>
			
			</div>
			
			
			<br/>
			
			<br/>
			
			<br/>
			
			
			<div style="margin-top: -3px;">
				<jsp:include page="Footer.jsp"></jsp:include>
		</div>
		</center>
     <br>
  </body>




<html>