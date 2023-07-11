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
	
	// ��ȹ� ���
	public String intrAprvProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		HashMap<String, Object> defaultInfo = null;
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
			// ���� ��� (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			if(!request.getFiles("fileList").isEmpty()) {
				resStr = fileProcService.intrFileProc101010(model, paramMap, request);
			}

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
		//
		try {
			//
			HashMap<String, Object> tempMap = null;
			String tempSave = (String)paramMap.get("tempSave");
			String aprvStr = (String)paramMap.get("aprvLine");
			String [] aprvLine = aprvStr.split("\\|");
			

			// ���缱 �и�

			
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ���
			//--------------------------------------------------------------------------------------------
			for(int i=0;i<aprvLine.length;i++) {
				// ǰ�ǹ� ����
				tempMap = new HashMap<String, Object>();
				tempMap.put("aprvIdx", (String)paramMap.get("contentIdx"));			// ������ ID
				tempMap.put("aprvTitle", (String)paramMap.get("aprvTitle"));		// ǰ�ǹ� ����
				tempMap.put("aprvContent", (String)paramMap.get("aprvContent"));	// ǰ�ǹ� ����
				
				// ���缱 ����
				String [] statLine = aprvLine[i].split("@");
				tempMap.put("aprvEmpIdx", statLine[0]);								// ���缱 ���
				tempMap.put("statusCd", statLine[1]);								// ���� �ܰ� (���, ����, ����, �ݷ�, ȸ��)
				tempMap.put("stepCd", IntrConst.STAT_0003);							// ���� �Ϸ�
				
				//--------------------------------------------------------------------------------------------
				// �ӽ����� ó��
				//--------------------------------------------------------------------------------------------
				if(i==0) { // ù �ܰ�
					if(tempSave.equals("Y")) { // �ӽ� ����
						tempMap.put("stepCd", IntrConst.STAT_0001);		// �ӽ� ����
					}
					// INTR_APRV
					resInt = aprvProcDao.intrAprvProc10101010(tempMap);

				} else {
					// ù �ܰ谡 �ƴ� ��� (INTR_APRV_STATUS)
					tempMap.put("stepCd", IntrConst.STAT_0002);		// ���
					resInt = aprvProcDao.intrAprvProc10101020(tempMap);
				}
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
}
