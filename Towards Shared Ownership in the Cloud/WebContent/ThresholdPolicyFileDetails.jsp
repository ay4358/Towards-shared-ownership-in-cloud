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

response.sendRedirect("CommuneLogin.jsp?status=Please Enter UserName and Password");
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
    <% if(request.getParameter("status")!=null) 
					  {%>
                           <h3 style=color:red><center><strong><%=request.getParameter("status")%></strong></center></h3>
                      <%}%>
  <body>
  
  
  
  
  
      <h3 align="center" style="color: #cc0066">View Files Status</h3>
  
  <table align="center">
  <%ResultSet rs1=null; %>
  <tr>


<th style="text-align: center;color: #99004d">FileName</th>
<th style="text-align: center;color: #99004d">FileCount</th>

</tr>

<%String userid=(String) session.getAttribute("userid");%>

<%
      
   try
   {
  Dbconnection dc=new Dbconnection();
  Connection con = dc.getConnection();
  
  
  
	     		
    PreparedStatement st1=con.prepareStatement("select filename,row_number()over(partition by filename order by filename) from files_table");
    
  
  
   rs1=st1.executeQuery();
   while(rs1.next())
   {%>
  <tr>
  <td><%=rs1.getString(1) %></td>

<td><%=rs1.getString(2) %></td>


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
