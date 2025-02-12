package com.intr.ctr;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.dao.AprvDao;
import com.intr.dao.BoardDao;
import com.intr.svc.AprvService;
import com.intr.svc.AuthService;
import com.intr.svc.BoardService;
import com.intr.svc.CoreService;
import com.intr.svc.MainService;
import com.intr.svc.EmpService;
import com.intr.svc.TempService;
import com.intr.svc.UtilService;
import com.intr.utils.Jsp;
import com.intr.utils.Path;
import com.intr.vo.EmpVO;

@Controller
public class MainController {
	//
	@Autowired
	CoreService coreService;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	EmpService empService;

	@Autowired
	AprvService aprvService;

	@Autowired
	TempService tempService;

	@Autowired
	AuthService authService;
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	AprvDao aprvDao;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	HttpSession session;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 로그인 화면 조회
	@RequestMapping(value={"/","/intrMainInqy1010.do"})
	public String intrMainInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 로그인 권한 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 로그인 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_LOGIN + Jsp.INTR_LOGIN_INQY_1010;
	}

	// 사용자 메인 조회
	@RequestMapping("/intrMainInqy1020.do")
	public String intrCoreInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			// EMP_IDX 저장
			EmpVO emp = (EmpVO)session.getAttribute("empVO");
			paramMap.put("empIdx", emp.getEmpIdx());
			
			//--------------------------------------------------------------------------------------------
			// 메뉴 세션 저장
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1030("0");
			
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 공지사항 조회
			//--------------------------------------------------------------------------------------------
			defaultList = boardDao.intrBoardInqy1011(model, paramMap);
			model.addAttribute("boardList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// 나의 기안 목록
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy1031(model, paramMap);
			model.addAttribute("aprvReqList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// 나의 결재 목록
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy1041(model, paramMap);
			model.addAttribute("aprvRecList",defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 사용자 메인 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_MAIN + Jsp.INTR_MAIN_INQY_1010;
	}

	// 관리자 메인 조회
	@RequestMapping("/intrMainInqy1030.do")
	public String intrMainInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 세션 저장
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1030("1");

			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 부서 사원 수 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy2040(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 템플릿 목록 조회
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy1030(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy4010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 메인 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_MAIN + Jsp.INTR_MAIN_INQY_2010;
	}
	
	// 마이페이지 조회
	@RequestMapping("/intrMainInqy1040.do")
	public String intrMainInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 세션 저장
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1030((String)paramMap.get("menuType"));
			
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 사원 상세 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 마이페이지 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_MYPAGE + Jsp.INTR_MYPAGE_INQY_1010;
	}
	
	// 로그인 처리
	@RequestMapping("/intrMainProc1010.do")
	@ResponseBody
	public String intrMainProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 로그인 처리
			//-------------------------------------------------------------------------------------------
			defaultStr = mainService.intrMainProc1010(model, paramMap);	
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 로그인 처리 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return defaultStr;
	}
	
	// 로그아웃 처리
	@RequestMapping("/intrMainProc1020.do")
	public String intrMainProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 세션 제거
			//--------------------------------------------------------------------------------------------
			if(session.getAttribute("empVO")!=null) {
				session.removeAttribute("empVO");
			}
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 로그아웃 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return "redirect:/";

	}
}
