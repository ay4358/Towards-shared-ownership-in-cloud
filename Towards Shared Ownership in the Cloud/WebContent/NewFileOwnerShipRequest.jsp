<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.RegistrationBean"%>
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

		<title>My JSP 'NewUserAccept.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
	<link rel="stylesheet" type="text/css" href="css/table.css">
	

	<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
</style>
	</head>

	<body>
		<div>
			<jsp:include page="Header.jsp"></jsp:include>
		</div>
		
		<center>
		<div style="height: 300px;; width: 500px; background-color: #A9A9A9; margin: 20px;">
			<div style="height: 300px;; width: 500px; background-color: #A9A9A9; margin: 20px;">
			
							<%
								String userinfo = request.getParameter("status");
								if (userinfo != null) {

								}
								try
								{
								HashMap hmpro9 = (HashMap) session.getAttribute("hmpro9");
							if(hmpro9.size()>0)
							{

								String msg = (String) session.getAttribute("acceptrequest");
								session.setAttribute("acceptrequest", " ");
								if (msg != null) {
							%>
							<label style="color: red; size: 20px;" ><%=msg%></label>
							<%
								}
								else
								{
								out.println("No Pending Requests");
								}
							%>
						<table>
			

					<%
						if (hmpro9.size() > 0) {
					%>
						  <tr>
                           <th>OwnershipId</th>
                           <th>Filename</th>
                           <th>Loginid</th>
             
                             <th>Grant</th>
                             <th>Deny</th>
                            
                           </tr>
			
					<%
						for (int i = 1; i <= hmpro9.size(); i++) {
								RegistrationBean rb= (RegistrationBean) hmpro9.get(i);
					%>
					<tr>
						<td>
							<%=rb.getOrid()%>
						</td>
						<td>
							<%=rb.getLoginid()%>
						</td>
						<td>
							<%=rb.getFilename()%>
						</td>
						
						<td>
							 <a
								href="GrantFileRequest.jsp?id=<%=rb.getOrid()%>">Grant</a> 
						</td>
						<td>
							 <a
								href="DenyFileRequest.jsp?id=<%=rb.getOrid()%>">Deny</a> 
						</td>
						
					</tr>
					<%
						}
						}
						}
						else
						{
						out.println("no recrods found");
						}
						}
						catch(Exception e)
						{
					out.println("no recrods found");
						}
					%>
		
			
			</table>
			
</div>
<!--<div  style="height: 30px;; width: 500px; background-color:#FFA500; margin: 20px;"></div>
			</div>
		--></center>
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
