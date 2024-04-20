package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import net.sf.json.JSONArray;

import com.intr.dao.AuthDao;
import com.intr.dao.ScheDao;
import com.intr.dao.TempDao;
import com.intr.svc.AuthService;
import com.intr.svc.ScheService;
import com.intr.svc.TempService;

@Service
@Transactional
public class ScheServiceImpl implements ScheService{
	//
	@Autowired
	ScheDao scheInqyDao;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 일정 목록 조회
	public void intrScheInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		JSONArray jsonArray = new JSONArray();
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 일정 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = scheInqyDao.intrScheInqy10101010(model, paramMap);
			model.addAttribute("defaultList", jsonArray.fromObject(defaultList));
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 일정 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

}
