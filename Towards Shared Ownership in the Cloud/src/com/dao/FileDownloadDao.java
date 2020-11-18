package com.dao;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.RegistrationBean;
import com.commune.bean.ProfileBean;
import com.util.Dbconnection;



public class FileDownloadDao {
	
	
	
	
public ArrayList<RegistrationBean> download(String loginid) {
		
		Connection con=null;
		
		ArrayList<RegistrationBean> list=new ArrayList<RegistrationBean>();
		try{
			con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select files_table.fileid,OWNERSHIPREQUEST.FILENAME,OWNERSHIPREQUEST.LOGINID,FILES_TABLE.subject from OWNERSHIPREQUEST,FILES_TABLE  where OWNERSHIPREQUEST.LOGINID=? and OWNERSHIPREQUEST.ORSTATUS='Grant' and OWNERSHIPREQUEST.filename=files_table.filename and FILES_TABLE.FILESTATUS	='Delegate'");
			ps.setString(1, loginid);
			//ps.setString(2, "Grant");
			ResultSet rs=ps.executeQuery();
			System.out.println("bbbbbbbb");
			while (rs.next()) {
				
				RegistrationBean rb=new RegistrationBean();
				
				System.out.println("aaaaaaaa");
				
				int fileid=rs.getInt(1);
				String filename=rs.getString(2);
				String loginid1=rs.getString(3);
				String subject=rs.getString(4);
				rb.setFileid(fileid);
				
				rb.setFilename(filename);
				rb.setLoginid(loginid1);
				rb.setSubject(subject);
				
				list.add(rb);
			}
			
		}
		catch (Exception e) {

		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public ArrayList<RegistrationBean> filedownload(String loginid) {
		
		Connection con=null;
		
		ArrayList<RegistrationBean> list=new ArrayList<RegistrationBean>();
		try{
			 con=Dbconnection.getConnection();
			System.out.println("ccccccccccc"+con);
			PreparedStatement ps=con.prepareStatement("select FILEID,FILENAME,SUBJECT,FILES from FILES_TABLE  where LOGINID=? and FILESTATUS=?");
			ps.setString(1, loginid);
			ps.setString(2, "Uploaded");
			System.out.println("before while");
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				System.out.println("after while");
				
				RegistrationBean rb=new RegistrationBean();
				int fileid=rs.getInt(1);
				
				String filename=rs.getString(2);
				
				String subject=rs.getString(3);
				rb.setFileid(fileid);
				System.out.println("fileid"+fileid);
				System.out.println("filename"+filename);
				System.out.println("subject"+subject);
				
				Blob b=rs.getBlob(4);
				
				byte brr[] = b.getBytes(1, (int) b.length());
				OutputStream fos=new FileOutputStream("F:/"+filename);
				fos.write(brr);
				
				
				
				System.out.println("brr"+brr);
				
				
				
				rb.setFilename(filename);
				rb.setSubject(subject);
				rb.setFile(""+filename);
				
				
				
				list.add(rb);
				
			}
			
		}
		catch (Exception e) {
e.printStackTrace();
		}
		return list;
	}



public ArrayList<RegistrationBean> downloadAdmin(String loginid) {
	
	Connection con=null;
	
	ArrayList<RegistrationBean> list=new ArrayList<RegistrationBean>();
	
	
	/*RegistrationBean rb1=new RegistrationBean();
	int fileid1=rb1.getFileid();*/
	
	
	try{
		con=Dbconnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select FILEID,FILENAME,SUBJECT,LOGINID from FILES_TABLE  where LOGINID=? and FILESTATUS=?");
		ps.setString(1, loginid);
		
		ps.setString(2, "Delegate");
		ResultSet rs=ps.executeQuery();
		System.out.println("bbbbbbbb");
		while (rs.next()) {
			
			RegistrationBean rb=new RegistrationBean();
			
			System.out.println("aaaaaaaa");
			
			int fileid=rs.getInt(1);
			
			String filename=rs.getString(2);
			String subject=rs.getString(3);
			String loginid1=rs.getString(4);
			
			
			rb.setFileid(fileid);
			rb.setFilename(filename);
			rb.setSubject(subject);
			rb.setLoginid(loginid1);
			
			list.add(rb);
		}
		
	}
	catch (Exception e) {

	}
	return list;
}



















public ArrayList<RegistrationBean> downloadUsers(String loginid) {
	
	Connection con=null;
	RegistrationBean rb1=new RegistrationBean();
	int fileid1=rb1.getFileid();
	
	ArrayList<RegistrationBean> list=new ArrayList<RegistrationBean>();
	try{
		 con=Dbconnection.getConnection();
		System.out.println("ccccccccccc"+con);
		PreparedStatement ps=con.prepareStatement("select FILEID,FILENAME,SUBJECT,FILES from FILES_TABLE  where LOGINID=? and FILEID=? and FILESTATUS=? ");
		ps.setString(1, loginid);
		ps.setInt(2, fileid1);
		ps.setString(3, "Delegate");
		System.out.println("before while");
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			System.out.println("after while");
			
			RegistrationBean rb=new RegistrationBean();
			int fileid=rs.getInt(1);
			
			String filename=rs.getString(2);
			
			String subject=rs.getString(3);
			rb.setFileid(fileid);
			System.out.println("fileid"+fileid);
			System.out.println("filename"+filename);
			System.out.println("subject"+subject);
			
			Blob b=rs.getBlob(4);
			
			byte brr[] = b.getBytes(1, (int) b.length());
			OutputStream fos=new FileOutputStream("F:/"+filename);
			fos.write(brr);
			
			
			
			System.out.println("brr"+brr);
			
			
			
			rb.setFilename(filename);
			rb.setSubject(subject);
			rb.setFile(""+filename);
			
			
			
			list.add(rb);
			
		}
		
	}
	catch (Exception e) {
e.printStackTrace();
	}
	return list;
}










public ArrayList<RegistrationBean> downloadFile(String loginid) {
	
	Connection con=null;
	
	ArrayList<RegistrationBean> list3=new ArrayList<RegistrationBean>();
	try{
		
		RegistrationBean rb1=new RegistrationBean();
		String ff=rb1.getFilename();
		
		
		 con=Dbconnection.getConnection();
		System.out.println("ccccccccccc"+con);
		PreparedStatement ps=con.prepareStatement("select FILES_TABLE.FILEID,FILES_TABLE.FILENAME,FILES_TABLE.SUBJECT,FILES_TABLE.FILES from FILES_TABLE,OWNERSHIPREQUEST  where OWNERSHIPREQUEST.LOGINID=? and OWNERSHIPREQUEST.FILENAME =? and OWNERSHIPREQUEST.ORSTATUS=?");
		ps.setString(1, loginid);
		ps.setString(2, ff);
		ps.setString(3, "Grant");
		System.out.println("before while");
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			System.out.println("after while");
			
			RegistrationBean rb=new RegistrationBean();
			int fileid=rs.getInt(1);
			
			String filename=rs.getString(2);
			
			String subject=rs.getString(3);
			rb.setFileid(fileid);
			System.out.println("fileid"+fileid);
			System.out.println("filename"+filename);
			System.out.println("subject"+subject);
			
			Blob b=rs.getBlob(4);
			
			byte brr[] = b.getBytes(1, (int) b.length());
			OutputStream fos=new FileOutputStream("F:/"+filename);
			fos.write(brr);
			
			
			
			System.out.println("brr"+brr);
			
			
			
			rb.setFilename(filename);
			rb.setSubject(subject);
			rb.setFile(""+filename);
			
			
			
			list3.add(rb);
			
		}
		
	}
	catch (Exception e) {
e.printStackTrace();
	}
	return list3;
}








