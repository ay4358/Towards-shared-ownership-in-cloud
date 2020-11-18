package com.commune.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;


import com.bean.RegistrationBean;
import com.commune.bean.ProfileBean;
import com.util.Dbconnection;

public class CommuneNewFileDRDao {
	
	
	Connection con=null;
	
	public HashMap getFileRDRequest(){
		
		  HashMap hm=new HashMap();
		  
		  try {
			  System.out.println("ccccccc"+con);
			  con=Dbconnection.getConnection();
				PreparedStatement ps = con.prepareStatement("select FILEID,FILENAME,SUBJECT,LOGINID FROM COMMUNEFILE where FILESTATUS='Pending'");
				int i = 0;
				System.out.println("ppppppp");
				ResultSet rs = ps.executeQuery();
				System.out.println("before while");
				while (rs.next()) {
					System.out.println("after while");

					ProfileBean pb = new ProfileBean();
					
					pb.setFileid(rs.getInt(1));
					
					pb.setFilename(rs.getString(2));
					pb.setSubject(rs.getString(3));
					
					pb.setLoginid(rs.getString(4));
					
					
					
					
					
					
					i = i + 1;
					hm.put(i, pb);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return hm;
		}

	
	
	
public boolean getAcceptFileReq(String id) {
		
		boolean flag=false;
		
		try {
			 con=Dbconnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update COMMUNEFILE set FILESTATUS='Accept' where FILEID='"+ id + "'");
			int i = 0;
			i = ps.executeUpdate();
			if (i > 0) {
				flag = true;

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}
	
	
	





public boolean getRejectFileReq(String id) {
	
	boolean flag=false;
	
	try {
		 con=Dbconnection.getConnection();
		PreparedStatement ps = con
				.prepareStatement("update COMMUNEFILE set FILESTATUS='Reject' where FILEID='"+ id + "'");
		int i = 0;
		i = ps.executeUpdate();
		if (i > 0) {
			flag = true;

		}
	} catch (Exception e) {
		System.out.println(e);
	}
	return flag;
}





public HashMap getFileOwnerShipRequest(){
	
	  HashMap hm=new HashMap();
	  
	  try {
		  System.out.println("ccccccc"+con);
		  con=Dbconnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select CRID,FILENAME,LOGINID FROM COMMUNEREQUEST where CRSTATUS='ReadWrite'");
			int i = 0;
			System.out.println("ppppppp");
			ResultSet rs = ps.executeQuery();
			System.out.println("before while");
			while (rs.next()) {
				System.out.println("after while");

				ProfileBean rb = new ProfileBean();
				
				rb.setCrid(rs.getInt(1));
				
				
				rb.setLoginid(rs.getString(2));
				rb.setFilename(rs.getString(3));
				
				
				
				i = i + 1;
				hm.put(i, rb);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hm;
	}









public boolean getGrantFileReq(String id) {
	
	boolean flag=false;
	
	try {
		 con=Dbconnection.getConnection();
		PreparedStatement ps = con
				.prepareStatement("update COMMUNEREQUEST set CRSTATUS='Grant' where CRID='"+ id + "'");
		int i = 0;
		i = ps.executeUpdate();
		if (i > 0) {
			flag = true;

		}
	} catch (Exception e) {
		System.out.println(e);
	}
	return flag;
}





public boolean getDenyFileReq(String id) {
	
	boolean flag=false;
	
	try {
		 con=Dbconnection.getConnection();
		PreparedStatement ps = con
				.prepareStatement("update COMMUNEREQUEST set CRSTATUS='Deny' where CRID='"+ id + "'");
		int i = 0;
		i = ps.executeUpdate();
		if (i > 0) {
			flag = true;

		}
	} catch (Exception e) {
		System.out.println(e);
	}
	return flag;
}



























}
