package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.intr.dao.QueryDao;
import com.intr.svc.QueryService;
import com.intr.svc.UtilService;

@Service
public class QueryServiceImpl implements QueryService{
	//
	@Autowired
	UtilService utilService;
	
	@Autowired
	QueryDao queryDao;
	
	// ���� ȭ�� ��ȸ
	public void intrQueryInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ���� ��� ��ȸ
	public void intrQueryInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		Set<String> columList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ȭ�� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = queryDao.intrQueryInqy1021(model, paramMap);
			
			if(defaultList!=null && !defaultList.isEmpty()) {
				//
				columList = defaultList.get(0).keySet();
				//
				model.addAttribute("colList",columList);
				model.addAttribute("dataList",defaultList);
			}
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// ���� �ٿ�ε�
	public void intrQueryInqy1030(HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		List<Map<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			defaultList = queryDao.intrQueryInqy1031(null, paramMap);
			utilService.excelDown(defaultList, paramMap, request, response);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// ���� �Է� ó��
	public String intrQueryProc1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String query = (String)paramMap.get("query");
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� �Է� ó��
			//--------------------------------------------------------------------------------------------
			paramMap.put("query", query.replaceAll(";", ""));
			resInt = queryDao.intrQueryProc1011(model, paramMap);
					
			// ó���� ���� ���� ��� �� ������ ��� ����
			if(resInt>0) {
				defaultStr = "Yes";
			}
			//--------------------------------------------------------------------------------------------
			// ��� ��ȯ
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
