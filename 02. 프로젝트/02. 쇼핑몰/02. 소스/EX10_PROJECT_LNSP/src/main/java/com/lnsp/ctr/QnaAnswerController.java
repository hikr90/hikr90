package com.lnsp.ctr;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.lnsp.dao.QnaAnswerDAO;
import com.lnsp.dao.QnaDAO;
import com.lnsp.vo.AnswerVO;
import com.lnsp.vo.MemberVO;
import com.lnsp.vo.QnaAnswerVO;

import util.Paging;

@Controller
public class QnaAnswerController {

	public static final String VIEW_PATH = "/WEB-INF/views/manager/";
	
	QnaDAO qna_dao;
	QnaAnswerDAO qnaAnswer_dao;
	

	@Autowired
	HttpServletRequest request;
	
	public void setQna_dao(QnaDAO qna_dao) {
		this.qna_dao = qna_dao;
	}
	
	public void setQnaAnswer_dao(QnaAnswerDAO qnaAnswer_dao) {
		this.qnaAnswer_dao = qnaAnswer_dao;
	}
	
	//1대1문의 리스트
	@RequestMapping("/manager_1to1QNA.do")
	public String qnaOneAnawerList( Model model, Integer page) {
	
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
		
		List<AnswerVO> list = null;	
		//전체목록
		list = qnaAnswer_dao.qnaOneAnswerList(map);
		
		//전체 게시물 수 가져오기
		int row_total = qnaAnswer_dao.qnaOneAnswerTotal();
		
		//페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging(
					"manager_1to1QNA.do", 
					nowPage, 
					row_total, 
					Common.Notice.BLOCKLIST, 
					Common.Notice.BLOCKPAGE);
		
		Map<String, Object> Partcount = qnaAnswer_dao.qnaOneAnswerCount();
		
		int total = qna_dao.qnaOneTotal();
		
		model.addAttribute("total", total);

