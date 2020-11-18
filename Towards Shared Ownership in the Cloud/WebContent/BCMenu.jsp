<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">






<html lang=''>
<head>
   <meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="styles.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="script.js"></script>
   <title>Towards Shared Ownership in the Cloud</title>
</head>
<body>

<div id='cssmenu'>
<ul>
   <li class=''><a href='BlockChainHome.jsp'><span>BCHome</span></a></li>
   <li><a href='BCOwnerContract.jsp'><span>OwnerContract</span></a></li>
   <li><a href='BCCloudContract.jsp'>CloudContract<span></span></a></li>
   <li><a href='BCCloudForward.jsp'>CloudContractForwardRequest<span></span></a></li>
   <!--
   <li><a href='NewFileDRRequestServlet'>Request<span></span></a></li>
    <li><a href='NewFileOwnerShipRequestServlet'>OwnerShipReq<span></span></a></li>
   --><li><a href='BCChangePassword.jsp'><span>ChangePwd</span></a></li>
   <li class='last'><a href='BCLogoutAction.jsp'><span>Logout</span></a></li>
</ul>
</div>






















  </body>
</html>
