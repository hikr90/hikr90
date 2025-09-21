package com.korea.bbs;

import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Common.Common;
import dao.BoardDao;
import util.Paging;
import vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	HttpServletRequest request;

	BoardDao board_dao;

	public void setBoard_dao(BoardDao board_dao) {
		this.board_dao = board_dao;
	}

	// 목록 조회
	@RequestMapping(value= {"/","/list.do"})
	public String list(Model model, Integer page) {
		/*	Paging
		 * 		관련 변수
		 * 			(1) nowPage
		 * 				- 현재 페이지 넘버, 다른 페이지에서 DML이 진행된 뒤 목록으로 이동하는 경우 보고있던 페이지 넘버를 유지시키기위한 변수
		 * 				- 첫 실행 시에는 NULL값으로 전송되므로 NULL을 체크할 수 있는 Integer 자료형으로 받는다.
		 */
		int nowPage = 1;
		//
		if(page!=null) {
			nowPage = page;
		}
		//
		int start = (nowPage - 1) * Common.Board.BLOCKLIST + 1; 	// 시작 값
		int end = start + Common.Board.BLOCKLIST -1;				// 종료 값
		//
		HashMap<String, Integer> map = new HashMap();
		map.put("start",start);
		map.put("end",end);

		// 목록 조회 쿼리 동작
		List<BoardVO> list = null;
		list = board_dao.selectlist(map);

		// 총 건수 쿼리
		int row_total = board_dao.getRowTotal();

		/*		getPaging
		 *			- 페이지 항목을 구현하는 메소드이다.
		 *			- 메소드를 통해서 페이지 항목을 Html형식으로 생성한 뒤, 결과를 Model에 저장하여 결과를 반환한다.
		 *			
		 *			파라미터
		 *				(1) url : 페이지 이동 시, 동작할 맵핑 주소
		 *				(2) nowPage : 현재 페이지 넘버
		 *				(3) row_total : 목록 전체 수
		 *				(4) blockList : 한페이지에서 보여주고자하는 목록 수
		 *				(5) blockPage : 한페이지에서 보여주고자하는 페이징 넘버 수
		 */
		String pageMenu = Paging.getPaging("list.do", nowPage, row_total, Common.Board.BLOCKLIST, Common.Board.BLOCKPAGE);

		//
		model.addAttribute("list",list);
		model.addAttribute("pageMenu", pageMenu);
		// 조회수 중복 처리 
		request.getSession().removeAttribute("show");
		//
		return Common.Board.VIEW_PATH + "board_list.jsp";
	}

	// 상세 조회
	@RequestMapping("/view.do")
	public String view(Model model, int idx) {
		//
		BoardVO vo = board_dao.selectone(idx);

		/* 조회수 중복 처리
		 * 	- 상세 화면 내에서 새로고침으로 조회수를 증가시키는 것을 막기위한 처리
		 *  
		 *  	동작 순서
		 *  		(1) 상세 화면 접속 시 getSession메소드로 세션 오픈
		 *  		(2) 조회수 증가를 판단하기위한 세션 영역 생성
		 * 			(3) 조회수 세션에 임의의 값 세팅
		 * 			(4) 어떤 방식이든 목록으로 나오는 순간, 세션 제거
		 * 			(5) 상세 화면 접속 시마다 조회수 세션 영역을 체크하여 세션이 있으면 조회수를 증가하지 않고, 없는 경우 조회수를 증가시킨다.
		 * 
		 */
		HttpSession session = request.getSession();
		String show = (String)session.getAttribute("show"); 
		//
		if(show==null) {
			// 조회수 증가
			board_dao.update_readhit(idx);
			// 상세보기 화면으로 이동했으므로 임의 값 추가
			session.setAttribute("show", "hit");
		}
		//
		model.addAttribute("vo",vo);
		return Common.Board.VIEW_PATH + "board_view.jsp"; 
	}

	// 작성 화면 이동
	@RequestMapping("/insert_form.do")
	public String insert_form() {
		//
		return Common.Board.VIEW_PATH + "board_write.jsp";
	}

	// 등록 처리
	@RequestMapping("/insert.do")
	public String insert(BoardVO vo, Model model) {
		// IP 목록 조회
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		// 등록 처리
		int res = board_dao.insert(vo);
		//
		return "redirect:list.do";		

	}

	// 목록 삭제
	@RequestMapping("del.do")
	@ResponseBody 
	public String delete(int idx, String pwd) {
		// 삭제 처리
		BoardVO baseVO = board_dao.selectone(idx, pwd);
		String resultStr = ""; 	// 삭제 처리 결과를 담는 JSON형태의 문자열
		String result = "no";	// 삭제 처리 결과

		// 삭제할 데이터가 존재하지 않는 경우
		if(baseVO==null) {
			// STRING.FORMAT로 문자열 형태 생성
			resultStr = String.format("[{'res':'%s'}]", result);
			return resultStr;
		}

		// 삭제 여부 변경
		baseVO.setSubject("삭제된 게시물입니다.");
		baseVO.setName("unknown");
		//
		int res = board_dao.del_update(baseVO); 

		// 삭제 여부 전송
		if(res==1) {
			result = "yes";
		}
		//
		resultStr = String.format("[{'res':'%s'}]", result);
		return resultStr;
	}

	// 수정 화면 이동
	@RequestMapping("/update_form.do")
	public String update_form(int idx, Model model) {
		//
		BoardVO vo = board_dao.selectone(idx);
		model.addAttribute("vo", vo);
		return Common.Board.VIEW_PATH + "board_update.jsp";
	}

	// 수정 처리
	@RequestMapping("/update.do")
	@ResponseBody
	public String update(int idx, String content, String subject) {
		//
		String ip = request.getRemoteAddr();
		String result = "no";

		// 수정할 데이터 로드
		BoardVO baseVO = board_dao.selectone(idx);
		
		//
		if(baseVO==null) {
			return result;
		}

		// 수정할 데이터 세팅
		BoardVO vo = new BoardVO();
		
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setName(baseVO.getName());
		vo.setPwd(baseVO.getPwd());
		vo.setIp(ip);
		vo.setReadhit(baseVO.getReadhit());
		vo.setIdx(baseVO.getIdx());
		vo.setRef(baseVO.getRef());
		vo.setStep(baseVO.getStep());
		vo.setDepth(baseVO.getDepth());
		vo.setDel_info(baseVO.getDel_info());
		
		// 변경 처리 
		int res = board_dao.update_info(vo);
		//
		if(res==1) {
			result = "yes";
		}
		//
		return result;
	}

	// 댓글 작성 화면 이동
	@RequestMapping("/reply_form.do")
	public String reply_form() {
		//
		return Common.Board.VIEW_PATH + "board_reply.jsp";
	}

	// 댓글 등록 처리
	@RequestMapping("/reply.do")
	public String reply(BoardVO vo, int page) {
		/* 댓글 처리
		 * 	(1) 댓글을 등록하는 원글 정보 조회
		 * 	(2) 원글의 Step 값을 증가
		 * 	(3) 댓글의 정보를 등록
		 */
		BoardVO baseVO = board_dao.selectone(vo.getIdx());
		//
		int res = board_dao.update_step(baseVO);
		//
		vo.setIp(request.getRemoteAddr());
		vo.setRef(baseVO.getRef()); 				// 댓글의 REF는 기준 게시글의 REF로 등록한다.
		vo.setStep(baseVO.getStep()+1); 			// 댓글의 STEP은 기준 게시글보다 하나 높은 STEP값으로 등록한다.
		vo.setDepth(baseVO.getDepth()+1); 			// 댓글의 DEPTH값은 기준 게시글보다 하나 높은 DEPTH값으로 등록한다.
		
		// 댓글 등록 처리
		res = board_dao.reply(vo);
		
		// 댓글 등록 뒤 작업을 진행했던 목록의 페이지로 이동할 수 있도록 파라미터 추가
		return "redirect:list.do?page="+page;
	}
}
