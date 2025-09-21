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

	// �������� ��ȸ ȭ��
	public void intrTaskInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = taskDao.intrTaskInqy1011(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// �������� ��� ��ȸ
	public void intrTaskInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			utilService.setPaging(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �������� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = taskDao.intrTaskInqy1021(model, paramMap);
			model.addAttribute("defaultList",defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// �������� ���
	public String intrTaskProc1010(Model model, @RequestBody List<HashMap<String, Object>> paramList) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ���� ��ü ����
			//--------------------------------------------------------------------------------------------
			taskDao.intrTaskProc1021(paramList.get(0));
			
			//--------------------------------------------------------------------------------------------
			// ���� ���� ���
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
			// ��� ��ȯ
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
