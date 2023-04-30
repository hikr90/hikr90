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
import com.intr.dao.inqy.ScheInqyDao;
import com.intr.svc.inqy.TempInqyService;
import com.intr.svc.inqy.AuthInqyService;
import com.intr.svc.inqy.ScheInqyService;

@Service
@Transactional
public class ScheInqyServiceImpl implements ScheInqyService{
	//
	@Autowired
	ScheInqyDao scheInqyDao;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// ���� ��� ��ȸ
	public void intrScheInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = scheInqyDao.intrScheInqy10101010(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[����] ������ ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}

}
