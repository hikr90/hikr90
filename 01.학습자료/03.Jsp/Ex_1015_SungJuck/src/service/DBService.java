package service;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBService {
	
	// 싱글톤 패턴
	static DBService single = null;
	
	// getInstance로 객체를 생성한다.
	public static DBService getInstance() {
		// 생성되지 않았으면 객체 생성
		if (single == null)
			single = new DBService();
		// 생성된 객체정보를 반환
		return single;
	}
	
	// 데이터소스 객체
	DataSource ds;
	
	// 서비스 생성자
	private DBService() {
		// 컨텍스트가 존재하지 않을 수 없을 수 있으므로 예외처리
		try {
			//
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracle_test");
			
		} catch (Exception e) {

		}
	}
	
	// 커넥션 연동 메소드
	public Connection getConnection() {
		//
		Connection conn = null;
		//
		try {
			//
			conn = ds.getConnection();
			
		} catch (Exception e) {
			
		}
		//
		return conn;
	}
}
