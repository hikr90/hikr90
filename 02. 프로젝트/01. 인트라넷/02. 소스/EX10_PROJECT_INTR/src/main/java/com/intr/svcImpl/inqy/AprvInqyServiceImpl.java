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
	
	//
	public void intrAprvInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvInqyDao.intrAprvInqy10101010(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 사용자 결재내역 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}

	}

}
