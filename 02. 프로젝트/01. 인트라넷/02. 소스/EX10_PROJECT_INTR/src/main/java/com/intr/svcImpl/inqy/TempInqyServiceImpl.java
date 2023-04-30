package com.intr.svcImpl.inqy;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.inqy.TempInqyDao;
import com.intr.svc.inqy.TempInqyService;

@Service
@Transactional
public class TempInqyServiceImpl implements TempInqyService{
	//
	@Autowired
	TempInqyDao tempInqyDao;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 템플릿 목록 조회
	public void intrTempInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = tempInqyDao.intrTempInqy10101010(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 템플릿 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 템플릿 상세 조회
	public void intrTempInqy102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 상세 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = tempInqyDao.intrTempInqy10201010(model, paramMap);
			model.addAttribute("defaultInfo", defaultInfo);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 템플릿 상세 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
}
