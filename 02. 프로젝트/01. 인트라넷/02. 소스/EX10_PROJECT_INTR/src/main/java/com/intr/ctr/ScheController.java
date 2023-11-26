package com.intr.ctr;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.comm.Page;
import com.intr.comm.Path;
import com.intr.svc.AuthService;
import com.intr.svc.MainService;
import com.intr.svc.EmpService;
import com.intr.svc.ScheService;
import com.intr.svc.TempService;

@Controller
public class ScheController {
	//
	@Autowired
	MainService mainService;
	
	@Autowired
	ScheService scheService;

	@Autowired
	EmpService empService;
	
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
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �μ�, ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy101012(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			scheService.intrScheInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_SCHE + Page.INTR_SCHE_INQY_1010;
	}
}
