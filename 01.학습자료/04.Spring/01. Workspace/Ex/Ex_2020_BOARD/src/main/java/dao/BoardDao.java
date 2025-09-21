package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.BoardVO;

public class BoardDao {
	
	//
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 전체 목록 조회
	public List<BoardVO> selectlist(){
		//
		List<BoardVO> list = sqlSession.selectList("board.board_list");
		return list;
	}
	
	// 게시판 등록
	public int insert(BoardVO vo) {
		//
		int res = sqlSession.insert("board.board_insert", vo);
		return res;
	}
	
	// 상세 조회
	public BoardVO selectone(int idx) {
		//
		BoardVO vo = null;
		vo = sqlSession.selectOne("board.board_one", idx);
		return vo;
	}
	
	// 조회수 처리
	public int update_readhit(int idx) {
		//
		int res = sqlSession.update("board.board_update_readhit", idx);
		return res;
	}
	
	// Step 증가
	public int update_step(BoardVO baseVO) {
		//
		int res = sqlSession.update("board.board_update_step",baseVO);
		return res;
	}
	
	// 댓글 추가
	public int reply(BoardVO vo) {
		//
		int res = sqlSession.insert("board.board_reply",vo);
		return res;
	}
	
	// 삭제 여부 판단을 위한 단건 조회  
	public BoardVO selectone(int idx, String pwd) {
		//
		BoardVO vo = null;
		//
		HashMap<String, Object> map = new HashMap<String, Object>(); // 여러 타입의 값을 받을 수 있도록 자료형의 부모격인 OBJECT타입으로 지정
		map.put("idx",idx);
		map.put("pwd",pwd);
		//
		vo = sqlSession.selectOne("board.idx_pwd", map);
		return vo;
	}
	
	// 목록 삭체 처리
	public int del_update(BoardVO vo) {
		//
		int res = sqlSession.update("board.del_update", vo);
		return res;
	}
	
	// 페이징 처리를 위한 목록 조회
	public List<BoardVO> selectlist(HashMap<String, Integer> map){
		//
		List<BoardVO> list = sqlSession.selectList("board.board_list_condition",map);
		return list;
	}
	
	// 페이징 처리를 위한 전체 항목 수 조회
	public int getRowTotal() {
		//
		int count = sqlSession.selectOne("board.board_count");
		return count;
	}
	
	// 목록 내용 수정
	public int update_info(BoardVO vo) {
		//
		int res = sqlSession.update("board.update_info", vo);
		return res;
	}
}
