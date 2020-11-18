package com.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.*;
import com.util.Dbconnection;

public class FileUploadDao {
	
	public int upload(RegistrationBean rb) throws SQLException {
		String loginid=rb.getLoginid();
		
		
		String subject=rb.getSubject();
		
		String file=rb.getFile();
		
		String filename=rb.getFilename();
	
		
		int i=0;
		int fileid=100;
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
			PreparedStatement ps=con.prepareStatement("insert into FILES_TABLE(FILEID,FILENAME,SUBJECT,FILES,FILESTATUS,LOGINID) values((select nvl(max(fileid),1)+1 from FILES_TABLE),?,?,?,?,?)");
			ps.setString(1, filename);
			ps.setString(2,subject);
			
			File f=new File(file);
			FileInputStream fis=new FileInputStream(f);
			ps.setBinaryStream(3, fis,(int)f.length());
			
			 ps.setString(4, "Uploaded");
			
			ps.setString(5, loginid);
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



