package com.javalec.controller;

public class test {

	String query = "select seqno, name, telno, address, email, relation from userinfo where ";
	JTextField[] tf = {tfSeqno, tfName, tfTelno, tfAddress, tfEmail, tfRelation};
	int i = Inner_Table.getSelectedRow(); //클릭된 로우값 가져와
	String wkSeq = (String) Inner_Table.getValueAt(i, 0); //그로우값의 0번의 값을 가져와
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		ResultSet rs = stmt_mysql.executeQuery(query + wkSeq); //입력, 수정, 삭제
		while(rs.next()) { //가져올게 있다 rs.next(false) 가져올거없다
			String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
			
			for(int j = 0;i<qTxt.length;i++) {
				tf[i].setText(qTxt[i]);
			}
		}
		conn_mysql.close();// 사용후 데이터베이스 연결 끊음
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}
