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
import com.intr.svc.TaskService;
import com.intr.vo.EmpVO;

@Service
@Transactional
public class TaskServiceImpl implements TaskService{
	//
	@Autowired
	TaskDao taskDao;

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
			paramMap.put("empIdx", "");
			defaultList = taskDao.intrTaskInqy1010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 업무일지 작성 화면
	public void intrTaskInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 파라미터 세팅
			//--------------------------------------------------------------------------------------------
			EmpVO empVo = (EmpVO)session.getAttribute("empVO");
			paramMap.put("empIdx", empVo.getEmpIdx());

			//--------------------------------------------------------------------------------------------
			// 업무일지 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = taskDao.intrTaskInqy1010(model, paramMap);
			model.addAttribute("defaultList",defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 업무일지 목록 건수 조회
	public void intrTaskInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 업무일지 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = taskDao.intrTaskInqy1020(model, paramMap);
			paramMap.put("rowTotal", defaultInfo.get("listCnt"));

			//--------------------------------------------------------------------------------------------
			// 페이지 (업무일지) 변수 처리
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL","intrTaskInqy1010.do");

			
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
			// 업무 일지 전체 삭제 (INTR_TASK)
			//--------------------------------------------------------------------------------------------
			taskDao.intrTaskProc1010(paramList.get(0));
			
			//--------------------------------------------------------------------------------------------
			// 업무 일지 등록 (INTR_TASK)
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
				tempMap.put("taskContent", paramList.get(i).get("taskContent"));
				//
				resInt += taskDao.intrTaskProc1020(tempMap);
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
