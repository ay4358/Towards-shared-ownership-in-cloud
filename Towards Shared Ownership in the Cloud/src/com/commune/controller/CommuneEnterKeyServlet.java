package com.commune.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.commune.bean.ProfileBean;
import com.commune.dao.CommuneDownloadFileDao;
import com.commune.dao.CommuneKeyCheckDao;



public class CommuneEnterKeyServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CommuneEnterKeyServlet() {
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
		try{
		HttpSession session=request.getSession();
		String loginid=(String) session.getAttribute("userid");
		
		String filename=request.getParameter("filename");
		String loginid1=request.getParameter("loginid");
		String key=request.getParameter("key");
		ProfileBean pb=new ProfileBean();
		
		
		pb.setFilename(filename);
		pb.setLoginid(loginid1);
		pb.setKey(key);
		
		
		
		
		CommuneKeyCheckDao ocd=new CommuneKeyCheckDao();

		
		int i=ocd.keycheck(pb);
		

		if(i==1){
			
			CommuneDownloadFileDao fdd=new CommuneDownloadFileDao();
			
			ArrayList<ProfileBean> list=fdd.filedownload(pb);
			session.setAttribute("list",list);			
			RequestDispatcher rd= request.getRequestDispatcher("CommuneFileDownload.jsp");
			rd.include(request,response);
		}
		else{
			
			
			RequestDispatcher rd= request.getRequestDispatcher("CommuneFileDownload.jsp?status=Invalid Key");
			rd.include(request, response);
			
			}
		}
			
		
		
		catch (Exception e) {
			RequestDispatcher rd= request.getRequestDispatcher("CommuneFileDownload.jsp?status=Invalid key");
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
