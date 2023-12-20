package com.intr.svcImpl.inqy;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.inqy.AprvInqyDao;
import com.intr.svc.inqy.AprvInqyService;

@Service
@Transactional
public class AprvInqyServiceImpl implements AprvInqyService{
	//
	@Autowired
	AprvInqyDao aprvInqyDao;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 기안 목록 조회
	public void intrAprvInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvInqyDao.intrAprvInqy10101010(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 기안 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 결재선 상세 정보 조회
	public void intrAprvInqy102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 상세 정보 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvInqyDao.intrAprvInqy10102010(model, paramMap);
			model.addAttribute("aprvDetInfo", defaultInfo);

			//--------------------------------------------------------------------------------------------
			// 현재 결재 정보 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvInqyDao.intrAprvInqy10102011(model, paramMap);
			model.addAttribute("currAprvInfo", defaultInfo);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 결재 상세 정보 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}

	}
	
	// 결재 목록 조회
	public void intrAprvInqy201010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvInqyDao.intrAprvInqy20101010(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 결재 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

	// 나의 기안 목록 조회
	public void intrAprvInqy103010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvInqyDao.intrAprvInqy10301010(model, paramMap);
			model.addAttribute("aprvReqList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 나의 기안 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 나의 결재 목록 조회
	public void intrAprvInqy103011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvInqyDao.intrAprvInqy10301110(model, paramMap);
			model.addAttribute("aprvRecList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 나의 결재 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

}
