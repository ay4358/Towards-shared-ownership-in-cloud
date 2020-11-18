package com.commune.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.commune.bean.ProfileBean;
import com.util.Dbconnection;

public class CommuneProfileDAO {
	
	
	private boolean flag;
	private Connection con;
	
	public boolean checkLoginIDExisted(String loginid) {
	
	
	boolean f = false;
	Connection con;

	try {

		con = Dbconnection.getConnection();

		PreparedStatement ps = con
				.prepareStatement("select * FROM CLOGININFO Where LOGINID=?");
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
	
	
	
	
	
	
	public boolean insertLoginInfo(ProfileBean pb) {
		String loginid = pb.getLoginid();
		String pass = pb.getPassword();
		String username = pb.getUsername();
		String usertype = pb.getRole();
		Connection con;
		try {
			con = Dbconnection.getConnection();

			PreparedStatement pst = null;
			int i = 0;
			pst = con
					.prepareStatement("insert into CLOGININFO values((select nvl(max(clid),1)+1 from CLOGININFO),?,?,?,?,?)");
			pst.setString(1, loginid);
			pst.setString(2, pass);
			pst.setString(3, usertype);
			pst.setString(4, username);
			pst.setString(5, "0");

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

	public boolean insertUserInfo(ProfileBean pb) {

		String username = pb.getUsername();
		String lastname = pb.getLastname();
		System.out.println("dao"+lastname);
		String userid = pb.getLoginid();
		String password = pb.getPassword();
		String cpassword = pb.getCpassword();
		String email = pb.getEmail();
		String phone = pb.getMobileno();
		String gender = pb.getGender();

		Connection con = null;

		try {
			con = Dbconnection.getConnection();

			PreparedStatement pst = null;
			int i = 0;
			pst = con
					.prepareStatement("insert into CUSERINFO values((select nvl(max(cuids),1)+1 from CUSERINFO),?,?,?,?,?,?,?,?)");

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