		model.addAttribute("count", Partcount);
		model.addAttribute("row_total", row_total);
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);

		return VIEW_PATH + "manager_1to1.jsp";
		
	}
	
	@RequestMapping("/manager_1to1part.do")
	public String qnaoneAnswerPartList( int count, Model model, Integer page ) {
		

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
		map.put("count", count);
		
		List<AnswerVO> list = null;	
		//전체목록
		list = qnaAnswer_dao.qnaOneAnswerPartList(map);
		
		//전체 게시물 수 가져오기
		int row_total = qnaAnswer_dao.qnaOneAnswerPartTotal( count );
		
		//페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging(
					"manager_1to1QNA.do", 
					nowPage, 
					row_total, 
					Common.Notice.BLOCKLIST, 
					Common.Notice.BLOCKPAGE);
		
		
		Map<String, Object> Partcount = qnaAnswer_dao.qnaOneAnswerPartCount( count );
		int total = qna_dao.qnaOneTotal();
		
		model.addAttribute("total", total);
		model.addAttribute("count", Partcount);
		model.addAttribute("row_total", row_total);
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return VIEW_PATH + "manager_1to1.jsp";
	}
	
	
	@RequestMapping("/manager_1to1condition.do")
	public String qnaoneAnswerconditionList( int count, Model model, Integer page ) {
		

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
		map.put("count", count);
		
		List<AnswerVO> list = null;	
		//전체목록
		int row_total = 0;
		
		if( count == 1) {
			list = qnaAnswer_dao.qnaOneAnswerWaitList(map);
			
			//전체 게시물 수 가져오기
			row_total = qnaAnswer_dao.qnaOneAnswerWaitTotal( count );
		
		}else if (count == 2) {
			
			list = qnaAnswer_dao.qnaOneAnswerCompleteList(map);
			
			//전체 게시물 수 가져오기
			row_total = qnaAnswer_dao.qnaOneAnswerCompleteTotal( count );
			
		}else if( count == 3) {
			
			list = qnaAnswer_dao.qnaOneAnswerDeleteList(map);
			
			//전체 게시물 수 가져오기
			row_total = qnaAnswer_dao.qnaOneAnswerDeleteTotal( count );
			
		}else {
			list = qnaAnswer_dao.qnaOneAnswerList(map);
			
			//전체 게시물 수 가져오기
			row_total = qnaAnswer_dao.qnaOneAnswerTotal();
			
		}
		
		//페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging(
					"manager_1to1QNA.do", 
					nowPage, 
					row_total, 
					Common.Notice.BLOCKLIST, 
					Common.Notice.BLOCKPAGE);
		

		Map<String, Object> Partcount = qnaAnswer_dao.qnaOneAnswerCount();
		
		int total = qna_dao.qnaOneTotal();
		
		model.addAttribute("total", total);
		model.addAttribute("count", Partcount);
		model.addAttribute("row_total", row_total);
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return VIEW_PATH + "manager_1to1.jsp";
	}
	
	
	@RequestMapping("/manager_1to1QNAanswer.do")
	public String qnaoneAnswerForm( int idx, Model model ) {
		
		AnswerVO vo = qnaAnswer_dao.qnaOneAnswerForm(idx);
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy / MM / dd");
		String time = sdf.format(cal.getTime());

		model.addAttribute("vo", vo);
		model.addAttribute("time", time);
		
		return VIEW_PATH + "manager_1to1answer.jsp";
	}
	
	@RequestMapping("/manager_1to1QNAinsert.do")
	public String qnaOneInsert( QnaAnswerVO vo, Integer page ) {
		
		int res = qnaAnswer_dao.qnaOneInsert(vo);
		int ynres = qna_dao.qnaOneYSupdate(vo.getQna_idx());
		
		System.out.println( "res" + res + " / ynres"+ ynres);
		
		return "redirect:manager_1to1QNA.do?page="+page;
		
	}
	
	//1대1문의 결과 들어갔을때 보여주는 뷰
	@RequestMapping("/qnaoneanswerview.do")
	public String qnaoneanswer(Model model, int q_idx) {
		
		AnswerVO vo = qna_dao.qnaOneAnswerView(q_idx);
		model.addAttribute("vo", vo);
		
		QnaAnswerVO qavo = qnaAnswer_dao.qnaOneManagerAnswerView(q_idx);
		model.addAttribute("qavo", qavo);
		
		return "/WEB-INF/views/front/1to1QNAanswer.jsp";
	}
	
	
	
	@RequestMapping("/manager_itemQNA.do")
	public String qnaProdAnawerList( Model model, Integer page) {

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
		
		List<AnswerVO> list = null;	
		//전체목록
		list = qnaAnswer_dao.qnaProdAnswerList(map);
		
		//전체 게시물 수 가져오기
		int row_total = qnaAnswer_dao.qnaProdAnswerTotal();
		
		//페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging(
					"manager_itemQNA.do", 
					nowPage, 
					row_total, 
					Common.Notice.BLOCKLIST, 
					Common.Notice.BLOCKPAGE);
		
		Map<String, Object> count = qnaAnswer_dao.qnaProdAnswerCount();

		model.addAttribute("count", count);
		model.addAttribute("row_total", row_total);
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);

		return VIEW_PATH + "manager_itemQNA.jsp";
		
	}
	
	@RequestMapping("/manager_itemQNAanswer.do")
	public String qnaprodAnswerForm( int idx, Model model ) {
		
		AnswerVO vo = qnaAnswer_dao.qnaProdAnswerForm(idx);
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy / MM / dd");
		String time = sdf.format(cal.getTime());

		model.addAttribute("vo", vo);
		model.addAttribute("time", time);
		
		return VIEW_PATH + "manager_itemQNAanswer.jsp";
	}
	
	@RequestMapping("/manager_itemQNAinsert.do")
	public String qnaProdInsert( QnaAnswerVO vo, Integer page ) {
		
		int res = qnaAnswer_dao.qnaProdInsert(vo);
		int ynres = qna_dao.qnaProdYSupdate(vo.getQna_idx());
		
		System.out.println( "res" + res + " / ynres"+ ynres);
		
		return "redirect:manager_itemQNA.do?page="+page;
		
	}
	

	@RequestMapping("/qnaprodanswerview.do")
	public String qnaprodanswer(Model model, int q_idx) {
		
		AnswerVO vo = qna_dao.qnaprodAnswerView(q_idx);
		model.addAttribute("vo", vo);
		QnaAnswerVO qavo = qnaAnswer_dao.qnaProdManagerAnswerView(q_idx);
		model.addAttribute("qavo", qavo);
		
		return "/WEB-INF/views/front/itemQNAanswer.jsp";
	}
	
	@RequestMapping("/qnaOneanswerInManagerview.do")
	public String qnaprodanswerInManager(Model model, int q_idx) {
		
		AnswerVO vo = qna_dao.qnaOneAnswerView(q_idx);
		model.addAttribute("vo", vo);
		QnaAnswerVO qavo = qnaAnswer_dao.qnaProdManagerAnswerView(q_idx);
		model.addAttribute("qavo", qavo);
		
		return "/WEB-INF/views/front/1to1QNAanswerInManager.jsp";
	}
	
	
	
	
	@RequestMapping("/qnaprodanswerInGoodsview.do")
	public String qnaprodanswerInGoods(Model model, int q_idx) {
		
		AnswerVO vo = qna_dao.qnaprodAnswerView(q_idx);
		model.addAttribute("vo", vo);
		QnaAnswerVO qavo = qnaAnswer_dao.qnaProdManagerAnswerView(q_idx);
		model.addAttribute("qavo", qavo);
		
		return "/WEB-INF/views/front/itemQNAanswerInGoods.jsp";
	}
	
	
	@RequestMapping("/qna1to1delete.do")
	public String qnaOneDelete( int idx, Integer page ) {
		
		int delres = qna_dao.qnaOnedelete(idx);
		
		return "redirect:manager_1to1QNA.do?page="+page;
	}
	
	@RequestMapping("/qnaitemdelete.do")
	public String qnaProdDelete( int idx, Integer page ) {
		
		System.out.println(idx +"/"+ page);
		int delres = qna_dao.qnaProddelete(idx);
		
		return "redirect:manager_itemQNA.do?page="+page;
	}
	
}



















