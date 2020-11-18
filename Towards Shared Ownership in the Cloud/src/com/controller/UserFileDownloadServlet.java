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

import com.bean.RegistrationBean;
import com.dao.FileDownloadDao;

public class UserFileDownloadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserFileDownloadServlet() {
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

		HttpSession session=request.getSession();
		
		/*String fileid=request.getParameter("fileid");
		
		//String filename=request.getParameter("filename");
		
		System.out.println("fileid   ----"+fileid);
		
		RegistrationBean rb=new RegistrationBean();
		int fid=Integer.parseInt(fileid);
		rb.setFileid(fid);
		//rb.setFilename(filename);
*/		
		
		
		String loginid=(String) session.getAttribute("userid");
		FileDownloadDao fdd=new FileDownloadDao();
		try{
			
			System.out.println("lllllllllll"+loginid);
		System.out.println("hhhhhhhhhh");
		ArrayList<RegistrationBean> list3=fdd.downloadAdmin(loginid);
		session.setAttribute("list3", list3);
		RequestDispatcher rd=request.getRequestDispatcher("ViewUserDownloadFile.jsp");
		rd.include(request, response);
		}
		catch (Exception e) {
			RequestDispatcher rd=request.getRequestDispatcher("ViewUserDownloadFile.jsp");
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
