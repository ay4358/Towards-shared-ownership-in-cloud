package com.blockchain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.blockchain.bean.BlockChainBean;
import com.util.Dbconnection;

public class BCProfileDAO {
	
	
	
	

		private boolean flag;
		private Connection con;
		
		public boolean checkLoginIDExisted(String loginid) {
		
		
		boolean f = false;
		Connection con;

		try {

			con = Dbconnection.getConnection();

			PreparedStatement ps = con
					.prepareStatement("select * FROM BLOCKCHAINLOGINDETAILS Where LOGINID=?");
			ps.setString(1, loginid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return f;
	}
		
		
		
		
		
		
		public boolean insertLoginInfo(BlockChainBean reb) {
			String loginid = reb.getLoginid();
			String pass = reb.getPassword();
			String username = reb.getUsername();
			String usertype = reb.getRole();
			Connection con;
			try {
				con = Dbconnection.getConnection();

				PreparedStatement pst = null;
				int i = 0;
				pst = con
						.prepareStatement("insert into BLOCKCHAINLOGINDETAILS values((select nvl(max(BCLID),1)+1 from BLOCKCHAINLOGINDETAILS),?,?,?,?,?)");
				pst.setString(1, loginid);
				pst.setString(2, pass);
				pst.setString(3, usertype);
				pst.setString(4, username);
				pst.setString(5, "1");

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

		public boolean insertUserInfo(BlockChainBean reb) {

			String username = reb.getUsername();
			String lastname = reb.getLastname();
			System.out.println("dao"+lastname);
			String userid = reb.getLoginid();
			String password = reb.getPassword();
			String cpassword = reb.getCpassword();
			String email = reb.getEmail();
			String phone = reb.getMobileno();
			String gender = reb.getGender();

			Connection con = null;

			try {
				con = Dbconnection.getConnection();

				PreparedStatement pst = null;
				int i = 0;
				pst = con
						.prepareStatement("insert into BLOCKCHAINUSERDETAILS values((select nvl(max(BCUID),1)+1 from BLOCKCHAINUSERDETAILS),?,?,?,?,?,?,?,?)");

				pst.setString(1, userid);
				pst.setString(2, password);
				pst.setString(3, cpassword);
				pst.setString(4, username);
				pst.setString(5, lastname);
				pst.setString(6, email);
				pst.setString(7, phone);
				pst.setString(8, gender);
				i = pst.executeUpdate();
				if (i == 1) {
					flag = true;
					con.commit();
				} else {
					flag = false;
					con.rollback();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();

			} finally {
				try {
					if (con != null)
						con.close();
				} catch (SQLException e) {
				}
			}

			return flag;
		}

		
	}
		

