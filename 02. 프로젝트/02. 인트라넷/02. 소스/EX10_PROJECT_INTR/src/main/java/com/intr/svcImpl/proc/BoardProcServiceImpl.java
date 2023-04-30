package com.intr.svcImpl.proc;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.dao.inqy.BoardInqyDao;
import com.intr.dao.inqy.CoreInqyDao;
import com.intr.dao.proc.BoardProcDao;
import com.intr.dao.proc.FileProcDao;
import com.intr.svc.proc.BoardProcService;
import com.intr.svc.proc.FileProcService;

@Service
@Transactional
public class BoardProcServiceImpl implements BoardProcService{
	//
	@Autowired
	BoardProcDao boardProcDao;
	
	@Autowired
	BoardInqyDao boardInqyDao;
	
	@Autowired
	CoreInqyDao coreInqyDao;

	@Autowired
	FileProcDao fileProcDao;
	
	@Autowired
	FileProcService fileProcService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 공지사항 등록
	public String intrBoardProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
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
			defaultInfo = coreInqyDao.intrCoreInqy10301010();
			paramMap.put("contentIdx", defaultInfo.get("contentIdx"));

			//--------------------------------------------------------------------------------------------
			// 공지사항 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardInqyDao.intrBoardInqy10102010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 공지사항 등록 (INTR_BOARD)
			//--------------------------------------------------------------------------------------------
			if(defaultInfo!=null) {
				resStr = "EXISTS";
			} else {
				// 등록
				resInt = boardProcDao.intrBoardProc10101010(paramMap);
				//
				if(resInt>0) {
					resStr = "YES";
				}
			}

			//--------------------------------------------------------------------------------------------
			// 파일 등록 (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			if(!request.getFiles("fileList").isEmpty()) {
				resStr = fileProcService.intrFileProc101010(model, paramMap, request);
			}

			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 공지사항 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}
	
	// 공지사항 삭제
	public String intrBoardProc102010(Model model, String [] delIdxArr) {
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
			resInt = boardProcDao.intrBoardProc10201010(paramMap);

			//--------------------------------------------------------------------------------------------
			// 파일 수정 (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			fileProcDao.intrFileProc10101030(paramMap);
			
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
			logger.debug("[서비스] 공지사항 삭제 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}
	
	// 공지사항 수정
	public String intrBoardProc103010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공지사항 수정 (INTR_BOARD)
			//--------------------------------------------------------------------------------------------
			resInt = boardProcDao.intrBoardProc10103010(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 파일 수정 (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			resStr = fileProcService.intrFileProc101010(model, paramMap, request);

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
			logger.debug("[서비스] 공지사항 수정 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}

}
