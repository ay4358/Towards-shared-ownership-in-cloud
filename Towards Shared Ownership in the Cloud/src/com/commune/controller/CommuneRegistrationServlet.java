package com.commune.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.commune.bean.ProfileBean;
import com.commune.dao.CommuneProfileDAO;

public class CommuneRegistrationServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CommuneRegistrationServlet() {
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

		ProfileBean pb=new ProfileBean();


		String loginid=request.getParameter("loginid");
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("confirmpassword");

		String username=request.getParameter("username");

		String lastname=request.getParameter("lastname");

		String email=request.getParameter("email");

		String mobileno=request.getParameter("mobileno");

		String gender=request.getParameter("gender");
		String usertype=request.getParameter("role");


		pb.setUsername(username);

		pb.setLastname(lastname);
		System.out.println("last name"+lastname);
		pb.setLoginid(loginid);
		pb.setPassword(password);
		pb.setCpassword(confirmpassword);
		pb.setEmail(email);
		pb.setMobileno(mobileno);
		pb.setGender(gender);
		pb.setRole(usertype);




		String target = "CommuneRegistration.jsp?status=Registration Failed  !!!!!";
		boolean flag1=new CommuneProfileDAO().checkLoginIDExisted(request.getParameter("loginid"));
		if(flag1==true){
			 target = "CommuneRegistration.jsp?status=This "+flag1+" login ID is not present!!";
		}
		else{
			boolean f=new CommuneProfileDAO().insertLoginInfo(pb);
			boolean f1=new CommuneProfileDAO().insertUserInfo(pb);
			if(f==true&&f1==true){
			target = "CommuneLogin.jsp?status=Welcome Account is created successfully";
			}else{
				target = "CommuneRegistration.jsp?status=Registration Failed  !!!!!";	
			}
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
