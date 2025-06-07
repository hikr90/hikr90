package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.AprvDao;
import com.intr.dao.CoreDao;
import com.intr.dao.TempDao;
import com.intr.dao.UtilDao;
import com.intr.svc.AprvService;
import com.intr.svc.UtilService;

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
				paramMap.put("commcodeGcd", 	"leav");
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
				paramMap.put("commcodeGcd", 	"pay");
				defaultList = utilDao.intrCodeInqy1011(paramMap);
				model.addAttribute("prepayList",defaultList);
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
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy1011(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
			//--------------------------------------------------------------------------------------------
			// ���� �ܰ� ��� ��ȸ
			//--------------------------------------------------------------------------------------------

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ���� �� ��ȸ
	public void intrAprvInqy2020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqy1012(model, paramMap);
			model.addAttribute("defaultInfo", defaultInfo);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
}
