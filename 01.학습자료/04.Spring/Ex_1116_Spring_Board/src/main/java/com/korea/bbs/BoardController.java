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
import dao.BoardDAO;
import util.Paging;
import vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	HttpServletRequest request;

	BoardDAO board_dao;

	public void setBoard_dao(BoardDAO board_dao) {
		this.board_dao = board_dao;
	}

	// 목록 조회
	@RequestMapping(value= {"/","/list.do"})
	public String list(Model model, Integer page) {
		/*	PAGING 
		 		# 1 관련 변수
		 			NOWPAGE
		 				- 현재 페이지 넘버, 다른 페이지에서 DML이 진행된 뒤 목록으로 이동하는 경우 보고있던 페이지 넘버를 유지시키기위한 변수
		 				- INT타입으로 지정하는 경우 해당 값이 NULL인지를 체크할 수 없으므로 INTEGER 자료형으로 받아줘야한다.
		 				- 페이지의 첫 동작에서는 NULL이므로 자동으로 1 페이지를 띄우며 특정 페이지의 넘버값이 있다면 다른 페이지에서 PAGE의 넘버값을 받아 NOWPAGE에 대입하여 사용한다.
		*/
		
		// NOWPAGE 값 생성
		int nowPage = 1;
		// NOWPAGE가 NULL이 아닌 경우, PAGE값으로 이동
		if(page!=null) {
			nowPage = page;
		}

		/*		# 2 페이징 처리 공식
		 			- 한 페이지에 표시될 게시물의 시작과 마지막 번호 계산
		 			- 시작과 마지막 번호를 HASHMAP에 담아 목록 조회 쿼리로 전송
		*/
		int start = (nowPage - 1) * Common.Board.BLOCKLIST + 1; 
		int end = start + Common.Board.BLOCKLIST -1;
		//
		HashMap<String, Integer> map = new HashMap();
		map.put("start",start);
		map.put("end",end);

		// 목록 조회 쿼리 동작
		List<BoardVO> list = null;
		list = board_dao.selectlist(map);

		/*		# 3 페이징 목록 구현을 위한 전체 행 수 파악 쿼리 
		 			- 전체 행의 수는 GETPAGING메소드의 파라미터로 사용된다.
		*/
		int row_total = board_dao.getRowTotal();

		/*		# 4 페이징 구현
		 			- GETPAGING메소드는 페이지 메뉴를 구현하는 메소드이다.
		 			
		 			## 파라미터
		 				### 1 페이징 이동 시, 다시 재동작할 맵핑 주소 (.DO URL)
		 				### 2 NOWPAGE (현재 페이지 넘버)
		 				### 3 ROW_TOTAL (목록 전체 숫자)
		 				### 4 한 페이지에서 보여주고자하는 목록 수 (BLOCKLIST)
		 				### 5 한 페이치에서 보여주고자하는 메뉴의 수 (BLOCKPAGE)
		 				
		 			이 메소드는 HTML의 태그로 목록을 구현한 뒤 HTML의 형식으로 결과를 반환한다.
		*/
		String pageMenu = Paging.getPaging("list.do", nowPage, row_total, Common.Board.BLOCKLIST, Common.Board.BLOCKPAGE);

		// FOWARDING
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

		// 특정한 목록을 조회하는 기준값(IDX)으로 조회하는 메소드
		BoardVO vo = board_dao.selectone(idx);

		/* 조회수 중복 처리
		 		- 사용자가 한 페이지에서 새로고침 혹은 인터넷등의 오류로 조회수를 증가시키는 것을 막기위한 처리
		 		
	 		# 1 GETSESSION메소드로 세션 객체 생성
	 		# 2 조회수 증가를 판단하기위한 세션 영역(SHOW) 생성
		*/
		HttpSession session = request.getSession();
		String show = (String)session.getAttribute("show"); 

		/* 		
	 		# 3 상세보기로 목록을 조회한 경우 세션에 임의 값 (HIT) 추가
	 			- 목록으로 이동하지 않았으므로 SHOW영역의 HIT값은 그대로 존재할 것이기에 아래의 IF문에 진입하지 않으므로 조회수 증가 작업이 진행되지 않는다.

	 		# 4 목록으로 나오는 경우 SHOW 영역 제거 (LIST.DO의 90번 라인 참고)
		 */
		if(show==null) {
			// 조회수 증가
			board_dao.update_readhit(idx);
			// 상세보기 화면으로 이동했으므로 임의값 (HIT) 추가
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

		// 
		/*	삭제 처리
		 		- 현업에서 데이터는 매우 중요하므로 사용여부를 판단하는 컬럼을 N값으로 변경하는 등
		 		- 목록을 보여주지 않는 방식으로 삭제 처리를 진행한다.
		*/
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

		// 수정할 데이터 지정 (화면상의 변경 값만 변경한다면 굳이 불러오지 않아도 상관없다.)
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
		/* 댓글 등록 처리 
		 		# 1 댓글을 등록하는 항목 정보 조회
				SELECTONE을 통해서 답글을 등록하는 최상위 게시글의 정보 로드
				REF, STEP, DEPTH의 정보를 알아낸 뒤, 해당 게시글의 STEP을 증가시킨 뒤, 댓글의 정보를 등록
		*/
		BoardVO baseVO = board_dao.selectone(vo.getIdx());
		
		/*		# 2 STEP, REF, DEPTH 값 처리 
		 			- STEP값 증가
		 			- VO 객체에 관련 값 저장
		*/
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
