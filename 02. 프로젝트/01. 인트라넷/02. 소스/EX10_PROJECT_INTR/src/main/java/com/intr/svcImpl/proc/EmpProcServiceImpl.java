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
import com.intr.dao.inqy.EmpInqyDao;
import com.intr.dao.proc.BoardProcDao;
import com.intr.dao.proc.EmpProcDao;
import com.intr.dao.proc.FileProcDao;
import com.intr.svc.proc.BoardProcService;
import com.intr.svc.proc.EmpProcService;
import com.intr.svc.proc.FileProcService;

@Service
@Transactional
public class EmpProcServiceImpl implements EmpProcService{
	//
	@Autowired
	EmpProcDao empProcDao;

	@Autowired
	EmpInqyDao empInqyDao;
	
	@Autowired
	CoreInqyDao coreInqyDao;

	@Autowired
	FileProcDao fileProcDao;
	
	@Autowired
	FileProcService fileProcService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 사원 등록
	public String intrEmpProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 시퀀스 채번 (사원)
			//--------------------------------------------------------------------------------------------
			defaultInfo = coreInqyDao.intrCoreInqy10301011();
			paramMap.put("contentIdx", defaultInfo.get("contentIdx"));

			//--------------------------------------------------------------------------------------------
			// 사원 등록
			//--------------------------------------------------------------------------------------------
			resInt = empProcDao.intrEmpProc10101010(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
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
			logger.debug("[서비스] 사원 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}
	
	// 사원 수정
	public String intrEmpProc102010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 수정
			//--------------------------------------------------------------------------------------------
			resInt = empProcDao.intrEmpProc10201010(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}

			//--------------------------------------------------------------------------------------------
			// 파일 등록 (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			resStr = fileProcService.intrFileProc101010(model, paramMap, request);

			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 사원 수정 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}
	
	// 사원 복직, 퇴사 처리
	public String intrEmpProc103010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 복직, 퇴사 처리
			//--------------------------------------------------------------------------------------------
			resInt = empProcDao.intrEmpProc10301010(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}

			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 사원 복직, 퇴사 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}
	
}