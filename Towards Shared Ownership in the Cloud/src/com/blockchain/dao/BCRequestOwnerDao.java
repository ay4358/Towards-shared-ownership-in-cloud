package com.blockchain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.blockchain.bean.BlockChainBean;
import com.util.Dbconnection;

public class BCRequestOwnerDao {

	
	
	public ArrayList<BlockChainBean> getdata(String userid) {
		Connection con=null;
		
		ArrayList<BlockChainBean> list=new ArrayList<BlockChainBean>();
		try {
			  con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select LOGINID from BLOCKCHAINLOGINDETAILS where loginid=?");
			ps.setString(1, userid);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				BlockChainBean pb=new BlockChainBean();
				String loginid=rs.getString(1);
				
				System.out.println(loginid);
				
				list.add(pb);
				//System.out.println(list.add(rb));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
