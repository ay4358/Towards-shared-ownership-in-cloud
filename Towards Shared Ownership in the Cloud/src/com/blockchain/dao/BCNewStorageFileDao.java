package com.blockchain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.commune.bean.ProfileBean;
import com.util.Dbconnection;

public class BCNewStorageFileDao {
	
	
	
	public HashMap getFileStorageRequest()
	{
	
	Connection con=null;
	
	 HashMap hm=new HashMap();
	  
	  try {
		  System.out.println("ccccccc"+con);
		  con=Dbconnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select CRID,FILENAME,LOGINID FROM  where CRSTATUS='ReadWrite'");
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

	
	
	
	

}
