package com.blockchain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.blockchain.bean.BlockChainBean;
import com.util.Dbconnection;

public class BlockChainOwnerDao {
	
	
	public boolean insertDetails(BlockChainBean reb)
	{
		boolean flag=false;
		
		String loginid=reb.getLoginid();
		System.out.println("ll"+loginid);
		
		String storage=reb.getStorage();
		String payment=reb.getPayment();
		String duration=reb.getDuration();
		
		
		Connection con;
		try {
			con = Dbconnection.getConnection();

			PreparedStatement pst = null;
			int i = 0;
			pst = con.prepareStatement("insert into BCOWNERSTORAGEDETAILS values((select nvl(max(BCDID),1)+1 from BCOWNERSTORAGEDETAILS),?,?,?,?,?)");
			
			
			
			pst.setString(1, storage);
			pst.setString(2, payment);
			pst.setString(3, duration);
			pst.setString(4, "Paid");
			pst.setString(5, loginid);
			
			i = pst.executeUpdate();
			if (i == 1) {
				flag = true;
				con.commit();
			} else {
				flag = false;
				con.rollback();
			}
		} catch (SQLException ex) {

		}
		return flag;
	}
}
		
		
		
		
		
		
		
	