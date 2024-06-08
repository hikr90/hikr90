package com.lnsp.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnsp.vo.MemberVO;

@Repository
public class ManagerDAO {

	@Autowired
	SqlSession sqlSession;

	/*
	 * // MAPPER : manager_1to1.do // 1:1문의 갯수 확인 public HashMap<String, Integer>
	 * onetoone_count() {
	 * 
	 * int order_c = sqlSession.selectOne("manager.onetoone_order_count"); // 주문/결제
	 * int delivery_c = sqlSession.selectOne("manager.onetoone_delivery_count"); //
	 * 배송 int cancel_c = sqlSession.selectOne("manager.onetoone_cancel_count"); //
	 * 취소 int refund_c = sqlSession.selectOne("manager.onetoone_refund_count"); //
	 * 환불 int total_c = order_c + delivery_c + cancel_c + refund_c; // 총합
	 * 
	 * HashMap<String, Integer> map = new HashMap<String, Integer>();
	 * map.put("total", total_c); map.put("order", order_c); map.put("delivery",
	 * delivery_c); map.put("cancel", cancel_c); map.put("refund", refund_c);
	 * 
	 * return map; }
	 * 
	 * // MAPPER : manager_estimate.do
	 * 
	 * // 견적 신청 조회 갯수 확인 public HashMap<String, Integer> estimate_count() {
	 * 
	 * int landscape_c = sqlSession.selectOne("manager.estimate_count", "조경 설계");
	 * int facility_c = sqlSession.selectOne("manager.estimate_count", "시설물 설치");
	 * int maintenance_c = sqlSession.selectOne("manager.estimate_count", "유지 관리");
	 * int tree_management_c = sqlSession.selectOne("manager.estimate_count",
	 * "수목 관리"); int other_c = sqlSession.selectOne("manager.estimate_count", "기타");
	 * int total_c = landscape_c + facility_c + maintenance_c + tree_management_c +
	 * other_c; // 총합
	 * 
	 * HashMap<String, Integer> map = new HashMap<String, Integer>();
	 * map.put("landscape", landscape_c); map.put("facility", facility_c);
	 * map.put("maintenance", maintenance_c); map.put("tree", tree_management_c);
	 * map.put("other", other_c); map.put("total", total_c);
	 * 
	 * return map; }
	 * 
	 * // estimate 불러오기 public List<EstimateVO> estimate_selectList(HashMap<String,
	 * Integer> map) { List<EstimateVO> list =
	 * sqlSession.selectList("estimate_selectList", map); return list; }
	 * 
	 * // MAPPER : manager_itemQNA.do
	 * 
	 * // 상품 문의 갯수 확인 public HashMap<String, Integer> itemQNA_count() {
	 * 
	 * int total = sqlSession.selectOne("manager.itemqna_total_count"); int
	 * waiting_c = sqlSession.selectOne("manager.itemqna_waiting_count"); int
	 * answered_c = total - waiting_c;
	 * 
	 * HashMap<String, Integer> map = new HashMap<String, Integer>();
	 * map.put("total", total); map.put("waiting", waiting_c); map.put("answered",
	 * answered_c);
	 * 
	 * return map; }
	 * 
	 * // MAPPER : manager_noticeboard.do
	 * 
	 * // 개시글 갯수 확인 public HashMap<String, Integer> noticeboard_count() {
	 * HashMap<String, Integer> map = new HashMap<String, Integer>(); int res = 0;
	 * res = sqlSession.selectOne("manager.noticeboard_notice_count");
	 * map.put("notice", res); // 공지사항 res =
	 * sqlSession.selectOne("manager.noticeboard_member_count"); map.put("member",
	 * res); // 회원FAQ res =
	 * sqlSession.selectOne("manager.noticeboard_delivery_count");
	 * map.put("delivery", res); // 배송FAQ res =
	 * sqlSession.selectOne("manager.noticeboard_order_count"); map.put("order",
	 * res); // 주문FAQ res =
	 * sqlSession.selectOne("manager.noticeboard_refund_count"); map.put("refund",
	 * res); // 환불FAQ res = sqlSession.selectOne("manager.noticeboard_qna1_count");
	 * map.put("qna1", res); // 1:1문의 res =
	 * sqlSession.selectOne("manager.noticeboard_qna2_count"); map.put("qna2", res);
	 * // 상품문의 return map; }
	 * 
	 * // MAPPER : delete_faq.do
	 * 
	 * // FAQ 개시판 불러오기 ( paging X ) public List<FaqVO> delete_faq_selectList(String
	 * ctg) { List<FaqVO> list = null; if (ctg.equals("회원 FAQ")) { list =
	 * sqlSession.selectList("manager.delete_member_selectlist"); } else if
	 * (ctg.equals("배송 FAQ")) { list =
	 * sqlSession.selectList("manager.delete_delivery_selectlist"); } else if
	 * (ctg.equals("반품 / 교환 FAQ")) { list =
	 * sqlSession.selectList("manager.delete_refund_selectlist"); } else if
	 * (ctg.equals("주문 / 결제 FAQ")) { list =
	 * sqlSession.selectList("manager.delete_order_selectlist"); } else if
	 * (ctg.equals("자주묻는 질문")) { list =
	 * sqlSession.selectList("manager.delete_top10_selectlist"); } return list; }
	 * 
	 * // MAPPER : delete_faq_del.do
	 * 
	 * // FAQ 삭제 ( update ) public int delete_faq_delete(int idx) { int res = 0; res
	 * = sqlSession.update("manager.delete_faq_delete", idx); return res; }
	 * 
	 * // MAPPER : delete_notice.do
	 * 
	 * // notice 개시판 갯수 확인 public int delete_notice_count() { int res = 0; res =
	 * sqlSession.selectOne("manager.delete_notice_count"); return res; }
	 * 
	 * // notice 개시판 부러오기 ( paging O ) public List<FaqVO>
	 * delete_notice_selectlist(HashMap<String, Integer> page) { List<FaqVO> list =
	 * sqlSession.selectList("manager.delete_notice_selectlist", page); return list;
	 * }
	 * 
	 * // goods 상품 불러오기 public List<GoodsVO> goodList(HashMap<String, Object> map) {
	 * List<GoodsVO> list = sqlSession.selectList("manager.goodList", map); return
	 * list; }
	 * 
	 * // goods 상품 총갯수 public HashMap<String, Integer> goods_count() {
	 * 
	 * int sale = sqlSession.selectOne("manager.goods_count_sale", "판매상품"); int
	 * soldout = sqlSession.selectOne("manager.goods_count_soldout", "품절상품"); int
	 * delete = sqlSession.selectOne("manager.goods_count_delete", "삭제상품"); int
	 * total = sale + soldout + delete;
	 * 
	 * HashMap<String, Integer> map = new HashMap<String, Integer>();
	 * map.put("sale", sale); map.put("soldout", soldout); map.put("delete",
	 * delete); map.put("total", total);
	 * 
	 * return map; }
	 * 
	 * // MAPPER : manager_member.do
	 * 
	 * // 가입회원 수 public int member_count() { int res =
	 * sqlSession.selectOne("manager.member_count"); return res; }
	 * 
	 * // 탈퇴회원 수 public int dismember_count() { int res =
	 * sqlSession.selectOne("manager.dismember_count"); return res; }
	 * 
	 * // 회원정보 조회 public List<MemberVO> member_selectList(HashMap<String, Integer>
	 * map) { List<MemberVO> res =
	 * sqlSession.selectList("manager.member_selectList", map); return res; }
	 * 
	 * // 아이디 회원정보 조회 public MemberVO member_selectone(String m_id) { MemberVO vo =
	 * sqlSession.selectOne("manager.member_selectone", m_id); return vo; }
	 * 
	 * // MAPPDER : manager_member_delaction.do // 관리자권한 회원 탈퇴 public int
	 * member_del(int idx) { int res = sqlSession.update("manager.member_del", idx);
	 * return res; }
	 * 
	 * // MAPPER : manager.do
	 * 
	 * // 주문 현황 public HashMap<String, Integer> order_count() { int idx1 =
	 * sqlSession.selectOne("manager.count_idx1"); // 총 주문 int idx2 = idx1; // 입금확인
	 * int idx3 = 0; // 배송중 int idx4 = 0; // 배송완료 int idx5 =
	 * sqlSession.selectOne("manager.count_idx6"); // 취소 int idx6 = 0; // 교환 int
	 * idx7 = sqlSession.selectOne("manager.count_idx7"); // 환불 int idx8 =
	 * sqlSession.selectOne("manager.count_idx8"); // 1:1 문의 int idx9 =
	 * sqlSession.selectOne("manager.count_idx9"); // 상품 문의
	 * 
	 * HashMap<String, Integer> map = new HashMap<String, Integer>();
	 * map.put("idx1", idx1); map.put("idx2", idx2); map.put("idx3", idx3);
	 * map.put("idx4", idx4); map.put("idx5", idx5); map.put("idx6", idx6);
	 * map.put("idx7", idx7); map.put("idx8", idx8); map.put("idx9", idx9);
	 * 
	 * return map; }
	 * 
	 * // 1:1 문의 public HashMap<String, Integer> onetoone_answer_count() { int
	 * waiting = sqlSession.selectOne("manager.onetoone_waiting"); int answered =
	 * sqlSession.selectOne("manager.onetoone_answered"); int total = waiting +
	 * answered;
	 * 
	 * HashMap<String, Integer> map = new HashMap<String, Integer>();
	 * map.put("waiting", waiting); map.put("answered", answered); map.put("total",
	 * total);
	 * 
	 * return map; }
	 */

}
