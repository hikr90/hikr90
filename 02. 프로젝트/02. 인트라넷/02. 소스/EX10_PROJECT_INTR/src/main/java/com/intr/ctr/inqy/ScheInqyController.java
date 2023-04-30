package com.intr.ctr.inqy;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.constant.IntrConstant;
import com.intr.svc.inqy.TempInqyService;
import com.intr.svc.inqy.CoreInqyService;
import com.intr.svc.inqy.EmpInqyService;
import com.intr.svc.inqy.ScheInqyService;
import com.intr.svc.inqy.AuthInqyService;

@Controller
public class ScheInqyController {
	//
	@Autowired
	CoreInqyService coreInqyService;
	
	@Autowired
	ScheInqyService scheInqyService;

	@Autowired
	EmpInqyService empInqyService;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* ��Ī : intrScheInqy1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.02.11
	 * ���� : ���� ���� ��� ��ȸ
	 */
	@RequestMapping("/intrScheInqy1010.do")
	public String intrScheInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �μ�, ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			empInqyService.intrEmpInqy101012(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			scheInqyService.intrScheInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_SCHE + IntrConstant.INTR_SCHE_INQY_1010;
	}

}
