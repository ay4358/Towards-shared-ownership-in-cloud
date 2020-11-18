package com.blockchain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.blockchain.bean.BlockChainBean;
import com.util.Dbconnection;

public class BCNewVoteDao {
	
	
	public HashMap getVoteRequest(){
		
		  HashMap hm=new HashMap();
		  
		  Connection con=null;
		  
		  
		  
		  
		  
		  
		  
		  try {
			  System.out.println("ccccccc"+con);
			  con=Dbconnection.getConnection();
				PreparedStatement ps = con.prepareStatement("select BCURID,DIRECTORY,USERSREQ,FILENAME,LOGINID FROM BCUSERREQUEST where BCUSTATUS='ReadWrite'");
				int i = 0;
				System.out.println("ppppppp");
				ResultSet rs = ps.executeQuery();
				System.out.println("before while");
				while (rs.next()) {
					System.out.println("after while");

					BlockChainBean bcb = new BlockChainBean();
					
					bcb.setBcurid(rs.getInt(1));
					
					
					bcb.setDirectory(rs.getString(2));
					bcb.setUaction(rs.getString(3));
					bcb.setFilename(rs.getString(4));
					bcb.setLoginid(rs.getString(5));
					
					
					i = i + 1;
					hm.put(i, bcb);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return hm;
		}
	
	
	
	
	
	
	
	public List<String> getFileNames()
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
	
	
	
	
	
	
	
	
	public List<String> getUsers()
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
	
	
	
	
	
	
	
	
	
	
public boolean getGrantReq(String id) {
		
		
		
		Connection con=null;
		
		boolean flag=false;
		
		try {
			 con=Dbconnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update BCUSERREQUEST set BCUSTATUS='Grant' where BCURID='"+ id + "'");
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
	
	
	
	
	
	
	
	
	
	
public boolean getDenyReq(String id) {
	
	Connection con=null;
	
	boolean flag=false;
	
	try {
		 con=Dbconnection.getConnection();
		PreparedStatement ps = con
				.prepareStatement("update BCUSERREQUEST set BCUSTATUS='Deny' where BCURID='"+ id + "'");
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
