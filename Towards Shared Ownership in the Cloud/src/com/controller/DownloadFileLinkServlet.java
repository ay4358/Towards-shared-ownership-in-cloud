package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FileDownloadDao;
import com.bean.*;

public class DownloadFileLinkServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DownloadFileLinkServlet() {
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


	
	
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();




		try{
			HttpSession session=request.getSession();
			String loginid=(String) session.getAttribute("userid");
			
			
			
			String filename=request.getParameter("filename");
			String fileid=request.getParameter("fileid");
			
			RegistrationBean rb=new RegistrationBean();
			
			
			System.out.println("ffff"+filename);
			//System.out.println("ssssssss"+sub);
			rb.setLoginid(loginid);
			
			rb.setFilename(filename);
			rb.setFileid(Integer.parseInt(fileid));
			
			
			
			
			
			

			
			FileDownloadDao fdd=new FileDownloadDao();
				
				ArrayList<RegistrationBean> list=fdd.filedownload123(rb);
				
				
				session.setAttribute("list3",list);		
				
				RequestDispatcher rd= request.getRequestDispatcher("DownloadFiles.jsp");
				rd.include(request,response);
			
			}
				
			
			
			catch (Exception e) {
				RequestDispatcher rd= request.getRequestDispatcher("DownloadFiles.jsp?status=Invalid");
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
