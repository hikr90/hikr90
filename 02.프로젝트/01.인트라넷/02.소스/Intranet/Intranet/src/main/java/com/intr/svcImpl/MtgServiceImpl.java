package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.dao.MtgDao;
import com.intr.dao.UtilDao;
import com.intr.svc.MtgService;
import com.intr.svc.UtilService;

import net.sf.json.JSONArray;

@Service
@Transactional(rollbackFor = Exception.class)
public class MtgServiceImpl implements MtgService{
	//
	@Autowired
	UtilService utilService;
	
	@Autowired
	MtgDao mtgDao;
	
	@Autowired
	UtilDao utilDao;
	
	// 회의 목록 조회
	public void intrMtgInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 페이징 처리
			//--------------------------------------------------------------------------------------------
			utilService.setPaging(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 회의 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = mtgDao.intrMtgInqy1011(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 회의 등록 조회
	public void intrMtgInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 회의 등록 조회
			//--------------------------------------------------------------------------------------------
			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// 회의 상세화면 조회
	public void intrMtgInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 회의 상세 정보
			//--------------------------------------------------------------------------------------------
			defaultInfo = mtgDao.intrMtgInqy1031(model, paramMap);
			model.addAttribute("defaultInfo",defaultInfo);

			//--------------------------------------------------------------------------------------------
			// 파일 정보
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqy1011(model, paramMap);
			model.addAttribute("fileList",defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 캘린더 조회
	public void intrMtgInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		JSONArray jAray = new JSONArray();
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 캘린더 조회
			//--------------------------------------------------------------------------------------------
			defaultList = mtgDao.intrMtgInqy2011(model, paramMap);
			model.addAttribute("calList", jAray.fromObject(defaultList));
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 캘린더 목록 조회
	public void intrMtgInqy2020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 캘린더 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = mtgDao.intrMtgInqy2021(model, paramMap);
			model.addAttribute("calInfo", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	
	// 회의 등록 처리
	public String intrMtgProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 회의 채번
			//--------------------------------------------------------------------------------------------
			defaultInfo = mtgDao.intrMtgInqy1010(model, paramMap);
			paramMap.put("sequenceId", (String)defaultInfo.get("sequenceId"));
			
			//--------------------------------------------------------------------------------------------
			// 회의 등록 처리
			//--------------------------------------------------------------------------------------------
			resInt = mtgDao.intrMtgProc1011(paramMap);
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
	
	// 회의 삭제
	public String intrMtgProc1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 회의 삭제
			//--------------------------------------------------------------------------------------------
			resInt = mtgDao.intrMtgProc1021(paramMap);

			//--------------------------------------------------------------------------------------------
			// 파일 삭제 처리
			//--------------------------------------------------------------------------------------------
			utilDao.intrFileProc1021(paramMap);
			
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
	
	// 회의 수정
	public String intrMtgProc1030(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 회의 수정
			//--------------------------------------------------------------------------------------------
			resInt = mtgDao.intrMtgProc1031(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 파일 수정
			//--------------------------------------------------------------------------------------------
			resStr = utilService.fileUpload(model, paramMap, request);

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
