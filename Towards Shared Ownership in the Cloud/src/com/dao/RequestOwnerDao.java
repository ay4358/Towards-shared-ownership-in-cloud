package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.RegistrationBean;
import com.util.Dbconnection;

public class RequestOwnerDao {
	
	
	
	
	public ArrayList<RegistrationBean> getdata(String userid) {
		Connection con=null;
		
		ArrayList<RegistrationBean> list=new ArrayList<RegistrationBean>();
		try {
			  con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select LOGINID from LOGINDETAILS where loginid=?");
			ps.setString(1, userid);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				RegistrationBean rb=new RegistrationBean();
				String loginid=rs.getString(1);
				
				System.out.println(loginid);
				
				list.add(rb);
				//System.out.println(list.add(rb));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

}
