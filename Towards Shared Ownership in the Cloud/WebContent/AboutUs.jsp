<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AboutUs.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <jsp:include page="Header.jsp"></jsp:include>
  
  <body>
   
 <br>
 
 
 
 <table width="100%" height="350px" cellspacing="0px"
				cellpadding="0px" style="background-color: #ddd;">
				<tr>
					<td width="20%">
						
					</td>
					<td width="70%" bgcolor="#FFEBCD">
						<p style="vertical-align: top; text-align: center; font-size: 20;" >
							
							
							Cloud storage platforms promise a convenient way for users to share files and engage in collaborations, 
							yet they require all files to have a single owner who unilaterally makes access control decisions. 
							Existing clouds are, thus, agnostic to the notion of shared ownership. 
							This can be a significant limitation inmany collaborations because, 
							for example, one owner can delete files and revoke access without consulting the other collaborators. 
							n this paper, we first formally define a notion of shared ownership within a file access control model. 
							We then propose two possible instantiations of our proposed shared ownership model.
							 Our first solution, called Commune, relies on secure file dispersal and collusionresistant 
							 secret sharing to ensure that all access grants in the cloud require the support of an agreed threshold of owners.
							  As such, Commune can be used in existing clouds without modifications to the platforms.
							   Our second solution, dubbed Comrade, leverages the blockchain technology in order to reach consensus on access control decision. 
							   Unlike Commune, Comrade requires that the cloud is able to translate access control decisions  
							   that reach consensus in the blockchain into storage access control rules, 
							   thus requiring minor modifications to existing clouds. We analyze the security of our proposals and compare/evaluate 
							   their performance through implementations using Amazon S3.
							
							
							
						</p>
					</td>
					<td width="20%">
						
					</td>
				</tr>
			</table>
 
 
 
 
 
 
 
 
 
 
 
 
  </body>
</html>
