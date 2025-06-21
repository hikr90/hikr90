package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.dao.AprvDao;
import com.intr.dao.CoreDao;
import com.intr.dao.TempDao;
import com.intr.dao.UtilDao;
import com.intr.svc.AprvService;
import com.intr.svc.UtilService;
import com.intr.utils.Const;

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
	UtilDao utilDao;
	
	@Autowired
	UtilService utilService;
	
	// ��� ��� ��ȸ
	public void intrAprvInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ��� ��� ��� ��ȸ
	public void intrAprvInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		HashMap<String, Object> defaultInfo = null;
		String temptypeCd = utilService.nvlProc((String)paramMap.get("temptypeCd"));
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = tempDao.intrTempInqy1021(model, paramMap);
			model.addAttribute("tempInfo", defaultInfo);
			
			//--------------------------------------------------------------------------------------------
			// �ް� ��û��
			//--------------------------------------------------------------------------------------------
			if(temptypeCd.equals("Leav")) {
				//--------------------------------------------------------------------------------------------
				// �����ڵ� (�ް� Ÿ��) ��ȸ
				//--------------------------------------------------------------------------------------------
				paramMap.put("commcodeGcd", 	"LEAV");
				defaultList = utilDao.intrCodeInqy1011(paramMap);
				model.addAttribute("leavList",defaultList);
			}
			
			//--------------------------------------------------------------------------------------------
			// �����ް��Ǽ�
			//--------------------------------------------------------------------------------------------
			else if(temptypeCd.equals("Exp")) {
				//--------------------------------------------------------------------------------------------
				// �����ڵ� (���� ���) ��ȸ
				//--------------------------------------------------------------------------------------------
				paramMap.put("commcodeGcd", 	"PAY");
				defaultList = utilDao.intrCodeInqy1011(paramMap);
				model.addAttribute("prepayList",defaultList);
			}

			//--------------------------------------------------------------------------------------------
			// ��ǰ������ ��û��
			//--------------------------------------------------------------------------------------------
			else if(temptypeCd.equals("Item")) {
				//--------------------------------------------------------------------------------------------
				// �����ڵ� (��û ����) ��ȸ
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
	
	// ���� ��� ��ȸ
	public void intrAprvInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			utilService.setPaging(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy1011(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
			//--------------------------------------------------------------------------------------------
			// �����ڵ� (����ܰ�) ��ȸ
			//--------------------------------------------------------------------------------------------
			paramMap.put("commcodeGcd", 	"STEP");
			defaultList = utilDao.intrCodeInqy1011(paramMap);
			model.addAttribute("stepList",defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ���� �� ��ȸ
	public void intrAprvInqy2020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqy1012(model, paramMap);
			model.addAttribute("defaultInfo", defaultInfo);
			
			//--------------------------------------------------------------------------------------------
			// ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqy2011(model, paramMap);
			model.addAttribute("aprvInfo", defaultInfo);
			
			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqy1011(model, paramMap);
			model.addAttribute("fileList",defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ��� ���
	public String intrAprvProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "YES";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ä��
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqy1010(model, paramMap);
			paramMap.put("sequenceId", (String)defaultInfo.get("sequenceId"));
			
			//--------------------------------------------------------------------------------------------
			// �⺻ ���� ó��
			//--------------------------------------------------------------------------------------------
			this.intrAprvProc2010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��� ���� ó��
			//--------------------------------------------------------------------------------------------
			this.intrAprvProc3010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ���
			//--------------------------------------------------------------------------------------------
			resStr = utilService.fileUpload(model, paramMap, request);
			
			//--------------------------------------------------------------------------------------------
			// ��� ��ȯ
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}
	
	// �⺻ ���� ó��
	public void intrAprvProc2010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> tempMap = null;
		String aprvLine = utilService.nvlProc((String)paramMap.get("aprvLine"));
		String [] arrLine = aprvLine.split("@");
		String [] arrLine2 = {};
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ������ ��� (APRVMAST)
			//--------------------------------------------------------------------------------------------
			aprvDao.intrAprvProc1011(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� �̷� ��� (APRVHIST)
			//--------------------------------------------------------------------------------------------
			if(aprvLine == "") {
				throw new Exception("���缱�� �������� �ʽ��ϴ�.");
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
				aprvDao.intrAprvProc1012(tempMap);
			}
			
			//--------------------------------------------------------------------------------------------
			// ���� �ܰ�, ��ȣ ���� (APRVHIST)
			//--------------------------------------------------------------------------------------------
			aprvDao.intrAprvProc1013(paramMap);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ��� ���� ó��
	public void intrAprvProc3010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> tempMap = null;
		String temptypeCd = utilService.nvlProc((String)paramMap.get("temptypeCd"));
		String line = "";
		String [] arrLine = {};
		String [] arrLine2 = {};
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ���� ó��
			//--------------------------------------------------------------------------------------------
			if(temptypeCd.equals("Leav")) {
				// �ް� ��û�� ��� (APRV_REL_LEAV)
				aprvDao.intrAprvProc1014(paramMap);
			}
			
			else if(temptypeCd.equals("Exp")) {
				// �����ް��Ǽ� ��� (APRV_REL_EXP)
				aprvDao.intrAprvProc1015(paramMap);
			}

			else if(temptypeCd.equals("Item")) {
				// ��ǰ������ ��û�� ��� (APRV_REL_ITEM)
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
					
					aprvDao.intrAprvProc1016(tempMap);
				}
			}
			
			else if(temptypeCd.equals("Corp")) {
				// ����ī�� ���꼭 ��� (APRV_REL_CORP)
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
					
					aprvDao.intrAprvProc1017(tempMap);
				}
			}
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ���� ó��
	public void intrAprvProc4010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> tempMap = null;
		String sequenceId = utilService.nvlProc((String)paramMap.get("sequenceId"));
		String currAprvSno = utilService.nvlProc((String)paramMap.get("currAprvSno"));
		String rslttypeCd = utilService.nvlProc((String)paramMap.get("rslttypeCd"));
		String rsltNote = utilService.nvlProc((String)paramMap.get("rsltNote"));
		//
		try {
			// ���� ����
			if(rslttypeCd.equals(Const.RSLT_0010)) {
				//--------------------------------------------------------------------------------------------
				// ���� ���� ��ȸ
				//--------------------------------------------------------------------------------------------
				tempMap = aprvDao.intrAprvInqy3011(model, paramMap);
				
				if(tempMap == null) {
					tempMap = new HashMap<String, Object>();
					tempMap.put("sequenceId", sequenceId);
					tempMap.put("currAprvSno", currAprvSno);
					tempMap.put("rslttypeCd", rslttypeCd);
					
					// APRVSTEP_CD ����
					paramMap.put("stepCd", Const.STEP_0020);		// ���� �Ϸ�
					aprvDao.intrAprvProc2011(paramMap);
					
				}  else {
					// CURR_APRV_SNO ����
					aprvDao.intrAprvProc2013(tempMap);
				}
				
				// RSLT ����
				tempMap = new HashMap<String, Object>();
				tempMap.put("sequenceId", sequenceId);
				tempMap.put("currAprvSno", currAprvSno);
				tempMap.put("rslttypeCd", rslttypeCd);
				tempMap.put("rsltNote", rsltNote);

				aprvDao.intrAprvProc2012(tempMap);
				
			} 
			
			// ���� �ݼ�
			else if(rslttypeCd.equals(Const.RSLT_0020)) {
				// APRVSTEP_CD ����
				paramMap.put("stepCd", Const.STEP_0030);			// ����ݼ�
				aprvDao.intrAprvProc2011(paramMap);
				
				// RSLT ����
				aprvDao.intrAprvProc2012(paramMap);
			}
			
			// ���� ���
			else if(rslttypeCd.equals(Const.RSLT_0030)) {
				// APRVSTEP_CD ����
				paramMap.put("stepCd", Const.STEP_0040);			// �������
				aprvDao.intrAprvProc2011(paramMap);
				
				// CURR_APRV_SNO ����
				paramMap.put("currAprvSno", "0001");						// ��� �ܰ� ��ȣ
				aprvDao.intrAprvProc2013(paramMap);
				
				// RSLT ����
				aprvDao.intrAprvProc2012(paramMap);
			}
			
			// ����
			else {
				throw new Exception("Exception : ���� ó�� �� ������ �߻��߽��ϴ�.");
			}
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
}
