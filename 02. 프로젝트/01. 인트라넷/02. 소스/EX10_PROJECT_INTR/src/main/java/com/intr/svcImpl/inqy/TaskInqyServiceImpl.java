package com.intr.svcImpl.inqy;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.inqy.TaskInqyDao;
import com.intr.svc.inqy.TaskInqyService;
import com.intr.vo.EmpVO;

@Service
@Transactional
public class TaskInqyServiceImpl implements TaskInqyService{
	//
	@Autowired
	TaskInqyDao taskInqyDao;
	
	@Autowired
	HttpSession session;

	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 업무일지 목록 조회
	public void intrTaskInqy201010(Model model, HashMap<String, Object> paramMap) {
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
			defaultList = taskInqyDao.intrTaskInqy20101010(model, paramMap);
			model.addAttribute("defaultList",defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 업무일지 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

}
