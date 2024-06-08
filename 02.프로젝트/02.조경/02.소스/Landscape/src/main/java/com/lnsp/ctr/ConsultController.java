package com.lnsp.ctr;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnsp.dao.ConsultDAO;
import com.lnsp.vo.MemberVO;

@Controller
public class ConsultController {
	
	@Autowired
	HttpServletRequest request;
	
	/*
	 * // consult_dao : BEAN ConsultDAO consult_dao = null; public void
	 * setConsult_dao(ConsultDAO consult_dao) { this.consult_dao = consult_dao; }
	 * 
	 * // jsp 파일 경로 public final String VIEW_PATH = "/WEB-INF/views/consult/";
	 * 
	 * @RequestMapping("/consult.do") public String consult(Model model) { return
	 * VIEW_PATH + "consult.jsp"; }
	 * 
	 * 
	 * @RequestMapping("/consultOk.do") public String consultOk(Model model, String
	 * radio1, String radio2, String radio3, String radio4, String address1, String
	 * address2, String address3, String address4) {
	 * 
	 * HttpSession session = request.getSession();
	 * 
	 * MemberVO user_vo = null; user_vo = (MemberVO)(session.getAttribute("user"));
	 * 
	 * EstimateVO vo = new EstimateVO(); vo.setM_num(user_vo.getIdx());
	 * vo.setEst_type(radio1); vo.setEst_place(radio2); vo.setEst_price(radio3);
	 * vo.setEst_day(radio4); String add = address1 + " " + address2 ;
	 * vo.setEst_region(add); System.out.println(address3);
	 * vo.setEst_space(address3); vo.setEst_memo(address4);
	 * 
	 * // 견적 추가 consult_dao.insert_consult(vo);
	 * 
	 * // 견적 총 정리 불러오기 EstimateVO res_vo = consult_dao.selectone_consult(vo);
	 * 
	 * model.addAttribute("vo",res_vo);
	 * 
	 * return VIEW_PATH + "consultOk.jsp"; }
	 */
	
}
