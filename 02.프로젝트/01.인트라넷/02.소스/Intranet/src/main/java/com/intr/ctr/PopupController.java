package com.intr.ctr;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intr.dao.AuthDao;
import com.intr.dao.EmpDao;
import com.intr.dao.ProjDao;
import com.intr.dao.UtilDao;
import com.intr.svc.AprvService;
import com.intr.svc.AuthService;
import com.intr.svc.MainService;
import com.intr.svc.ProjService;
import com.intr.svc.TempService;
import com.intr.svc.EmpService;
import com.intr.svc.UtilService;
import com.intr.utils.Const;

@Controller
public class PopupController {
	//
	@Autowired
	MainService mainService;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	EmpService empService;
	
	@Autowired
	AuthService authService;
	
	@Autowired
	TempService tempService;
	
	@Autowired
	AprvService aprvService;
	
	@Autowired
	ProjService projService;
	
	@Autowired
	AuthDao authDao;
	
	@Autowired
	UtilDao utilDao;
	
	@Autowired
	EmpDao empDao;
	
	@Autowired
	ProjDao projDao;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// 담당자 조회
	@RequestMapping("/intrPopupInqy1010.do")
	public String intrPopupInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 담당자 조회
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy3011(model, paramMap);
			model.addAttribute("empList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 담당자 팝업 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1011;
	}

	// 아이디 찾기 팝업 조회
	@RequestMapping("/intrPopupInqy1021.do")
	public String intrPopupInqy1021(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 팝업(아이디 찾기) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1021;
	}

	// 비밀번호 찾기 팝업 조회 
	@RequestMapping("/intrPopupInqy1022.do")
	public String intrPopupInqy1022(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//
		} catch (Exception e) {
			//
			logger.debug("Exception : 팝업(비밀번호 찾기) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1022;
	}
	
	// 프로젝트 조회
	@RequestMapping("/intrPopupInqy1030.do")
	public String intrPopupInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 프로젝트 조회
			//--------------------------------------------------------------------------------------------
			defaultList = projDao.intrProjInqy1011(model, paramMap);
			model.addAttribute("projList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 프로젝트 목록 팝업 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1031;
	}
	
	// 결재선 선택 팝업 조회
	@RequestMapping("/intrPopupInqy1041.do")
	public String intrPopupInqy1041(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 부서 사원 트리 조회
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy2031(model);
			model.addAttribute("empList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// 공통코드 (결재선) 조회
			//--------------------------------------------------------------------------------------------
			paramMap.put("commcodeGcd", 	"type");
			defaultList = utilDao.intrCodeInqy1011(paramMap);
			model.addAttribute("typeList",defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 결재선 선택 팝업 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1041;
	}
	
	// 결재선 팝업 조회
	@RequestMapping("/intrPopupInqy1042.do")
	public String intrPopupInqy1042(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재선 팝업 조회
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 결재선 팝업 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1042;
	}
	
	// 결재의견 팝업 조회
	@RequestMapping("/intrPopupInqy1050.do")
	public String intrPopupInqy1050(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재의견 팝업 조회
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 결재 의견 팝업 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1051;
	}
	
	// 물품 등록 팝업 조회
	@RequestMapping("/intrPopupInqy1061.do")
	public String intrPopupInqy1061(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 물품 등록 팝업 조회
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 물품 등록 팝업 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1061;
	}
	
	// 물품 조회 팝업 조회
	@RequestMapping("/intrPopupInqy1062.do")
	public String intrPopupInqy1062(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 물품 조회 팝업 조회
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 물품 조회 팝업 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1062;
	}
	
	// 정산내역 등록 팝업 조회
	@RequestMapping("/intrPopupInqy1071.do")
	public String intrPopupInqy1071(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 정산내역 팝업 조회
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 정산내역 등록 팝업 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1071;
	}
	
	// 정산내역 조회 팝업 조회
	@RequestMapping("/intrPopupInqy1072.do")
	public String intrPopupInqy1072(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 정산내역 조회 팝업 조회
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 정산내역 조회 팝업 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1072;
	}
}