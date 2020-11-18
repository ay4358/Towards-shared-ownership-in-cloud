package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.NewFileDRDao;
import com.dao.NewUserAcceptance;

public class NewFileDRRequestServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NewFileDRRequestServlet() {
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
		String userid=(String)session.getAttribute("userid");

System.out.println("sssssssss");
		HashMap hmpro5=new NewFileDRDao().getFileRDRequest();
		System.out.println("ssssssoooo");
		if(hmpro5.size()>0){
		session.setAttribute("hmpro5", hmpro5);
		}


		String target="NewFileRequest.jsp?status=New Request";
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
		out.flush();
		out.close();
		}


		public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		doGet(request, response);

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
