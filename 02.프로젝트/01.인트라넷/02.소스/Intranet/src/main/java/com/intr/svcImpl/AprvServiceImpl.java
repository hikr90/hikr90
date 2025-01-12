package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.intr.dao.AprvDao;
import com.intr.dao.CoreDao;
import com.intr.svc.AprvService;
import com.intr.svc.MainService;
import com.intr.svc.UtilService;
import com.intr.utils.AprvLine;

@Service
public class AprvServiceImpl implements AprvService{
	//
	@Autowired
	AprvDao aprvDao;
	
	@Autowired
	CoreDao coreDao;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	UtilService utilService;
	
	// ��� ��� ��ȸ
	public void intrAprvInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			utilService.setPaging(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy1011(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ���缱 �� ���� ��ȸ
	public void intrAprvInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� �� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqy1021(model, paramMap);
			model.addAttribute("aprvDetInfo", defaultInfo);
			
			//--------------------------------------------------------------------------------------------
			// ���� ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqy2013(model, paramMap);
			model.addAttribute("currAprvInfo", defaultInfo);
			
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
			defaultList = aprvDao.intrAprvInqy2011(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// ���� ��� ��� ��ȸ
	public void intrAprvInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy1031(model, paramMap);
			model.addAttribute("aprvReqList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ���� ���� ��� ��ȸ
	public void intrAprvInqy1040(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy1041(model, paramMap);
			model.addAttribute("aprvRecList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ��ȹ� ���
	public String intrAprvProc1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ ä��
			//--------------------------------------------------------------------------------------------
			defaultInfo = coreDao.intrCoreInqy1022();
			paramMap.put("contId", defaultInfo.get("contId"));

			//--------------------------------------------------------------------------------------------
			// ��ȹ� ���
			//--------------------------------------------------------------------------------------------
			resStr = this.intrAprvProc1030(model, paramMap);

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

	// ���� ���� ó��
	public String intrAprvProc1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		String aprvGb = (String)paramMap.get("aprvGb"); // ����, �ݼ� ����
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ó�� (�ݷ�:0, ����:1, ���:2)
			//--------------------------------------------------------------------------------------------
			if(aprvGb.equals("0")) {
				//--------------------------------------------------------------------------------------------
				// �ݷ� ó�� 
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", AprvLine.STEP_0004);
				resInt = this.intrAprvProc1050(model, paramMap);
				
			} else if(aprvGb.equals("1")) {
				//--------------------------------------------------------------------------------------------
				// ���� ó��
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", AprvLine.STEP_0002);
				resInt = this.intrAprvProc1040(model, paramMap);
				
			} else {
				//--------------------------------------------------------------------------------------------
				// ���� ���
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", AprvLine.STEP_0005);
				resInt = this.intrAprvProc1060(model, paramMap);
			}
			
			//--------------------------------------------------------------------------------------------
			// ��� ��ȯ
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
	
	// ��ȹ� ���
	public String intrAprvProc1030(Model model, HashMap<String, Object> paramMap) throws Exception {
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
			// ��ȹ� ���
			//--------------------------------------------------------------------------------------------
			for(int i=0;i<aprvLine.length;i++) {
				// ǰ�ǹ� ����
				tempMap = new HashMap<String, Object>();
				tempMap.put("contId", (String)paramMap.get("contId"));			// ������ IDX
				tempMap.put("empIdx", (String)paramMap.get("empIdx"));				// EMP IDX
				tempMap.put("tempCd", (String)paramMap.get("tempCd"));		// ���ø� CD
				tempMap.put("contSid", i + 1);										// ������ SNO
				tempMap.put("aprvTitle", (String)paramMap.get("aprvTitle"));		// ǰ�ǹ� ����
				tempMap.put("aprvCont", (String)paramMap.get("aprvCont"));	// ǰ�ǹ� ����
				tempMap.put("efctSdt", (String)paramMap.get("efctSdt"));			// �������� (����)
				tempMap.put("efctEdt", (String)paramMap.get("efctEdt"));			// �������� (����)
				
				// ���缱 ����
				String [] stepLine = aprvLine[i].split(AprvLine.AT_SIGN);
				tempMap.put("aprvEmpIdx", stepLine[0]);								// ���缱 ���
				tempMap.put("stepCd", stepLine[1]);									// ���� �ܰ� (���, ����, ����, �ݷ�, ȸ��)
				tempMap.put("lastAprvYn", "N");										// ���������ڿ���
				
				//--------------------------------------------------------------------------------------------
				// ���� ���� ���
				//--------------------------------------------------------------------------------------------
				if(flag.equals("N") && stepLine[1].equals(AprvLine.STEP_0002)) { // ù�� ° ���� �ܰ��� ��� ����
					flag = "Y";
					resInt = aprvDao.intrAprvProc1011(tempMap);
				}
				
				//--------------------------------------------------------------------------------------------
				// ���� ������ ���� ����
				//--------------------------------------------------------------------------------------------
				if(i==aprvLine.length-1) {
					tempMap.put("lastAprvYn", "Y");	
				}

				//--------------------------------------------------------------------------------------------
				// ���缱 ���� ���
				//--------------------------------------------------------------------------------------------
				resInt = aprvDao.intrAprvProc1021(tempMap);
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

	// ���� ����
	private int intrAprvProc1040(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		int resInt = 0;
		
		//--------------------------------------------------------------------------------------------
		// ���� ���� ��ȣ ����
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProc1041(model, paramMap);

		//--------------------------------------------------------------------------------------------
		// ��� ����
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProc1042(model, paramMap);
		//
		return resInt;
	}

	// ���� �ݷ�
	private int intrAprvProc1050(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		int resInt = 0;
		paramMap.put("tempStepCd", AprvLine.STEP_0004);
		
		//--------------------------------------------------------------------------------------------
		// �� �ܰ� �ݼ����� ���� 
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProc1051(model, paramMap);

		//--------------------------------------------------------------------------------------------
		// �� �ܰ� �ݼ����� ���� 
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProc1052(model, paramMap);
		//
		return resInt;
	}

	// ���� ���
	private int intrAprvProc1060(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String cancelYn = "";
		int resInt = 0;
		
		//--------------------------------------------------------------------------------------------
		// ���� ���� Ȯ��
		//--------------------------------------------------------------------------------------------
		defaultInfo = aprvDao.intrAprvInqy2013(model, paramMap);
		paramMap.put("tempAprvSno", "0001");
		paramMap.put("tempStepCd", AprvLine.STEP_0005);
		//
		if(defaultInfo!=null) {
			cancelYn = String.valueOf(defaultInfo.get("cancelYn"));
			//
			if(cancelYn.equals("Y")) {
				//--------------------------------------------------------------------------------------------
				// �� �ܰ� ȸ���� ���� (INTR_APRV)
				//--------------------------------------------------------------------------------------------
				resInt = aprvDao.intrAprvProc1061(model, paramMap);

				//--------------------------------------------------------------------------------------------
				// �� �ܰ� ȸ���� ���� (INTR_APRV_LINE)
				//--------------------------------------------------------------------------------------------
				resInt = aprvDao.intrAprvProc1062(model, paramMap);

			} else {
				//
				resInt = -1;
			}
		}
		//
		return resInt;
	}
}
