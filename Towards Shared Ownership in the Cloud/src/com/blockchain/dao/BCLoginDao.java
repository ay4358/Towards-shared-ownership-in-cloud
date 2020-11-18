package com.blockchain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.blockchain.bean.BlockChainBean;
import com.util.Dbconnection;

public class BCLoginDao {
	
	
	
	
	
	
	Connection con;



public BlockChainBean loginCheck(BlockChainBean regbean)
   {
       String userid=regbean.getLoginid();
       String password=regbean.getPassword();
      
       
      
       
       BlockChainBean regbean1=new BlockChainBean();
          try
       {
       	   con=Dbconnection.getConnection();
           
           PreparedStatement pst=con.prepareStatement("select ROLE,LOGINID from BLOCKCHAINLOGINDETAILS where LOGINID=? and PASSWORD=? and STATUS='1'");
           pst.setString(1,userid);
           pst.setString(2,password);
           
           ResultSet rs=pst.executeQuery();
          
           if(rs.next())
           {
           	regbean1.setRole(rs.getString(1));
           	regbean1.setLoginid(rs.getString(2));            
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




}
