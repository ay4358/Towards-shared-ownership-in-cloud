package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.RegistrationBean;


import com.util.Dbconnection;

public class LoginDao {
	
	
	 Connection con;
	
	
	
	 public RegistrationBean loginCheck(RegistrationBean regbean)
	    {
	        String userid=regbean.getLoginid();
	        String password=regbean.getPassword();
	       
	        
	       
	        
	        RegistrationBean regbean1=new RegistrationBean();
	           try
	        {
	        	   con=Dbconnection.getConnection();
	            
	            PreparedStatement pst=con.prepareStatement("select ROLE,USERNAME from LOGINDETAILS where LOGINID=? and PASSWORD=? and STATUS='1'");
	            pst.setString(1,userid);
	            pst.setString(2,password);
	            
	            ResultSet rs=pst.executeQuery();
	           
	            if(rs.next())
	            {
	            	regbean1.setRole(rs.getString(1));
	            	regbean1.setUsername(rs.getString(2));            
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
	       
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        return regbean1;
	    }
	
	
	
	
	
	
	//select filename,row_number() over(partition by filename order by filename) from files_table
	
	
	
	
	
	
	

}




