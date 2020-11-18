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

public class UsersFileDownloadServlet extends HttpServlet {

	
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

HttpSession session=request.getSession();

String fileid1=request.getParameter("fileid");

RegistrationBean rb=new RegistrationBean();
int fileid=Integer.parseInt(fileid1);

rb.setFileid(fileid);




String loginid=(String) session.getAttribute("userid");
FileDownloadDao fdd=new FileDownloadDao();
try{
	
	System.out.println("lllllllllll"+loginid);
System.out.println("hhhhhhhhhh");
ArrayList<RegistrationBean> list=fdd.downloadUsers(loginid);
session.setAttribute("list", list);
RequestDispatcher rd=request.getRequestDispatcher("DownloadFile.jsp");
rd.include(request, response);
}
catch (Exception e) {
	RequestDispatcher rd=request.getRequestDispatcher("DownloadFile.jsp");
	rd.include(request, response);
}

}
	
	
	
}
