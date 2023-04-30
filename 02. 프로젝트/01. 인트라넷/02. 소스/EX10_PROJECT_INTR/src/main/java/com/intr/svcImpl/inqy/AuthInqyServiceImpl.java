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
	
	// ���� ��� ��ȸ
	public void intrAuthInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = authInqyDao.intrAuthInqy10101010(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[����] ������ ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ���� �� ��ȸ
	public void intrAuthInqy102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �����ڵ� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = authInqyDao.intrAuthInqy10201010(model, paramMap);
			model.addAttribute("defaultInfo", defaultInfo);
			
		} catch (Exception e) {
			//
			logger.debug("[����] ������ ���� �� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// �޴� ���� ��� ��ȸ
	public void intrAuthInqy201010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = authInqyDao.intrAuthInqy20101010(model, paramMap);
			model.addAttribute("authMenuList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[����] ������ �޴� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ����� ��� ��ȸ
	public void intrAuthInqy301010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = authInqyDao.intrAuthInqy30101010(model, paramMap);
			model.addAttribute("empList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[����] ������ ����� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ����� ���� ��� ��ȸ
	public void intrAuthInqy301020(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����� ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = authInqyDao.intrAuthInqy30101020(model, paramMap);
			model.addAttribute("authEmpList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[����] ������ ����� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}

}
