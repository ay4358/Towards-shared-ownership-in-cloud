package com.commune.dao;

import java.sql.Connection;
import java.sql.SQLException;


import com.commune.bean.ProfileBean;
import com.util.Dbconnection;

public class CommuneChangePasswordDao {
	
	 public boolean changePassword(ProfileBean reb)
	    {
		 
		 boolean flag=false ;
		 
		 
	    	 	 String uid=reb.getLoginid();
	    		 String pass=reb.getPassword();
	    		 String npass=reb.getNewpassword();
	    		 
	      
	        
	    		 Connection con=null;;
	 			
	 			try {
	 				
	 				con=Dbconnection.getConnection();
	 				

	           int i;
	           int i1;
	           String q="update CLOGININFO set PASSWORD='"+npass+"' where LOGINID='"+uid+"' and PASSWORD='"+pass+"'";
	           System.out.println(q);
	           i=con.createStatement().executeUpdate(q);
	           
	           String q2="update CUSERINFO set PASSWORD='"+npass+"' where LOGINID='"+uid+"' and PASSWORD='"+pass+"'";
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



