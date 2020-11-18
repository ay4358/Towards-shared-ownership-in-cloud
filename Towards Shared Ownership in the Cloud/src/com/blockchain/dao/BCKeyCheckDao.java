package com.blockchain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.blockchain.bean.BlockChainBean;
import com.commune.bean.ProfileBean;
import com.util.Dbconnection;

public class BCKeyCheckDao {
	
	
	
	int i=1;
	
	
	public int keycheck(BlockChainBean bcb) {
			
			
			
			Connection con=null;
			
			
			
			
			
			String filename=bcb.getFilename();
			String loginid=bcb.getLoginid();
			
			Long key1=bcb.getFilekey();
			
			System.out.println("key1"+key1);
			try
			{
				con=Dbconnection.getConnection();
			
			PreparedStatement ps=con.prepareStatement("select FILEKEY from BCFILEUPLOAD where  FILENAME='"+filename+"' and LOGINID='"+loginid+"'");
			
			ResultSet rs=ps.executeQuery();
			System.out.println("bbkkkkkk");
			while(rs.next())
			{
				
				Long key=rs.getLong(1);
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

	
	
	
	
	
	
	
	
	


