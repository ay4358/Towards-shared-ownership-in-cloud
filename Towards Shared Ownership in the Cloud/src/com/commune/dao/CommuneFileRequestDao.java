package com.commune.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.RegistrationBean;
import com.commune.bean.ProfileBean;
import com.util.Dbconnection;

public class CommuneFileRequestDao {
	
	
	
	
	public List<String> getFileNames()
	{
		List<String> list=new ArrayList<String>();
		
		try {
			Connection con=Dbconnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select FILENAME,SUBJECT from COMMUNEFILE where FILESTATUS='Accept'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				
				
				
				list.add(rs.getString(1));
				//list.add(rs.getString(2));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	
	
	
	
	public List<String> getFileUsers()
	{
		List<String> list=new ArrayList<String>();
		
		try {
			Connection con=Dbconnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select LOGINID from CLOGININFO where STATUS='1' and  ROLE='CUSER'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				
				
				
				list.add(rs.getString(1));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	
	
	public int ownerShipDetails(ProfileBean pb) throws SQLException {
		
		String loginid=pb.getLoginid();
		
		
		
		
		String filename=pb.getFilename();
		String wraction=pb.getWraction();
	
		
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
			PreparedStatement ps=con.prepareStatement("insert into COMMUNEREQUEST values((select nvl(max(CRID),1)+1 from COMMUNEREQUEST),?,?,?)");
			
	
		
			ps.setString(1, filename);
			ps.setString(2, loginid);
			
			
			ps.setString(3, wraction);
			
			 i=ps.executeUpdate();
			 System.out.println("i*********"+i);
			 
			
			 
			 
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		return i;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
