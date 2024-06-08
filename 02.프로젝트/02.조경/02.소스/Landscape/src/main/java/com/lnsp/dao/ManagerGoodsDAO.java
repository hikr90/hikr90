package com.lnsp.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerGoodsDAO {

	@Autowired
	SqlSession sqlSession;

	/*
	 * public int delete_goods(int idx, int status, int g_condition) {
	 * HashMap<String, Integer> map = new HashMap<String, Integer>(); map.put("idx",
	 * idx); map.put("status", status); map.put("g_condition", g_condition);
	 * 
	 * int res = sqlSession.update("managergoods.goods_delete", map);
	 * 
	 * return res; }
	 * 
	 * public int soldout_goods(int idx, int status, int g_condition) {
	 * HashMap<String, Integer> map = new HashMap<String, Integer>(); map.put("idx",
	 * idx); map.put("status", status); map.put("g_condition", g_condition);
	 * 
	 * int res = sqlSession.update("managergoods.goods_soldout", map);
	 * 
	 * return res; }
	 * 
	 * public int insert_goods(int idx, int status, int g_condition) {
	 * HashMap<String, Integer> map = new HashMap<String, Integer>(); map.put("idx",
	 * idx); map.put("status", status); map.put("g_condition", g_condition);
	 * 
	 * int res = sqlSession.update("managergoods.goods_sale", map);
	 * 
	 * return res; }
	 * 
	 * public List<GoodsVO> Search(HashMap<String, Object> map) { List<GoodsVO>
	 * search_list = sqlSession.selectList("managergoods.Search", map); return
	 * search_list; }
	 * 
	 * public int SearchResult(String text, String radio, int select) {
	 * HashMap<String, Object> selectmap = new HashMap<String, Object>();
	 * selectmap.put("search", text); selectmap.put("radio", radio);
	 * selectmap.put("select", select);
	 * 
	 * int res = sqlSession.selectOne("managergoods.SearchResult", selectmap);
	 * return res; }
	 * 
	 * public HashMap<String, Integer> goods_count() { int sale =
	 * sqlSession.selectOne("manager.goods_count_sale", "판매상품"); int soldout =
	 * sqlSession.selectOne("manager.goods_count_soldout", "품절상품"); int delete =
	 * sqlSession.selectOne("manager.goods_count_delete", "삭제상품"); int total = sale
	 * + soldout + delete;
	 * 
	 * HashMap<String, Integer> map = new HashMap<String, Integer>();
	 * map.put("sale", sale); map.put("soldout", soldout); map.put("delete",
	 * delete); map.put("total", total);
	 * 
	 * return map; }
	 */

}
