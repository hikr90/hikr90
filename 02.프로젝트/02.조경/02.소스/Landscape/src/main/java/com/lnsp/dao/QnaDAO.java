package com.lnsp.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnaDAO {

	@Autowired
	SqlSession sqlSession;

	/*
	 * public List<QnaVO> qnaOneList() { List<QnaVO> list =
	 * sqlSession.selectList("qna.qnaOneList"); return list; }
	 * 
	 * public List<QnaVO> qnaOneList( HashMap<String, Object> map ) { List<QnaVO>
	 * list = sqlSession.selectList("qna.qnaOnePagingList", map); return list; }
	 * 
	 * public QnaVO qnaOneFormList( ) { QnaVO vo =
	 * sqlSession.selectOne("qna.qnaOneFormList", 1); return vo; }
	 * 
	 * public int qnaOneInsert( QnaVO vo ) {
	 * 
	 * int res = sqlSession.insert("qna.qnaOneInsert",vo);
	 * 
	 * return res;
	 * 
	 * }
	 * 
	 * public QnaVO qnaOneAnswerView(int q_idx) {
	 * 
	 * QnaVO vo = sqlSession.selectOne("qna.qnaOneAnswerView", q_idx); return vo; }
	 * 
	 * public int qnaOneTotal(int idx) { int res =
	 * sqlSession.selectOne("qna.qnaOneIdxTotal", idx); return res; }
	 * 
	 * public int qnaOneTotal() { int res = sqlSession.selectOne("qna.qnaOneTotal");
	 * return res; }
	 * 
	 * 
	 * 
	 * public List<QnaVO> qnaProdList() { List<QnaVO> list =
	 * sqlSession.selectList("qna.qnaProdList"); return list; }
	 * 
	 * public List<QnaVO> qnaProdList(HashMap<String, Object> map ) { List<QnaVO>
	 * list = sqlSession.selectList("qna.qnaProdPagingList", map); return list; }
	 * 
	 * public QnaVO qnaprodForm(QnaVO vo) { QnaVO resvo =
	 * sqlSession.selectOne("qna.qnaOneFormlist", vo); return resvo; }
	 * 
	 * 
	 * public int qnaProdInsert( QnaVO vo ) {
	 * 
	 * int res = sqlSession.insert("qna.qnaProdInsert", vo);
	 * 
	 * return res;
	 * 
	 * }
	 * 
	 * 
	 * public QnaVO qnaprodAnswerView(int q_idx) {
	 * 
	 * QnaVO vo = sqlSession.selectOne("qna.qnaProdAnswerView", q_idx); return vo; }
	 * 
	 * public int qnaProdTotal() { int res =
	 * sqlSession.selectOne("qna.qnaProdTotal"); return res; }
	 * 
	 * public int qnaProdTotal( int idx) { int res =
	 * sqlSession.selectOne("qna.qnaProdIdxTotal", idx); return res; }
	 * 
	 * 
	 * public List<QnaVO> qprodIngoodsListView(HashMap<String, Object> map ){
	 * List<QnaVO> list = sqlSession.selectList("qna.qprodIngoodsListView", map);
	 * return list; }
	 * 
	 * public int qnaProdIngoodsTotal( int idx) { int res =
	 * sqlSession.selectOne("qna.qnaProdIngoodsIdxTotal", idx); return res; }
	 * 
	 * 
	 * 
	 * //-----------------------------------관리자-------------------------------------
	 * -----
	 * 
	 * public int qnaOneYSupdate(int idx) { int res =
	 * sqlSession.update("qna.qnaOneYSupdate", idx); return res; }
	 * 
	 * 
	 * public int qnaProdYSupdate(int idx) { int res =
	 * sqlSession.update("qna.qnaProdYSupdate", idx); return res; }
	 * 
	 * 
	 * 
	 * public int qnaOnedelete(int idx) {
	 * 
	 * int res = sqlSession.update("qna.qnaOneDelete", idx);
	 * 
	 * return res; }
	 * 
	 * public int qnaProddelete(int idx) {
	 * 
	 * int res = sqlSession.update("qna.qnaProdDelete", idx);
	 * 
	 * return res; }
	 */
	
}










