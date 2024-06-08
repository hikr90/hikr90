package com.lnsp.ctr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnsp.dao.CartDAO;
import com.lnsp.dao.GoodsDAO;
import com.lnsp.dao.OrderInfoDAO;
import com.lnsp.dao.QnaDAO;
import com.lnsp.dao.TempDAO;
import com.lnsp.utils.Page;
import com.lnsp.vo.MemberVO;

@Controller
public class GoodsController {

	public static final String VIEW_PATH = "/WEB-INF/views/front/";

	@Autowired
	HttpServletRequest request;

	GoodsDAO goods_dao = new GoodsDAO();

	TempDAO temp_dao = new TempDAO();

	OrderInfoDAO orderinfo_dao = new OrderInfoDAO();

	CartDAO cart_dao = new CartDAO();

	QnaDAO qna_dao = new QnaDAO();

	public void setOrderinfo_dao(OrderInfoDAO orderinfo_dao) {
		this.orderinfo_dao = orderinfo_dao;
	}

	public void setGoods_dao(GoodsDAO goods_dao) {
		this.goods_dao = goods_dao;
	}

	public void setTemp_dao(TempDAO temp_dao) {
		this.temp_dao = temp_dao;
	}

	public void setCart_dao(CartDAO cart_dao) {
		this.cart_dao = cart_dao;
	}

