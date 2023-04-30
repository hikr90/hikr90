package com.intr.svcImpl.inqy;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.inqy.QnaInqyDao;
import com.intr.svc.inqy.QnaInqyService;

@Service
@Transactional
public class QnaInqyServiceImpl implements QnaInqyService{
	//
	@Autowired
	QnaInqyDao qnaInqyDao;
	
	@Autowired
	HttpServletRequest request;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// Q&A ��� ��ȸ
	public void intrQnaInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// Q&A ���
			//--------------------------------------------------------------------------------------------
			defaultList = qnaInqyDao.intrQnaInqy10101010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// ������ ���� ����
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL", "intrQnaInqy1010.do");
			//
			if(defaultList!=null) {
				paramMap.put("rowTotal", defaultList.get(0).get("listCnt"));
			} else {
				paramMap.put("rowTotal", "0");				
			}

		} catch (Exception e) {
			//
			logger.debug("[����] ������ Q&A ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}

}
