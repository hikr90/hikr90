package com.intr.svcImpl.proc;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.intr.dao.proc.TaskProcDao;
import com.intr.svc.proc.TaskProcService;

@Service
@Transactional
public class TaskProcServiceImpl implements TaskProcService{
	//
	@Autowired
	TaskProcDao taskProcDao;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 공지사항 등록
	public String intrTaskProc101010(Model model, @RequestBody List<HashMap<String, Object>> paramList) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 업무 일지 전체 삭제 (INTR_TASK)
			//--------------------------------------------------------------------------------------------
			taskProcDao.intrTaskProc10101010(paramList.get(0));
			
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
				resInt += taskProcDao.intrTaskProc10101011(tempMap);
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
			logger.debug("[서비스] 업무일지 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

}
