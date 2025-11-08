package dao;

import java.util.List;

public interface BoardDAO {
	
	/*	DAO	
	  		- Data Access Object의 약자로, DB를 사용하여 데이터를 조회하거나 조작하는 기능을 전담하는 오브젝트
			- 인터페이스므로 추상메소드와 상수만 사용 가능하다.
			- 코드의 관리와 가독성을 위한 용도로서 인터페이스를 구현하는 클래스가 따로 있어야한다.
	*/
	
	// 목록 조회
	List selectList(); 	// (어떤 타입이 올지 모르니, <타입> 지정을 하지 않는다.

	// 조회수 증가
	int increaseCnt();
}