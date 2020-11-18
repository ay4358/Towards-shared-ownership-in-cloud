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
import com.blockchain.dao.BCLoginDao;


public class BlockChainLoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BlockChainLoginServlet() {
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
		
		
		
		
		String usertype="";
	     String loginid1="";
		
		
		String loginid=request.getParameter("loginid");
		String password=request.getParameter("password");
	
		BlockChainBean rb=new BlockChainBean();
		
		
		
		
		HttpSession session = request.getSession();
		
		
		//session.setAttribute("userid",userid);
		
		rb.setLoginid(loginid);
		rb.setPassword(password);
		
		
		BlockChainBean rb1=new BlockChainBean();
		
		BCLoginDao dao=new BCLoginDao();
		/*LoginServicei ls=new LoginServiceImpl();*/
	
		rb1=dao.loginCheck(rb);
		
		usertype=rb1.getRole();
		loginid1=rb1.getLoginid();

		
		
		session.setAttribute("role",usertype);
		System.out.println("uuuuuuuuu"+usertype);
		
		String target = "BlockChainLogin.jsp?status=Invalid username and password";
		
		//session.setAttribute("userid", request.getParameter("userid"));
		
       if(usertype.equals("BLOCKCHAIN"))
       {          
          target = "BlockChainHome.jsp?status=Welcome "+loginid1;
          session.setAttribute("userid",loginid1);
          session.setAttribute("role",usertype);
       } 
       else if(usertype.equals("BCOWNER"))
       {
          target = "BCOwnerHome.jsp?status=Welcome "+loginid1;  	
          session.setAttribute("userid",loginid1);
          session.setAttribute("role",usertype);
          
       } 
       else if(usertype.equals("BCUSER"))
       {
          target = "BCUserHome.jsp?status=Welcome "+loginid1;  	
          session.setAttribute("userid",loginid1);
          session.setAttribute("role",usertype);
          
       } 
      
       else if(usertype.equals("CPROVIDER"))
       {
          target = "BCProviderHome.jsp?status=Welcome "+loginid1;  	
          session.setAttribute("userid",loginid1);
          session.setAttribute("role",usertype);
          
       } 
     
       
       else { 
          target = "BlockChainLogin.jsp?status=Invalid username and password";
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
