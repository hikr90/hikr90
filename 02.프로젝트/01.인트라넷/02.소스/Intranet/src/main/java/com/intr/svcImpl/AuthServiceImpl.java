package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.AuthDao;
import com.intr.svc.AuthService;

@Service
@Transactional
public class AuthServiceImpl implements AuthService{
	//
	@Autowired
	AuthDao authDao;
	
	public void intrAuthInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy1010(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 권한 상세 조회
	public void intrAuthInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공통코드 상세 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = authDao.intrAuthInqy1020(model, paramMap);
			model.addAttribute("defaultInfo", defaultInfo);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 메뉴 권한 목록 조회
	public void intrAuthInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy1030(model, paramMap);
			model.addAttribute("authMenuList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 사용자 목록 조회
	public void intrAuthInqy1040(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사용자 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy1040(model, paramMap);
			model.addAttribute("empList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 사용자 권한 목록 조회
	public void intrAuthInqy1050(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사용자 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy1050(model, paramMap);
			model.addAttribute("authEmpList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 권한 등록 처리
	public String intrAuthProc1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 권한 등록 처리
			//--------------------------------------------------------------------------------------------
			resInt = authDao.intrAuthProc1010(paramMap);
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
		//
		return defaultStr;
	}
	
	// 권한 수정 처리
	public String intrAuthProc1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 권한 수정 처리
			//--------------------------------------------------------------------------------------------
			resInt = authDao.intrAuthProc1020(paramMap);
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
		//
		return defaultStr;
	}
	
	// 권한 삭제 처리
	public String intrAuthProc1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 권한 삭제 처리
			//--------------------------------------------------------------------------------------------
			resInt = authDao.intrAuthProc1030(paramMap);
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
		//
		return defaultStr;
	}
	
	// 메뉴 권한 저장 처리
	public String intrAuthProc1040(Model model, HashMap<String, Object> paramMap) throws Exception {
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
			authDao.intrAuthProc1040(paramMap);

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
					resInt += authDao.intrAuthProc1050(tempMap);
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
			throw new Exception(e.getMessage());
		}
		//
		return defaultStr;
	}
	
	// 사용자 권한 저장 처리
	public String intrAuthProc1050(Model model, HashMap<String, Object> paramMap) throws Exception {
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
			authDao.intrAuthProc1060(paramMap);

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
					resInt += authDao.intrAuthProc1070(tempMap);
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
			throw new Exception(e.getMessage());
		}
		//
		return defaultStr;
	}

}
