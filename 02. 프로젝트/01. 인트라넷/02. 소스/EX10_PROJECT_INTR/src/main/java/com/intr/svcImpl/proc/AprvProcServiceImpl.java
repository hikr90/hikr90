package com.intr.svcImpl.proc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.constant.IntrConst;
import com.intr.dao.inqy.CoreInqyDao;
import com.intr.dao.proc.AprvProcDao;
import com.intr.dao.proc.AuthProcDao;
import com.intr.dao.proc.FileProcDao;
import com.intr.dao.proc.TempProcDao;
import com.intr.dao.proc.TaskProcDao;
import com.intr.svc.proc.AprvProcService;
import com.intr.svc.proc.AuthProcService;
import com.intr.svc.proc.FileProcService;
import com.intr.svc.proc.TempProcService;
import com.intr.svc.proc.TaskProcService;

@Service
@Transactional
public class AprvProcServiceImpl implements AprvProcService{
	//
	@Autowired
	AprvProcDao aprvProcDao;
	
	@Autowired
	CoreInqyDao coreInqyDao;

	@Autowired
	FileProcDao fileProcDao;
	
	@Autowired
	FileProcService fileProcService;

	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 기안문 등록
	public String intrAprvProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 시퀀스 채번 (컨텐츠)
			//--------------------------------------------------------------------------------------------
			defaultInfo = coreInqyDao.intrCoreInqy10301010();
			paramMap.put("contentIdx", defaultInfo.get("contentIdx"));

			//--------------------------------------------------------------------------------------------
			// 기안문 등록 (INTR_APRV, INTR_APRV_STATUS)
			//--------------------------------------------------------------------------------------------
			resStr = this.intrAprvProc101011(model, paramMap);
			
			
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
			logger.debug("[서비스] 품의문 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}

	// 기안문 등록 (INTR_APRV, INTR_APRV_STATUS)
	private String intrAprvProc101011(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		String resStr = "NO";
		//
		try {
			//
			HashMap<String, Object> tempMap = null;
			String tempSave = (String)paramMap.get("tempSave");
			String aprvStr = (String)paramMap.get("aprvLine");
			String [] aprvLine = aprvStr.split("\\|");
			

			// 결재선 분리

			
			//--------------------------------------------------------------------------------------------
			// 기안문 등록
			//--------------------------------------------------------------------------------------------
			for(int i=0;i<aprvLine.length;i++) {
				// 품의문 정보
				tempMap = new HashMap<String, Object>();
				tempMap.put("aprvIdx", (String)paramMap.get("contentIdx"));			// 컨텐츠 ID
				tempMap.put("aprvTitle", (String)paramMap.get("aprvTitle"));		// 품의문 제목
				tempMap.put("aprvContent", (String)paramMap.get("aprvContent"));	// 품의문 내용
				
				// 결재선 정보
				String [] statLine = aprvLine[i].split("@");
				tempMap.put("aprvEmpIdx", statLine[0]);								// 결재선 사번
				tempMap.put("statusCd", statLine[1]);								// 결재 단계 (기안, 결재, 참조, 반려, 회수)
				tempMap.put("stepCd", IntrConst.STAT_0003);							// 진행 완료
				
				//--------------------------------------------------------------------------------------------
				// 임시저장 처리
				//--------------------------------------------------------------------------------------------
				if(i==0) { // 첫 단계
					if(tempSave.equals("Y")) { // 임시 저장
						tempMap.put("stepCd", IntrConst.STAT_0001);		// 임시 저장
					}
					// INTR_APRV
					resInt = aprvProcDao.intrAprvProc10101010(tempMap);

				} else {
					// 첫 단계가 아닌 경우 (INTR_APRV_STATUS)
					tempMap.put("stepCd", IntrConst.STAT_0002);		// 대기
					resInt = aprvProcDao.intrAprvProc10101020(tempMap);
				}
			}
			//
			if(resInt>0) {
				resStr = "YES";
			}
			
		} catch (Exception e) {
			//
			logger.debug("[서비스 메소드] 품의문 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return resStr;
	}
}
