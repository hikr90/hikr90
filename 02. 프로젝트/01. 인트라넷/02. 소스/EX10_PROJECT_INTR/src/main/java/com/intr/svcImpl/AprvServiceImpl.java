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
	
	// ��� ��� ��ȸ
	public void intrAprvInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy10101010(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[����] ��� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ���缱 �� ���� ��ȸ
	public void intrAprvInqy102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� �� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqy10102010(model, paramMap);
			model.addAttribute("aprvDetInfo", defaultInfo);

			//--------------------------------------------------------------------------------------------
			// ���� ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqy10102011(model, paramMap);
			model.addAttribute("currAprvInfo", defaultInfo);
			
		} catch (Exception e) {
			//
			logger.debug("[����] ���� �� ���� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}

	}
	
	// ���� ��� ��ȸ
	public void intrAprvInqy201010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy20101010(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[����] ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}

	// ���� ��� ��� ��ȸ
	public void intrAprvInqy103010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy10301010(model, paramMap);
			model.addAttribute("aprvReqList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[����] ���� ��� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ���� ���� ��� ��ȸ
	public void intrAprvInqy103011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy10301110(model, paramMap);
			model.addAttribute("aprvRecList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[����] ���� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ��ȹ� ���
	public String intrAprvProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		String defaultStr = "";
		String resStr = "NO";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ ä�� (������)
			//--------------------------------------------------------------------------------------------
			defaultInfo = mainDao.intrMainInqy10301010();
			paramMap.put("contentIdx", defaultInfo.get("contentIdx"));

			//--------------------------------------------------------------------------------------------
			// ��ȹ� ��� (INTR_APRV, INTR_APRV_STATUS)
			//--------------------------------------------------------------------------------------------
			resStr = this.intrAprvProc101011(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ��� ��ȯ
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			logger.debug("[����] ǰ�ǹ� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}

	// ��ȹ� ��� (INTR_APRV, INTR_APRV_STATUS)
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
			// ��ȹ� ���
			//--------------------------------------------------------------------------------------------
			for(int i=0;i<aprvLine.length;i++) {
				// ǰ�ǹ� ����
				tempMap = new HashMap<String, Object>();
				tempMap.put("aprvIdx", (String)paramMap.get("contentIdx"));			// ������ IDX
				tempMap.put("empIdx", (String)paramMap.get("empIdx"));				// EMP IDX
				tempMap.put("templateCd", (String)paramMap.get("templateCd"));		// ���ø� CD
				tempMap.put("aprvSno", i + 1);										// ������ SNO
				tempMap.put("aprvTitle", (String)paramMap.get("aprvTitle"));		// ǰ�ǹ� ����
				tempMap.put("aprvContent", (String)paramMap.get("aprvContent"));	// ǰ�ǹ� ����
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
					resInt = aprvDao.intrAprvProc10101010(tempMap);
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
				resInt = aprvDao.intrAprvProc10101020(tempMap);
			}
			//
			if(resInt>0) {
				resStr = "YES";
			}
			
		} catch (Exception e) {
			//
			logger.debug("[���� �޼ҵ�] ǰ�ǹ� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return resStr;
	}
	
	// ���� ���� ó��
	public String intrAprvProc102010(Model model, HashMap<String, Object> paramMap) {
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
				resInt = this.aprvReturn(model, paramMap);
				
			} else if(aprvGb.equals("1")) {
				//--------------------------------------------------------------------------------------------
				// ���� ó��
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", AprvLine.STEP_0002);
				resInt = this.aprvConfirm(model, paramMap);
				
			} else {
				//--------------------------------------------------------------------------------------------
				// ���� ���
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", AprvLine.STEP_0005);
				resInt = this.aprvWithdraw(model, paramMap);
			}; 
			
			
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
			logger.debug("[����] ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}

	// ���� ����
	private int aprvConfirm(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		
		//--------------------------------------------------------------------------------------------
		// CURR_APRV_SNO ����
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProc10101022(model, paramMap);

		//--------------------------------------------------------------------------------------------
		// RSLT ����
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProc10101021(model, paramMap);
		//
		return resInt;
	}

	// ���� �ݷ�
	private int aprvReturn(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		paramMap.put("tempStepCd", AprvLine.STEP_0004);
		
		//--------------------------------------------------------------------------------------------
		// �� �ܰ� �ݼ����� ���� (INTR_APRV)
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProc10101025(model, paramMap);

		//--------------------------------------------------------------------------------------------
		// �� �ܰ� �ݼ����� ���� (INTR_APRV_LINE)
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProc10101026(model, paramMap);
		//
		return resInt;
	}

	// ���� ���
	private int aprvWithdraw(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		String cancelYn = "";
		int resInt = 0;
		
		//--------------------------------------------------------------------------------------------
		// ���� ���� Ȯ��
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
				// �� �ܰ� ȸ���� ���� (INTR_APRV)
				//--------------------------------------------------------------------------------------------
				resInt = aprvDao.intrAprvProc10101023(model, paramMap);

				//--------------------------------------------------------------------------------------------
				// �� �ܰ� ȸ���� ���� (INTR_APRV_LINE)
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
