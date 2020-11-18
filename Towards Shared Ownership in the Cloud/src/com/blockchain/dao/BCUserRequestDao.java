package com.blockchain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.blockchain.bean.BlockChainBean;
import com.util.Dbconnection;

public class BCUserRequestDao {
public int insertUserDetails(BlockChainBean bcb) throws SQLException {
		
		
		
		String filename=bcb.getFilename();
		String loginid=bcb.getLoginid();
		
		
		String directory=bcb.getDirectory();
		
		String uaction=bcb.getUaction();
		String reqaction=bcb.getReqaction();
	
		
		int i=0;
		
		Connection con=null;
		
		
		
		
		try{
			con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into BCUSERREQUEST values((select nvl(max(BCURID),1)+1 from BCUSERREQUEST),?,?,?,?,?)");
			
	
		
			ps.setString(1, directory);
			ps.setString(2, uaction);
			
			
			ps.setString(3, reqaction);
			ps.setString(4, filename);
			ps.setString(5, loginid);
			
			 i=ps.executeUpdate();
			 System.out.println("i*********"+i);
			 
			
			 
			 
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		return i;
	}




}
