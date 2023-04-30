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
import com.intr.dao.inqy.AuthInqyDao;
import com.intr.svc.inqy.TempInqyService;
import com.intr.svc.inqy.AuthInqyService;

@Service
@Transactional
public class AuthInqyServiceImpl implements AuthInqyService{
	//
	@Autowired
	AuthInqyDao authInqyDao;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 권한 목록 조회
	public void intrAuthInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = authInqyDao.intrAuthInqy10101010(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 권한 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 권한 상세 조회
	public void intrAuthInqy102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공통코드 상세 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = authInqyDao.intrAuthInqy10201010(model, paramMap);
			model.addAttribute("defaultInfo", defaultInfo);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 권한 상세 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 메뉴 권한 목록 조회
	public void intrAuthInqy201010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = authInqyDao.intrAuthInqy20101010(model, paramMap);
			model.addAttribute("authMenuList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 메뉴 권한 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 사용자 목록 조회
	public void intrAuthInqy301010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사용자 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = authInqyDao.intrAuthInqy30101010(model, paramMap);
			model.addAttribute("empList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 사용자 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 사용자 권한 목록 조회
	public void intrAuthInqy301020(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사용자 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = authInqyDao.intrAuthInqy30101020(model, paramMap);
			model.addAttribute("authEmpList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 사용자 권한 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

}
