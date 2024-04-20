package service;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBService {
	
	// SINGLE-TON PATTERN 
	static DBService single = null;
	
	public static DBService getInstance() {
		if (single == null)
			single = new DBService();
		return single;
	}
	
	
	DataSource ds;
	
	private DBService() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracle_test");
			
		} catch (Exception e) {

		}
	} 
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
		} catch (Exception e) {
			
		}
		return conn;
	}
}
