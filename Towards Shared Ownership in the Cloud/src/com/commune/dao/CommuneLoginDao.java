package com.commune.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.commune.bean.ProfileBean;
import com.util.Dbconnection;

public class CommuneLoginDao {
	 Connection con;
		
		
		
	 public ProfileBean loginCheck(ProfileBean pbean)
	    {
	        String userid=pbean.getLoginid();
	        String password=pbean.getPassword();
	       
	        
	       
	        
	        ProfileBean pbean1=new ProfileBean();
	           try
	        {
	        	   con=Dbconnection.getConnection();
	            
	            PreparedStatement pst=con.prepareStatement("select ROLE,USERNAME from CLOGININFO where LOGINID=? and PASSWORD=? and STATUS='1'");
	            pst.setString(1,userid);
	            pst.setString(2,password);
	            
	            ResultSet rs=pst.executeQuery();
	           
	            if(rs.next())
	            {
	            	pbean1.setRole(rs.getString(1));
	            	pbean1.setUsername(rs.getString(2));            
	            }
	           
	        }
	        catch (SQLException ex) 
	        {
	        	ex.printStackTrace();
	        }
	        
	        
	        finally {
	        	try {
	        	if (con != null)
	        	con.close();
	        	} catch (SQLException e) {
	        	}
	        	}
	        
	        
	        
	        
	        
	        
	        
	        
	        
	       
	        return pbean1;
	    }
	
	
	
	
	
	
	
	

}







