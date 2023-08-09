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
import com.intr.dao.inqy.AprvInqyDao;
import com.intr.dao.inqy.CoreInqyDao;
import com.intr.dao.proc.AprvProcDao;
import com.intr.dao.proc.AuthProcDao;
import com.intr.dao.proc.TempProcDao;
import com.intr.dao.proc.TaskProcDao;
import com.intr.svc.proc.AprvProcService;
import com.intr.svc.proc.AuthProcService;
import com.intr.svc.proc.TempProcService;
import com.intr.svc.proc.TaskProcService;

@Service
@Transactional
public class AprvProcServiceImpl implements AprvProcService{
	//
	@Autowired
	AprvProcDao aprvProcDao;
	
	@Autowired
	AprvInqyDao aprvInqyDao;

	@Autowired
	CoreInqyDao coreInqyDao;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
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
			defaultInfo = coreInqyDao.intrCoreInqy10301010();
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
			String [] aprvLine = aprvStr.split(IntrConst.VERTICAL_BAR);
			
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
				String [] stepLine = aprvLine[i].split(IntrConst.AT_SIGN);
				tempMap.put("aprvEmpIdx", stepLine[0]);								// ���缱 ���
				tempMap.put("stepCd", stepLine[1]);									// ���� �ܰ� (���, ����, ����, �ݷ�, ȸ��)
				tempMap.put("lastAprvYn", "N");										// ���������ڿ���
				
				//--------------------------------------------------------------------------------------------
				// ���� ���� ���
				//--------------------------------------------------------------------------------------------
				if(flag.equals("N") && stepLine[1].equals(IntrConst.STEP_0002)) { // ù�� ° ���� �ܰ��� ��� ����
					flag = "Y";
					resInt = aprvProcDao.intrAprvProc10101010(tempMap);
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
				resInt = aprvProcDao.intrAprvProc10101020(tempMap);
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
				paramMap.put("stepCd", IntrConst.STEP_0004);
				resInt = this.aprvReturn(model, paramMap);
				
			} else if(aprvGb.equals("1")) {
				//--------------------------------------------------------------------------------------------
				// ���� ó��
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", IntrConst.STEP_0002);
				resInt = this.aprvConfirm(model, paramMap);
				
			} else {
				//--------------------------------------------------------------------------------------------
				// ���� ���
				//--------------------------------------------------------------------------------------------
				paramMap.put("stepCd", IntrConst.STEP_0005);
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
		resInt = aprvProcDao.intrAprvProc10101022(model, paramMap);

		//--------------------------------------------------------------------------------------------
		// RSLT ����
		//--------------------------------------------------------------------------------------------
		resInt = aprvProcDao.intrAprvProc10101021(model, paramMap);
		//
		return resInt;
	}

	// ���� �ݷ�
	private int aprvReturn(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		paramMap.put("tempStepCd", IntrConst.STEP_0004);
		
		//--------------------------------------------------------------------------------------------
		// �� �ܰ� �ݼ����� ���� (INTR_APRV)
		//--------------------------------------------------------------------------------------------
		resInt = aprvProcDao.intrAprvProc10101025(model, paramMap);

		//--------------------------------------------------------------------------------------------
		// �� �ܰ� �ݼ����� ���� (INTR_APRV_LINE)
		//--------------------------------------------------------------------------------------------
		resInt = aprvProcDao.intrAprvProc10101026(model, paramMap);
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
		defaultInfo = aprvInqyDao.intrAprvInqy10102011(model, paramMap);
		paramMap.put("tempAprvSno", "0001");
		paramMap.put("tempStepCd", IntrConst.STEP_0005);
		//
		if(defaultInfo!=null) {
			cancelYn = String.valueOf(defaultInfo.get("cancelYn"));
			//
			if(cancelYn.equals("Y")) {
				//--------------------------------------------------------------------------------------------
				// �� �ܰ� ȸ���� ���� (INTR_APRV)
				//--------------------------------------------------------------------------------------------
				resInt = aprvProcDao.intrAprvProc10101023(model, paramMap);

				//--------------------------------------------------------------------------------------------
				// �� �ܰ� ȸ���� ���� (INTR_APRV_LINE)
				//--------------------------------------------------------------------------------------------
				resInt = aprvProcDao.intrAprvProc10101024(model, paramMap);

			} else {
				//
				resInt = -1;
			}
		}
		//
		return resInt;
	}
}
