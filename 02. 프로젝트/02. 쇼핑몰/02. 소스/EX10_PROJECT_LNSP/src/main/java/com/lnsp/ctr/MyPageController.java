package com.lnsp.ctr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnsp.comm.Common;
import com.lnsp.dao.MemberDAO;
import com.lnsp.dao.OrderInfoDAO;
import com.lnsp.util.IamportClient;
import com.lnsp.util.Paging_myPage;
import com.lnsp.vo.MemberVO;
import com.lnsp.vo.OrderInfoVO;

@Controller
public class MyPageController {
	public static final String VIEW_PATH = "/WEB-INF/views/front/";
	// 작성자 : 유영일
	// 마이페이지 전 기능
	@Autowired
	HttpServletRequest request;

	OrderInfoDAO orderinfo_dao;

	MemberDAO member_dao;
	IamportClient import_client;

	public void setImport_client(IamportClient import_client) {
		this.import_client = import_client;
	}

	public void setOrderinfo_dao(OrderInfoDAO orderinfo_dao) {
		this.orderinfo_dao = orderinfo_dao;
	}

	public void setMember_dao(MemberDAO member_dao) {
		this.member_dao = member_dao;
	}

	// 마이 페이지로 이동
	@RequestMapping("/mypage.do")
	public String order_list(Model model, Integer page) {

		int idx = ((MemberVO) (request.getSession().getAttribute("user"))).getIdx();

		int nowPage = 1;

		if (page != null) {
			nowPage = page;
		}

		// 한 페이지에 표시될 게시물의 시작과 끝 번호를 계산
		int start = (nowPage - 1) * Common.MyPage.BLOCKLIST + 1;
		int end = start + Common.MyPage.BLOCKLIST - 1;

		HashMap<String, Integer> map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("idx", idx);

		// 전체 목록 가져오기
		List<OrderInfoVO> list = orderinfo_dao.order_list(map);

		// 전체 게시물 수 가져오기
		int row_total = orderinfo_dao.getRowTotal(idx);

		// 페이지 메뉴 생성하기
		String pageMenu = Paging_myPage.getPaging("mypage.do", nowPage, row_total, Common.MyPage.BLOCKLIST,
				Common.MyPage.BLOCKPAGE);

		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);

		return VIEW_PATH + "mypage.jsp";
	}

	// 환불/변경할 제품 목록 조회
	@RequestMapping("/refund.do")
	public String refund_list(Model model, Integer page) {

		int idx = ((MemberVO) (request.getSession().getAttribute("user"))).getIdx();

		int nowPage = 1;

		if (page != null) {
			nowPage = page;
		}

		// 한 페이지에 표시될 게시물의 시작과 끝 번호를 계산
		int start = (nowPage - 1) * Common.MyPage.BLOCKLIST + 1;
		int end = start + Common.MyPage.BLOCKLIST - 1;

		HashMap<String, Integer> map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("idx", idx);

		// 전체 목록 가져오기
		List<OrderInfoVO> list = orderinfo_dao.order_list(map);

		// 전체 게시물 수 가져오기
		int row_total = orderinfo_dao.getRowTotal(idx);

		// 페이지 메뉴 생성하기
		String pageMenu = Paging_myPage.getPaging("mypage.do", nowPage, row_total, Common.MyPage.BLOCKLIST,
				Common.MyPage.BLOCKPAGE);

		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);

		return VIEW_PATH + "refund.jsp";
	}

	// 환불/변경할 제품 선택 후 환불계좌 입력 페이지 조회
	@RequestMapping("/refundOk.do")
	public String refundOk(Model model, int idx) {

		OrderInfoVO vo = orderinfo_dao.refundOk(idx);

		model.addAttribute("vo", vo);

		return VIEW_PATH + "refundOk.jsp";
	}

	@RequestMapping("/changeOk.do")
	public String changeOk(Model model, int idx) {

		OrderInfoVO vo = orderinfo_dao.refundOk(idx);

		model.addAttribute("vo", vo);

		return VIEW_PATH + "changeOk.jsp";
	}

	@RequestMapping("/pwd_check.do")
	public String pwd_check(Model model) {

		int idx = ((MemberVO) (request.getSession().getAttribute("user"))).getIdx();

		MemberVO vo = member_dao.pwd_check(idx);

		model.addAttribute("vo", vo);

		return VIEW_PATH + "pwdCk_modal.jsp";
	}

	@RequestMapping("/updateMember_form.do")
	public String updateMember_form(Model model) {

		int idx = ((MemberVO) (request.getSession().getAttribute("user"))).getIdx();

		MemberVO vo = member_dao.select_memberInfo(idx);

		model.addAttribute("vo", vo);

		return VIEW_PATH + "updateMember.jsp";

	}

	@RequestMapping("/update_memberInfo.do")
	public String update_memberInfo(MemberVO vo) {

		int idx = ((MemberVO) (request.getSession().getAttribute("user"))).getIdx();

		String hp1 = request.getParameter("hp1");
		String hp2 = request.getParameter("hp2");
		String hp3 = request.getParameter("hp3");

		String m_phone = hp1 + "-" + hp2 + "-" + hp3;

		String zipcode = request.getParameter("zipcode");
		String addr = request.getParameter("addr");
		String address = request.getParameter("address");

		String m_addr = zipcode + " " + addr + " " + address;

		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");

		String m_email = email1 + "@" + email2;

		vo.setIdx(idx);
		vo.setM_phone(m_phone);
		vo.setM_addr(m_addr);
		vo.setM_email(m_email);

		member_dao.update_memberInfo(vo);

		return "redirect:mypage.do";
	}

	@RequestMapping("/refund_check.do")
	public String refund_check(HttpServletResponse response, int idx) throws IOException {

		int res = orderinfo_dao.refund_check(idx);

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		if (res == 1) {

			out.println("<script>alert('환불 신청 성공!');</script>");

			out.flush();
		} else {

			out.println("<script>alert('환불 신청 실패!'); </script>");

			out.flush();
		}

		return "forward:refund.do";
	}

	// 회원 탈퇴
	@RequestMapping("/mypage_leave.do")
	public String mypage_leave() {

		return VIEW_PATH + "leave.jsp";
	}

	// 회원 탈퇴
	@RequestMapping("/mypage_leave_action.do")
	@ResponseBody
	public String mypage_leave_action(Model model, String id, String pwd, String tel1, String tel2, String tel3) {

		MemberVO member_vo = (MemberVO) (request.getSession().getAttribute("user"));

		String tel_num = tel1 + "-" + tel2 + "-" + tel3;

		boolean res = true;
		if (!member_vo.getM_id().equalsIgnoreCase(id)) {
			res = false;
		}
		if (!member_vo.getM_pwd().equalsIgnoreCase(pwd)) {
			res = false;
		}
		if (!member_vo.getM_tell().equalsIgnoreCase(tel_num)) {
			res = false;
		}

		String result = "no";
		String resStr = "";
		// HashMap<String, String> map = new HashMap<String, String>();
		if (res) {

			result = "yes";
			resStr = String.format("[{'result':'%s'}]", result);
			member_dao.setstatus_member(member_vo); // 회원 삭제

			HttpSession session = request.getSession();
			session.removeAttribute("user");

		} else {
			resStr = String.format("[{'result':'%s'}]", result);

		}

		return resStr;

	}
}
