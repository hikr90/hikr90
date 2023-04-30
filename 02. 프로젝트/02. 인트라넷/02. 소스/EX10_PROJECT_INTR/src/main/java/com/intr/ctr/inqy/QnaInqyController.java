package com.intr.ctr.inqy;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intr.constant.IntrConstant;
import com.intr.svc.inqy.CoreInqyService;
import com.intr.svc.inqy.QnaInqyService;

@Controller
public class QnaInqyController {
	//
	@Autowired
	QnaInqyService qnaInqyService;
	
	@Autowired
	CoreInqyService coreInqyService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* ��Ī : intrQnaInqy1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.02
	 * ���� : ������ Q&A ��� ��ȸ
	 */
	@RequestMapping("/intrQnaInqy1010.do")
	public String intrBoardInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����� �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// Q&A ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			qnaInqyService.intrQnaInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ �������� Q&A ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_QNA + IntrConstant.INTR_QNA_LIST_1010;
	}
	
}
