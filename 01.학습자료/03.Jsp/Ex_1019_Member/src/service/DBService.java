package service;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBService {
	//
	static DBService single = null;
	//
	public static DBService getInstance() {
		if (single == null)
			single = new DBService();
		return single;
	}
	//
	DataSource ds;
	// 생성자
	private DBService() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracle_test");
			
		} catch (Exception e) {

		}
	} 

	// DB 연동
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
		} catch (Exception e) {
			
		}
		return conn;
	}
}
