package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.TempDao;
import com.intr.svc.TempService;

@Service
@Transactional
public class TempServiceImpl implements TempService{
	//
	@Autowired
	TempDao tempDao;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 템플릿 목록 조회
	public void intrTempInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = tempDao.intrTempInqy10101010(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 템플릿 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 템플릿 상세 조회
	public void intrTempInqy102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 상세 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = tempDao.intrTempInqy10201010(model, paramMap);
			model.addAttribute("defaultInfo", defaultInfo);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 템플릿 상세 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

	// (메인)템플릿 목록 조회
	public void intrTempInqy103010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// (메인)템플릿 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = tempDao.intrTempInqy10101010(model, paramMap);
			model.addAttribute("tempList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 (메인)템플릿 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 템플릿 등록
	public String intrTempProc101010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 등록
			//--------------------------------------------------------------------------------------------
			resInt = tempDao.intrTempProc10101010(paramMap);
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
			logger.debug("[서비스] 관리자 템플릿 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 템플릿 수정
	public String intrTempProc102010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 수정
			//--------------------------------------------------------------------------------------------
			resInt = tempDao.intrTempProc10201010(paramMap);
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
			logger.debug("[서비스] 관리자 템플릿 수정 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 템플릿 삭제
	public String intrTempProc103010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 삭제
			//--------------------------------------------------------------------------------------------
			resInt = tempDao.intrTempProc10301010(paramMap);
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
			logger.debug("[서비스] 관리자 템플릿 삭제 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}
