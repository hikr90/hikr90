package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

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

	// 업무일지 조회 화면
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
			defaultList = taskDao.intrTaskInqy1021(model, paramMap);
			model.addAttribute("defaultList",defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 업무일지 등록
	public String intrTaskProc1010(Model model, @RequestBody List<HashMap<String, Object>> paramList) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 업무 일지 전체 삭제
			//--------------------------------------------------------------------------------------------
			taskDao.intrTaskProc1021(paramList.get(0));
			
			//--------------------------------------------------------------------------------------------
			// 업무 일지 등록
			//--------------------------------------------------------------------------------------------
			int addCnt = paramList.size();
			HashMap<String, Object> tempMap = null;
			//
			for(int i=0;i<addCnt;i++) {
				//
				tempMap = new HashMap<String, Object>();
				tempMap.put("empIdx", paramList.get(i).get("empIdx"));
				tempMap.put("regDt", paramList.get(i).get("regDt"));
				tempMap.put("regTm", paramList.get(i).get("regTm"));
				tempMap.put("taskCont", paramList.get(i).get("taskCont"));
				//
				resInt += taskDao.intrTaskProc1011(tempMap);
			}
			//
			if(resInt==addCnt) {
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
