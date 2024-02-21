package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.AuthDao;
import com.intr.dao.TempDao;
import com.intr.svc.AuthService;
import com.intr.svc.TempService;

@Service
@Transactional
public class AuthServiceImpl implements AuthService{
	//
	@Autowired
	AuthDao authDao;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 권한 목록 조회
	public void intrAuthInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy10101010(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 권한 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 권한 상세 조회
	public void intrAuthInqy102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공통코드 상세 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = authDao.intrAuthInqy10201010(model, paramMap);
			model.addAttribute("defaultInfo", defaultInfo);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 권한 상세 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 메뉴 권한 목록 조회
	public void intrAuthInqy201010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy20101010(model, paramMap);
			model.addAttribute("authMenuList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 메뉴 권한 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 사용자 목록 조회
	public void intrAuthInqy301010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사용자 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy30101010(model, paramMap);
			model.addAttribute("empList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 사용자 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 사용자 권한 목록 조회
	public void intrAuthInqy301020(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사용자 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy30101020(model, paramMap);
			model.addAttribute("authEmpList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 사용자 권한 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 권한 등록 처리
	public String intrAuthProc101010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 권한 등록 처리
			//--------------------------------------------------------------------------------------------
			resInt = authDao.intrAuthProc10101010(paramMap);
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
			logger.debug("[서비스] 관리자 권한 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 권한 수정 처리
	public String intrAuthProc102010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 권한 수정 처리
			//--------------------------------------------------------------------------------------------
			resInt = authDao.intrAuthProc10201010(paramMap);
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
			logger.debug("[서비스] 관리자 권한 수정 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 권한 삭제 처리
	public String intrAuthProc103010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 권한 삭제 처리
			//--------------------------------------------------------------------------------------------
			resInt = authDao.intrAuthProc10301010(paramMap);
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
			logger.debug("[서비스] 관리자 권한 삭제 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 메뉴 권한 저장 처리
	public String intrAuthProc201010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		HashMap<String, Object> tempMap = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 권한 삭제 처리
			//--------------------------------------------------------------------------------------------
			authDao.intrAuthProc20101010(paramMap);

			//--------------------------------------------------------------------------------------------
			// 메뉴 권한 저장 처리
			//--------------------------------------------------------------------------------------------
			for(int i=0;i<paramMap.size();i++) {
				//
				if(paramMap.get("menuCd"+i)!=null) {
					//
					tempMap = new HashMap<String, Object>();
					tempMap.put("menuCd", (String)paramMap.get("menuCd"+i));
					tempMap.put("authCd", (String)paramMap.get("authCd"));
					//
					resInt += authDao.intrAuthProc20101020(tempMap);
				}
			}
			
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
			logger.debug("[서비스] 관리자 메뉴 권한 저장 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 사용자 권한 저장 처리
	public String intrAuthProc301010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		HashMap<String, Object> tempMap = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사용자 권한 삭제 처리
			//--------------------------------------------------------------------------------------------
			authDao.intrAuthProc30101010(paramMap);

			//--------------------------------------------------------------------------------------------
			// 사용자 권한 저장 처리
			//--------------------------------------------------------------------------------------------
			for(int i=0;i<paramMap.size();i++) {
				//
				if(paramMap.get("empIdx"+i)!=null) {
					//
					tempMap = new HashMap<String, Object>();
					tempMap.put("empIdx", (String)paramMap.get("empIdx"+i));
					tempMap.put("authCd", (String)paramMap.get("authCd"));
					//
					resInt += authDao.intrAuthProc30101020(tempMap);
				}
			}
			
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
			logger.debug("[서비스] 관리자 사용자 권한 저장 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

}
