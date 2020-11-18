<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div style="padding: 30px; text-align: center; width: 100%; background-color: rgb(228, 231, 254);"/>
  <h2><font face="Calibri"><b><i><font size="8" color="blue">Towards Shared Ownership in the Cloud</font></i></b></font></h2> 
  </div>


		<!--<table>
			<tr>
				<td>
				</td>
			</tr>
		</table>
		--><c:choose>
			<c:when test="${sessionScope.role eq'CLOUD'}">
				<jsp:include page="./CloudMenu.jsp" />
			</c:when>
			<c:when test="${sessionScope.role eq 'USER'}">
				<jsp:include page="./UserMenu.jsp" />
			</c:when>
			<c:when test="${sessionScope.role eq'CADMIN'}">
				<jsp:include page="./CommuneAdminMenu.jsp" />
			</c:when>
			<c:when test="${sessionScope.role eq 'CUSER'}">
				<jsp:include page="./CommuneUserMenu.jsp" />
			</c:when>
			
			
			
			<c:when test="${sessionScope.role eq 'BLOCKCHAIN'}">
				<jsp:include page="./BCMenu.jsp" />
			</c:when>
			
			
			<c:when test="${sessionScope.role eq 'BCOWNER'}">
				<jsp:include page="./BCOwnerMenu.jsp" />
			</c:when>
			
			<c:when test="${sessionScope.role eq 'BCUSER'}">
				<jsp:include page="./BCUserMenu.jsp" />
			</c:when>
			
			<c:when test="${sessionScope.role eq 'CPROVIDER'}">
				<jsp:include page="./BCProviderMenu.jsp" />
			</c:when>
			
			
			
			
			<c:when test="${sessionScope.role eq null}">
				<jsp:include page="./HomeMenu.jsp" />
			</c:when>
			
			
			
			
			
			
			
			
		</c:choose>
		<br>
		<br>
		<br>
		<font color="red">
		<center>
		<b> <c:if test="${requestScope.status!='null'}">
				<c:out value="${requestScope.status}"></c:out>
			</c:if> </b>
		</font>
		</center>
	</body>
</html>