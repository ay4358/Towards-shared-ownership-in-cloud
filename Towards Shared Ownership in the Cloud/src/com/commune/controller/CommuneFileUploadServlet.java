package com.commune.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RegistrationBean;
import com.commune.bean.ProfileBean;
import com.commune.dao.CommuneFileUploadDao;
import com.commune.util.CryptoUtils;



public class CommuneFileUploadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CommuneFileUploadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {



		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String loginid=request.getParameter("loginid");
		
		String filename=request.getParameter("filename");
		String subject=request.getParameter("subject");
		
		String file=request.getParameter("file");
		String key=request.getParameter("key");
		
		File f=new File(request.getParameter("file"));
		
		
	
		
		String filename1=f.getName();
		
		String status="Pending";
		
		//String key="1234567890123456";
		
		File file1=new File("F:/"+filename);
		
		System.out.println("before");
		CryptoUtils.encrypt(key, f, file1);
		System.out.println("encryption completed");
		
		ProfileBean pb=new ProfileBean();

		
		pb.setLoginid(loginid);
		pb.setFilename(filename);
		pb.setSubject(subject);
		
		pb.setFile(file);
	
		pb.setKey(key);
		
		
		CommuneFileUploadDao fd=new CommuneFileUploadDao();
		
		try {
			int i=fd.upload(pb);
			System.out.println("rrrrrr");
			if(i!=0){
				RequestDispatcher rd=request.getRequestDispatcher("CommuneFileUpload.jsp?msg=Data Uploaded successfully");
				rd.include(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("CommuneFileUpload.jsp?msg=Data NOt Uploaded");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			RequestDispatcher rd=request.getRequestDispatcher("CommuneFileUpload.jsp?msg=Some Internal Problem Occured");
			rd.include(request, response);
			
		}
	}



		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
