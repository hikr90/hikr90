package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MybatisConnector;
import vo.BoardVO;

public class BoardDAO {
	static BoardDAO single = null;
	//
	public static BoardDAO getInstance() {
		if (single == null)
			single = new BoardDAO();
		return single;
	}
	//
	SqlSessionFactory factory = null;
	// 생성자
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
	
	// 게시물 단건 조회
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
	
	// 게시글의 Step 증가
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
	
	// 삭제 가능 여부 단건 조회
	public BoardVO selectone(int idx, String pwd) {
		BoardVO vo = null;
		SqlSession sqlSession = factory.openSession();
		//
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("idx",idx);
		map.put("pwd",pwd);
		//
		vo = sqlSession.selectOne("board.idx_pwd", map);
		sqlSession.close();
		return vo;
	}
	
	// 게시글 삭제 처리
	public int del_update(BoardVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("board.del_update", vo);
		sqlSession.close();
		return res;
	}
	
	// 페이지별 목록 조회
	public List<BoardVO> selectlist(HashMap<String, Integer> map){
		List<BoardVO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("board.board_list_condition",map);
		sqlSession.close();
		return list;
	}
	
	// 전체 게시물 수 조회
	public int getRowToal() {
		SqlSession sqlSession = factory.openSession(); 
		int count = sqlSession.selectOne("board.board_count");
		sqlSession.close();
		return count;
	}
	
	// 게시글 수정
	public int update_info(BoardVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("board.update_info", vo);
		sqlSession.close();
		return res;
	}
}
