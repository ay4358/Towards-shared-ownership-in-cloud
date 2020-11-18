package com.blockchain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.blockchain.bean.BlockChainBean;
import com.commune.bean.ProfileBean;
import com.util.Dbconnection;

public class BCNewFileDao {

	
	
	
	public HashMap getFileOwnerShipRequest(){
		
		  HashMap hm=new HashMap();
		  
		  Connection con=null;
		  
		  
		  
		  
		  
		  
		  
		  try {
			  System.out.println("ccccccc"+con);
			  con=Dbconnection.getConnection();
				PreparedStatement ps = con.prepareStatement("select BCRID,FILENAME,LOGINID FROM BCFILEREQUEST where BCRSTATUS='ReadWrite'");
				int i = 0;
				System.out.println("ppppppp");
				ResultSet rs = ps.executeQuery();
				System.out.println("before while");
				while (rs.next()) {
					System.out.println("after while");

					BlockChainBean rb = new BlockChainBean();
					
					rb.setBcrid(rs.getInt(1));
					
					
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
		
		
		
		Connection con=null;
		
		boolean flag=false;
		
		try {
			 con=Dbconnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update BCFILEREQUEST set BCRSTATUS='Grant' where BCRID='"+ id + "'");
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
		
		Connection con=null;
		
		boolean flag=false;
		
		try {
			 con=Dbconnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update BCFILEREQUEST set BCRSTATUS='Deny' where BCRID='"+ id + "'");
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