	public void setQna_dao(QnaDAO qna_dao) {
		this.qna_dao = qna_dao;
	}

/*
 * @RequestMapping("/tree.do") public String tree(Model model, String category,
 * Integer page) {
 * 
 * if (category == null || category.isEmpty()) { category = "tree"; } //
 * List<GoodsVO> list = goods_dao.goodList(category);
 * 
 * int nowPage = 1; // list.do?page=1 if (page != null) { nowPage = page; }
 * 
 * // 한페이지에 표시될 게시물의 시작과 끝 번호 계산 int start = (nowPage - 1) *
 * Paging.Page.BLOCKLIST + 1; int end = start + Paging.Page.BLOCKLIST - 1;
 * 
 * HashMap<String, Object> map = new HashMap(); map.put("start", start);
 * map.put("end", end); map.put("category", category);
 * 
 * List<GoodsVO> list = goods_dao.goodList(map);
 * 
 * // 전체 게시물 수 가져오기 int row_total = goods_dao.getRowTotal(category);
 * 
 * // 페이지 메뉴 생성하기 String pageMenu =
 * Paging_Productlist.getPaging("tree.do?category=" + category + "&", nowPage,
 * row_total, Paging.Page.BLOCKLIST, Paging.Page.BLOCKPAGE);
 * 
 * model.addAttribute("list", list); model.addAttribute("pageMenu", pageMenu);
 * 
 * request.getSession().removeAttribute("show");
 * 
 * return VIEW_PATH + "tree.jsp";
 * 
 * }
 * 
 * @RequestMapping("/treeitem1.do") public String treeitem(Model model, int idx,
 * Integer page) {
 * 
 * // idx에 해당하는 게시글 얻어오기 GoodsVO vo = goods_dao.selectOne(idx);
 * 
 * // 조회수 증가 HttpSession session = request.getSession(); String show = (String)
 * session.getAttribute("show");
 * 
 * if (show == null) { goods_dao.update_readhit(idx);
 * session.setAttribute("show", ""); }
 * 
 * // 클래스가 넘어오면 인식을 못하게 만드는것 int nowPage = 1; // list.do?page=1
 * 
 * if (page != null) { nowPage = page; }
 * 
 * // 한 페이지에 표시되는 게시물의 시작과 끝 번호를 계산 int start = (nowPage - 1) *
 * Paging.Page.BLOCKLIST + 1; int end = start + Paging.Page.BLOCKLIST - 1;
 * 
 * HashMap<String, Object> map = new HashMap(); map.put("start", start);
 * map.put("end", end); map.put("idx", idx);
 * 
 * List<QnaVO> list = null; // 목록 list = qna_dao.qprodIngoodsListView(map);
 * 
 * // 게시물 수 가져오기 int row_total = qna_dao.qnaProdIngoodsTotal(idx);
 * 
 * // 페이지 메뉴 생성하기 String pageMenu =
 * Paging_QNAinGoods.getPaging("treeitem1.do?idx=" + idx + "&", nowPage,
 * row_total, Paging.Page.BLOCKLIST, Paging.Page.BLOCKPAGE);
 * 
 * model.addAttribute("row_total", row_total); model.addAttribute("pageMenu",
 * pageMenu); model.addAttribute("list", list);
 * 
 * model.addAttribute("vo", vo); return VIEW_PATH + "treeitem1.jsp"; }
 * 
 * // 바로 구매(TempCart) 테이블에 insert 및 insert된 값 바로 조회
 * 
 * @RequestMapping("/order_temp.do") public String order_temp(Model model,
 * TempVO vo) {
 * 
 * HttpSession session = request.getSession(false); MemberVO member = (MemberVO)
 * (session.getAttribute("user"));
 * 
 * Map<String, Integer> map = new HashMap<String, Integer>(); List<TempVO> list
 * = null;
 * 
 * if (session == null || member == null) {
 * 
 * return VIEW_PATH + "order.jsp"; } else { int m_num = member.getIdx();
 * 
 * vo.setM_num(m_num);
 * 
 * int res = temp_dao.order_temp(vo);
 * 
 * if (res == 1) { list = temp_dao.select_temp();
 * 
 * if (list != null) { map.put("idx", list.get(0).getIdx()); map.put("m_num",
 * m_num);
 * 
 * TempVO vo2 = temp_dao.temp_list(map);
 * 
 * model.addAttribute("vo2", vo2); } }
 * 
 * }
 * 
 * return VIEW_PATH + "order.jsp";
 * 
 * }
 * 
 * @RequestMapping("/order_temp2.do") public String order_temp2(Model model,
 * TempVO vo) {
 * 
 * // int m_num = ((Member)
 * (request.getSession().getAttribute("user"))).getIdx();
 * 
 * HttpSession session = request.getSession(false); MemberVO member = (MemberVO)
 * (session.getAttribute("user"));
 * 
 * Map<String, Integer> map = new HashMap<String, Integer>(); List<TempVO> list
 * = null; // List<TempVO> list2 = null;
 * 
 * if (session == null || member == null) {
 * 
 * return VIEW_PATH + "order.jsp"; } else { int m_num = member.getIdx();
 * 
 * vo.setM_num(m_num); vo.setG_num("SRO-5");
 * 
 * int res = temp_dao.order_temp(vo);
 * 
 * if (res == 1) { // list = temp_dao.select_temp(); // if (list != null) { //
 * map.put("idx", list.get(0).getIdx()); // map.put("m_num", m_num);
 * 
 * list = temp_dao.temp_list2(m_num);
 * 
 * model.addAttribute("list", list); model.addAttribute("vo", list.get(0));
 * 
 * }
 * 
 * }
 * 
 * return VIEW_PATH + "orderinfo.jsp";
 * 
 * }
 * 
 * // 입력 받은 orderinfo 데이터를 insert 한 후 import.jsp에 뿌려줌
 * 
 * @RequestMapping("/import.do") public String importAction(Model model,
 * OrderInfoVO vo) {
 * 
 * String deemail1 = request.getParameter("deemail1"); String deemail2 =
 * request.getParameter("deemail2");
 * 
 * String oi_deemail = deemail1 + "@" + deemail2;
 * 
 * String dehp1 = request.getParameter("dehp1"); String dehp2 =
 * request.getParameter("dehp2"); String dehp3 = request.getParameter("dehp3");
 * 
 * String oi_dephone = dehp1 + "-" + dehp2 + "-" + dehp3;
 * 
 * String detel1 = request.getParameter("detel1"); String detel2 =
 * request.getParameter("detel2"); String detel3 =
 * request.getParameter("detel3");
 * 
 * String oi_detel = detel1 + "-" + detel2 + "-" + detel3;
 * 
 * String dezipcode = request.getParameter("dezipcode"); String deaddr =
 * request.getParameter("deaddr"); String deaddress =
 * request.getParameter("deaddress");
 * 
 * String oi_deaddr = dezipcode + " " + deaddr + " " + deaddress;
 * 
 * vo.setOi_deemail(oi_deemail); vo.setOi_dephone(oi_dephone);
 * vo.setOi_detel(oi_detel); vo.setOi_deaddr(oi_deaddr); vo.setImp_uid("11111");
 * 
 * int m_num = ((MemberVO)
 * (request.getSession().getAttribute("user"))).getIdx(); vo.setM_num(m_num);
 * 
 * Map<String, Integer> map = new HashMap<String, Integer>(); List<OrderInfoVO>
 * list = null;
 * 
 * int res = orderinfo_dao.insertOrderInfo(vo);
 * 
 * if (res == 1) { list = orderinfo_dao.select_orderinfo();
 * 
 * if (list != null) { map.put("idx", list.get(0).getIdx()); map.put("m_num",
 * m_num);
 * 
 * OrderInfoVO vo2 = orderinfo_dao.select_import(map);
 * 
 * model.addAttribute("vo2", vo2); }
 * 
 * } return VIEW_PATH + "import.jsp"; }
 * 
 * @RequestMapping("/import2.do") public String importAction2(Model model,
 * OrderInfoVO vo) {
 * 
 * String deemail1 = request.getParameter("deemail1"); String deemail2 =
 * request.getParameter("deemail2");
 * 
 * String oi_deemail = deemail1 + "@" + deemail2;
 * 
 * String dehp1 = request.getParameter("dehp1"); String dehp2 =
 * request.getParameter("dehp2"); String dehp3 = request.getParameter("dehp3");
 * 
 * String oi_dephone = dehp1 + "-" + dehp2 + "-" + dehp3;
 * 
 * String detel1 = request.getParameter("detel1"); String detel2 =
 * request.getParameter("detel2"); String detel3 =
 * request.getParameter("detel3");
 * 
 * String oi_detel = detel1 + "-" + detel2 + "-" + detel3;
 * 
 * String dezipcode = request.getParameter("dezipcode"); String deaddr =
 * request.getParameter("deaddr"); String deaddress =
 * request.getParameter("deaddress");
 * 
 * String oi_deaddr = dezipcode + " " + deaddr + " " + deaddress;
 * 
 * vo.setOi_deemail(oi_deemail); vo.setOi_dephone(oi_dephone);
 * vo.setOi_detel(oi_detel); vo.setOi_deaddr(oi_deaddr);
 * 
 * int m_num = ((MemberVO)
 * (request.getSession().getAttribute("user"))).getIdx(); vo.setM_num(m_num);
 * 
 * Map<String, Integer> map = new HashMap<String, Integer>(); List<OrderInfoVO>
 * list = null;
 * 
 * int res = orderinfo_dao.insertOrderInfo2(vo);
 * 
 * if (res == 1) { list = orderinfo_dao.select_orderinfo(); if (list != null) {
 * map.put("idx", list.get(0).getIdx()); map.put("m_num", m_num);
 * 
 * OrderInfoVO vo2 = orderinfo_dao.select_import(map);
 * 
 * model.addAttribute("vo2", vo2); }
 * 
 * } return VIEW_PATH + "import.jsp"; }
 * 
 * @RequestMapping("/orderOk.do") public String orderOk(Model model, int idx,
 * String imp) {
 * 
 * int m_num = ((MemberVO)
 * (request.getSession().getAttribute("user"))).getIdx();
 * 
 * HashMap<String, Object> map = new HashMap<String, Object>(); map.put("idx",
 * idx); map.put("m_num", m_num); map.put("imp", imp);
 * 
 * int res = orderinfo_dao.updateInfo(map);
 * 
 * if (res == 1) { OrderInfoVO vo = orderinfo_dao.orderOk(map);
 * model.addAttribute("vo", vo); }
 * 
 * return VIEW_PATH + "orderOk.jsp"; }
 * 
 * @RequestMapping("/cart_insert.do")
 * 
 * @ResponseBody // return된 결과값을 콜백메서드로 돌려줘라 public String cart_insert(Model
 * model, String g_num, Integer g_price, String g_name, int count) {
 * 
 * // System.out.println("bbbb"+count);
 * 
 * HttpSession session = request.getSession(); MemberVO member = (MemberVO)
 * (session.getAttribute("user")); CartVO vo = new CartVO(); vo.setG_num(g_num);
 * vo.setM_num(member.getIdx()); vo.setG_price(g_price); vo.setCount(count);
 * vo.setG_name(g_name);
 * 
 * // int cnt = cart_dao.update(count, g_num);
 * 
 * CartVO res = cart_dao.selectOne(vo);
 * 
 * String result = "no"; if (res == null) { result = "yes";
 * cart_dao.cart_insert(vo); } else { cart_dao.update(count, g_num); }
 * 
 * return result;
 * 
 * }
 * 
 * @RequestMapping("/cart.do") public String cart(Model model) { HttpSession
 * session = request.getSession(); MemberVO member = (MemberVO)
 * (session.getAttribute("user")); int idx = member.getIdx(); //
 * System.out.println("aaaa"+idx);
 * 
 * List<CartVO> list = cart_dao.cart_list(idx); model.addAttribute("list",
 * list); return VIEW_PATH + "cart.jsp"; }
 * 
 * @RequestMapping("/cart_update.do") public String cart_update(Model model, int
 * count, String g_num, int m_num) {
 * 
 * CartVO vo = new CartVO(); vo.setG_num(g_num); vo.setM_num(m_num);
 * vo.setCount(count);
 * 
 * int res = cart_dao.update_cart(count, g_num, m_num); // int cart =
 * cart_dao.update_cart(count, g_num);
 * 
 * return "redirect:cart.do?g_num=" + g_num + "&count=" + count + "&m_num=" +
 * m_num;
 * 
 * }
 * 
 * @RequestMapping("/cart_delete.do") public String delete(int idx, int m_num) {
 * 
 * CartVO del = cart_dao.selectOne(idx, m_num);
 * 
 * return "redirect:cart.do?idx=" + idx;
 * 
 * }
 */
	}


/*
 * int nowPage = 1; //list.do?page=1 if(page != null ) { nowPage = page; }
 * 
 * //한페이지에 표시될 게시물의 시작과 끝 번호 계산 int start = (nowPage - 1) *
 * Common.Test.BLOCKLIST +1; int end = start + Common.Test.BLOCKLIST -1;
 * 
 * HashMap<String, Integer> map = new HashMap(); map.put("start", start);
 * map.put("end", end);
 * 
 * list = goods_dao.goodList(map);
 * 
 * int row_total = goods_dao.getRowTotal();
 * 
 * String pageMenu = Paging.getPaging("tree/tree.do", nowPage, row_total,
 * Common.Test.BLOCKLIST, Common.Test.BLOCKPAGE);
 * 
 * model.addAttribute("pageMenu", pageMenu);
 * 
 * //세션에 기록되어 있던 조회수 저장 정보를 삭제 request.getSession().removeAttribute("show");
 * 
 * return Common.Test.VIEW_PATH + "tree.jsp";
 */