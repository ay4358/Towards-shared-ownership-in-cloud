package com.blockchain.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blockchain.bean.BlockChainBean;
import com.blockchain.dao.BCFileRequestDao;
import com.commune.dao.CommuneFileRequestDao;

public class BCContractOwnerShipServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BCContractOwnerShipServlet() {
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


		
		
		
		BlockChainBean bcb=new BlockChainBean();

		

		String storage=request.getParameter("storage");
			
		String duration=request.getParameter("duration");
			String loginid=request.getParameter("loginid");
			
			String pay=request.getParameter("pay");
			
			
			

			
			bcb.setLoginid(loginid);
			bcb.setStorage(storage);
			bcb.setDuration(duration);
		
			bcb.setPay(pay);
			
			BCFileRequestDao fd=new BCFileRequestDao();
			
			try {
				int i=fd.insertDetails(bcb);
				
				
				if(i!=0){
					RequestDispatcher rd=request.getRequestDispatcher("BCOwnerContract.jsp?status=Data Inserted successfully");
					rd.include(request, response);
				}
				else {
					RequestDispatcher rd=request.getRequestDispatcher("BCOwnerContract.jsp?status=Data NOt Inserted");
					rd.include(request, response);
				}
			} catch (SQLException e) {
				RequestDispatcher rd=request.getRequestDispatcher("BCOwnerContract.jsp?status=Some Internal Problem Occured");
				rd.include(request, response);
				
			}
			
			
			
			
			
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
		//PrintWriter out = response.getWriter();
		
		
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
