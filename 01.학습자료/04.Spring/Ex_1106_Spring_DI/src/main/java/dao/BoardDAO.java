package dao;

import java.util.List;

public interface BoardDAO {
	
	/*	DAO	
			- 각각의 DML을 수행하는 기능 메소드
			- 인터페이스므로 추상메소드와 상수만 사용 가능하다.
			- 코드의 관리와 가독성을 높이기위한 용도로, 인터페이스를 구현하는 클래스(DAOImpl)가 따로 있어야한다.
	*/
	
	// 목록 조회
	List selectList(); 	// (어떤 타입이 올지 모르니, <타입> 지정을 하지 않는다.

	// 조회수 증가
	int increaseCnt();
}