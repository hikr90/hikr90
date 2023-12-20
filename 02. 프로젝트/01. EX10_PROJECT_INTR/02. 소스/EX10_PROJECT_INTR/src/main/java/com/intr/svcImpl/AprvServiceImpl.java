package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.comm.AprvLine;
import com.intr.dao.AprvDao;
import com.intr.dao.MainDao;
import com.intr.svc.AprvService;

@Service
@Transactional
public class AprvServiceImpl implements AprvService{
	//
	@Autowired
	AprvDao aprvDao;
	
	@Autowired
	MainDao mainDao;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 기안 목록 조회
	public void intrAprvInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy10101010(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 기안 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 결재선 상세 정보 조회
	public void intrAprvInqy102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 상세 정보 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqy10102010(model, paramMap);
			model.addAttribute("aprvDetInfo", defaultInfo);

			//--------------------------------------------------------------------------------------------
			// 현재 결재 정보 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqy10102011(model, paramMap);
			model.addAttribute("currAprvInfo", defaultInfo);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 결재 상세 정보 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}

	}
	
	// 결재 목록 조회
	public void intrAprvInqy201010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy20101010(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 결재 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

	// 나의 기안 목록 조회
	public void intrAprvInqy103010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy10301010(model, paramMap);
			model.addAttribute("aprvReqList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 나의 기안 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 나의 결재 목록 조회
	public void intrAprvInqy103011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy10301110(model, paramMap);
			model.addAttribute("aprvRecList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[서비스] 나의 결재 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 기안문 등록
	public String intrAprvProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		String defaultStr = "";
		String resStr = "NO";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 시퀀스 채번 (컨텐츠)
			//--------------------------------------------------------------------------------------------
			defaultInfo = mainDao.intrMainInqy10301010();
			paramMap.put("contentIdx", defaultInfo.get("contentIdx"));

			//--------------------------------------------------------------------------------------------
			// 기안문 등록 (INTR_APRV, INTR_APRV_STATUS)
			//--------------------------------------------------------------------------------------------
			resStr = this.intrAprvProc101011(model, paramMap);

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
			String [] aprvLine = aprvStr.split(AprvLine.VERTICAL_BAR);
			
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
				String [] stepLine = aprvLine[i].split(AprvLine.AT_SIGN);
				tempMap.put("aprvEmpIdx", stepLine[0]);								// 결재선 사번
				tempMap.put("stepCd", stepLine[1]);									// 결재 단계 (기안, 결재, 참조, 반려, 회수)
				tempMap.put("lastAprvYn", "N");										// 최종결재자여부
				
				//--------------------------------------------------------------------------------------------
				// 결재 정보 등록
				//--------------------------------------------------------------------------------------------
				if(flag.equals("N") && stepLine[1].equals(AprvLine.STEP_0002)) { // 첫번 째 결재 단계인 경우 저장
					flag = "Y";
					resInt = aprvDao.intrAprvProc10101010(tempMap);
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
				resInt = aprvDao.intrAprvProc10101020(tempMap);
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
				paramMap.put("stepCd", AprvLine.STEP_0004);
				resInt = this.aprvReturn(model, paramMap);
				
			} else if(aprvGb.equals("1")) {
				//--------------------------------------------------------------------------------------------
				// 결재 처리
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", AprvLine.STEP_0002);
				resInt = this.aprvConfirm(model, paramMap);
				
			} else {
				//--------------------------------------------------------------------------------------------
				// 결재 취소
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", AprvLine.STEP_0005);
				resInt = this.aprvWithdraw(model, paramMap);
			}; 
			
			
			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			if(resInt>0) {
				resStr = "YES";
			} else if(resInt<0) {
				resStr = "EXIST";
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
		resInt = aprvDao.intrAprvProc10101022(model, paramMap);

		//--------------------------------------------------------------------------------------------
		// RSLT 수정
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProc10101021(model, paramMap);
		//
		return resInt;
	}

	// 결재 반려
	private int aprvReturn(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		paramMap.put("tempStepCd", AprvLine.STEP_0004);
		
		//--------------------------------------------------------------------------------------------
		// 현 단계 반송으로 변경 (INTR_APRV)
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProc10101025(model, paramMap);

		//--------------------------------------------------------------------------------------------
		// 현 단계 반송으로 변경 (INTR_APRV_LINE)
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProc10101026(model, paramMap);
		//
		return resInt;
	}

	// 결재 취소
	private int aprvWithdraw(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		String cancelYn = "";
		int resInt = 0;
		
		//--------------------------------------------------------------------------------------------
		// 결재 상태 확인
		//--------------------------------------------------------------------------------------------
		defaultInfo = aprvDao.intrAprvInqy10102011(model, paramMap);
		paramMap.put("tempAprvSno", "0001");
		paramMap.put("tempStepCd", AprvLine.STEP_0005);
		//
		if(defaultInfo!=null) {
			cancelYn = String.valueOf(defaultInfo.get("cancelYn"));
			//
			if(cancelYn.equals("Y")) {
				//--------------------------------------------------------------------------------------------
				// 현 단계 회수로 변경 (INTR_APRV)
				//--------------------------------------------------------------------------------------------
				resInt = aprvDao.intrAprvProc10101023(model, paramMap);

				//--------------------------------------------------------------------------------------------
				// 현 단계 회수로 변경 (INTR_APRV_LINE)
				//--------------------------------------------------------------------------------------------
				resInt = aprvDao.intrAprvProc10101024(model, paramMap);

			} else {
				//
				resInt = -1;
			}
		}
		//
		return resInt;
	}

}
