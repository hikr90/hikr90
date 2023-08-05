package com.intr.svcImpl.proc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.javassist.compiler.ast.IntConst;
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
		String flag = "N";
		//
		try {
			//
			HashMap<String, Object> tempMap = null;
			String aprvStr = (String)paramMap.get("aprvLine");
			String [] aprvLine = aprvStr.split(IntrConst.VERTICAL_BAR);
			
			//--------------------------------------------------------------------------------------------
			// 기안문 등록
			//--------------------------------------------------------------------------------------------
			for(int i=0;i<aprvLine.length;i++) {
				// 품의문 정보
				tempMap = new HashMap<String, Object>();
				tempMap.put("aprvIdx", (String)paramMap.get("contentIdx"));			// 컨텐츠 IDX
				tempMap.put("empIdx", (String)paramMap.get("empIdx"));				// EMP IDX
				tempMap.put("templateCd", (String)paramMap.get("templateCd"));		// 템플릿 CD
				tempMap.put("aprvSno", i + 1);										// 컨텐츠 SNO
				tempMap.put("aprvTitle", (String)paramMap.get("aprvTitle"));		// 품의문 제목
				tempMap.put("aprvContent", (String)paramMap.get("aprvContent"));	// 품의문 내용
				tempMap.put("efctSdt", (String)paramMap.get("efctSdt"));			// 시행일자 (시작)
				tempMap.put("efctEdt", (String)paramMap.get("efctEdt"));			// 시행일자 (종료)
				
				// 결재선 정보
				String [] stepLine = aprvLine[i].split(IntrConst.AT_SIGN);
				tempMap.put("aprvEmpIdx", stepLine[0]);								// 결재선 사번
				tempMap.put("stepCd", stepLine[1]);									// 결재 단계 (기안, 결재, 참조, 반려, 회수)
				tempMap.put("lastAprvYn", "N");										// 최종결재자여부
				
				//--------------------------------------------------------------------------------------------
				// 결재 정보 등록
				//--------------------------------------------------------------------------------------------
				if(flag.equals("N") && stepLine[1].equals(IntrConst.STEP_0002)) { // 첫번 째 결재 단계인 경우 저장
					flag = "Y";
					resInt = aprvProcDao.intrAprvProc10101010(tempMap);
				}
				
				//--------------------------------------------------------------------------------------------
				// 최종 결재자 여부 지정
				//--------------------------------------------------------------------------------------------
				if(i==aprvLine.length-1) {
					tempMap.put("lastAprvYn", "Y");	
				}

				//--------------------------------------------------------------------------------------------
				// 결재선 정보 등록
				//--------------------------------------------------------------------------------------------
				resInt = aprvProcDao.intrAprvProc10101020(tempMap);
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
	
	// 결재 수신 처리
	public String intrAprvProc102010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		String aprvGb = (String)paramMap.get("aprvGb"); // 결재, 반송 여부
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 수신 처리 (반려:0, 결재:1, 취소:2)
			//--------------------------------------------------------------------------------------------
			if(aprvGb.equals("0")) {
				//--------------------------------------------------------------------------------------------
				// 반려 처리 
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", IntrConst.STEP_0004);
				resInt = this.aprvReturn(model, paramMap);
				
			} else if(aprvGb.equals("1")) {
				//--------------------------------------------------------------------------------------------
				// 결재 처리
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", IntrConst.STEP_0002);
				resInt = this.aprvConfirm(model, paramMap);
				
			} else {
				//--------------------------------------------------------------------------------------------
				// 결재 취소
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", IntrConst.STEP_0005);
				resInt = this.aprvWithdraw(model, paramMap);
			}; 
			
			
			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			if(resInt!=0) {
				resStr = "YES";
			}
			//
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 결재 수신 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}

	// 결재 승인
	private int aprvConfirm(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		
		//--------------------------------------------------------------------------------------------
		// CURR_APRV_SNO 수정
		//--------------------------------------------------------------------------------------------
		resInt = aprvProcDao.intrAprvProc10101022(model, paramMap);

		//--------------------------------------------------------------------------------------------
		// RSLT 수정
		//--------------------------------------------------------------------------------------------
		resInt = aprvProcDao.intrAprvProc10101021(model, paramMap);
		//
		return resInt;
	}

	// 결재 반려
	private int aprvReturn(Model model, HashMap<String, Object> paramMap) {
		//
		return 0;
	}

	// 결재 취소
	private int aprvWithdraw(Model model, HashMap<String, Object> paramMap) {
		//
		return 0;
	}
}
