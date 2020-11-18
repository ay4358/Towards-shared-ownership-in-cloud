package com.commune.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.commune.bean.ProfileBean;
import com.util.Dbconnection;

public class CommuneKeyCheckDao {
	int i=1;
	
	
public int keycheck(ProfileBean pb) {
		
		
		
		Connection con=null;
		
		
		int cridid=pb.getCrid();
		
		
		String filename=pb.getFilename();
		String loginid=pb.getLoginid();
		
		String key1=pb.getKey();
		System.out.println("key1"+key1);
		try
		{
			con=Dbconnection.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select KEY from COMMUNEFILE where  FILENAME='"+filename+"' and LOGINID='"+loginid+"'");
		
		ResultSet rs=ps.executeQuery();
		System.out.println("bbkkkkkk");
		while(rs.next())
		{
			
			String key=rs.getString(1);
			System.out.println("aaakkk");
			System.out.println("key"+key);
			
			
			
			if(key.equals(key1)){
								
				System.out.println("vvvvvvvvv"+i);
					return i;
				
				
								
			}else{
				
				i++;
				System.out.println("aaavvvvvvvvv"+i);
				
				
		}
			return i;	
			
		}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return i;
		
	
	}

}
