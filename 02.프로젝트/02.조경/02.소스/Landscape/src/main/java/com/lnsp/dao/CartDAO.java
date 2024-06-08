package com.lnsp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAO {

	@Autowired
	SqlSession sqlSession;

	/*
	 * //장바구니 상품넣기 public int cart_insert(CartVO vo) { int res =
	 * sqlSession.insert("cart.cart_insert", vo);
	 * 
	 * return res; }
	 * 
	 * //장바구니 상품조회 public List<CartVO> cart_list(int idx) { List<CartVO> list =
	 * sqlSession.selectList("cart.cart_list", idx);
	 * 
	 * return list; }
	 * 
	 * //장바구니 수량 업데이트 public int update(int count, String g_num) {
	 * 
	 * HashMap<String, Object> map = new HashMap<String, Object>(); map.put("count",
	 * count); map.put("g_num", g_num); int cnt =
	 * sqlSession.update("cart.cart_update", map);
	 * 
	 * return cnt; }
	 * 
	 * 
	 * //장바구니 중복체크 public CartVO selectOne(CartVO vo) { CartVO one =
	 * sqlSession.selectOne("cart.cart_one", vo); return one; }
	 * 
	 * 
	 * 
	 * //장바구니 상품삭제 public CartVO selectOne(int idx, int m_num) {
	 * 
	 * CartVO vo = new CartVO(); HashMap<String, Integer> map = new HashMap<String,
	 * Integer>(); map.put("idx", idx); map.put("m_num", m_num);
	 * 
	 * vo = sqlSession.selectOne("cart.delete_cart", map); return vo; }
	 * 
	 * 
	 * //카트페이지 상품 수량 업데이트 public int update_cart(int count, String g_num, int m_num)
	 * {
	 * 
	 * HashMap<String, Object> map = new HashMap<String, Object>(); map.put("count",
	 * count); map.put("g_num", g_num); map.put("m_num", m_num);
	 * 
	 * int cart = sqlSession.update("cart.cart_cnt_update", map);
	 * 
	 * return cart; }
	 * 
	 * 
	 * 
	 * public int selectCart(int count, String g_num, int m_num) {
	 * 
	 * 
	 * HashMap<String, Object> map = new HashMap<String, Object>(); map.put("count",
	 * count); map.put("g_num", g_num); map.put("m_num", m_num); int res =
	 * sqlSession.selectOne("cart.cart_cnt_update", map);
	 * 
	 * return res; }
	 * 
	 * 
	 * public CartVO selectCart(String g_num, int count) {
	 * 
	 * CartVO vo = new CartVO(); HashMap<String, Object> map = new HashMap<String,
	 * Object>(); map.put("g_num", g_num); map.put("count", count); vo =
	 * sqlSession.selectOne("cart.cart_one1", map); return vo; }
	 * 
	 */

}
