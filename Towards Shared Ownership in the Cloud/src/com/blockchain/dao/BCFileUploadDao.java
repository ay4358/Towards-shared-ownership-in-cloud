package com.blockchain.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.blockchain.bean.BlockChainBean;

import com.util.Dbconnection;

public class BCFileUploadDao {
	
	
	
	
public int upload(BlockChainBean bcb) throws SQLException {
		
		String loginid=bcb.getLoginid();
		
		
		String subject=bcb.getSubject();
		
		String file=bcb.getFile();
		
		String filename=bcb.getFilename();
		
		Long filekey=bcb.getFilekey();
	
		
		int i=0;
		
		Connection con=null;
		
		
		
		/*PreparedStatement pst=con.prepareStatement("select max(FILEID) from FILES_TABLE");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			fileid = rs.getInt(1);
			fileid=fileid+1;
		}
*/
		try{
			con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into BCFILEUPLOAD(BCFID,FILENAME,SUBJECT,FILEKEY,FILESTATUS,LOGINID,FILES) values((select nvl(max(BCFID),1)+1 from BCFILEUPLOAD),?,?,?,?,?,?)");
			ps.setString(1, filename);
			ps.setString(2,subject);
			
			
			ps.setLong(3, filekey);
			
			 ps.setString(4, "Uploaded");
			
			ps.setString(5, loginid);
			
			File f=new File(file);
			FileInputStream fis=new FileInputStream(f);
			ps.setBinaryStream(6, fis,(int)f.length());
			
			
			
			 i=ps.executeUpdate();
			 
			 System.out.println("i*********"+i);
			 
			
			 
			 
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		
		
		
		
		finally {
        	try {
        	if (con != null)
        	con.close();
        	} catch (SQLException e) {
        	}
        	}
		
		
		
		
		
		
		
		return i;
	}
}






	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


