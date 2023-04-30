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

import com.intr.dao.inqy.BoardInqyDao;
import com.intr.dao.inqy.FileInqyDao;
import com.intr.svc.inqy.BoardInqyService;

@Service
@Transactional
public class BoardInqyServiceImpl implements BoardInqyService{
	//
	@Autowired
	BoardInqyDao boardInqyDao;
	
	@Autowired
	FileInqyDao fileInqyDao;
	
	@Autowired
	HttpServletRequest request;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// 공지사항 목록 조회
	public void intrBoardInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공지사항 목록
			//--------------------------------------------------------------------------------------------
			defaultList = boardInqyDao.intrBoardInqy10101010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// 페이지 변수 저장
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL", "intrBoardInqy2010.do");
			//
			if(defaultList!=null) {
				paramMap.put("rowTotal", defaultList.get(0).get("listCnt"));
			} else {
				paramMap.put("rowTotal", "0");				
			}

			//--------------------------------------------------------------------------------------------
			// 조회수 세션 초기화
			//--------------------------------------------------------------------------------------------
			request.getSession().removeAttribute("readhit");
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 공지사항 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

	// 공지사항 목록 건수 조회
	public void intrBoardInqy101011(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공지사항 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardInqyDao.intrBoardInqy10101011(model, paramMap);
			paramMap.put("rowTotal", defaultInfo.get("listCnt"));

			//--------------------------------------------------------------------------------------------
			// 페이지 (공지사항) 변수 처리
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL","intrBoardInqy2010.do");

			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 공지사항 목록 건수 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 공지사항 상세화면 조회
	public void intrBoardInqy103010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공지사항 상세 정보
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardInqyDao.intrBoardInqy10102010(model, paramMap);
			model.addAttribute("defaultInfo",defaultInfo);

			//--------------------------------------------------------------------------------------------
			// 파일 정보
			//--------------------------------------------------------------------------------------------
			defaultList = fileInqyDao.intrFileInqy101010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 공지사항 상세화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

}
