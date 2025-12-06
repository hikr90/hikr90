package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.intr.dao.TaskDao;
import com.intr.svc.EmpService;
import com.intr.svc.MainService;
import com.intr.svc.TaskService;
import com.intr.svc.UtilService;

@Service
@Transactional(rollbackFor = Exception.class)
public class TaskServiceImpl implements TaskService{
	//
	@Autowired
	TaskDao taskDao;

	@Autowired
	MainService mainService;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	EmpService empService;
	
	@Autowired
	HttpSession session;

	// 업무일지 작성
	public void intrTaskInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 업무일지 조회
			//--------------------------------------------------------------------------------------------
			defaultList = taskDao.intrTaskInqy1011(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 업무일지 작성 (ajax)
	public void intrTaskInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 업무일지 조회
			//--------------------------------------------------------------------------------------------
			defaultList = taskDao.intrTaskInqy1011(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 업무일지 목록 조회
	public void intrTaskInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 페이징 처리
			//--------------------------------------------------------------------------------------------
			utilService.setPaging(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 업무일지 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = taskDao.intrTaskInqy2011(model, paramMap);
			model.addAttribute("defaultList",defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 업무일지 상세 조회
	public void intrTaskInqy2020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 업무일지 상세 조회
			//--------------------------------------------------------------------------------------------
			defaultList = taskDao.intrTaskInqy2021(model, paramMap);
			model.addAttribute("defaultList",defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 업무 캘린더 조회
	public void intrTaskInqy3010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 업무 캘린더 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = taskDao.intrTaskInqy3011(model, paramMap);
			model.addAttribute("defaultList",defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 업무일지 등록
	public String intrTaskProc1010(Model model, @RequestBody HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> tempMap = null;
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 업무 일지 전체 삭제
			//--------------------------------------------------------------------------------------------
			tempMap = new HashMap<String, Object>();
			tempMap.put("empIdx", (String)paramMap.get("empIdx"));
			tempMap.put("srchDt", (String)paramMap.get("srchDt"));
			//
			taskDao.intrTaskProc1021(tempMap);

			//--------------------------------------------------------------------------------------------
			// 업무일지 채번
			//--------------------------------------------------------------------------------------------
			defaultInfo = taskDao.intrTaskInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 업무 일지 등록
			//--------------------------------------------------------------------------------------------
			String jStr = (String)paramMap.get("taskList");
			JSONParser parser = new JSONParser();
			JSONArray arr = (JSONArray)parser.parse(jStr);
			JSONObject obj = null; 
			
			for(Object data : arr) {
				obj = (JSONObject) data;
				// 임시 저장
				tempMap = new HashMap<String, Object>();
				
				tempMap.put("sequenceId", utilService.nvlProc((String)defaultInfo.get("sequenceId")));
				tempMap.put("taskTitle", utilService.nvlProc((String)obj.get("taskTitle")));
				tempMap.put("taskCont", utilService.nvlProc((String)obj.get("taskCont")));
				tempMap.put("taskHh", utilService.nvlProc((String)obj.get("taskHh")));
				tempMap.put("taskMm", utilService.nvlProc((String)obj.get("taskMm")));
				tempMap.put("taskDt", utilService.nvlProc((String)obj.get("taskDt")));
				tempMap.put("empIdx", utilService.nvlProc((String)obj.get("empIdx")));
				
				System.out.println("kth1 : " + tempMap);
				// 등록 처리
				resInt += taskDao.intrTaskProc1011(tempMap);
			}
			
			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			if(arr.size() == resInt) {
				resStr = "YES";
			}
			
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return defaultStr;
	}
}
