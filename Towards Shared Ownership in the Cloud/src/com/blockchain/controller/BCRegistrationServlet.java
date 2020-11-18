package com.blockchain.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.blockchain.bean.BlockChainBean;
import com.blockchain.dao.BCProfileDAO;


public class BCRegistrationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

BlockChainBean bcb=new BlockChainBean();


String loginid=request.getParameter("loginid");
String password=request.getParameter("password");
String confirmpassword=request.getParameter("confirmpassword");

String username=request.getParameter("username");

String lastname=request.getParameter("lastname");

String email=request.getParameter("email");

String mobileno=request.getParameter("mobileno");

String gender=request.getParameter("gender");
String usertype=request.getParameter("role");


bcb.setUsername(username);

bcb.setLastname(lastname);
System.out.println("last name"+lastname);
bcb.setLoginid(loginid);
bcb.setPassword(password);
bcb.setCpassword(confirmpassword);
bcb.setEmail(email);
bcb.setMobileno(mobileno);
bcb.setGender(gender);
bcb.setRole(usertype);




String target = "BlockChainRegistration.jsp?status=Registration Failed  !!!!!";

boolean flag1=new BCProfileDAO().checkLoginIDExisted(request.getParameter("loginid"));
if(flag1==true){
	 target = "BlockChainRegistration.jsp?status=This "+flag1+" login ID is not present!!";
}
else{
	boolean f=new BCProfileDAO().insertLoginInfo(bcb);
	boolean f1=new BCProfileDAO().insertUserInfo(bcb);
	if(f==true&&f1==true){
	target = "BlockChainLogin.jsp?status=Welcome Account is created successfully";
	}else{
		target = "BlockChainRegistration.jsp?status=Registration Failed  !!!!!";	
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
