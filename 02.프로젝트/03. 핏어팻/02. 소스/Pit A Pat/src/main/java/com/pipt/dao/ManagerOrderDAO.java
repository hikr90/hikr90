package com.pipt.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerOrderDAO {

	@Autowired
	SqlSession sqlSession;

	/*
	 * public List<OrderInfoVO> manager_order(HashMap<String, Integer> map) {
	 * 
	 * List<OrderInfoVO> list =
	 * sqlSession.selectList("manager_order.manager_orderList", map);
	 * 
	 * return list; }
	 * 
	 * public int getRowTotal() {
	 * 
	 * return sqlSession.selectOne("manager_order.order_count"); }
	 * 
	 * public HashMap<String, Integer> order_count() {
	 * 
	 * int total = sqlSession.selectOne("manager_order.getCount_total"); int refund
	 * = sqlSession.selectOne("manager_order.getCount_refund"); int change =
	 * sqlSession.selectOne("manager_order.getCount_change");
	 * 
	 * HashMap<String, Integer> map2 = new HashMap<String, Integer>();
	 * map2.put("total", total);
	 * 
	 * int sum = sqlSession.selectOne("manager_order.getCount_sum", map2);
	 * 
	 * HashMap<String, Integer> map = new HashMap<String, Integer>();
	 * map.put("total", total); map.put("refund", refund); map.put("change",
	 * change); map.put("sum", sum);
	 * 
	 * return map; }
	 * 
	 * public List<OrderInfoVO> manager_refund(HashMap<String, Integer> map) {
	 * 
	 * List<OrderInfoVO> list =
	 * sqlSession.selectList("manager_order.manager_refund", map);
	 * 
	 * return list; }
	 * 
	 * public int refund_state(int idx) {
	 * 
	 * return sqlSession.update("manager_order.refund_status", idx); }
	 * 
	 * public List<OrderInfoVO> manager_refund_search(HashMap<String, Object> map) {
	 * List<OrderInfoVO> list =
	 * sqlSession.selectList("manager_order.manager_refund_search", map);
	 * 
	 * return list; }
	 * 
	 * public int getRowTotal_search(HashMap<String, Object> map) {
	 * 
	 * System.out.println("COUNT : " +
	 * sqlSession.selectOne("manager_order.getRowTotal_search", map));
	 * 
	 * return sqlSession.selectOne("manager_order.getRowTotal_search", map); }
	 * 
	 * public int getRowTotal_refund() {
	 * 
	 * return sqlSession.selectOne("manager_order.getRowTotal_refund"); }
	 */

}
