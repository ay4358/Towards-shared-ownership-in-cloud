<%@page import="java.lang.String"%>
<%@ page session="true"%>

<%@page import="java.util.ArrayList" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.Dbconnection" %>
<%@page import="java.io.*" %>

<%@page import="com.bean.RegistrationBean" %>

<!--<link rel="stylesheet" type="text/css" href="css/table.css"> -->

<%
	String loginid;
%>
<html>
	<head>
		<style type="text/css">
.Title1 {
	font-family: TimesNewRoman;
	font-weight: bold;
	font-size: 30px;
	font-style: italic;
	color: blue;
}

.t2 {
	th: tr :   
   border :    1px;
}
table th td{
border: 1px
}
.Title2 {
	font-family: TimesNewRoman;
	font-weight: bold;
	font-size: 15px;
	font-style: normal;
}
</style>

	</head>
	<body>


		<jsp:include page="./Header.jsp"></jsp:include>
		<%
			loginid = (String) session.getAttribute("userid");
		%>
		<table border="0" width="980" height="" align="center">
			<tr>
				<td nowrap="nowrap" colspan="7">
					<br>
				</td>
			</tr>
			<tr>
				<td nowrap="nowrap" valign="top">
					<table height="">
						<tr>
							<td valign="top">
								<table align="left" border="0">
									<tr align="center">


									</tr>

								</table>
							</td>
							<td nowrap="nowrap" colspan="4" align="center">
							
							<p>Towards Shared Owner Ship in the Cloud </p>
								
								</br>


								<table width="800" align="center" border="">
									<tr>
										<td align="center">
										<h2>
									Files Details
								</h2>
											<table align="center" border="">
											
											
													<td>


														<td align="center">
															<table id="t2" align="center" bgcolor="#938E96"
																border="2" width="500">

                                  
																<tr></tr>
																<tr>
																<th></th>
											<th>FileId</th>
											<th>FileName</th>
											<th>Subject</th>
											<th>Files</th>
											
											
											
											
											
											

												<tr>
																<tr>
																	
																		<%--
																			if (loginid.equals((String) session.getAttribute("cloud"))) {
																		--%>

																
																	<td valign="middle">
																		<%
																			Connection con = null;
																				ResultSet rs = null;
																				

																				String loginid1=request.getParameter("loginid");
																				String filename=request.getParameter("filename");
																				
																				try {
																				
																				 con=Dbconnection.getConnection();
																				 
																					
																					PreparedStatement ps=con.prepareStatement("select FILEID,FILENAME,SUBJECT,FILES from FILES_TABLE  where LOGINID=? and FILESTATUS=? and FILENAME=?");
			                                                                 ps.setString(1, loginid);
			                                                              ps.setString(2, "Uploaded");
			                                                              ps.setString(3,filename);
			                                                          System.out.println("before while");
			                                                              rs=ps.executeQuery();
			                                                              RegistrationBean rb=new RegistrationBean();
																		%>

																	</td>
																	
											
											
											
																	
																	<%
																		while (rs.next()) {
																	%>
																	

                                                                  <td><%=rs.getInt(1)%></td>
				                                                  <td><%=rs.getString(2)%></td>
				                                                  <td><%=rs.getString(3)%></td>
				                                                 <%  java.sql.Blob b=rs.getBlob("files");
				byte[] brr=b.getBytes(1, (int) b.length());
				FileOutputStream fos=new FileOutputStream("F:/"+rs.getString(2));
				//OutputStream o = response.getOutputStream();
				
				fos.write(brr);
				
				rb.setFile(""+rs.getString(2));
				 %>
			
			
		                                      
				                                       <td>
  <font color="green"><a href="F:\<%=rb.getFile()%>"><%=rb.getFile()%></a></font>
  </td>
              
				                                                  
				                                                  
				                                                  <%-- <td><% java.sql.Blob bb=rs.getBlob(4);
				                                                  byte[] files = bb.getBytes(1,(int)bb.length());
                                                    
 
                                                    java.io.OutputStream o = response.getOutputStream();
 
                                                o.write(files);%>
                                                <%out.println(files.toString()); %>>
                                                
                                                </td>
				                                                  --%>
				                                                  </tr>
																		<%
																			System.out.println("after while");
				
				                         
				                                /*   int fileid=rs.getInt(1);
				
				                              String filename=rs.getString(2);
				
				                            String subject=rs.getString(3);
				
				                                Blob b=rs.getBlob(4);
				                                rb.setFileid(fileid);
				System.out.println("fileid"+fileid);
				System.out.println("filename"+filename);
				System.out.println("subject"+subject);
				System.out.println("brr"+brr);
				
				
				
				rb.setFilename(filename);
				rb.setSubject(subject);
				rb.setFile(""+filename);
				
				InputStream x=File.getBinaryStream();
				int size=x.available();
				ServletOutputStream Fileout = response.getOutputStream();
				FileInputStream f = new FileInputStream("");
				int nextByte = f.read();

				while ( nextByte != -1 ) {
				out.write(nextByte);
				nextByte = f.read();
				}
															*/		
																
																%>

																		<td align="center">
																			<br />
																			




																			<%
																			}
																		%>

																			<td>



																			</td>
																			

																		</td>

																	</tr>

																	<%
																		}

																			catch (Exception e) {
																				System.out
																						.println("............exception rised:");
																				con.close();
																				e.printStackTrace();
																			} finally {
																				try {
																					rs.close();
																					
																					con.close();
																				} catch (Exception e) {
																					e.printStackTrace();
																				}
																			}
																	%>
																	
																	<%
																		/*} else {*/
																	%>

																	

																</tr>
															</table>


															
												</tr>
											</table>
										</td>
									</tr>
								</table>
								</div>

							</td>
						</tr>
					</table>
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