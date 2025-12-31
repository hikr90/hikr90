package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.dao.AprvDao;
import com.intr.dao.CoreDao;
import com.intr.dao.EmpDao;
import com.intr.dao.TempDao;
import com.intr.dao.UtilDao;
import com.intr.svc.AprvService;
import com.intr.svc.UtilService;
import com.intr.utils.Const;

import net.sf.json.JSONArray;

@Service
@Transactional(rollbackFor = Exception.class)
public class AprvServiceImpl implements AprvService{
	//
	@Autowired
	AprvDao aprvDao;
	
	@Autowired
	CoreDao coreDao;
	
	@Autowired
	TempDao tempDao;

	@Autowired
	EmpDao empDao;
	
	@Autowired
	UtilDao utilDao;
	
	@Autowired
	UtilService utilService;
	
	// 기안 목록 조회
	public void intrAprvInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안 목록 조회
			//--------------------------------------------------------------------------------------------

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 기안 등록 양식 조회
	public void intrAprvInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		HashMap<String, Object> defaultInfo = null;
		String temptypeCd = utilService.nvlProc((String)paramMap.get("temptypeCd"));
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안 양식 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = tempDao.intrTempInqy1021(model, paramMap);
			model.addAttribute("tempInfo", defaultInfo);
			
			//--------------------------------------------------------------------------------------------
			// 휴가 신청서
			//--------------------------------------------------------------------------------------------
			if(temptypeCd.equals("Leav")) {
				//--------------------------------------------------------------------------------------------
				// 공통코드 (휴가 타입) 조회
				//--------------------------------------------------------------------------------------------
				paramMap.put("commcodeGcd", 	"LEAV");
				defaultList = utilDao.intrCodeInqy1011(paramMap);
				model.addAttribute("leavList",defaultList);
			}
			
			//--------------------------------------------------------------------------------------------
			// 가지급결의서
			//--------------------------------------------------------------------------------------------
			else if(temptypeCd.equals("Exp")) {
				//--------------------------------------------------------------------------------------------
				// 공통코드 (지급 방법) 조회
				//--------------------------------------------------------------------------------------------
				paramMap.put("commcodeGcd", 	"PAY");
				defaultList = utilDao.intrCodeInqy1011(paramMap);
				model.addAttribute("prepayList",defaultList);
			}

