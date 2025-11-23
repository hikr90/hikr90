package com.intr.svcImpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.dao.BanrDao;
import com.intr.dao.UtilDao;
import com.intr.svc.BanrService;
import com.intr.svc.UtilService;

@Service
@Transactional(rollbackFor = Exception.class)
public class BanrServiceImpl implements BanrService {
	//
	@Autowired
	UtilService utilService;
	
	@Autowired
	BanrDao banrDao;
	
	@Autowired
	UtilDao utilDao;
	
	// 배너 관리 조회
	public void intrBanrInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 배너 조회
			//--------------------------------------------------------------------------------------------
			defaultList = banrDao.intrBanrInqy1010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 배너 저장
	public String intrBanrProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		String sequenceId = utilService.nvlProc((String)paramMap.get("sequenceId"));
		//
		try {
			//
			if(sequenceId.equals("")) {
				//--------------------------------------------------------------------------------------------
				// 사용 중지 처리
				//--------------------------------------------------------------------------------------------
				resInt = banrDao.intrBanrProc1021(paramMap);

				//--------------------------------------------------------------------------------------------
				// 배너 채번
				//--------------------------------------------------------------------------------------------
				defaultInfo = banrDao.intrBanrInqy1010(model, paramMap);
				paramMap.put("sequenceId", (String)defaultInfo.get("sequenceId"));
			} 
			
			//--------------------------------------------------------------------------------------------
			// 배너 저장 처리
			//--------------------------------------------------------------------------------------------
			resInt = banrDao.intrBanrProc1011(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}

			//--------------------------------------------------------------------------------------------
			// 파일 등록
			//--------------------------------------------------------------------------------------------
			resStr = utilService.fileUpload(model, paramMap, request);
			
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
	
	// 배너 삭제
	public String intrBanrProc1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 배너 삭제
			//--------------------------------------------------------------------------------------------
			resInt = banrDao.intrBanrProc1021(paramMap);

			//--------------------------------------------------------------------------------------------
			// 파일 삭제 처리 (삭제)
			//--------------------------------------------------------------------------------------------
			utilDao.intrFileProc1022(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			if(resInt>0) {
				resStr = "YES";
			}
			//
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}
}
