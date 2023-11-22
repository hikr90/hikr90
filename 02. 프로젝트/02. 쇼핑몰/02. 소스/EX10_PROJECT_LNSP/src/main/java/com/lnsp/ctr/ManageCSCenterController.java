package com.lnsp.ctr;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnsp.dao.ManageCSCenterDAO;
import com.lnsp.vo.FaqVO;

import util.ClientUtils;

@Controller
public class ManageCSCenterController {
	
	// 경로
	public final String VIEW_PATH = "/WEB-INF/views/manager/";
	
	// dao
	ManageCSCenterDAO managecscenter_dao = null;
	public void setManagecscenter_dao(ManageCSCenterDAO managecscenter_dao) {
		this.managecscenter_dao = managecscenter_dao;
	}
	
	// faq 글 수정 
	@RequestMapping("/change_faq.do")
	public String change_faq(Model model, int idx, String ctg) {
		FaqVO vo = managecscenter_dao.faq_selectone(idx);
		model.addAttribute("vo",vo);
		model.addAttribute("ctg",ctg);
		return VIEW_PATH + "change_faq.jsp";
	}
	
	@RequestMapping("/cscenter_change_action.do")
	public String cscenter_change_action(Model model, FaqVO vo) throws UnsupportedEncodingException {
		
		// 개시글 갱신
		managecscenter_dao.faq_update(vo);
		
		
		// 맵핑 설정
		String loc = "delete_faq.do";
		
		String param = vo.getCategory();
		
		// 이부분은 내가 DB와 jsp를 제대로 준비하지 못해서 생긴 문장들 : 박세환
		if(param.equals("공지")) {
			loc = "delete_notice.do";
			param = "";
		}else if(param.equals("주문/결제")) {
			param = "주문 / 결제 FAQ";
		}else if(param.equals("반품/교환")) {
			param = "반품 / 교환 FAQ";
		}else if(param.equals("배송")) {
			param = "배송 FAQ";
		}else if(param.equals("회원")) {
			param = "회원 FAQ";
		}
		
		// redirect: 하기전에 파라미터 인코딩
		String encodedParam = "";
		if(!param.equals("")) {
			encodedParam = URLEncoder.encode(param, "UTF-8");
		}
		
		return "redirect:" + loc + "?ctg=" + encodedParam;
	}
	
	// faq 글 추가
	@RequestMapping("/insert_faq.do")
	public String insert_faq() {
		
		return VIEW_PATH + "insert_faq.jsp";
	}
	
	@RequestMapping("/cscenter_insert_action.do")
	public String cscenter_insert_action(Model model, FaqVO vo, HttpServletRequest request) throws UnsupportedEncodingException {
		// ip 확인
		String ip = ClientUtils.getIp(request);
		vo.setIp(ip);
		
		// 개시글 추가
		managecscenter_dao.faq_insert(vo);
		
		// 이부분은 내가 DB와 jsp를 제대로 준비하지 못해서 생긴 문장들 : 박세환
		String param = vo.getCategory();
		String loc = "delete_faq.do";
		
		if(param.equals("공지")) {
			loc = "delete_notice.do";
			param = "";
		}else if(param.equals("주문/결제")) {
			param = "주문 / 결제 FAQ";
		}else if(param.equals("반품/교환")) {
			param = "반품 / 교환 FAQ";
		}else if(param.equals("배송")) {
			param = "배송 FAQ";
		}else if(param.equals("회원")) {
			param = "회원 FAQ";
		}
		
		// redirect: 하기전에 파라미터 인코딩
		String encodedParam = "";
		if(!param.equals("")) {
			encodedParam = URLEncoder.encode(param, "UTF-8");
		}
		
		return "redirect:" + loc + "?ctg=" + encodedParam;
	}
}
