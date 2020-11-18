package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.RegistrationBean;
import com.dao.LoginDao;
import com.dao.ProfileDAO;

public class RegistrationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

RegistrationBean rb=new RegistrationBean();


String loginid=request.getParameter("loginid");
String password=request.getParameter("password");
String confirmpassword=request.getParameter("confirmpassword");

String username=request.getParameter("username");

String lastname=request.getParameter("lastname");

String email=request.getParameter("email");

String mobileno=request.getParameter("mobileno");

String gender=request.getParameter("gender");
String usertype=request.getParameter("role");


rb.setUsername(username);

rb.setLastname(lastname);
System.out.println("last name"+lastname);
rb.setLoginid(loginid);
rb.setPassword(password);
rb.setCpassword(confirmpassword);
rb.setEmail(email);
rb.setMobileno(mobileno);
rb.setGender(gender);
rb.setRole(usertype);




String target = "Registration.jsp?status=Registration Failed  !!!!!";
boolean flag1=new ProfileDAO().checkLoginIDExisted(request.getParameter("loginid"));
if(flag1==true){
	 target = "Registration.jsp?status=This "+flag1+" login ID is not present!!";
}
else{
	boolean f=new ProfileDAO().insertLoginInfo(rb);
	boolean f1=new ProfileDAO().insertUserInfo(rb);
	if(f==true&&f1==true){
	target = "Login.jsp?status=Welcome Account is created successfully";
	}else{
		target = "Registration.jsp?status=Registration Failed  !!!!!";	
	}
}
RequestDispatcher rd = request.getRequestDispatcher(target);
rd.forward(request,response);  

out.flush();
out.close();
}


public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();
doGet(request,response);
out.flush();
out.close();
}
}
