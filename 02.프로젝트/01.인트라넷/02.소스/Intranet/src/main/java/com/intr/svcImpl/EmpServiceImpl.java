package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	// 사원 목록 조회
	public void intrEmpInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 목록
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy1010(model, paramMap);
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
			throw new Exception(e.getMessage());
		}
	}
	
	// 사원 목록 건수 조회
	public void intrEmpInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = empDao.intrEmpInqy1020(model, paramMap);
			paramMap.put("rowTotal", defaultInfo.get("listCnt"));

			//--------------------------------------------------------------------------------------------
			// 페이지 (사원) 변수 처리
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL","intrEmpInqy2010.do");

			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 부서, 직급 조회
	public void intrEmpInqy1050(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 부서 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy1030(model, paramMap);
			model.addAttribute("deptList", defaultList);

			//--------------------------------------------------------------------------------------------
			// 부서 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy1040(model, paramMap);
			model.addAttribute("gradeList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	
	// 사원 아이디 중복 조회
	public String intrEmpInqy1040(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		String defaultStr = "";
		String resStr = "NO";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 아이디 중복 조회
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy1050(model, paramMap);
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
			throw new Exception(e.getMessage());
		}
		//
		return defaultStr;
	}
	
	// 사원 상세 조회
	public void intrEmpInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 상세 정보
			//--------------------------------------------------------------------------------------------
			defaultInfo = empDao.intrEmpInqy1060(model, paramMap);
			model.addAttribute("defaultInfo",defaultInfo);

			//--------------------------------------------------------------------------------------------
			// 파일 정보
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqy1010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 부서 사원 트리 조회
	public void intrEmpInqy1060(Model model) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 목록
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy1070(model);
			model.addAttribute("defaultList",defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// 부서 사원 수 조회
	public void intrEmpInqy1070(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 부서 사원 수 조회
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy1080(model, paramMap);
			model.addAttribute("deptEmpList",defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 사원 등록
	public String intrEmpProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
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
			defaultInfo = mainDao.intrMainInqy1030();
			paramMap.put("contentIdx", defaultInfo.get("contentIdx"));

			//--------------------------------------------------------------------------------------------
			// 사원 등록
			//--------------------------------------------------------------------------------------------
			resInt = empDao.intrEmpProc1010(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}

			//--------------------------------------------------------------------------------------------
			// 파일 등록 (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			if(!request.getFiles("fileList").isEmpty()) {
				resStr = utilService.intrFileProc1010(model, paramMap, request);
			}

			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}
	
	// 사원 수정
	public String intrEmpProc1020(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 수정
			//--------------------------------------------------------------------------------------------
			resInt = empDao.intrEmpProc1020(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}

			//--------------------------------------------------------------------------------------------
			// 파일 등록 (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			resStr = utilService.intrFileProc1010(model, paramMap, request);

			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}
	
	// 사원 복직, 퇴사 처리
	public String intrEmpProc1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 복직, 퇴사 처리
			//--------------------------------------------------------------------------------------------
			resInt = empDao.intrEmpProc1030(paramMap);
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
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}

}
