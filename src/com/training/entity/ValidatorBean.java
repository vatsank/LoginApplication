package com.training.entity;
import java.sql.*;

import com.training.utils.MySqlConnection;
public class ValidatorBean {

	private String userName;
	private String passWord;
	
    Connection con =null;
	public ValidatorBean() {
		super();
        con =MySqlConnection.getMySqlConnection();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		System.out.println("SEt user Name called");
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
		System.out.println("set passWord called");
	}
	
	
	public boolean validate(){
		
		boolean isValid = false;
	
		String sql = "select * from myusers where userName=? and passWord=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, this.userName);
			pstmt.setString(2, this.passWord);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				 isValid=true;
			}
		} catch (Exception e) {
		   
			e.printStackTrace();
		}
		return isValid;
		
		
	}
}
