package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import net.sf.json.JSONArray;

import com.intr.dao.ScheDao;
import com.intr.svc.ScheService;

@Service
@Transactional
public class ScheServiceImpl implements ScheService{
	//
	@Autowired
	ScheDao scheInqyDao;
	
	// 일정 목록 조회
	public void intrScheInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		JSONArray jsonArray = new JSONArray();
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 일정 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = scheInqyDao.intrScheInqy1010(model, paramMap);
			model.addAttribute("defaultList", jsonArray.fromObject(defaultList));
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

}
