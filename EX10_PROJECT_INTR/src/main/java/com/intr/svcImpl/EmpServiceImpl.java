package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.dao.EmpDao;
import com.intr.dao.MainDao;
import com.intr.dao.UtilDao;
import com.intr.svc.EmpService;
import com.intr.svc.UtilService;

@Service
@Transactional
public class EmpServiceImpl implements EmpService{
	//
	@Autowired
	MainDao mainDao;
	
	@Autowired
	EmpDao empDao;
	
	@Autowired
	UtilDao utilDao;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	HttpServletRequest request;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// 사원 목록 조회
	public void intrEmpInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 목록
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy10101010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// 페이지 변수 저장
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL", "intrEmpInqy2010.do");
			//
			if(defaultList!=null) {
				paramMap.put("rowTotal", defaultList.get(0).get("listCnt"));
			} else {
				paramMap.put("rowTotal", "0");				
			}

		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 사원 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 사원 목록 건수 조회
	public void intrEmpInqy101011(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = empDao.intrEmpInqy10101011(model, paramMap);
			paramMap.put("rowTotal", defaultInfo.get("listCnt"));

			//--------------------------------------------------------------------------------------------
			// 페이지 (사원) 변수 처리
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL","intrEmpInqy2010.do");

			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 사원 목록 건수 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 부서, 직급 조회
	public void intrEmpInqy101012(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 부서 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy10101210(model, paramMap);
			model.addAttribute("deptList", defaultList);

			//--------------------------------------------------------------------------------------------
			// 부서 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy10101211(model, paramMap);
			model.addAttribute("gradeList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 부서, 직급 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

	
	// 사원 아이디 중복 조회
	public String intrEmpInqy101110(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		String defaultStr = "";
		String resStr = "NO";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 아이디 중복 조회
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy10111010(model, paramMap);
			//
			if(defaultList.size()>0) {
				resStr = "YES";
			}
			
			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 사원 아이디 중복 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 사원 상세 조회
	public void intrEmpInqy102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 상세 정보
			//--------------------------------------------------------------------------------------------
			defaultInfo = empDao.intrEmpInqy10102010(model, paramMap);
			model.addAttribute("defaultInfo",defaultInfo);

			//--------------------------------------------------------------------------------------------
			// 파일 정보
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqy101010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 사원 상세화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 부서 사원 트리 조회
	public void intrEmpInqy103010(Model model) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 목록
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy10301010(model);
			model.addAttribute("defaultList",defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 부서 사원 트리 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

	// 부서 사원 수 조회
	public void intrEmpInqy104010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 부서 사원 수 조회
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy10401010(model, paramMap);
			model.addAttribute("deptEmpList",defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 부서 사원 수 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 사원 등록
	public String intrEmpProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 시퀀스 채번 (사원)
			//--------------------------------------------------------------------------------------------
			defaultInfo = mainDao.intrMainInqy10301011();
			paramMap.put("contentIdx", defaultInfo.get("contentIdx"));

			//--------------------------------------------------------------------------------------------
			// 사원 등록
			//--------------------------------------------------------------------------------------------
			resInt = empDao.intrEmpProc10101010(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}

			//--------------------------------------------------------------------------------------------
			// 파일 등록 (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			if(!request.getFiles("fileList").isEmpty()) {
				resStr = utilService.intrFileProc101010(model, paramMap, request);
			}

			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 사원 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}
	
	// 사원 수정
	public String intrEmpProc102010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 수정
			//--------------------------------------------------------------------------------------------
			resInt = empDao.intrEmpProc10201010(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}

			//--------------------------------------------------------------------------------------------
			// 파일 등록 (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			resStr = utilService.intrFileProc101010(model, paramMap, request);

			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 사원 수정 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}
	
	// 사원 복직, 퇴사 처리
	public String intrEmpProc103010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 복직, 퇴사 처리
			//--------------------------------------------------------------------------------------------
			resInt = empDao.intrEmpProc10301010(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}

			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 사원 복직, 퇴사 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}

}
