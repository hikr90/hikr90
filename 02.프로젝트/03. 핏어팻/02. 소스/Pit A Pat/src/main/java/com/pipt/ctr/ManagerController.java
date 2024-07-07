package com.pipt.ctr;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pipt.dao.ManagerDAO;
import com.pipt.dao.ManagerOrderDAO;
import com.pipt.utils.Page;
import com.pipt.vo.MemberVO;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Controller
public class ManagerController {

	// VIEW_PATH
	public final String VIEW_PATH = "/WEB-INF/views/manager/";

	// DAO
	/*
	 * ManagerDAO manager_dao; ManagerOrderDAO manager_order; IamportClient
	 * import_client;
	 * 
	 * public void setImport_client(IamportClient import_client) {
	 * this.import_client = import_client; }
	 * 
	 * public void setManager_dao(ManagerDAO manager_dao) { this.manager_dao =
	 * manager_dao; }
	 * 
	 * public void setManager_order(ManagerOrderDAO manager_order) {
	 * this.manager_order = manager_order; }
	 * 
	 * // MAPPING
	 * 
	 * @RequestMapping("/manager_1to1.do") public String manager_1to1(Model model) {
	 * HashMap<String, Integer> count_map = manager_dao.onetoone_count();
	 * model.addAttribute("count_map", count_map);
	 * 
	 * return VIEW_PATH + "manager_1to1.jsp"; }
	 * 
	 * @RequestMapping("/manager_1to1answer.do") public String
	 * manager_1to1answer(Model model) { return VIEW_PATH +
	 * "manager_1to1answer.jsp"; }
	 * 
	 * @RequestMapping("/manager_cancel.do") public String manager_cancel(Model
	 * model, Integer page) {
	 * 
	 * HashMap<String, Integer> ordercount = manager_order.order_count();
	 * model.addAttribute("count", ordercount);
	 * 
	 * int nowPage = 1;
	 * 
	 * if (page != null) { nowPage = page; }
	 * 
	 * // 한 페이지에 표시될 게시물의 시작과 끝 번호를 계산 int start = (nowPage - 1) *
	 * Paging.Page.BLOCKLIST + 1; int end = start + Paging.Page.BLOCKLIST - 1;
	 * 
	 * HashMap<String, Integer> map = new HashMap(); map.put("start", start);
	 * map.put("end", end);
	 * 
	 * // 전체 목록 가져오기 List<OrderInfoVO> list = null;
	 * 
	 * // 전체 게시물 수 가져오기 int row_total = manager_order.getRowTotal();
	 * 
	 * // 페이지 메뉴 생성하기 String pageMenu = Page.getPaging("manager_cancel.do", nowPage,
	 * row_total, Paging.Page.BLOCKLIST, Paging.Page.BLOCKPAGE);
	 * 
	 * model.addAttribute("list", list); model.addAttribute("pageMenu", pageMenu);
	 * 
	 * return VIEW_PATH + "manager_cancel.jsp"; }
	 * 
	 * @RequestMapping("/manager_change.do") public String manager_change(Model
	 * model, Integer page) {
	 * 
	 * HashMap<String, Integer> ordercount = manager_order.order_count();
	 * model.addAttribute("count", ordercount);
	 * 
	 * int nowPage = 1;
	 * 
	 * if (page != null) { nowPage = page; }
	 * 
	 * // 한 페이지에 표시될 게시물의 시작과 끝 번호를 계산 int start = (nowPage - 1) *
	 * Paging.Page.BLOCKLIST + 1; int end = start + Paging.Page.BLOCKLIST - 1;
	 * 
	 * HashMap<String, Integer> map = new HashMap(); map.put("start", start);
	 * map.put("end", end);
	 * 
	 * // 전체 목록 가져오기 List<OrderInfoVO> list = null;
	 * 
	 * // 전체 게시물 수 가져오기 int row_total = manager_order.getRowTotal();
	 * 
	 * // 페이지 메뉴 생성하기 String pageMenu = Page.getPaging("manager_change.do", nowPage,
	 * row_total, Paging.Page.BLOCKLIST, Paging.Page.BLOCKPAGE);
	 * 
	 * model.addAttribute("list", list); model.addAttribute("pageMenu", pageMenu);
	 * 
	 * return VIEW_PATH + "manager_change.jsp"; }
	 * 
	 * @RequestMapping("/manager_delivery.do") public String manager_delivery(Model
	 * model) { return VIEW_PATH + "manager_delivery.jsp"; }
	 * 
	 * @RequestMapping("/manager_deliveryok.do") public String
	 * manager_deliveryok(Model model) { return VIEW_PATH +
	 * "manager_deliveryok.jsp"; }
	 * 
	 * @RequestMapping("/manager_estimate.do") public String manager_estimate(Model
	 * model, Integer page) { // 견적 신청 조회 갯수 확인 HashMap<String, Integer> estimate_c
	 * = manager_dao.estimate_count(); model.addAttribute("estimate_c", estimate_c);
	 * 
	 * // PAGING 처리 int nowpage = 1; if (page != null) { nowpage = page; } int start
	 * = (nowpage - 1) * Paging.Page.BLOCKLIST + 1; int end = start - 1 +
	 * Paging.Page.BLOCKLIST; HashMap<String, Integer> map = new HashMap<String,
	 * Integer>(); map.put("start", start); map.put("end", end);
	 * 
	 * String pageMenu = Page.getPaging("manager_estimate.do", nowpage,
	 * estimate_c.get("total"), Paging.Page.BLOCKLIST, Paging.Page.BLOCKPAGE);
	 * model.addAttribute("pageMenu", pageMenu);
	 * 
	 * // 견적 신청 테이블 조회 List<EstimateVO> list = manager_dao.estimate_selectList(map);
	 * model.addAttribute("list", list);
	 * 
	 * return VIEW_PATH + "manager_estimate.jsp"; }
	 * 
	 * @RequestMapping("/manager_member.do") public String manager_member(Model
	 * model, String m_id, Integer page) { // 회원 인원수 불러오기 int member_count =
	 * manager_dao.member_count(); int dismember_count =
	 * manager_dao.dismember_count(); int allmember_count = member_count +
	 * dismember_count;
	 * 
	 * Map<String, Integer> count_map = new HashMap<String, Integer>();
	 * count_map.put("allmember", allmember_count); count_map.put("member",
	 * member_count); count_map.put("dismember", dismember_count);
	 * 
	 * model.addAttribute("count_map", count_map);
	 * 
	 * // 회원 정보 불러오기
	 * 
	 * // 모든 회원 정보 if (m_id == null) { // 페이징 처리 int row_total =
	 * manager_dao.member_count();
	 * 
	 * int nowPage = 1; if (page != null) { nowPage = page; } int start = (nowPage -
	 * 1) * Paging.Page.BLOCKLIST + 1; int end = start + Paging.Page.BLOCKLIST - 1;
	 * 
	 * HashMap<String, Integer> map = new HashMap<String, Integer>();
	 * map.put("start", start); map.put("end", end);
	 * 
	 * List<MemberVO> list = manager_dao.member_selectList(map);
	 * model.addAttribute("member_list", list);
	 * 
	 * String pageMenu = Page.getPaging("manager_member.do", nowPage, row_total,
	 * Paging.Page.BLOCKLIST, Paging.Page.BLOCKPAGE); model.addAttribute("pageMenu",
	 * pageMenu);
	 * 
	 * return VIEW_PATH + "manager_member.jsp"; }
	 * 
	 * // 회원 아이디 검색 List<MemberVO> list = new ArrayList<MemberVO>();
	 * 
	 * MemberVO vo = manager_dao.member_selectone(m_id); list.add(vo);
	 * model.addAttribute("member_list", list);
	 * 
	 * return VIEW_PATH + "manager_member.jsp"; }
	 * 
	 * @RequestMapping("/manager_member_delaction.do") public String
	 * manager_member_delaction(Model model, int idx) {
	 * 
	 * int res = manager_dao.member_del(idx);
	 * 
	 * return "redirect:manager_member.do"; }
	 * 
	 * @RequestMapping("/manager_noticeboard.do") public String
	 * manager_noticeboard(Model model) {
	 * 
	 * // 관리자ID String notice_manager = "admin"; // 공지사항 관리자 String center_manager =
	 * "admin"; // 자주묻는질문 관리자 String order_manager = "admin"; // 주문/결제FAQ 관리자 String
	 * refund_manager = "admin"; // 반품/교환FAQ 관리자 String delivery_manager = "admin";
	 * // 배송FAQ 관리자 String member_manager = "admin"; // 회원FAQ 관리자 String qna_manager
	 * = "admin"; // 1:1문의 관리자 String itemqna_manager = "admin"; // 상품문의 관리자
	 * model.addAttribute("notice_manager", notice_manager);
	 * model.addAttribute("center_manager", center_manager);
	 * model.addAttribute("order_manager", order_manager);
	 * model.addAttribute("refund_manager", refund_manager);
	 * model.addAttribute("delivery_manager", delivery_manager);
	 * model.addAttribute("member_manager", member_manager);
	 * model.addAttribute("qna_manager", qna_manager);
	 * model.addAttribute("itemqna_manager", itemqna_manager);
	 * 
	 * // 게시글 갯수 HashMap<String, Integer> notice_count =
	 * manager_dao.noticeboard_count(); model.addAttribute("notice_count",
	 * notice_count);
	 * 
	 * return VIEW_PATH + "manager_noticeboard.jsp"; }
	 * 
	 * @RequestMapping("/manager_order.do") public String manager_order(Model model,
	 * Integer page) {
	 * 
	 * HashMap<String, Integer> ordercount = manager_order.order_count();
	 * model.addAttribute("count", ordercount);
	 * 
	 * int nowPage = 1;
	 * 
	 * if (page != null) { nowPage = page; }
	 * 
	 * // 한 페이지에 표시될 게시물의 시작과 끝 번호를 계산 int start = (nowPage - 1) *
	 * Paging.Page.BLOCKLIST + 1; int end = start + Paging.Page.BLOCKLIST - 1;
	 * 
	 * HashMap<String, Integer> map = new HashMap(); map.put("start", start);
	 * map.put("end", end);
	 * 
	 * // 전체 목록 가져오기 List<OrderInfoVO> list = manager_order.manager_order(map);
	 * 
	 * // 전체 게시물 수 가져오기 int row_total = manager_order.getRowTotal();
	 * 
	 * // 페이지 메뉴 생성하기 String pageMenu = Page.getPaging("manager_order.do", nowPage,
	 * row_total, Paging.Page.BLOCKLIST, Paging.Page.BLOCKPAGE);
	 * 
	 * model.addAttribute("list", list); model.addAttribute("pageMenu", pageMenu);
	 * 
	 * return VIEW_PATH + "manager_order.jsp"; }
	 * 
	 * @RequestMapping("/manager_payok.do") public String manager_payok(Model model)
	 * { return VIEW_PATH + "manager_payok.jsp"; }
	 * 
	 * @RequestMapping("/manager_prepare.do") public String manager_prepare(Model
	 * model) { return VIEW_PATH + "manager_prepare.jsp"; }
	 * 
	 * @RequestMapping("/manager_product.do") public String manager_product(Model
	 * model, Integer page) {
	 * 
	 * HashMap<String, Integer> goodcount = manager_dao.goods_count();
	 * model.addAttribute("goodcount", goodcount);
	 * 
	 * int nowPage = 1; // list.do?page=1 if (page != null) { nowPage = page; }
	 * 
	 * // 한페이지에 표시될 게시물의 시작과 끝 번호 계산 int start = (nowPage - 1) *
	 * Paging.Page.BLOCKLIST + 1; int end = start + Paging.Page.BLOCKLIST - 1;
	 * 
	 * HashMap<String, Object> map = new HashMap<String, Object>(); map.put("start",
	 * start); map.put("end", end);
	 * 
	 * List<GoodsVO> list = manager_dao.goodList(map);
	 * 
	 * // 페이지 메뉴 생성하기 String pageMenu = Page.getPaging("manager_product.do",
	 * nowPage, goodcount.get("total"), Paging.Page.BLOCKLIST,
	 * Paging.Page.BLOCKPAGE);
	 * 
	 * model.addAttribute("list", list); model.addAttribute("pageMenu", pageMenu);
	 * return VIEW_PATH + "manager_product.jsp"; }
	 * 
	 * @RequestMapping("/manager_productlist.do") public String
	 * manager_productlist(Model model, Integer page) { HashMap<String, Integer>
	 * goodcount = manager_dao.goods_count(); model.addAttribute("goodcount",
	 * goodcount);
	 * 
	 * int nowPage = 1; // list.do?page=1 if (page != null) { nowPage = page; }
	 * 
	 * // 한페이지에 표시될 게시물의 시작과 끝 번호 계산 int start = (nowPage - 1) *
	 * Paging.Page.BLOCKLIST + 1; int end = start + Paging.Page.BLOCKLIST - 1;
	 * 
	 * HashMap<String, Object> map = new HashMap<String, Object>(); map.put("start",
	 * start); map.put("end", end);
	 * 
	 * List<GoodsVO> list = manager_dao.goodList(map);
	 * 
	 * // 페이지 메뉴 생성하기 String pageMenu = Page.getPaging("manager_productlist.do",
	 * nowPage, goodcount.get("total"), Paging.Page.BLOCKLIST,
	 * Paging.Page.BLOCKPAGE);
	 * 
	 * model.addAttribute("list", list); model.addAttribute("pageMenu", pageMenu);
	 * 
	 * return VIEW_PATH + "manager_productlist.jsp"; }
	 * 
	 * @RequestMapping("/manager_refund.do") public String manager_refund(Model
	 * model, Integer page) { HashMap<String, Integer> ordercount =
	 * manager_order.order_count(); model.addAttribute("count", ordercount);
	 * 
	 * int nowPage = 1;
	 * 
	 * if (page != null) { nowPage = page; }
	 * 
	 * // 한 페이지에 표시될 게시물의 시작과 끝 번호를 계산 int start = (nowPage - 1) *
	 * Paging.Page.BLOCKLIST + 1; int end = start + Paging.Page.BLOCKLIST - 1;
	 * 
	 * HashMap<String, Integer> map = new HashMap(); map.put("start", start);
	 * map.put("end", end);
	 * 
	 * // 전체 목록 가져오기 List<OrderInfoVO> list = manager_order.manager_refund(map);
	 * 
	 * // 전체 게시물 수 가져오기 int row_total = manager_order.getRowTotal_refund();
	 * 
	 * // 페이지 메뉴 생성하기 String pageMenu = Page.getPaging("manager_refund.do", nowPage,
	 * row_total, Paging.Page.BLOCKLIST, Paging.Page.BLOCKPAGE);
	 * 
	 * model.addAttribute("list", list); model.addAttribute("pageMenu", pageMenu);
	 * 
	 * return VIEW_PATH + "manager_refund.jsp"; }
	 * 
	 * @RequestMapping("/manager_return.do") public String manager_return(Model
	 * model) { return VIEW_PATH + "manager_return.jsp"; }
	 * 
	 * @RequestMapping("/manager.do") public String manager(Model model) { // 상품 현황
	 * HashMap<String, Integer> goodcount = manager_dao.goods_count();
	 * 
	 * map.put("sale", sale); map.put("soldout", soldout); map.put("delete",
	 * delete); map.put("total", total);
	 * 
	 * model.addAttribute("goodcount", goodcount);
	 * 
	 * // 견적 현황 HashMap<String, Integer> estimate_c = manager_dao.estimate_count();
	 * 
	 * map.put("landscape", landscape_c); map.put("facility", facility_c);
	 * map.put("maintenance", maintenance_c); map.put("tree", tree_management_c);
	 * map.put("other", other_c); map.put("total", total_c);
	 * 
	 * model.addAttribute("estimate_c", estimate_c);
	 * 
	 * // 1:1 문의 HashMap<String, Integer> count_map =
	 * manager_dao.onetoone_answer_count();
	 * 
	 * map.put("waiting", waiting); map.put("answered", answered); map.put("total",
	 * total);
	 * 
	 * model.addAttribute("count_map", count_map);
	 * 
	 * // 상품 문의 HashMap<String, Integer> itemqna_count =
	 * manager_dao.itemQNA_count();
	 * 
	 * map.put("total", total); map.put("waiting", waiting_c); map.put("answered",
	 * answered_c);
	 * 
	 * model.addAttribute("itemqna", itemqna_count);
	 * 
	 * HashMap<String, Integer> order_count = manager_dao.order_count();
	 * model.addAttribute("order_count", order_count);
	 * 
	 * return VIEW_PATH + "manager.jsp"; }
	 * 
	 * // MAPPING (delete_...) // // @RequestMapping("/delete_cscenter.do") //
	 * public String delete_cscenter(Model model) { // return VIEW_PATH +
	 * "delete_cscenter.jsp"; // } // // @RequestMapping("/delete_delivery.do") //
	 * public String delete_delivery(Model model) { // return VIEW_PATH +
	 * "delete_delivery.jsp"; // } // // @RequestMapping("/delete_member.do") //
	 * public String delete_member(Model model) { // return VIEW_PATH +
	 * "delete_member.jsp"; // } // // // @RequestMapping("/delete_notice.do") // //
	 * public String delete_notice(Model model) { // // return VIEW_PATH +
	 * "delete_notice.jsp"; // // } // // @RequestMapping("/delete_order.do") //
	 * public String delete_order(Model model) { // return VIEW_PATH +
	 * "delete_order.jsp"; // } // // @RequestMapping("/delete_refund.do") // public
	 * String delete_refund(Model model) { // return VIEW_PATH +
	 * "delete_refund.jsp"; // }
	 * 
	 * // MAPPING (delete_...)
	 * 
	 * @RequestMapping("/delete_faq.do") public String delete_member(Model model,
	 * String ctg) { model.addAttribute("ctg", ctg);
	 * 
	 * List<FaqVO> list = manager_dao.delete_faq_selectList(ctg);
	 * model.addAttribute("list", list);
	 * 
	 * if (ctg.equals("자주묻는 질문")) { return VIEW_PATH + "delete_cscenter.jsp"; }
	 * 
	 * return VIEW_PATH + "delete_faq.jsp"; }
	 * 
	 * @RequestMapping("/delete_notice.do") public String delete_notice(Model model,
	 * Integer page) { int nowpage = 1; if (page != null) { nowpage = page; } int
	 * start = (nowpage - 1) * Paging.Page.BLOCKLIST + 1; int end = start +
	 * Paging.Page.BLOCKLIST - 1;
	 * 
	 * HashMap<String, Integer> map = new HashMap<String, Integer>();
	 * map.put("start", start); map.put("end", end);
	 * 
	 * List<FaqVO> list = manager_dao.delete_notice_selectlist(map); int row_total =
	 * manager_dao.delete_notice_count(); String paging =
	 * Page.getPaging("delete_notice.do", nowpage, row_total, Paging.Page.BLOCKLIST,
	 * Paging.Page.BLOCKPAGE);
	 * 
	 * model.addAttribute("paging", paging); model.addAttribute("list", list);
	 * return VIEW_PATH + "delete_notice.jsp"; }
	 * 
	 * @RequestMapping("/delete_faq_del.do") public String delete_faq_del(Model
	 * model, int idx, String ctg) throws UnsupportedEncodingException { String
	 * encodedParam = URLEncoder.encode(ctg, "UTF-8");
	 * 
	 * manager_dao.delete_faq_delete(idx); // 삭제 처리!! ( STATUS = -1 )
	 * 
	 * return "redirect:delete_faq.do?ctg=" + encodedParam; }
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("/refundAction.do") public String refundAction(String imp,
	 * int idx) {
	 * 
	 * CancelData cd = new CancelData(imp, true); IamportResponse<Payment> aa =
	 * null;
	 * 
	 * int res = manager_order.refund_state(idx);
	 * 
	 * if (res == 1) {
	 * 
	 * try { aa = import_client.cancelPaymentByImpUid(cd); } catch
	 * (IamportResponseException e) { e.printStackTrace(); } catch (IOException e) {
	 * e.printStackTrace(); } } return String.format("[{'res':'%s'}]",
	 * aa.getMessage()); // return VIEW_PATH + "importRefund.jsp"; }
	 * 
	 * @RequestMapping("/search_on_refund.do") public String search_on_refund(Model
	 * model, String orderCode, String radio, Integer page) { HashMap<String,
	 * Integer> ordercount = manager_order.order_count();
	 * model.addAttribute("count", ordercount);
	 * 
	 * System.out.println("radio : " + radio);
	 * 
	 * int nowPage = 1;
	 * 
	 * if (page != null) { nowPage = page; }
	 * 
	 * // 한 페이지에 표시될 게시물의 시작과 끝 번호를 계산 int start = (nowPage - 1) *
	 * Paging.Page.BLOCKLIST + 1; int end = start + Paging.Page.BLOCKLIST - 1;
	 * 
	 * HashMap<String, Object> map = new HashMap(); map.put("start", start);
	 * map.put("end", end); map.put("orderCode", orderCode); map.put("radio",
	 * radio);
	 * 
	 * // 전체 목록 가져오기 List<OrderInfoVO> list =
	 * manager_order.manager_refund_search(map);
	 * 
	 * System.out.println("list : " + list);
	 * 
	 * // 전체 게시물 수 가져오기 int row_total = manager_order.getRowTotal_search(map);
	 * 
	 * System.out.println("row_total : " + row_total);
	 * 
	 * // 페이지 메뉴 생성하기 String pageMenu = Page.getPaging("search_on_refund.do",
	 * nowPage, row_total, Paging.Page.BLOCKLIST, Paging.Page.BLOCKPAGE);
	 * 
	 * model.addAttribute("list", list); model.addAttribute("pageMenu", pageMenu);
	 * 
	 * return VIEW_PATH + "manager_refund.jsp"; }
	 */
}
