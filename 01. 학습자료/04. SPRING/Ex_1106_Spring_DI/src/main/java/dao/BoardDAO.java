package dao;

import java.util.List;

public interface BoardDAO {
	
	/*	DAO	
			- 각각의 DML을 수행하는 기능 메소드
			- 인터페이스므로 추상메소드와 상수만 사용 가능하다.
			- 코드의 관리와 가독성을 높이기위한 용도로, 인터페이스를 구성하는 클래스(DAOIMPL)이 따로 있어야한다.
	*/
	List selectList(); 	// 어떤 타입이 처리될 지 불분명한 경우 < > 의 타입란을 입력하지 않는다.

	// 조회수를 증가시키는 메소드
	// 아래처럼 DML메소드를 추가하여 관리할 수 있다.
	int increaseCnt();
}