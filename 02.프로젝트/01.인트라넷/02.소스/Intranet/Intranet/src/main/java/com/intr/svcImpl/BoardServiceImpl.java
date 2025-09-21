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
import com.intr.dao.UtilDao;
import com.intr.svc.BoardService;
import com.intr.svc.CoreService;
import com.intr.svc.EmpService;
import com.intr.svc.MainService;
import com.intr.svc.UtilService;

@Service
@Transactional(rollbackFor = Exception.class)
public class BoardServiceImpl implements BoardService{
	//
	@Autowired
	HttpServletRequest request;

	@Autowired
	CoreService coreService;

	@Autowired
	MainService mainService;
	
	@Autowired
	EmpService empService;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	UtilDao utilDao;
	
	// 공지사항 목록 조회
	public void intrBoardInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 페이징 처리
			//--------------------------------------------------------------------------------------------
			utilService.setPaging(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 공지사항 목록
			//--------------------------------------------------------------------------------------------
			defaultList = boardDao.intrBoardInqy1011(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// 공통코드 (사용여부) 조회
			//--------------------------------------------------------------------------------------------
			paramMap.put("commcodeGcd", 	"USE");
			defaultList = utilDao.intrCodeInqy1011(paramMap);
			model.addAttribute("useList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// 조회수 세션 초기화
			//--------------------------------------------------------------------------------------------
			request.getSession().removeAttribute("readHit");
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// 공지사항 상세화면 조회
	public void intrBoardInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공지사항 상세 정보
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardDao.intrBoardInqy1021(model, paramMap);
			model.addAttribute("defaultInfo",defaultInfo);

			//--------------------------------------------------------------------------------------------
			// 파일 정보
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqy1011(model, paramMap);
			model.addAttribute("fileList",defaultList);

			//--------------------------------------------------------------------------------------------
			// 조회수 처리
			//--------------------------------------------------------------------------------------------
			HttpSession session = request.getSession();
			String readHit = (String)session.getAttribute("readHit");
			//
			if(readHit==null) {
				boardDao.intrBoardProc1032(model, paramMap);
				session.setAttribute("readHit", "hit");
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
			// 공지사항 채번
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardDao.intrBoardInqy1010(model, paramMap);
			paramMap.put("sequenceId", (String)defaultInfo.get("sequenceId"));
			
			//--------------------------------------------------------------------------------------------
			// 공지사항 등록
			//--------------------------------------------------------------------------------------------
			resInt = boardDao.intrBoardProc1011(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}

			//--------------------------------------------------------------------------------------------
			// 파일 등록
			//--------------------------------------------------------------------------------------------
			resStr = utilService.fileUpload(model, paramMap, request);
			
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
			resInt = boardDao.intrBoardProc1021(paramMap);

			//--------------------------------------------------------------------------------------------
			// 파일 삭제 처리 (삭제)
			//--------------------------------------------------------------------------------------------
			utilDao.intrFileProc1022(paramMap);
			
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
			// 공지사항 수정
			//--------------------------------------------------------------------------------------------
			resInt = boardDao.intrBoardProc1031(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 파일 수정
			//--------------------------------------------------------------------------------------------
			resStr = utilService.fileUpload(model, paramMap, request);

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
