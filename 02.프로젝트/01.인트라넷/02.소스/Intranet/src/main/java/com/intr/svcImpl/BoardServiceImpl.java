package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.dao.BoardDao;
import com.intr.dao.MainDao;
import com.intr.dao.UtilDao;
import com.intr.svc.BoardService;
import com.intr.svc.UtilService;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	//
	@Autowired
	MainDao mainDao;
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	UtilDao utilDao;
	
	@Autowired
	HttpServletRequest request;
	
	// 공지사항 목록 조회
	public void intrBoardInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공지사항 목록
			//--------------------------------------------------------------------------------------------
			defaultList = boardDao.intrBoardInqy1010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// 페이지 변수 저장
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL", "intrBoardInqy2010.do");
			//
			if(defaultList!=null && defaultList.size()!=0) {
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
			throw new Exception(e.getMessage());
		}
	}

	// 공지사항 목록 건수 조회
	public void intrBoardInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공지사항 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardDao.intrBoardInqy1020(model, paramMap);
			paramMap.put("rowTotal", defaultInfo.get("listCnt"));

			//--------------------------------------------------------------------------------------------
			// 페이지 (공지사항) 변수 처리
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL","intrBoardInqy2010.do");

			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 공지사항 상세화면 조회
	public void intrBoardInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공지사항 상세 정보
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardDao.intrBoardInqy1030(model, paramMap);
			model.addAttribute("defaultInfo",defaultInfo);

			//--------------------------------------------------------------------------------------------
			// 파일 정보
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqy1010(model, paramMap);
			model.addAttribute("defaultList",defaultList);

			//--------------------------------------------------------------------------------------------
			// 조회수 처리
			//--------------------------------------------------------------------------------------------
			HttpSession session = request.getSession();
			String readhit = (String)session.getAttribute("readhit");
			//
			if(readhit==null) {
				boardDao.intrBoardProc1040(model, paramMap);
				session.setAttribute("readhit", "hit");
			}

			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 공지사항 등록
	public String intrBoardProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 시퀀스 채번 (컨텐츠)
			//--------------------------------------------------------------------------------------------
			defaultInfo = mainDao.intrMainInqy1030();
			paramMap.put("contentIdx", defaultInfo.get("contentIdx"));

			//--------------------------------------------------------------------------------------------
			// 공지사항 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardDao.intrBoardInqy1030(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 공지사항 등록 (INTR_BOARD)
			//--------------------------------------------------------------------------------------------
			if(defaultInfo!=null) {
				resStr = "EXISTS";
			} else {
				// 등록
				resInt = boardDao.intrBoardProc1010(paramMap);
				//
				if(resInt>0) {
					resStr = "YES";
				}
			}

			//--------------------------------------------------------------------------------------------
			// 파일 등록 (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			if(!request.getFiles("fileList").isEmpty()) {
				resStr = utilService.intrFileProc1010(model, paramMap, request);
			}

			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}
	
	// 공지사항 삭제
	public String intrBoardProc1020(Model model, String [] delIdxArr) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 값 세팅
			//--------------------------------------------------------------------------------------------
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("delIdxArr", delIdxArr);

			//--------------------------------------------------------------------------------------------
			// 공지사항 삭제
			//--------------------------------------------------------------------------------------------
			resInt = boardDao.intrBoardProc1020(paramMap);

			//--------------------------------------------------------------------------------------------
			// 파일 수정 (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			utilDao.intrFileProc1050(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			if(resInt>0) {
				resStr = "YES";
			}
			//
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}
	
	// 공지사항 수정
	public String intrBoardProc1030(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공지사항 수정 (INTR_BOARD)
			//--------------------------------------------------------------------------------------------
			resInt = boardDao.intrBoardProc1030(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 파일 수정 (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			resStr = utilService.intrFileProc1010(model, paramMap, request);

			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			if(resInt>0) {
				resStr = "YES";
			}
			//
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}

}
