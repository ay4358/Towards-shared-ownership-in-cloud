package com.blockchain.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.blockchain.bean.BlockChainBean;
import com.commune.util.CryptoUtils;
import com.util.Dbconnection;

public class BCDownloadFileDao {
public ArrayList<BlockChainBean> download(String loginid) {
		
		Connection con=null;
		
		ArrayList<BlockChainBean> list=new ArrayList<BlockChainBean>();
		try{
			con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select BCURID,FILENAME,LOGINID from BCUSERREQUEST  where LOGINID=? and BCUSTATUS=?");
			ps.setString(1, loginid);
			ps.setString(2, "Success");
			ResultSet rs=ps.executeQuery();
			System.out.println("bbbbbbbb");
			while (rs.next()) {
				BlockChainBean pb=new BlockChainBean();
				System.out.println("aaaaaaaa");
				
				int bcurid=rs.getInt(1);
				String filename=rs.getString(2);
				String loginid1=rs.getString(3);
				pb.setBcurid(bcurid);
				
				pb.setFilename(filename);
				pb.setLoginid(loginid1);
				
				list.add(pb);
			}
			
		}
		catch (Exception e) {

		}
		return list;
	}
	









public ArrayList<BlockChainBean> filedownload(BlockChainBean bcb) throws FileNotFoundException {
	
	String loginid=bcb.getLoginid();
	
	
	String filename=bcb.getFilename();
	
	Connection con=null;
	
	ArrayList<BlockChainBean> list=new ArrayList<BlockChainBean>();
	try {
		
		con=Dbconnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select FILENAME,FILES,FILEKEY,LOGINID from BCFILEUPLOAD where FILENAME=? and LOGINID=?");
		ps.setString(1, filename);
		
		ps.setString(2, loginid);
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
			System.out.println("ddddffffd");
			BlockChainBean pb1=new BlockChainBean();
			
			
			String fname=rs.getString(1);
			
			Blob b=rs.getBlob(2);
			
			
			
			Long key1=rs.getLong(3);
			String key=String.valueOf(key1);
			System.out.println("kkkk"+key);
			
			String loginid1=rs.getString(4);
			System.out.println("loginiddownload"+loginid1);
			
			
			byte[] brr=b.getBytes(1, (int) b.length());
			FileOutputStream fos=new FileOutputStream("D:/"+fname);
			fos.write(brr);
			
			//pb1.setFileid(fileid);
			
			pb1.setFilename(fname);
			pb1.setFile(""+fname);
			pb1.setLoginid(loginid1);
			
			File file=new File("D:/"+fname);
			
			
			
			File file2=new File("D:/"+fname);
			
			
			
			
			System.out.println("before");
			
			CryptoUtils.decrypt(key, file, file2);
			
			System.out.println("decrypted successfully");
			
						
			list.add(pb1);
		}
		
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return list;
}


























}
