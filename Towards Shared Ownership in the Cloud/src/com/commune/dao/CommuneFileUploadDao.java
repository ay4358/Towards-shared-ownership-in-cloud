package com.commune.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.commune.bean.ProfileBean;
import com.util.Dbconnection;

public class CommuneFileUploadDao {
	public int upload(ProfileBean pb) throws SQLException {
		
		String loginid=pb.getLoginid();
		
		
		String subject=pb.getSubject();
		
		String file=pb.getFile();
		
		String filename=pb.getFilename();
		String key=pb.getKey();
	
		
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
			PreparedStatement ps=con.prepareStatement("insert into COMMUNEFILE(FILEID,FILENAME,SUBJECT,FILES,FILESTATUS,LOGINID,KEY) values((select nvl(max(fileid),1)+1 from COMMUNEFILE),?,?,?,?,?,?)");
			ps.setString(1, filename);
			ps.setString(2,subject);
			
			File f=new File(file);
			FileInputStream fis=new FileInputStream(f);
			ps.setBinaryStream(3, fis,(int)f.length());
			
			 ps.setString(4, "Pending");
			
			ps.setString(5, loginid);
			ps.setString(6, key);
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






