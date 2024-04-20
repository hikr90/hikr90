package service;

import java.util.List;

import dao.BoardDAO;

public class BoardServiceImpl implements BoardService{
	
	/*	SERVICEIMPL
	 		- SERVICE를 구현하는 CLASS
	 		- ROOT-CONTEXT에서 생성자 인젝션 방식으로 주입한 DAO의 객체를 받아주기위해서 기본 생성자를 작성한다.
	 		- SERVICE에 있는 추상 메소드를 오버라이딩한다.
	*/
	BoardDAO dao;
	
	// 기본 생성자
	public BoardServiceImpl() {
		
	}
	
	// 빈 객체를 받아주는 생성자
	public BoardServiceImpl(BoardDAO dao) {
		this.dao = dao;
	}
	
	// 인터페이스에 생성된 VIEWLIST 메소드 구현
	@Override
	public List viewList() {
		// VIEWLIST 서비스 메소드에서 DAO의 목록 조회 메소드와 조회수를 증가시키는 기능 동작		
		List list = dao.selectList();
		int res = dao.increaseCnt();
		//
		return list;
	}
}
