package com.pipt.ctr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pipt.dao.FaqDAO;
import com.pipt.utils.Page;

@Controller
public class CSCenterController {
	
	/*
	 * // dao 요청 bean 작성 필요 FaqDAO faq_dao = new FaqDAO(); public void
	 * setFaq_dao(FaqDAO faq_dao) { this.faq_dao = faq_dao; }
	 * 
	 * // 파일 경로, 이후 수정 가능성 있음 public final String VIEW_PATH =
	 * "/WEB-INF/views/cscenter/";
	 * 
	 * // 고객센터 클릭시 먼저 나오는 맵핑 ★★★★★★★
	 * 
	 * @RequestMapping("/piptServiceInqy1010.do") public String csCenterTop10(Model
	 * model) { List<FaqVO> data_list = faq_dao.viewTop10(); List<FaqVO> list = new
	 * ArrayList<FaqVO>(); for (int i = 0; i < 10; i++) { if(data_list.get(i) !=
	 * null) { list.add(data_list.get(i)); } }
	 * 
	 * model.addAttribute("list",list);
	 * 
	 * String mainText = "자주묻는 질문 TOP 10"; String subText =
	 * "* 고객님들께서 가장 많이 궁금해하시는 사항입니다."; model.addAttribute("mainText", mainText);
	 * model.addAttribute("subText",subText);
	 * 
	 * return VIEW_PATH + "CSCenter.jsp"; }
	 * 
	 * @RequestMapping("/cscenter_notice.do") public String csCenterNotice(Model
	 * model, Integer page) {
	 * 
	 * //paging 처리 int nowPage = 1; if(page != null) { nowPage = page; } int start =
	 * (nowPage - 1) * Paging.Page.BLOCKLIST + 1; int end = start +
	 * Paging.Page.BLOCKLIST - 1;
	 * 
	 * HashMap<String, Integer> map = new HashMap<String, Integer>();
	 * map.put("start", start); map.put("end", end);
	 * 
	 * int row_total = faq_dao.getNoticeTotal();
	 * 
	 * String pageMenu = Page.getPaging("cscenter_notice.do", nowPage, row_total,
	 * Paging.Page.BLOCKLIST, Paging.Page.BLOCKPAGE);
	 * model.addAttribute("pageMenu",pageMenu);
	 * 
	 * List<FaqVO> list = faq_dao.viewNotice(map); model.addAttribute("list",list);
	 * 
	 * String mainText = "공지사항"; String subText = "* 고객 여러분께 유익한 정보를 알려드립니다.";
	 * model.addAttribute("mainText", mainText);
	 * model.addAttribute("subText",subText);
	 * 
	 * return VIEW_PATH + "CSCenterNotice.jsp"; }
	 * 
	 * @RequestMapping("/cscenter_result.do") public String csCenterResult(Model
	 * model, String sc, Integer page) { model.addAttribute("sc",sc);
	 * 
	 * int row_total = faq_dao.getSearchResult(sc);
	 * 
	 * if( row_total == 0 ) { return "redirect:cscenter_notice.do"; }
	 * 
	 * //paging 처리 int nowPage = 1; if(page != null) { nowPage = page; } int start =
	 * (nowPage - 1) * Paging.Page.BLOCKLIST + 1; int end = start +
	 * Paging.Page.BLOCKLIST - 1;
	 * 
	 * HashMap<String, Object> map = new HashMap<String, Object>(); map.put("start",
	 * start); map.put("end", end); map.put("sc", sc);
	 * 
	 * 
	 * // ------------ Paging_CSCenterResult ------------ String pageMenu =
	 * Paging_CSCenterResult.getPaging("cscenter_result.do?sc="+ sc + "&", nowPage,
	 * row_total, Paging.Page.BLOCKLIST, Paging.Page.BLOCKPAGE);
	 * model.addAttribute("pageMenu",pageMenu);
	 * 
	 * 
	 * List<FaqVO> dao_list = faq_dao.getSearch(map); List<FaqVO> list = new
	 * ArrayList<FaqVO>(); for (int i = start-1; i < end-1; i++) { if(i <
	 * dao_list.size()) list.add(dao_list.get(i)); }
	 * 
	 * model.addAttribute("list",list);
	 * 
	 * String mainText = "공지사항"; String subText = "* 고객 여러분께 유익한 정보를 알려드립니다.";
	 * model.addAttribute("mainText", mainText); model.addAttribute("subText",
	 * subText);
	 * 
	 * return VIEW_PATH + "CSCenterNotice.jsp"; }
	 * 
	 * 
	 * @RequestMapping("/cscenter_member.do") public String csCenterMember(Model
	 * model) { List<FaqVO> list = faq_dao.viewMember();
	 * model.addAttribute("list",list);
	 * 
	 * String mainText = "회원 FAQ"; String subText =
	 * "* 답변이 충분하지 않으시다면 1:1 문의를 이용해 주세요."; model.addAttribute("mainText",
	 * mainText); model.addAttribute("subText",subText);
	 * 
	 * return VIEW_PATH + "CSCenter.jsp"; }
	 * 
	 * @RequestMapping("/cscenter_delivery.do") public String csCenterDelivery(Model
	 * model) { List<FaqVO> list = faq_dao.viewDelivery();
	 * model.addAttribute("list",list);
	 * 
	 * String mainText = "배송 FAQ"; String subText =
	 * "* 답변이 충분하지 않으시다면 1:1 문의를 이용해 주세요."; model.addAttribute("mainText",
	 * mainText); model.addAttribute("subText",subText);
	 * 
	 * return VIEW_PATH + "CSCenter.jsp"; }
	 * 
	 * @RequestMapping("/cscenter_order.do") public String csCenterOrder(Model
	 * model) { List<FaqVO> list = faq_dao.viewOrder();
	 * model.addAttribute("list",list);
	 * 
	 * String mainText = "주문 / 결제 FAQ"; String subText =
	 * "* 답변이 충분하지 않으시다면 1:1 문의를 이용해 주세요."; model.addAttribute("mainText",
	 * mainText); model.addAttribute("subText",subText);
	 * 
	 * return VIEW_PATH + "CSCenter.jsp"; }
	 * 
	 * @RequestMapping("/cscenter_refund.do") public String csCenterRefund(Model
	 * model) { List<FaqVO> list = faq_dao.viewRefund();
	 * model.addAttribute("list",list);
	 * 
	 * String mainText = "반품 / 교환 FAQ"; String subText =
	 * "* 답변이 충분하지 않으시다면 1:1 문의를 이용해 주세요."; model.addAttribute("mainText",
	 * mainText); model.addAttribute("subText",subText);
	 * 
	 * return VIEW_PATH + "CSCenter.jsp"; }
	 * 
	 * // TODO // 조회수 증가에 사소한 버그가 있음
	 * 
	 * @RequestMapping("/readhit.do")
	 * 
	 * @ResponseBody public String csCenterReadhit(Model model, int idx) { int res =
	 * faq_dao.updateReadhit(idx); return ""+ res; }
	 */
	
}
