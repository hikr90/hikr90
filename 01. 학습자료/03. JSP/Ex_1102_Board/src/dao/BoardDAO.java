package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MybatisConnector;
import vo.BoardVO;

public class BoardDAO {
	static BoardDAO single = null;

	public static BoardDAO getInstance() {
		if (single == null)
			single = new BoardDAO();
		return single;
	}
	
	SqlSessionFactory factory = null;
	
	public BoardDAO() {
		factory = MybatisConnector.getInstance().getFactory();
	}
	
	// 전체 게시물 조회
	public List<BoardVO> selectlist(){
		List<BoardVO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("board.board_list");
		sqlSession.close();
		return list;
	}
	
	// 새 글 등록
	public int insert(BoardVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.insert("board.board_insert", vo);
		sqlSession.close();
		return res;
	}
	
	// 게시물 한건 조회(글 제목을 클릭했을 시 해당 IDX가 DB에 있는지 확인)
	public BoardVO selectone(int idx) {
		BoardVO vo = null;
		SqlSession sqlSession = factory.openSession();
		vo = sqlSession.selectOne("board.board_one", idx);
		sqlSession.close();
		return vo;
	}
	
	// 조회수 증가
	public int update_readhit(int idx) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("board.board_update_readhit", idx);
		sqlSession.close();
		return res;
	}
	
	// STEP의 수정(증가)
	public int update_step(BoardVO baseVO) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("board.board_update_step",baseVO);
		sqlSession.close();
		return res;
	}
	
	// 댓글 추가
	public int reply(BoardVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.insert("board.board_reply",vo);
		sqlSession.close();
		return res;
	}
	
	// 삭제가 가능한 글인지 비번을 대조할 SELECTONDE 오버로딩 메서드 (IDX, PWD를 인자로 받는다.)
	public BoardVO selectone(int idx, String pwd) {
		BoardVO vo = null;
		SqlSession sqlSession = factory.openSession();
		
		// IDX와 PWD의 타입이 서로 타입이 다르므로 HASHMAP의 OBJECT 타입을 사용한다.
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("idx",idx);
		map.put("pwd",pwd);
		
		vo = sqlSession.selectOne("board.idx_pwd", map);
		sqlSession.close();
		return vo;
	}
	
	// 삭제된 것처럼 업데이트
	public int del_update(BoardVO vo) {
		
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("board.del_update", vo);
		sqlSession.close();
		return res;
	}
	
	// 페이지별 게시물 조회
	public List<BoardVO> selectlist(HashMap<String, Integer> map){
		List<BoardVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("board.board_list_condition",map);
		sqlSession.close();
		return list;
	}
	
	// 전체 게시물 수 구하기
	public int getRowToal() {
		SqlSession sqlSession = factory.openSession(); 
		int count = sqlSession.selectOne("board.board_count");
		sqlSession.close();
		return count;
	}
	
	// 게시글 내용 수정
	public int update_info(BoardVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("board.update_info", vo);
		sqlSession.close();
		return res;
	}
}
