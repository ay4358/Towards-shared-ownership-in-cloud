<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>

<%@page import="java.sql.Connection"%>


<%@page import="com.util.Dbconnection"%>
<%@page import="com.bean.RegistrationBean"%>
<%@page import="java.sql.PreparedStatement"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%

HttpServletResponse httpResponse = (HttpServletResponse)response;

httpResponse.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
response.addHeader("Cache-Control", "post-check=0, pre-check=0");
httpResponse.setHeader("Pragma","no-cache"); 
httpResponse.setDateHeader ("Expires", 0); 

String uid=(String)session.getAttribute("userid");
if(uid==null)
{

response.sendRedirect("BlockChainLogin.jsp?status=Please Enter UserName and Password");
return ;
}


%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Cloud</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/table.css">

	
<jsp:include page="Header.jsp"></jsp:include>
<br/><br/>




  </head>
  
  
  <jsp:include page="BCCloudForward.jsp"></jsp:include>
  
    <% if(request.getParameter("status")!=null) 
					  {%>
                           <h3 style=color:red><center><strong><%=request.getParameter("status")%></strong></center></h3>
                      <%}%>
  <body>
  
  
  
  
  
      <h3 align="center" style="color: #cc0066">View Files Status</h3>
  
  <table align="center">
  <%ResultSet rs1=null; %>
  <tr>

<th style="text-align: center;color: #99004d">LOGINID</th>
<th style="text-align: center;color: #99004d">FILEDIRECTORY</th>
<th style="text-align: center;color: #99004d">FILENAME</th>
<th style="text-align: center;color: #99004d">USERSREQ</th>
<th style="text-align: center;color: #99004d">ACTION</th>



</tr>

<%String userid=(String) session.getAttribute("userid");%>
<% String id1=request.getParameter("id"); 

int id=Integer.parseInt(id1);
%>

<%
      
   try
   {
  Dbconnection dc=new Dbconnection();
  Connection con = dc.getConnection();
  
  
  
	     		
    PreparedStatement st1=con.prepareStatement("update BCUSERREQUEST set BCUSTATUS='Success' where BCUSTATUS='Grant' and BCURID='"+ id + "'");
    
  
  int i = 0;
			i = st1.executeUpdate();
			if (i > 0) {
			boolean	flag = true;

		%>	
  
  </tr>
  
   <%   } }
    
    catch(Exception e){
        e.printStackTrace();
        
    }
  
%>



	
	
						
			
				</table>
														



</form>


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
