package service;

import java.util.List;

import dao.BoardDAO;

public class BoardServiceImpl implements BoardService{
	
	/*	ServiceImpl
	 * 		- 서비스를 구현하는 클래스
	 * 		- 추상 메소드를 통해서 하나의 단위 작업(DML)에 여러 기능(DAO)를 붙여 사용한다.
	 * 		- 공통된 속성의 기능을 사용하는 경우, 하나의 인터페이스에서 생성한 뒤 타 클래스에서 객체만 주입하여 공통적으로 사용 가능하다.
	 */
	BoardDAO dao;
	
	// 기본 생성자
	public BoardServiceImpl() {
		
	}
	
	// 빈객체를 받는 생성자
	public BoardServiceImpl(BoardDAO dao) {
		this.dao = dao;
	}
	
	// 인터페이스의 추상메소드 오버라이딩
	@Override
	public List viewList() {
		List list = dao.selectList();	// 목록 조회
		int res = dao.increaseCnt();	// 조회수 증가
		//
		return list;
	}
}
