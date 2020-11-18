package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FileUploadDao;

import com.bean.RegistrationBean;;


public class FileUploadServlet extends HttpServlet {

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
		
		File f=new File(request.getParameter("file"));
		
		
		/*String files=f.getName();
		
		
		File file1=new File("F:/"+files);
		*/
		
		
		RegistrationBean rb=new RegistrationBean();
		
		rb.setLoginid(loginid);
		rb.setFilename(filename);
		rb.setSubject(subject);
		rb.setFile(file);
	
		
		
		FileUploadDao fd=new FileUploadDao();
		
		try {
			int i=fd.upload(rb);
			if(i!=0){
				RequestDispatcher rd=request.getRequestDispatcher("FileUpload.jsp?status=Data Uploaded successfully");
				rd.include(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("FileUpload.jsp?status=Data NOt Uploaded");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			RequestDispatcher rd=request.getRequestDispatcher("FileUpload.jsp?status=Some Internal Problem Occured");
			rd.include(request, response);
			
		}
	}

}
