package com.blockchain.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blockchain.bean.BlockChainBean;
import com.blockchain.dao.BCChangePasswordDao;
import com.commune.bean.ProfileBean;
import com.commune.dao.CommuneChangePasswordDao;

public class BCChangePasswordServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BCChangePasswordServlet() {
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


		
		
		
		
		HttpSession session = request.getSession();
		String userid=(String)session.getAttribute("userid");
		String target = "BCChangePassword.jsp?status=Please enter correct old password......";
		
		BlockChainBean b=new BlockChainBean();
		b.setPassword(request.getParameter("password"));
		b.setNewpassword(request.getParameter("npassword"));
		
		
	
		b.setLoginid(userid);
		
		boolean f=	new BCChangePasswordDao().changePassword(b);
		
		if(f==true){
			
			target = "BCChangePassword.jsp?status=Your Password is changed ......";
		}
		else{
			
			target = "BCChangePassword.jsp?status=Please enter correct old password......";
		}

		   RequestDispatcher rd = request.getRequestDispatcher(target);
		   rd.forward(request,response);    
		out.flush();
		out.close();
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
