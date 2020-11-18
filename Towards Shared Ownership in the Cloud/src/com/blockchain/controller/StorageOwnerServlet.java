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
import com.blockchain.dao.BlockChainOwnerDao;

public class StorageOwnerServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StorageOwnerServlet() {
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
		String target = "BCOwnerMemory.jsp?status=Failed  !!!!!";
		
		try
		{
			
		
		String storage=request.getParameter("storage");
		
		String payment=request.getParameter("payment");
		
		String duration=request.getParameter("duration");
		
		//String loginid=request.getParameter("loginid");
		
		HttpSession session = request.getSession();
		String loginid= (String) session.getAttribute("userid");
		
		
		BlockChainBean bcb=new BlockChainBean();
		
		bcb.setStorage(storage);
		bcb.setPayment(payment);
		bcb.setDuration(duration);
		bcb.setLoginid(loginid);
		
		
		
		BlockChainOwnerDao bcod=new BlockChainOwnerDao();
		
		
		Boolean b=bcod.insertDetails(bcb);
		
		if(b==true)
		{
				target = "BCOwnerStorageDetails.jsp?status=Welcome Details inserted successfully";
				
				}
		else
		{
					target = "BCOwnerStorageDetails.jsp?status=Failed  !!!!!";	
				}
			
		}
		
		
		
		catch (Exception e) {


			e.printStackTrace();
			
			
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
