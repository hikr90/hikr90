package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.TempDao;
import com.intr.svc.MainService;
import com.intr.svc.TempService;
import com.intr.svc.UtilService;

@Service
@Transactional(rollbackFor = Exception.class)
public class TempServiceImpl implements TempService{
	//
	@Autowired
	TempDao tempDao;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	UtilService utilService;
	
	// 기안문 양식 목록 조회
	public void intrTempInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안문 양식 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = tempDao.intrTempInqy1011(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 기안문 양식 상세 조회
	public void intrTempInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안문 양식 상세 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = tempDao.intrTempInqy1021(model, paramMap);
			model.addAttribute("defaultInfo", defaultInfo);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// 기안문 양식 목록 조회
	public void intrTempInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// (메인)기안문 양식 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = tempDao.intrTempInqy1011(model, paramMap);
			model.addAttribute("tempList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 기안문 양식 등록
	public String intrTempProc1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안문 양식 등록
			//--------------------------------------------------------------------------------------------
			resInt = tempDao.intrTempProc1011(paramMap);
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
	
	// 기안문 양식 수정
	public String intrTempProc1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안문 양식 수정
			//--------------------------------------------------------------------------------------------
			resInt = tempDao.intrTempProc1021(paramMap);
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
	
	// 기안문 양식 삭제
	public String intrTempProc1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안문 양식 삭제
			//--------------------------------------------------------------------------------------------
			resInt = tempDao.intrTempProc1031(paramMap);
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
