package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.dao.AprvDao;
import com.intr.dao.MainDao;
import com.intr.svc.AprvService;
import com.intr.utils.AprvLine;

@Service
@Transactional
public class AprvServiceImpl implements AprvService{
	//
	@Autowired
	AprvDao aprvDao;
	
	@Autowired
	MainDao mainDao;
	
	// 기안 목록 조회
	public void intrAprvInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqyDao1010(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 결재선 상세 정보 조회
	public void intrAprvInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 상세 정보 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqyDao1020(model, paramMap);
			model.addAttribute("aprvDetInfo", defaultInfo);

			//--------------------------------------------------------------------------------------------
			// 현재 결재 정보 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqyDao1040(model, paramMap);
			model.addAttribute("currAprvInfo", defaultInfo);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}

	}
	
	// 결재 목록 조회
	public void intrAprvInqyService1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqyDao1050(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// 나의 기안 목록 조회
	public void intrAprvInqyService1040(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 나의 기안 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqyDao1060(model, paramMap);
			model.addAttribute("aprvReqList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 나의 결재 목록 조회
	public void intrAprvInqyService1050(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 나의 결재 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqyDao1070(model, paramMap);
			model.addAttribute("aprvRecList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 기안문 등록
	public String intrAprvProcService1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 시퀀스 채번
			//--------------------------------------------------------------------------------------------
			defaultInfo = mainDao.intrMainInqyDao1030();
			paramMap.put("contId", defaultInfo.get("contId"));

			//--------------------------------------------------------------------------------------------
			// 기안문 등록
			//--------------------------------------------------------------------------------------------
			resStr = this.intrAprvProcService1030(model, paramMap);

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

	// 결재 수신 처리
	public String intrAprvProcService1020(Model model, HashMap<String, Object> paramMap) throws Exception {
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
				resInt = this.intrAprvProcService1022(model, paramMap);
				
			} else if(aprvGb.equals("1")) {
				//--------------------------------------------------------------------------------------------
				// 결재 처리
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", AprvLine.STEP_0002);
				resInt = this.intrAprvProcService1021(model, paramMap);
				
			} else {
				//--------------------------------------------------------------------------------------------
				// 결재 취소
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", AprvLine.STEP_0005);
				resInt = this.intrAprvProcService1023(model, paramMap);
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
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}
	
	// 기안문 등록
	public String intrAprvProcService1030(Model model, HashMap<String, Object> paramMap) throws Exception {
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
				tempMap.put("aprvIdx", (String)paramMap.get("contId"));			// 컨텐츠 IDX
				tempMap.put("empIdx", (String)paramMap.get("empIdx"));				// EMP IDX
				tempMap.put("tempCd", (String)paramMap.get("tempCd"));		// 템플릿 CD
				tempMap.put("aprvSno", i + 1);										// 컨텐츠 SNO
				tempMap.put("aprvTitle", (String)paramMap.get("aprvTitle"));		// 품의문 제목
				tempMap.put("aprvCont", (String)paramMap.get("aprvCont"));	// 품의문 내용
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
					resInt = aprvDao.intrAprvProcDao1010(tempMap);
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
				resInt = aprvDao.intrAprvProcDao1020(tempMap);
			}
			//
			if(resInt>0) {
				resStr = "YES";
			}
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return resStr;
	}

	// 결재 승인
	private int intrAprvProcService1021(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		int resInt = 0;
		
		//--------------------------------------------------------------------------------------------
		// 현재 결재 번호 수정
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProcDao1040(model, paramMap);

		//--------------------------------------------------------------------------------------------
		// 결과 수정
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProcDao1030(model, paramMap);
		//
		return resInt;
	}

	// 결재 반려
	private int intrAprvProcService1022(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		int resInt = 0;
		paramMap.put("tempStepCd", AprvLine.STEP_0004);
		
		//--------------------------------------------------------------------------------------------
		// 현 단계 반송으로 변경 
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProcDao1070(model, paramMap);

		//--------------------------------------------------------------------------------------------
		// 현 단계 반송으로 변경 
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProcDao1080(model, paramMap);
		//
		return resInt;
	}

	// 결재 취소
	private int intrAprvProcService1023(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String cancelYn = "";
		int resInt = 0;
		
		//--------------------------------------------------------------------------------------------
		// 결재 상태 확인
		//--------------------------------------------------------------------------------------------
		defaultInfo = aprvDao.intrAprvInqyDao1040(model, paramMap);
		paramMap.put("tempAprvSno", "0001");
		paramMap.put("tempStepCd", AprvLine.STEP_0005);
		//
		if(defaultInfo!=null) {
			cancelYn = String.valueOf(defaultInfo.get("cancelYn"));
			//
			if(cancelYn.equals("Y")) {
				//--------------------------------------------------------------------------------------------
				// 현 단계 회수로 변경 
				//--------------------------------------------------------------------------------------------
				resInt = aprvDao.intrAprvProcDao1050(model, paramMap);

				//--------------------------------------------------------------------------------------------
				// 현 단계 회수로 변경 
				//--------------------------------------------------------------------------------------------
				resInt = aprvDao.intrAprvProcDao1060(model, paramMap);

			} else {
				//
				resInt = -1;
			}
		}
		//
		return resInt;
	}
	
	// 결재 목록 건수
	public void intrAprvInqyService1060(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqyDao1080(model, paramMap);
			paramMap.put("rowTotal", defaultInfo.get("listCnt"));

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 기안 목록 건수 조회
	public void intrAprvInqyService1070(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqyDao1090(model, paramMap);
			paramMap.put("rowTotal", defaultInfo.get("listCnt"));

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
}
