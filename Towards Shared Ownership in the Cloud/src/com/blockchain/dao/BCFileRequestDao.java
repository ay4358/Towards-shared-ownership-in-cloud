package com.blockchain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blockchain.bean.BlockChainBean;
import com.commune.bean.ProfileBean;
import com.util.Dbconnection;

public class BCFileRequestDao {
	
	public List<String> getStorage()
	{
		List<String> list=new ArrayList<String>();
		
		try {
			Connection con=Dbconnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select STORAGE from BCOWNERSTORAGEDETAILS where BCODSTATUS='Paid'");
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
	
	
	public List<String> getDuration()
	{
		List<String> list=new ArrayList<String>();
		
		try {
			Connection con=Dbconnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select DURATION from BCOWNERSTORAGEDETAILS where BCODSTATUS='Paid'");
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
	
	
	
	
	
	
	public List<String> getFileNameDetails()
	{
		List<String> list=new ArrayList<String>();
		
		try {
			Connection con=Dbconnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select FILENAME from BCFILEUPLOAD where FILESTATUS='Uploaded'");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<String> getFileUsers()
	{
		List<String> list=new ArrayList<String>();
		
		try {
			Connection con=Dbconnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select LOGINID from BLOCKCHAINLOGINDETAILS where STATUS='1' and  ROLE='BCUSER'");
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
	
	
	
	
	
	
public int ownerShipDetails(BlockChainBean bcb) throws SQLException {
		
		String loginid=bcb.getLoginid();
		
		
		
		
		String filename=bcb.getFilename();
		String wraction=bcb.getWraction();
	
		
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
			PreparedStatement ps=con.prepareStatement("insert into BCFILEREQUEST values((select nvl(max(BCRID),1)+1 from BCFILEREQUEST),?,?,?)");
			
	
		
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




	
	
	
public int insertDetails(BlockChainBean bcb) throws SQLException {
	
	String loginid=bcb.getLoginid();
	
	
	
	
	String storage=bcb.getStorage();
	String duration=bcb.getDuration();
	
	String pay=bcb.getPay();

	
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
		PreparedStatement ps=con.prepareStatement("insert into BCOWNERCONTRACT values((select nvl(max(BCCID),1)+1 from BCOWNERCONTRACT),?,?,?,?,?)");
		

	
		ps.setString(1, storage);
		ps.setString(2, loginid);
		
		
		ps.setString(3, pay);
		ps.setString(4, "OK");
		ps.setString(5, duration);
		
		 i=ps.executeUpdate();
		 System.out.println("i*********"+i);
		 
		
		 
		 
	}
	catch (Exception e) {
			e.printStackTrace();
	}
	return i;
}



	
	
	
	

}
