package com.commune.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.commune.bean.ProfileBean;
import com.util.Dbconnection;

public class CommuneRequestOwnerDao {
	public ArrayList<ProfileBean> getdata(String userid) {
		Connection con=null;
		
		ArrayList<ProfileBean> list=new ArrayList<ProfileBean>();
		try {
			  con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select LOGINID from CLOGININFO where loginid=?");
			ps.setString(1, userid);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				ProfileBean pb=new ProfileBean();
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