			//--------------------------------------------------------------------------------------------
			// 물품반출입 신청서
			//--------------------------------------------------------------------------------------------
			else if(temptypeCd.equals("Item")) {
				//--------------------------------------------------------------------------------------------
				// 공통코드 (요청 구분) 조회
				//--------------------------------------------------------------------------------------------
				paramMap.put("commcodeGcd", 	"REQ");
				defaultList = utilDao.intrCodeInqy1011(paramMap);
				model.addAttribute("reqList",defaultList);
			}
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 결재 목록 조회
	public void intrAprvInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 페이징 처리
			//--------------------------------------------------------------------------------------------
			utilService.setPaging(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 결재 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy1011(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
			//--------------------------------------------------------------------------------------------
			// 공통코드 (결재단계) 조회
			//--------------------------------------------------------------------------------------------
			paramMap.put("commcodeGcd", 	"STEP");
			defaultList = utilDao.intrCodeInqy1011(paramMap);
			model.addAttribute("stepList",defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 결재 상세 조회
	public void intrAprvInqy2020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 상세 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqy1012(model, paramMap);
			model.addAttribute("defaultInfo", defaultInfo);
			
			//--------------------------------------------------------------------------------------------
			// 결재 상태 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqy2011(model, paramMap);
			model.addAttribute("aprvInfo", defaultInfo);
			
			//--------------------------------------------------------------------------------------------
			// 파일 정보
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqy1011(model, paramMap);
			model.addAttribute("fileList",defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// 연차 공유 조회
	public void intrAprvInqy3010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		JSONArray jAray = new JSONArray();
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 연차 공유 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy3011(model, paramMap);
			model.addAttribute("defaultList", jAray.fromObject(defaultList));
			
			//--------------------------------------------------------------------------------------------
			// 공통코드 (휴가 타입) 조회
			//--------------------------------------------------------------------------------------------
			paramMap.put("commcodeGcd", 	"LEAV");
			defaultList = utilDao.intrCodeInqy1011(paramMap);
			model.addAttribute("leavList",defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 결재선 관리 조회
	public void intrAprvInqy4010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재선 관리 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy4011(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
			//--------------------------------------------------------------------------------------------
			// 부서 사원 트리 조회
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy2031(model, paramMap);
			model.addAttribute("empList",defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 결재선 등록 조회
	public void intrAprvInqy4020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공통코드 (결재선) 조회
			//--------------------------------------------------------------------------------------------
			paramMap.put("commcodeGcd", 	"TYPE");
			defaultList = utilDao.intrCodeInqy1011(paramMap);
			model.addAttribute("typeList",defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 결재선 상세 조회
	public void intrAprvInqy4030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재선 상세 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy4031(model, paramMap);
			model.addAttribute("aprvlineList", defaultList);
			
			//--------------------------------------------------------------------------------------------
			// 공통코드 (결재선) 조회
			//--------------------------------------------------------------------------------------------
			paramMap.put("commcodeGcd", 	"TYPE");
			defaultList = utilDao.intrCodeInqy1011(paramMap);
			model.addAttribute("typeList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// 결재 타입 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy4032(model, paramMap);
			model.addAttribute("aprvtypeList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 기안 등록
	public String intrAprvProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "YES";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 채번
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqy1010(model, paramMap);
			paramMap.put("sequenceId", (String)defaultInfo.get("sequenceId"));
			
			//--------------------------------------------------------------------------------------------
			// 기본 정보 처리
			//--------------------------------------------------------------------------------------------
			this.intrAprvProc2010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 양식 유형 처리
			//--------------------------------------------------------------------------------------------
			this.intrAprvProc2020(model, paramMap);
			
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
	
	// 기본 정보 처리
	public void intrAprvProc2010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> tempMap = null;
		String aprvLine = utilService.nvlProc((String)paramMap.get("aprvLine"));
		String [] arrLine = aprvLine.split("@");
		String [] arrLine2 = {};
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 마스터 등록 (APRV_MAST)
			//--------------------------------------------------------------------------------------------
			aprvDao.intrAprvProc1011(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 결재 이력 등록 (APRV_HIST)
			//--------------------------------------------------------------------------------------------
			if(aprvLine == "") {
				throw new Exception("결재선이 존재하지 않습니다.");
			}
			//
			for(int i=0;i<arrLine.length;i++) {
				//
				arrLine2 = arrLine[i].split("\\|");
				tempMap = new HashMap<String, Object>();
				
				tempMap.put("sequenceId", 	(String)paramMap.get("sequenceId"));
				tempMap.put("aprvtypeCd", 	arrLine2[0]);
				tempMap.put("aprvIdx", 		arrLine2[1]);
				//
				aprvDao.intrAprvProc1012(model, tempMap);
			}
			
			//--------------------------------------------------------------------------------------------
			// 현재 단계, 번호 수정 (APRV_HIST)
			//--------------------------------------------------------------------------------------------
			aprvDao.intrAprvProc1013(model, paramMap);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 양식 유형 처리
	public void intrAprvProc2020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> tempMap = null;
		String temptypeCd = utilService.nvlProc((String)paramMap.get("temptypeCd"));
		String line = "";
		String [] arrLine = {};
		String [] arrLine2 = {};
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 양식 유형 처리
			//--------------------------------------------------------------------------------------------
			if(temptypeCd.equals("Leav")) {
				// 휴가 신청서 등록 (APRV_REL_LEAV)
				aprvDao.intrAprvProc1014(model, paramMap);
			}
			
			else if(temptypeCd.equals("Exp")) {
				// 가지급결의서 등록 (APRV_REL_EXP)
				aprvDao.intrAprvProc1015(model, paramMap);
			}

			else if(temptypeCd.equals("Item")) {
				// 물품반출입 신청서 등록 (APRV_REL_ITEM)
				line = utilService.nvlProc((String)paramMap.get("itemLine"));
				arrLine = line.split("@");
				//
				for(int i=0;i<arrLine.length;i++) {
					//
					arrLine2 = arrLine[i].split("\\|");
					tempMap = new HashMap<String, Object>();
					
					tempMap.put("sequenceId", 		(String)paramMap.get("sequenceId"));
					tempMap.put("projCd", 				(String)paramMap.get("projPcd"));
					tempMap.put("reqDt", 				(String)paramMap.get("reqDt"));
					tempMap.put("reqtypeCd", 		(String)paramMap.get("reqtypeCd"));
					tempMap.put("mgtNo", 				arrLine2[0]);
					tempMap.put("itemNm", 			arrLine2[1]);
					tempMap.put("itemCnt", 			arrLine2[2]);
					tempMap.put("reqRsn", 				arrLine2[3]);
					
					aprvDao.intrAprvProc1016(model, tempMap);
				}
			}
			
			else if(temptypeCd.equals("Corp")) {
				// 법인카드 정산서 등록 (APRV_REL_CORP)
				line = utilService.nvlProc((String)paramMap.get("corpLine"));
				arrLine = line.split("@");
				
				for(int i=0;i<arrLine.length;i++) {
					//
					arrLine2 = arrLine[i].split("\\|");
					tempMap = new HashMap<String, Object>();
					
					tempMap.put("sequenceId", 	(String)paramMap.get("sequenceId"));
					tempMap.put("projCd", 			(String)paramMap.get("projPcd"));
					tempMap.put("cardNm", 		(String)paramMap.get("cardNm"));
					tempMap.put("cardNo", 		(String)paramMap.get("cardNo"));
					tempMap.put("useLoc", 			arrLine2[0]);
					tempMap.put("useAmt", 			arrLine2[1]);
					tempMap.put("useRsn", 			arrLine2[2]);
					tempMap.put("useDt",	 		arrLine2[3]);
					
					aprvDao.intrAprvProc1017(model, tempMap);
				}
			}
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 결재 처리
	public void intrAprvProc3010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> tempMap = null;
		String sequenceId = utilService.nvlProc((String)paramMap.get("sequenceId"));
		String currAprvSno = utilService.nvlProc((String)paramMap.get("currAprvSno"));
		String rslttypeCd = utilService.nvlProc((String)paramMap.get("rslttypeCd"));
		String rsltNote = utilService.nvlProc((String)paramMap.get("rsltNote"));
		//
		try {
			// 결재 승인
			if(rslttypeCd.equals(Const.RSLT_0010)) {
				//--------------------------------------------------------------------------------------------
				// 다음 결재 조회
				//--------------------------------------------------------------------------------------------
				tempMap = aprvDao.intrAprvInqy2012(model, paramMap);
				
				if(tempMap == null) {
					tempMap = new HashMap<String, Object>();
					tempMap.put("sequenceId", sequenceId);
					tempMap.put("currAprvSno", currAprvSno);
					tempMap.put("rslttypeCd", rslttypeCd);
					
					// APRVSTEP_CD 수정
					paramMap.put("stepCd", Const.STEP_0020);		// 결재 완료
					aprvDao.intrAprvProc2011(model, paramMap);
					
				}  else {
					// CURR_APRV_SNO 수정
					aprvDao.intrAprvProc2013(model, tempMap);
				}
				
				// RSLT 수정
				tempMap = new HashMap<String, Object>();
				tempMap.put("sequenceId", sequenceId);
				tempMap.put("currAprvSno", currAprvSno);
				tempMap.put("rslttypeCd", rslttypeCd);
				tempMap.put("rsltNote", rsltNote);

				aprvDao.intrAprvProc2012(model, tempMap);
				
			} 
			
			// 결재 반송
			else if(rslttypeCd.equals(Const.RSLT_0020)) {
				// APRVSTEP_CD 수정
				paramMap.put("stepCd", Const.STEP_0030);			// 결재반송
				aprvDao.intrAprvProc2011(model, paramMap);
				
				// RSLT 수정
				aprvDao.intrAprvProc2012(model, paramMap);
			}
			
			// 결재 취소
			else if(rslttypeCd.equals(Const.RSLT_0030)) {
				// APRVSTEP_CD 수정
				paramMap.put("stepCd", Const.STEP_0040);			// 결재취소
				aprvDao.intrAprvProc2011(model, paramMap);
				
				// CURR_APRV_SNO 수정
				paramMap.put("currAprvSno", "0001");						// 기안 단계 번호
				aprvDao.intrAprvProc2013(model, paramMap);
				
				// RSLT 수정
				aprvDao.intrAprvProc2012(model, paramMap);
			}
			
			// 오류
			else {
				throw new Exception("Exception : 결재 처리 중 에러가 발생했습니다.");
			}
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 결재선 저장 처리
	@SuppressWarnings("unchecked")
	public String intrAprvProc4010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		HashMap<String, Object> defaultInfo = null;
		HashMap<String, Object> tempMap = null;
		String sequenceId = utilService.nvlProc((String)paramMap.get("sequenceId"));
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//
			if(sequenceId == "") {
				//--------------------------------------------------------------------------------------------
				// 결재 채번
				//--------------------------------------------------------------------------------------------
				defaultInfo = aprvDao.intrAprvInqy2010(model, paramMap);
				sequenceId = (String)defaultInfo.get("sequenceId");
				paramMap.put("sequenceId", sequenceId);

				//--------------------------------------------------------------------------------------------
				// 결재선 마스터 (APRV_LINE_MAST) 등록
				//--------------------------------------------------------------------------------------------
				aprvDao.intrAprvProc4011(model, paramMap);
				
			} else {
				//--------------------------------------------------------------------------------------------
				// 결재선 마스터 (APRV_LINE_MAST) 수정
				//--------------------------------------------------------------------------------------------
				aprvDao.intrAprvProc4013(model, paramMap);
				
				//--------------------------------------------------------------------------------------------
				// 결재선 상세 (APRV_LINE_DETL) 삭제
				//--------------------------------------------------------------------------------------------
				aprvDao.intrAprvProc4015(model, paramMap);
			}
			
			//--------------------------------------------------------------------------------------------
			// 결재선 상세 (APRV_LINE_DETL) 등록
			//--------------------------------------------------------------------------------------------
			ObjectMapper objMapper = new ObjectMapper();
			defaultList = objMapper.readValue((String)paramMap.get("aprvlineList"), List.class);
			//
			for(HashMap<String, Object> list : defaultList) {
				tempMap = new HashMap<String, Object>();
				//
				tempMap.put("sequenceId", utilService.nvlProc((String)paramMap.get("sequenceId")));
				tempMap.put("aprvIdx", utilService.nvlProc((String)list.get("aprvIdx")));
				tempMap.put("aprvtypeCd", utilService.nvlProc((String)list.get("aprvtypeCd")));
				//
				resInt += aprvDao.intrAprvProc4012(model, tempMap);
			}
			
			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			if(resInt == defaultList.size()) {
				resStr = "YES";
			}
			
			defaultStr = String.format("[{'res':'%s'}]", resStr);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return defaultStr;
	}
	
	// 결재선 삭제 처리
	public String intrAprvProc4020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "YES";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재선 마스터 (APRV_LINE_MAST) 삭제
			//--------------------------------------------------------------------------------------------
			aprvDao.intrAprvProc4014(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 결재선 상세 (APRV_LINE_DETL) 삭제
			//--------------------------------------------------------------------------------------------
			aprvDao.intrAprvProc4015(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 결과 반환
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return defaultStr;
	}
}
