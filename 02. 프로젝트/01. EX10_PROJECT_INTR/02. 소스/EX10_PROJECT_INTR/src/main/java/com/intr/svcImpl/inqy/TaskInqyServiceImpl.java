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
import com.intr.svc.inqy.CoreInqyService;
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
	
	// 업무일지 조회 화면
	public void intrTaskInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 업무일지 조회
			//--------------------------------------------------------------------------------------------
			defaultList = taskInqyDao.intrTaskInqy10101010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 업무일지 조회 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 업무일지 작성 화면
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
			defaultList = taskInqyDao.intrTaskInqy10101010(model, paramMap);
			model.addAttribute("defaultList",defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 업무일지 작성 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 업무일지 목록 건수 조회
	public void intrTaskInqy101011(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 업무일지 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = taskInqyDao.intrTaskInqy10101011(model, paramMap);
			paramMap.put("rowTotal", defaultInfo.get("listCnt"));

			//--------------------------------------------------------------------------------------------
			// 페이지 (업무일지) 변수 처리
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL","intrTaskInqy1010.do");

			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 업무일지 목록 건수 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

}
