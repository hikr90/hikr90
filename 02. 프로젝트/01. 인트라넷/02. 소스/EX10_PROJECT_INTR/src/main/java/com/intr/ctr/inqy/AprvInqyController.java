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
import com.intr.svc.inqy.AprvInqyService;
import com.intr.svc.inqy.CoreInqyService;

@Controller
public class AprvInqyController {
	//
	@Autowired
	CoreInqyService coreInqyService;

	@Autowired
	AprvInqyService aprvInqyService;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* ��Ī : intrAprvInqy1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.06.25
	 * ���� : ���系�� ��� ��ȸ
	 */
	@RequestMapping("/intrAprvInqy1010.do")
	public String intrAprvInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���系�� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvInqyService.intrAprvInqy101010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���系�� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_APRV + IntrConstant.INTR_APRV_LIST_1010;
	}
}
