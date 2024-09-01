package com.intr.ctr;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.svc.MainService;
import com.intr.svc.ScheService;
import com.intr.utils.Jsp;
import com.intr.utils.Path;

@Controller
public class ScheController {
	//
	@Autowired
	MainService mainService;
	
	@Autowired
	ScheService scheService;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// ���� ���� ��� ��ȸ
	@RequestMapping("/intrScheInqy1010.do")
	public String intrScheInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			scheService.intrScheInqyService1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_SCHE + Jsp.INTR_SCHE_INQY_1010;
	}
}
