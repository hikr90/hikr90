package com.intr.svcImpl.inqy;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.inqy.EmpInqyDao;
import com.intr.dao.inqy.FileInqyDao;
import com.intr.svc.inqy.EmpInqyService;

@Service
@Transactional
public class EmpInqyServiceImpl implements EmpInqyService{
	//
	@Autowired
	EmpInqyDao empInqyDao;
	
	@Autowired
	FileInqyDao fileInqyDao;
	
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
			defaultList = empInqyDao.intrEmpInqy10101010(model, paramMap);
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
			defaultInfo = empInqyDao.intrEmpInqy10101011(model, paramMap);
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
			defaultList = empInqyDao.intrEmpInqy10101210(model, paramMap);
			model.addAttribute("deptList", defaultList);

			//--------------------------------------------------------------------------------------------
			// 부서 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = empInqyDao.intrEmpInqy10101211(model, paramMap);
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
			defaultList = empInqyDao.intrEmpInqy10111010(model, paramMap);
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
			defaultInfo = empInqyDao.intrEmpInqy10102010(model, paramMap);
			model.addAttribute("defaultInfo",defaultInfo);

			//--------------------------------------------------------------------------------------------
			// 파일 정보
			//--------------------------------------------------------------------------------------------
			defaultList = fileInqyDao.intrFileInqy101010(model, paramMap);
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
			defaultList = empInqyDao.intrEmpInqy10301010(model);
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
			defaultList = empInqyDao.intrEmpInqy10401010(model, paramMap);
			model.addAttribute("deptEmpList",defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 부서 직원 수 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
}
