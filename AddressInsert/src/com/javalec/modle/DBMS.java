package com.javalec.modle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBMS {
	final String url_mysql = "jdbc:mysql://172.30.1.1/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	final String id_mysql = "root";
	final String pw_mysql = "1q2w3e4r!";
	
	Connection conn_mylsq = null;
	PreparedStatement ps = null;
	Statement stmt_myslq;
	
	public void mysqlConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn_mylsq = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			stmt_myslq = conn_mylsq.createStatement();
			System.out.println("[mysqlConnect] mysql 연결 성공");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean insertUserInfo(String[] input) {
		String query = "insert into userinfo (name, telno, address, email, relation) values (?, ?, ?, ?, ?)";
		
		try {
			mysqlConnect();
			ps = conn_mylsq.prepareStatement(query);
			for (int i = 1; i <= 5; i ++) {
				ps.setString(i, input[i - 1]);
			}
			ps.executeUpdate();
			System.out.println("[insertUserInfo] 입력 성공");
			conn_mylsq.close();
			System.out.println("[insertUserInfo] mysql연결 종료");
			return true;
		}catch (Exception e) {
			System.out.println("[insertUserInfo] 입력실패");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public ArrayList<String[]> searchUser() {
		String query = "select seqno, name, telno, relation from userinfo";
		ArrayList<String[]> result = new ArrayList<String[]>();
		
		try {
			mysqlConnect();
			ResultSet rs = stmt_myslq.executeQuery(query);
			
			while(rs.next()) {
				String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
				result.add(qTxt);
			}
			System.out.println("[searchUser] 불러오기 성공");
			conn_mylsq.close();
			System.out.println("[searchUser] mysql연결 종료");
		}catch (Exception e) {
			System.out.println("[searchUser] 불러오기 실패");
			e.printStackTrace();
		}

		return result;
	}
	
	public ArrayList<String> searchOneUser(String seqNo) {
		System.out.println("[searchOneUser] 시작");
		String query = "select seqno, name, telno, address, email, relation from userinfo where seqno = " + seqNo ;
		ArrayList<String> result = new ArrayList<String>();
		
		try {
			mysqlConnect();
			ResultSet rs = stmt_myslq.executeQuery(query);
			
			if (rs.next()) {
				for (int i = 1; i <= 6; i++) {
					result.add(rs.getString(i));
				}
			}
			
			System.out.println("[searchOneUser] 불러오기 성공");
			conn_mylsq.close();
			System.out.println("[searchOneUser] mysql연결 종료");
		}catch (Exception e) {
			System.out.println("[searchOneUser] 불러오기 실패");
			e.printStackTrace();
		}

		return result;
	}
	
}
