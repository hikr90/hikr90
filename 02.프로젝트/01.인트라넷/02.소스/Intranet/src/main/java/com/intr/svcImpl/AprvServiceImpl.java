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
	
	// ��� ��� ��ȸ
	public void intrAprvInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqyDao1010(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ���缱 �� ���� ��ȸ
	public void intrAprvInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� �� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqyDao1020(model, paramMap);
			model.addAttribute("aprvDetInfo", defaultInfo);

			//--------------------------------------------------------------------------------------------
			// ���� ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqyDao1040(model, paramMap);
			model.addAttribute("currAprvInfo", defaultInfo);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}

	}
	
	// ���� ��� ��ȸ
	public void intrAprvInqyService1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqyDao1050(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// ���� ��� ��� ��ȸ
	public void intrAprvInqyService1040(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqyDao1060(model, paramMap);
			model.addAttribute("aprvReqList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ���� ���� ��� ��ȸ
	public void intrAprvInqyService1050(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqyDao1070(model, paramMap);
			model.addAttribute("aprvRecList", defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ��ȹ� ���
	public String intrAprvProcService1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ ä��
			//--------------------------------------------------------------------------------------------
			defaultInfo = mainDao.intrMainInqyDao1030();
			paramMap.put("contId", defaultInfo.get("contId"));

			//--------------------------------------------------------------------------------------------
			// ��ȹ� ���
			//--------------------------------------------------------------------------------------------
			resStr = this.intrAprvProcService1030(model, paramMap);

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
	public String intrAprvProcService1020(Model model, HashMap<String, Object> paramMap) throws Exception {
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
				resInt = this.intrAprvProcService1022(model, paramMap);
				
			} else if(aprvGb.equals("1")) {
				//--------------------------------------------------------------------------------------------
				// ���� ó��
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", AprvLine.STEP_0002);
				resInt = this.intrAprvProcService1021(model, paramMap);
				
			} else {
				//--------------------------------------------------------------------------------------------
				// ���� ���
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", AprvLine.STEP_0005);
				resInt = this.intrAprvProcService1023(model, paramMap);
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
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}
	
	// ��ȹ� ���
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
			// ��ȹ� ���
			//--------------------------------------------------------------------------------------------
			for(int i=0;i<aprvLine.length;i++) {
				// ǰ�ǹ� ����
				tempMap = new HashMap<String, Object>();
				tempMap.put("aprvIdx", (String)paramMap.get("contId"));			// ������ IDX
				tempMap.put("empIdx", (String)paramMap.get("empIdx"));				// EMP IDX
				tempMap.put("tempCd", (String)paramMap.get("tempCd"));		// ���ø� CD
				tempMap.put("aprvSno", i + 1);										// ������ SNO
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
					resInt = aprvDao.intrAprvProcDao1010(tempMap);
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

	// ���� ����
	private int intrAprvProcService1021(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		int resInt = 0;
		
		//--------------------------------------------------------------------------------------------
		// ���� ���� ��ȣ ����
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProcDao1040(model, paramMap);

		//--------------------------------------------------------------------------------------------
		// ��� ����
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProcDao1030(model, paramMap);
		//
		return resInt;
	}

	// ���� �ݷ�
	private int intrAprvProcService1022(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		int resInt = 0;
		paramMap.put("tempStepCd", AprvLine.STEP_0004);
		
		//--------------------------------------------------------------------------------------------
		// �� �ܰ� �ݼ����� ���� 
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProcDao1070(model, paramMap);

		//--------------------------------------------------------------------------------------------
		// �� �ܰ� �ݼ����� ���� 
		//--------------------------------------------------------------------------------------------
		resInt = aprvDao.intrAprvProcDao1080(model, paramMap);
		//
		return resInt;
	}

	// ���� ���
	private int intrAprvProcService1023(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String cancelYn = "";
		int resInt = 0;
		
		//--------------------------------------------------------------------------------------------
		// ���� ���� Ȯ��
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
				// �� �ܰ� ȸ���� ���� 
				//--------------------------------------------------------------------------------------------
				resInt = aprvDao.intrAprvProcDao1050(model, paramMap);

				//--------------------------------------------------------------------------------------------
				// �� �ܰ� ȸ���� ���� 
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
	
	// ���� ��� �Ǽ�
	public void intrAprvInqyService1060(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqyDao1080(model, paramMap);
			paramMap.put("rowTotal", defaultInfo.get("listCnt"));

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ��� ��� �Ǽ� ��ȸ
	public void intrAprvInqyService1070(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqyDao1090(model, paramMap);
			paramMap.put("rowTotal", defaultInfo.get("listCnt"));

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
}
