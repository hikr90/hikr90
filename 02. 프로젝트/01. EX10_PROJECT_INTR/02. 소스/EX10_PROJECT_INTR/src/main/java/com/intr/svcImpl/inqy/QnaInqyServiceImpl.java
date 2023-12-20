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

	// Q&A 목록 조회
	public void intrQnaInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// Q&A 목록
			//--------------------------------------------------------------------------------------------
			defaultList = qnaInqyDao.intrQnaInqy10101010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// 페이지 변수 저장
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
			logger.debug("[서비스] 관리자 Q&A 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

}
