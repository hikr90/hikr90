package com.lnsp.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnsp.vo.AnswerVO;

@Repository
public class QnaDAO {

	@Autowired
	SqlSession sqlSession;

	public List<AnswerVO> qnaOneList() {
		List<AnswerVO> list = sqlSession.selectList("qna.qnaOneList");
		return list;
	}
	
	public List<AnswerVO> qnaOneList( HashMap<String, Object> map ) {
		List<AnswerVO> list = sqlSession.selectList("qna.qnaOnePagingList", map);
		return list;
	}
	
	public AnswerVO qnaOneFormList( ) {
		AnswerVO vo = sqlSession.selectOne("qna.qnaOneFormList", 1);
		return vo;
	}
	
	public int qnaOneInsert( AnswerVO vo ) {
		
		int res = sqlSession.insert("qna.qnaOneInsert",vo);
		
		return res;
		
	}
	
	public AnswerVO qnaOneAnswerView(int q_idx) {
		
		AnswerVO vo = sqlSession.selectOne("qna.qnaOneAnswerView", q_idx);
		return vo;
	}
	
	public int qnaOneTotal(int idx) {
		int res = sqlSession.selectOne("qna.qnaOneIdxTotal", idx);
		return res;
	}
	
	public int qnaOneTotal() {
		int res = sqlSession.selectOne("qna.qnaOneTotal");
		return res;
	}

	
	
	public List<AnswerVO> qnaProdList() {
		List<AnswerVO> list = sqlSession.selectList("qna.qnaProdList");
		return list;
	}
	
	public List<AnswerVO> qnaProdList(HashMap<String, Object> map ) {
		List<AnswerVO> list = sqlSession.selectList("qna.qnaProdPagingList", map);
		return list;
	}
	
	public AnswerVO qnaprodForm(AnswerVO vo) {
		AnswerVO resvo = sqlSession.selectOne("qna.qnaOneFormlist", vo);
		return resvo;
	}
	

	public int qnaProdInsert( AnswerVO vo ) {
		
		int res = sqlSession.insert("qna.qnaProdInsert", vo);
		
		return res;
		
	}
	
	
	public AnswerVO qnaprodAnswerView(int q_idx) {
		
		AnswerVO vo = sqlSession.selectOne("qna.qnaProdAnswerView", q_idx);
		return vo;
	}
	
	public int qnaProdTotal() {
		int res = sqlSession.selectOne("qna.qnaProdTotal");
		return res;
	}
	
	public int qnaProdTotal( int idx) {
		int res = sqlSession.selectOne("qna.qnaProdIdxTotal", idx);
		return res;
	}
	

	public List<AnswerVO> qprodIngoodsListView(HashMap<String, Object> map ){
		List<AnswerVO> list = sqlSession.selectList("qna.qprodIngoodsListView", map);
		return list;
	}
	
	public int qnaProdIngoodsTotal( int idx) {
		int res = sqlSession.selectOne("qna.qnaProdIngoodsIdxTotal", idx);
		return res;
	}
	
	
	
//-----------------------------------관리자------------------------------------------
	
	public int qnaOneYSupdate(int idx) {
		int res = sqlSession.update("qna.qnaOneYSupdate", idx);
		return res;
	}
	
	
	public int qnaProdYSupdate(int idx) {
		int res = sqlSession.update("qna.qnaProdYSupdate", idx);
		return res;
	}
	
	
	
	public int qnaOnedelete(int idx) {
		
		int res = sqlSession.update("qna.qnaOneDelete", idx);
		
		return res;
	}
	
	public int qnaProddelete(int idx) {
		
		int res = sqlSession.update("qna.qnaProdDelete", idx);
		
		return res;
	}
	
}










