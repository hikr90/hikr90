package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.QueryDao;
import com.intr.svc.QueryService;
import com.intr.svc.UtilService;

@Service
@Transactional(rollbackFor = Exception.class)
public class QueryServiceImpl implements QueryService{
	//
	@Autowired
	UtilService utilService;
	
	@Autowired
	QueryDao queryDao;
	
	// 쿼리 화면 조회
	public void intrQueryInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 쿼리 결과 조회
	public void intrQueryInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		Set<String> colList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 쿼리 화면 조회
			//--------------------------------------------------------------------------------------------
			defaultList = queryDao.intrQueryInqy1021(model, paramMap);
			
			if(defaultList!=null && !defaultList.isEmpty()) {
				colList = defaultList.get(0).keySet();
				//
				model.addAttribute("colList",colList);
				model.addAttribute("dataList",defaultList);
			}
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// 엑셀 다운로드
	public void intrQueryInqy1030(HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		List<Map<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 엑셀 다운로드
			//--------------------------------------------------------------------------------------------
			defaultList = queryDao.intrQueryInqy1031(null, paramMap);
			utilService.excelDown(defaultList, paramMap, request, response);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// 쿼리 입력 처리
	public String intrQueryProc1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String query = (String)paramMap.get("query");
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 쿼리 입력 처리
			//--------------------------------------------------------------------------------------------
			paramMap.put("query", query.replaceAll(";", ""));
			resInt = queryDao.intrQueryProc1011(model, paramMap);
					
			// 처리된 건이 없는 경우 빈 값으로 결과 전송
			if(resInt>0) {
				defaultStr = "Yes";
			}
			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'resInt':'%d'}]", resInt);			
					
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return defaultStr;
	}
}
