package com.commune.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.commune.bean.ProfileBean;
import com.commune.util.*;

import com.util.Dbconnection;


public class CommuneDownloadFileDao {
	
	
	
	
public ArrayList<ProfileBean> download(String loginid) {
		
		Connection con=null;
		
		ArrayList<ProfileBean> list=new ArrayList<ProfileBean>();
		try{
			con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select CRID,FILENAME,LOGINID from COMMUNEREQUEST  where LOGINID=? and CRSTATUS=?");
			ps.setString(1, loginid);
			ps.setString(2, "Grant");
			ResultSet rs=ps.executeQuery();
			System.out.println("bbbbbbbb");
			while (rs.next()) {
				ProfileBean pb=new ProfileBean();
				System.out.println("aaaaaaaa");
				
				int crid=rs.getInt(1);
				String filename=rs.getString(2);
				String loginid1=rs.getString(3);
				pb.setCrid(crid);
				
				pb.setFilename(filename);
				pb.setLoginid(loginid1);
				
				list.add(pb);
			}
			
		}
		catch (Exception e) {

		}
		return list;
	}
	
	






public ArrayList<ProfileBean> filedownload(ProfileBean pb) throws FileNotFoundException {
	
	String loginid=pb.getLoginid();
	int fileid=pb.getFileid();
	
	String filename=pb.getFilename();
	
	Connection con=null;
	
	ArrayList<ProfileBean> list=new ArrayList<ProfileBean>();
	try {
		
		con=Dbconnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select FILEID,FILENAME,FILES,LOGINID,KEY from COMMUNEFILE where FILENAME=? and LOGINID=?");
		ps.setString(1, filename);
		
		ps.setString(2, loginid);
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			System.out.println("ddddffffd");
			ProfileBean pb1=new ProfileBean();
			
			int id=rs.getInt(1);
			String fname=rs.getString(2);
			
			Blob b=rs.getBlob(3);
			
			String loginid1=rs.getString(4);
			
			String key=rs.getString(5);
			
			byte[] brr=b.getBytes(1, (int) b.length());
			FileOutputStream fos=new FileOutputStream("D:/"+fname);
			fos.write(brr);
			
			//pb1.setFileid(fileid);
			
			pb1.setFilename(fname);
			pb1.setFile(""+fname);
			
			File file=new File("D:/"+fname);
			
			
			
			File file2=new File("D:/"+fname);
			
			
			pb1.setLoginid(loginid1);
			
			System.out.println("before");
			CryptoUtils.decrypt(key, file, file2);
			System.out.println("decrypted successfully");
			
						
			list.add(pb1);
		}
		
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return list;
}
















}
