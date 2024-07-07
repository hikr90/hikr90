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

	// �������� ��ȸ ȭ��
	public void intrTaskInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� ��ȸ
			//--------------------------------------------------------------------------------------------
			paramMap.put("empIdx", "");
			defaultList = taskDao.intrTaskInqyDao1010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// �������� �ۼ� ȭ��
	public void intrTaskInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �Ķ���� ����
			//--------------------------------------------------------------------------------------------
			EmpVO empVo = (EmpVO)session.getAttribute("empVO");
			paramMap.put("empIdx", empVo.getEmpIdx());

			//--------------------------------------------------------------------------------------------
			// �������� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = taskDao.intrTaskInqyDao1010(model, paramMap);
			model.addAttribute("defaultList",defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// �������� ��� �Ǽ� ��ȸ
	public void intrTaskInqyService1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = taskDao.intrTaskInqyDao1020(model, paramMap);
			paramMap.put("rowTotal", defaultInfo.get("listCnt"));

			//--------------------------------------------------------------------------------------------
			// ������ (��������) ���� ó��
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL","intrTaskInqy1010.do");

			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// �������� ���
	public String intrTaskProcService1010(Model model, @RequestBody List<HashMap<String, Object>> paramList) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ���� ��ü ����
			//--------------------------------------------------------------------------------------------
			taskDao.intrTaskProcDao1010(paramList.get(0));
			
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
				resInt += taskDao.intrTaskProcDao1020(tempMap);
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
