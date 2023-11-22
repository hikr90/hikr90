package com.lnsp.ctr;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnsp.comm.Common;
import com.lnsp.dao.QnaDAO;
import com.lnsp.vo.AnswerVO;
import com.lnsp.vo.MemberVO;

import util.Paging;

@Controller
public class QnaController {

	public static final String VIEW_PATH = "/WEB-INF/views/front/";
	
	QnaDAO qna_dao;
	

	@Autowired
	HttpServletRequest request;
	
	public void setQna_dao(QnaDAO qna_dao) {
		this.qna_dao = qna_dao;
	}
	
	//1대1문의 리스트
	@RequestMapping("/qnaonelist.do")
	public String qnaOneList( Model model, Integer page) {
							
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		//클래스가 넘어오면 인식을 못하게 만드는것
		int nowPage = 1;
		//list.do?page=1
		
		if( page != null) {
		nowPage = page;
		}
		
		//한 페이지에 표시되는 게시물의 시작과 끝 번호를 계산
		int start = (nowPage - 1) * Common.Notice.BLOCKLIST + 1;
		int end = start + Common.Notice.BLOCKLIST - 1;
		
		HashMap<String, Object > map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("idx", user.getIdx());
		
		List<AnswerVO> list = null;	
		//전체목록
		list = qna_dao.qnaOneList(map);
		
		//전체 게시물 수 가져오기
		int row_total = qna_dao.qnaOneTotal(user.getIdx());
		
		//페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging(
					"qnaonelist.do", 
					nowPage, 
					row_total, 
					Common.Notice.BLOCKLIST, 
					Common.Notice.BLOCKPAGE);
		
		model.addAttribute("row_total", row_total);
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);

		return VIEW_PATH + "1to1QNA.jsp";
		
	}
	
	//1대1문의 form
	@RequestMapping("/qnaoneform.do")
	public String qnaformAction(Model model ) {
		
		/*
		 * QnaVO vo = qna_dao.qnaOneFormList(); model.addAttribute("vo", vo);
		 */
		
		return VIEW_PATH + "1to1QNAform.jsp";
	}
	
	//1대1문의 insert
	@RequestMapping("/qnaoneinsert.do")
	public String qnaOneInsert(AnswerVO vo, int idx) {
		
		vo.setQ_ip(request.getRemoteAddr());
		vo.setMember_idx(idx);
		int res = qna_dao.qnaOneInsert( vo );
		
		return "redirect:qnaonelist.do";
		
	}
	
	/*
	 * //1대1문의 결과 들어갔을때 보여주는 뷰
	 * 
	 * @RequestMapping("/qnaoneanswerview.do") public String qnaoneanswer(Model
	 * model, int q_idx) {
	 * 
	 * QnaVO vo = qna_dao.qnaOneAnswerView(q_idx); model.addAttribute("vo", vo);
	 * 
	 * 
	 * return VIEW_PATH + "1to1QNAanswer.jsp"; }
	 */
	
	
	//상품문의 리스트
	@RequestMapping("/qnaprodlist.do")
	public String qnaprodList( Model model, Integer page) {
		
				
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		//클래스가 넘어오면 인식을 못하게 만드는것
		int nowPage = 1;
		//list.do?page=1
		
		if( page != null) {
		nowPage = page;
		}
		
		//한 페이지에 표시되는 게시물의 시작과 끝 번호를 계산
		int start = (nowPage - 1) * Common.Notice.BLOCKLIST + 1;
		int end = start + Common.Notice.BLOCKLIST - 1;
		
		HashMap<String, Object > map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("idx", user.getIdx());
		
		List<AnswerVO> list = null;	
		//전체목록
		list = qna_dao.qnaProdList(map);
		
		//전체 게시물 수 가져오기
		int row_total = qna_dao.qnaProdTotal(user.getIdx());
		
		//페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging(
				"qnaprodlist.do", 
				nowPage, 
				row_total, 
				Common.Notice.BLOCKLIST, 
				Common.Notice.BLOCKPAGE);
		
		model.addAttribute("row_total", row_total);
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
				
		return VIEW_PATH + "itemQNA.jsp";
		
	}
	
	@RequestMapping("/qnaprodform.do")
	public String qnaprodForm( AnswerVO paramvo, Model model) {
		
		AnswerVO vo = qna_dao.qnaprodForm(paramvo);
		model.addAttribute("vo", vo);
		
		return VIEW_PATH + "itemQNAform.jsp";
	}
	
	@RequestMapping("/qnaprodinsert.do")
	@ResponseBody
	public String qnaProdInsert( AnswerVO vo) {
		
		vo.setQ_ip(request.getRemoteAddr());
		int res = qna_dao.qnaProdInsert(vo);
		
		String result = "no";
		if( res == 1) {
			result = "yes";
		}
		
		//ajax의 결과를 돌려줘야함
		return result;
		
	}
	
	
	
}
