package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.RegistrationBean;
import com.util.Dbconnection;




public class ChangePasswordDao {

	 public boolean changePassword(RegistrationBean reb)
	    {
		 
		 boolean flag=false ;
		 
		 
	    	 	 String uid=reb.getLoginid();
	    		 String pass=reb.getPassword();
	    		 String npass=reb.getNewpassword();
	    		 String cpass=reb.getConfirmpassword();
	    		 
	      
	        
	    		 Connection con=null;
	 			
	 			try {
	 				
	 				con=Dbconnection.getConnection();
	 				

	           int i;
	           int i1;
	           String q="update LOGINDETAILS set PASSWORD='"+npass+"' where LOGINID='"+uid+"' and PASSWORD='"+pass+"'";
	           System.out.println(q);
	           i=con.createStatement().executeUpdate(q);
	           
	           String q2="update USERDETAILS set PASSWORD='"+npass+"',CONFIRMPASSWORD='"+cpass+"' where LOGINID='"+uid+"' and PASSWORD='"+pass+"'";
	           System.out.println(q2);
	           
	           i1=con.createStatement().executeUpdate(q2);
	           
	           
	           
	           
	        
	            if(i==1&&i1==1)
	            {
	                flag=true;
	                con.commit();
	            }
	            
	        }
	        catch (SQLException ex) 
	        {
	            ex.printStackTrace();
	            flag=false;
	           
	        }
	        
	        
	        finally {
	        	try {
	        	if (con != null)
	        	con.close();
	        	} catch (SQLException e) {
	        	}
	        	}
	        
	        
	        
	        
	       
	        return flag;
	    }
	   
		
	

}
