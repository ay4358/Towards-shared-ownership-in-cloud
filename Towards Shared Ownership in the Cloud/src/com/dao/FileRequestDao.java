package com.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.RegistrationBean;
import com.util.Dbconnection;

public class FileRequestDao {
	
	
	
	
	public List<String> getFileNames1()
	{
		Connection con=null;
		List<String> list=new ArrayList<String>();
		
		try {
			 con=Dbconnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select FILENAME from FILES_TABLE where FILESTATUS='Uploaded	'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				
				
				
				list.add(rs.getString(1));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		finally {
        	try {
        	if (con != null)
        	con.close();
        	} catch (SQLException e) {
        	}
        	}
		
		
		
		
		
		
		
		return list;
		
		
	}
	
	
	
	
	
	public List<String> getFileNames()
	{
		Connection con=null;
		List<String> list=new ArrayList<String>();
		
		try {
			 con=Dbconnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select FILENAME from FILES_TABLE where FILESTATUS='Delegate'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				
				
				
				list.add(rs.getString(1));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		finally {
        	try {
        	if (con != null)
        	con.close();
        	} catch (SQLException e) {
        	}
        	}
		
		
		
		
		
		
		
		return list;
		
		
	}
	
	
	
	public List<String> getFileUsers()
	{
		
		Connection con=null;
		
		List<String> list=new ArrayList<String>();
		
		try {
			 con=Dbconnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select LOGINID from LOGINDETAILS where STATUS='1' and  ROLE='USER'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				
				
				
				list.add(rs.getString(1));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		finally {
        	try {
        	if (con != null)
        	con.close();
        	} catch (SQLException e) {
        	}
        	}
		
		
		
		
		
		
		return list;
		
		
	}
	
	
	
	
	
	
	public int drDetails(RegistrationBean rb) throws SQLException {
		String loginid=rb.getLoginid();
		
		
		
		
		String filename=rb.getFilename();
		String draction=rb.getDraction();
	
		
		int i=0;
		int fileid=100;
		Connection con=null;
		
		
		
		/*PreparedStatement pst=con.prepareStatement("select max(FILEID) from FILES_TABLE");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			fileid = rs.getInt(1);
			fileid=fileid+1;
		}
*/
		try{
			con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into REQUEST values((select nvl(max(rid),1)+1 from REQUEST),?,?,?)");
			ps.setString(1, filename);
			
			
			
		
			ps.setString(2, loginid);
			
			
			ps.setString(3, draction);
			
			 i=ps.executeUpdate();
			 System.out.println("i*********"+i);
			 
			
			 
			 
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		
		
		
		finally {
        	try {
        	if (con != null)
        	con.close();
        	} catch (SQLException e) {
        	}
        	}
		
		
		
		
		
		
		
		
		
		
		
		
		return i;
	}
	
	
	
	
	
	
	
	
	
	
	public int ownerShipDetails(RegistrationBean rb) throws SQLException {
		String loginid=rb.getLoginid();
		
		
		
		
		String filename=rb.getFilename();
		String waction=rb.getWaction();
	
		
		int i=0;
		int fileid=100;
		Connection con=null;
		
		
		
		/*PreparedStatement pst=con.prepareStatement("select max(FILEID) from FILES_TABLE");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			fileid = rs.getInt(1);
			fileid=fileid+1;
		}
*/
		try{
			con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into THRESHOLDPOLICY values((select nvl(max(tid),1)+1 from THRESHOLDPOLICY),?,?,?)");
			ps.setString(1, loginid);
			
			
			
		
			ps.setString(2, filename);
			
			
			ps.setString(3, waction);
			
			 i=ps.executeUpdate();
			 System.out.println("i*********"+i);
			 
			
			 
			 
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		
		
		finally {
        	try {
        	if (con != null)
        	con.close();
        	} catch (SQLException e) {
        	}
        	}
		
		
		
		
		
		
		
		
		
		
		return i;
	}
	
	
	
	
	
	
	
	public int ownerShipRequest(RegistrationBean rb) throws SQLException {
		String loginid=rb.getLoginid();
		
		
		
		
		String filename=rb.getFilename();
		String waction=rb.getWaction();
	
		
		int i=0;
		int fileid=100;
		Connection con=null;
		
		
		
		/*PreparedStatement pst=con.prepareStatement("select max(FILEID) from FILES_TABLE");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			fileid = rs.getInt(1);
			fileid=fileid+1;
		}
*/
		try{
			con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into OWNERSHIPREQUEST values((select nvl(max(ORID),1)+1 from OWNERSHIPREQUEST),?,?,?)");
			
			
			
			
		
			ps.setString(1, filename);
			ps.setString(2, loginid);
			
			
			ps.setString(3, "Pending");
			
			 i=ps.executeUpdate();
			 System.out.println("i*********"+i);
			 
			
			 
			 
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		
		
		
		
		
		finally {
        	try {
        	if (con != null)
        	con.close();
        	} catch (SQLException e) {
        	}
        	}
		
		
		
		
		
		
		
		
		
		return i;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
