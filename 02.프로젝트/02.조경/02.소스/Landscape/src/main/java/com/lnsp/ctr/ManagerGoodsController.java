package com.lnsp.ctr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnsp.dao.ManagerGoodsDAO;
import com.lnsp.utils.Page;

@Controller
public class ManagerGoodsController {

	// 경로
	public final String VIEW_PATH = "/WEB-INF/views/manager/";
	
	ManagerGoodsDAO mg_goodsdao = new ManagerGoodsDAO();
	
	public void setMg_goodsdao(ManagerGoodsDAO mg_goodsdao) {
		this.mg_goodsdao = mg_goodsdao;
	}
	
	/*
	 * @RequestMapping("/goods_delete.do") public String goods_delete(Model model,
	 * int idx, int status, int g_condition) {
	 * 
	 * GoodsVO vo = new GoodsVO(); vo.setIdx(idx); vo.setStatus(status);
	 * vo.setG_condition(g_condition);
	 * 
	 * int res = mg_goodsdao.delete_goods(idx, status, g_condition);
	 * 
	 * return "manager_productlist.do?idx=" + idx + "&status=" + status
	 * +"&g_condition=" + g_condition;
	 * 
	 * }
	 * 
	 * @RequestMapping("/goods_soldout.do") public String goods_soldout(Model model,
	 * int idx, int status, int g_condition) {
	 * 
	 * GoodsVO vo = new GoodsVO(); vo.setIdx(idx); vo.setStatus(status);
	 * vo.setG_condition(g_condition);
	 * 
	 * int res = mg_goodsdao.soldout_goods(idx, status, g_condition);
	 * 
	 * return "manager_productlist.do?idx=" + idx + "&status=" + status
	 * +"&g_condition=" + g_condition;
	 * 
	 * }
	 * 
	 * @RequestMapping("/goods_insert.do") public String goods_insert(Model model,
	 * int idx, int status, int g_condition) {
	 * 
	 * GoodsVO vo = new GoodsVO(); vo.setIdx(idx); vo.setStatus(status);
	 * vo.setG_condition(g_condition);
	 * 
	 * int res = mg_goodsdao.insert_goods(idx, status, g_condition);
	 * 
	 * return "manager_productlist.do?idx=" + idx + "&status=" + status
	 * +"&g_condition=" + g_condition;
	 * 
	 * }
	 * 
	 * @RequestMapping("/manager_productsearch.do") public String
	 * manager_search(Model model, String search, Integer page, String text, String
	 * radio, int select) {
	 * 
	 * HashMap<String, Integer> goodcount = mg_goodsdao.goods_count();
	 * model.addAttribute("goodcount", goodcount); model.addAttribute(search);
	 * 
	 * int row_total = mg_goodsdao.SearchResult(search, radio, select);
	 * 
	 * //paging 처리 int nowPage = 1; if(page != null) { nowPage = page; } int start =
	 * (nowPage - 1) * Paging.Page.BLOCKLIST + 1; int end = start +
	 * Paging.Page.BLOCKLIST - 1;
	 * 
	 * HashMap<String, Object> map = new HashMap<String, Object>(); map.put("start",
	 * start); map.put("end", end); map.put("search", search); map.put("radio",
	 * radio); // if(select.equals("all")) { // select = "1,2,3"; // }
	 * map.put("select", select); String pageMenu =
	 * Paging_Productlist.getPaging("manager_productsearch.do?search="+ search +
	 * "&radio=" + radio + "&select=" + select + "&", nowPage, row_total ,
	 * Paging.Page.BLOCKLIST, Paging.Page.BLOCKPAGE);
	 * 
	 * List<GoodsVO> search_list = mg_goodsdao.Search(map); List<GoodsVO> list = new
	 * ArrayList<GoodsVO>(); for (int i = start-1; i < end-1; i++) { if(i <
	 * search_list.size()) list.add(search_list.get(i)); }
	 * 
	 * model.addAttribute("list",list); model.addAttribute("pageMenu", pageMenu);
	 * 
	 * return VIEW_PATH + "manager_productlist.jsp";
	 * 
	 * }
	 */
}

