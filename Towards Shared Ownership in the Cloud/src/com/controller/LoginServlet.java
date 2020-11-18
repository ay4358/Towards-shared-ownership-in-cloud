package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.dao.LoginDao;

import com.bean.RegistrationBean;
import com.dao.LoginDao;



public class LoginServlet extends HttpServlet {

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

		
		
		
		
		String usertype="";
	     String username="";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String loginid=request.getParameter("loginid");
		String password=request.getParameter("password");
	
		RegistrationBean rb=new RegistrationBean();
		
		
		
		
		HttpSession session = request.getSession();
		
		
		//session.setAttribute("userid",userid);
		
		rb.setLoginid(loginid);
		rb.setPassword(password);
		
		
		RegistrationBean rb1=new RegistrationBean();
		
		LoginDao dao=new LoginDao();
		/*LoginServicei ls=new LoginServiceImpl();*/
		String target = "Login.jsp?status=Invalid username and password";
		
		try{
	
		rb1=dao.loginCheck(rb);
		
		usertype=rb1.getRole();
		username=rb1.getUsername();

		
		
		session.setAttribute("role",usertype);
		System.out.println("uuuuuuuuu"+usertype);
		
		
		
		//session.setAttribute("userid", request.getParameter("userid"));
		
        if(usertype.equals("CLOUD"))
        {          
           target = "CloudHome.jsp?status=Welcome "+loginid;
           session.setAttribute("userid",loginid);
           session.setAttribute("role",usertype);
        } 
        else if(usertype.equals("USER"))
        {
           target = "UserHome.jsp?status=Welcome "+loginid;  	
           session.setAttribute("userid",loginid);
           session.setAttribute("role",usertype);
           
        } 
       
        else { 
           target = "Login.jsp?status=Invalid username and password";
           }   
		}
		catch (Exception e) {
			
			target = "Login.jsp?status=Invalid username and password";
			
					}
	
       RequestDispatcher rd = request.getRequestDispatcher(target);
       rd.forward(request,response);    
	
		out.flush();
		out.close();
	}
		
		
		
		
	}


