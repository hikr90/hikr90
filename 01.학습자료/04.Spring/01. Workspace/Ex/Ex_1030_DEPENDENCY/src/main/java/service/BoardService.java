package service;

import java.util.List;

	/* 	Service
	 * 		- 인터페이스와 구현 클래스를 통해서 DAO로 하나로 묶어서 관리할 수 있도록 한다.
	 * 		- 컨트롤러와 DAO를 통해서 맵퍼(XML)에 접근하도록 돕는다.
	 */
public interface BoardService {
	// 목록을 조회하는 단위 작업
	List viewList();
}	
