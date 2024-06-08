package com.lnsp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnaAnswerDAO {

	@Autowired
	SqlSession sqlSession;

	/*
	 * public List<QnaVO> qnaOneAnswerList( HashMap<String, Object> map ) {
	 * List<QnaVO> list = sqlSession.selectList("qnaAnswer.qnaOneAnswerPagingList",
	 * map); return list; }
	 * 
	 * public List<QnaVO> qnaOneAnswerPartList( HashMap<String, Object> map ) {
	 * List<QnaVO> list =
	 * sqlSession.selectList("qnaAnswer.qnaOneAnswerPartPagingList", map); return
	 * list; }
	 * 
	 * public List<QnaVO> qnaOneAnswerWaitList( HashMap<String, Object> map ) {
	 * List<QnaVO> list =
	 * sqlSession.selectList("qnaAnswer.qnaOneAnswerWaitPagingList", map); return
	 * list; }
	 * 
	 * public List<QnaVO> qnaOneAnswerCompleteList( HashMap<String, Object> map ) {
	 * List<QnaVO> list =
	 * sqlSession.selectList("qnaAnswer.qnaOneAnswerCompletePagingList", map);
	 * return list; }
	 * 
	 * public List<QnaVO> qnaOneAnswerDeleteList( HashMap<String, Object> map ) {
	 * List<QnaVO> list =
	 * sqlSession.selectList("qnaAnswer.qnaOneAnswerDeletePagingList", map); return
	 * list; }
	 * 
	 * public int qnaOneAnswerTotal() { int res =
	 * sqlSession.selectOne("qnaAnswer.qnaOneAnswerTotal"); return res; }
	 * 
	 * public int qnaOneAnswerPartTotal( int count ) { int res =
	 * sqlSession.selectOne("qnaAnswer.qnaOneAnswerPartTotal", count); return res; }
	 * 
	 * 
	 * public int qnaOneAnswerWaitTotal( int count ) { int res =
	 * sqlSession.selectOne("qnaAnswer.qnaOneAnswerWaitTotal", count); return res; }
	 * 
	 * 
	 * public int qnaOneAnswerCompleteTotal( int count ) { int res =
	 * sqlSession.selectOne("qnaAnswer.qnaOneAnswerCompleteTotal", count); return
	 * res; }
	 * 
	 * public int qnaOneAnswerDeleteTotal( int count ) { int res =
	 * sqlSession.selectOne("qnaAnswer.qnaOneAnswerDeleteTotal", count); return res;
	 * }
	 * 
	 * public Map qnaOneAnswerCount() {
	 * 
	 * String[] cnt = {"count1", "count2", "count3", "count4", "count5"};
	 * 
	 * Map<String, Object> countmap = new HashMap(); for (int i = 0; i < cnt.length;
	 * i++) { countmap.put(cnt[i]
	 * ,sqlSession.selectOne("qnaAnswer.qnaOneAnswerCount"+(i+1) ) ); }
	 * 
	 * countmap.put("wait", sqlSession.selectOne("qnaAnswer.qnaoneAnswerWait"));
	 * countmap.put("Complete",
	 * sqlSession.selectOne("qnaAnswer.qnaoneAnswerComplete"));
	 * countmap.put("delete", sqlSession.selectOne("qnaAnswer.qnaoneAnswerDelete"));
	 * return countmap;
	 * 
	 * }
	 * 
	 * 
	 * public Map qnaOneAnswerPartCount( int count ) {
	 * 
	 * String[] cnt = {"count1", "count2", "count3", "count4", "count5"};
	 * 
	 * Map<String, Object> countmap = new HashMap(); for (int i = 0; i < cnt.length;
	 * i++) { countmap.put(cnt[i]
	 * ,sqlSession.selectOne("qnaAnswer.qnaOneAnswerCount"+(i+1) ) ); }
	 * 
	 * countmap.put("wait", sqlSession.selectOne("qnaAnswer.qnaoneAnswerPartWait",
	 * count)); countmap.put("Complete",
	 * sqlSession.selectOne("qnaAnswer.qnaoneAnswerPartComplete", count));
	 * countmap.put("delete",
	 * sqlSession.selectOne("qnaAnswer.qnaoneAnswerPartDelete", count));
	 * 
	 * return countmap;
	 * 
	 * }
	 * 
	 * public QnaVO qnaOneAnswerForm( int idx ) {
	 * 
	 * QnaVO vo = sqlSession.selectOne("qnaAnswer.qnaOneAnswerForm", idx);
	 * 
	 * return vo; }
	 * 
	 * public int qnaOneInsert( AnswerVO vo) {
	 * 
	 * int res = sqlSession.insert("qnaAnswer.qnaOneAnswerInsert", vo); return res;
	 * 
	 * }
	 * 
	 * public AnswerVO qnaOneManagerAnswerView(int q_idx) {
	 * 
	 * AnswerVO vo = sqlSession.selectOne("qnaAnswer.qnaOneManagerAnswerView",
	 * q_idx); return vo;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public List<QnaVO> qnaProdAnswerList( HashMap<String, Object> map ) {
	 * List<QnaVO> list = sqlSession.selectList("qnaAnswer.qnaProdAnswerPagingList",
	 * map); return list; }
	 * 
	 * public int qnaProdAnswerTotal() { int res =
	 * sqlSession.selectOne("qnaAnswer.qnaprodAnswerTotal"); return res; }
	 * 
	 * public Map qnaProdAnswerCount() {
	 * 
	 * Map<String, Object> countmap = new HashMap();
	 * 
	 * countmap.put("wait", sqlSession.selectOne("qnaAnswer.qnaprodAnswerWait"));
	 * countmap.put("Complete",
	 * sqlSession.selectOne("qnaAnswer.qnaprodAnswerComplete"));
	 * 
	 * 
	 * return countmap;
	 * 
	 * }
	 * 
	 * public QnaVO qnaProdAnswerForm( int idx ) {
	 * 
	 * QnaVO vo = sqlSession.selectOne("qnaAnswer.qnaProdAnswerForm", idx);
	 * 
	 * return vo; }
	 * 
	 * public int qnaProdInsert( AnswerVO vo) {
	 * 
	 * int res = sqlSession.insert("qnaAnswer.qnaProdAnswerInsert", vo); return res;
	 * 
	 * }
	 * 
	 * 
	 * public AnswerVO qnaProdManagerAnswerView(int q_idx) {
	 * 
	 * AnswerVO vo = sqlSession.selectOne("qnaAnswer.qnaProdManagerAnswerView",
	 * q_idx); return vo;
	 * 
	 * }
	 */

	
}










