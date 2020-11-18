package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


import com.bean.RegistrationBean;
import com.util.Dbconnection;

public class NewFileDRDao {
	
	
	Connection con=null;
	
	
	
	public HashMap getFileDetails(){
		  HashMap hm=new HashMap();
		  try {
			  
			  
			  con=Dbconnection.getConnection();
				PreparedStatement ps = con
						.prepareStatement("select * FROM FILES_TABLE where STATUS='Uploaded' and loginid='cloud'");
				int i = 0;
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					RegistrationBean rbean = new RegistrationBean();
					
					/*rbean.setUserid(rs.getString(2));
					rbean.setUsertype(rs.getString(3));*/
					
					rbean.setUsername(rs.getString(4));
					i = i + 1;
					hm.put(i, rbean);

				}
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
			 finally {
		        	try {
		        	if (con != null)
		        	con.close();
		        	} catch (SQLException e) {
		        	}
		        	}
			
			return hm;
		}
	
	
	
	
	
	
	
	
	public boolean getDelegateFileReq(String id) {
		
		boolean flag=false;
		
		try {
			 con=Dbconnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update FILES_TABLE set FILESTATUS='Delegate' where FILEID='"+ id + "'");
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
	
	
	
	
	
public boolean getRevokeFileReq(String id) {
		
		boolean flag=false;
		
		try {
			 con=Dbconnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update FILES_TABLE set FILESTATUS='Revoke' where FILEID='"+ id + "'");
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
	
	
	
	
	

public HashMap getFileRDRequest(){
	
	  HashMap hm=new HashMap();
	  
	  try {
		  System.out.println("ccccccc"+con);
		  con=Dbconnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select LOGINID,FILENAME,SUBJECT,FILEID FROM FILES_TABLE where FILESTATUS='Uploaded'");
			int i = 0;
			System.out.println("ppppppp");
			ResultSet rs = ps.executeQuery();
			System.out.println("before while");
			while (rs.next()) {
				System.out.println("after while");

				RegistrationBean rb = new RegistrationBean();
				
				rb.setLoginid(rs.getString(1));
				rb.setFilename(rs.getString(2));
				
				rb.setSubject(rs.getString(3));
				rb.setFileid(rs.getInt(4));
				
				
				i = i + 1;
				hm.put(i, rb);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hm;
	}

	





public HashMap getFileOwnerShipRequest(){
	
	  HashMap hm=new HashMap();
	  
	  try {
		  System.out.println("ccccccc"+con);
		  con=Dbconnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select ORID,FILENAME,LOGINID FROM OWNERSHIPREQUEST where ORSTATUS='Pending'");
			int i = 0;
			System.out.println("ppppppp");
			ResultSet rs = ps.executeQuery();
			System.out.println("before while");
			while (rs.next()) {
				System.out.println("after while");

				RegistrationBean rb = new RegistrationBean();
				
				rb.setOrid(rs.getInt(1));
				
				
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







public boolean getDenyFileReq(String id) {
	
	boolean flag=false;
	
	try {
		 con=Dbconnection.getConnection();
		PreparedStatement ps = con
				.prepareStatement("update OWNERSHIPREQUEST set ORSTATUS='Deny' where ORID='"+ id + "'");
		int i = 0;
		i = ps.executeUpdate();
		if (i > 0) {
			flag = true;

		}
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
	finally {
    	try {
    	if (con != null)
    	con.close();
    	} catch (SQLException e) {
    	}
    	}
	
	
	
	
	
	
	return flag;
}





public boolean getGrantFileReq(String id) {
	
	boolean flag=false;
	
	try {
		 con=Dbconnection.getConnection();
		PreparedStatement ps = con
				.prepareStatement("update OWNERSHIPREQUEST set ORSTATUS='Grant' where ORID='"+ id + "'");
		int i = 0;
		i = ps.executeUpdate();
		if (i > 0) {
			flag = true;

		}
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
	
	finally {
    	try {
    	if (con != null)
    	con.close();
    	} catch (SQLException e) {
    	}
    	}
	
	
	
	
	
	
	
	return flag;
}









	
	

}