public ArrayList<RegistrationBean> filedownload123(RegistrationBean rb2) {
	
	Connection con=null;
	
	
	
	
	String fn=rb2.getFilename();
      int fileid1=rb2.getFileid();
	
	System.out.println("fn--------"+fn);
	
	System.out.println("fileid--------"+fileid1);
	
	ArrayList<RegistrationBean> list=new ArrayList<RegistrationBean>();
	try{
		 con=Dbconnection.getConnection();
		 
		System.out.println("ccccccccccc"+con);
		
		PreparedStatement ps=con.prepareStatement("select FILEID,FILENAME,SUBJECT,FILES from FILES_TABLE  where FILENAME=? and FILEID=? ");
		ps.setString(1, fn);
		ps.setInt(2, fileid1);
		
		
		ResultSet rs=ps.executeQuery();
		System.out.println("before while");
		
		while (rs.next()) {
			
			
			RegistrationBean rb=new RegistrationBean();
			
			int fileid=rs.getInt(1);
			
			String filename=rs.getString(2);
			
			String sub1=rs.getString(3);
			
			rb.setFileid(fileid);
			System.out.println("fileid"+fileid);
			System.out.println("filename"+filename);
			System.out.println("subject"+sub1);
			
			Blob b=rs.getBlob(4);
			
			byte brr[] = b.getBytes(1, (int) b.length());
			OutputStream fos=new FileOutputStream("D:/"+filename);
			fos.write(brr);
			
			
			
			System.out.println("brr"+brr);
			
			
			
			rb.setFilename(filename);
			rb.setSubject(sub1);
			rb.setFile(""+filename);
			
			
			
			list.add(rb);
			
		}
		
	}
	catch (Exception e) {
                              e.printStackTrace();
	}
	return list;
}
















public ArrayList<RegistrationBean> filedownload555(RegistrationBean rb2) {
	
	Connection con=null;
	
	
	
	
	String fn=rb2.getFilename();
      int fileid1=rb2.getFileid();
	
	System.out.println("fn--------"+fn);
	
	System.out.println("fileid--------"+fileid1);
	
	ArrayList<RegistrationBean> list=new ArrayList<RegistrationBean>();
	try{
		 con=Dbconnection.getConnection();
		 
		System.out.println("ccccccccccc"+con);
		
		PreparedStatement ps=con.prepareStatement("select FILEID,FILENAME,SUBJECT,FILES from FILES_TABLE  where FILENAME=? and FILEID=?");
		ps.setString(1, fn);
		ps.setInt(2, fileid1);
		
		
		ResultSet rs=ps.executeQuery();
		System.out.println("before while");
		
		while (rs.next()) {
			
			
			RegistrationBean rb=new RegistrationBean();
			
			int fileid=rs.getInt(1);
			
			String filename=rs.getString(2);
			
			String sub1=rs.getString(3);
			
			rb.setFileid(fileid);
			System.out.println("fileid"+fileid);
			System.out.println("filename"+filename);
			System.out.println("subject"+sub1);
			
			Blob b=rs.getBlob(4);
			
			byte brr[] = b.getBytes(1, (int) b.length());
			OutputStream fos=new FileOutputStream("D:/"+filename);
			fos.write(brr);
			
			
			
			System.out.println("brr"+brr);
			
			
			
			rb.setFilename(filename);
			rb.setSubject(sub1);
			rb.setFile(""+filename);
			
			
			
			list.add(rb);
			
		}
		
	}
	catch (Exception e) {
                              e.printStackTrace();
	}
	return list;
}






}
