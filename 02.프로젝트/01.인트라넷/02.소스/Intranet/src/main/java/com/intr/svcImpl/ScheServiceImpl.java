package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import net.sf.json.JSONArray;

import com.intr.dao.ScheDao;
import com.intr.dao.UtilDao;
import com.intr.svc.EmpService;
import com.intr.svc.MainService;
import com.intr.svc.ScheService;
import com.intr.svc.UtilService;

@Service
@Transactional(rollbackFor = Exception.class)
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
	
	@Autowired
	UtilDao utilDao;
	
	// ���� ��� ��ȸ
	public void intrScheInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		JSONArray jAray = new JSONArray();
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = scheInqyDao.intrScheInqy1011(model, paramMap);
			model.addAttribute("defaultList", jAray.fromObject(defaultList));
			
			//--------------------------------------------------------------------------------------------
			// �����ڵ� (�ް� Ÿ��) ��ȸ
			//--------------------------------------------------------------------------------------------
			paramMap.put("commcodeGcd", 	"LEAV");
			defaultList = utilDao.intrCodeInqy1011(paramMap);
			model.addAttribute("leavList",defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
}
