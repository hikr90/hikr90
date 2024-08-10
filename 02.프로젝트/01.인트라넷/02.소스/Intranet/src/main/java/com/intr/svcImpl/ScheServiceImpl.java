package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import net.sf.json.JSONArray;

import com.intr.dao.ScheDao;
import com.intr.svc.EmpService;
import com.intr.svc.MainService;
import com.intr.svc.ScheService;
import com.intr.svc.UtilService;

@Service
@Transactional
public class ScheServiceImpl implements ScheService{
	//
	@Autowired
	ScheDao scheInqyDao;

	@Autowired
	MainService mainService;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	EmpService empService;
	
	// 일정 목록 조회
	public void intrScheInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		JSONArray jsonArray = new JSONArray();
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 일정 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = scheInqyDao.intrScheInqyDao1010(model, paramMap);
			model.addAttribute("defaultList", jsonArray.fromObject(defaultList));
			
			//--------------------------------------------------------------------------------------------
			// 부서 직급 정보 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqyService1050(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 부서 직급 정보 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqyService1040(model, paramMap);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
}
