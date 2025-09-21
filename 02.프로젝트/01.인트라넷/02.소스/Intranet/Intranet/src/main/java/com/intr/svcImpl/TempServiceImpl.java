package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.TempDao;
import com.intr.svc.MainService;
import com.intr.svc.TempService;
import com.intr.svc.UtilService;

@Service
@Transactional(rollbackFor = Exception.class)
public class TempServiceImpl implements TempService{
	//
	@Autowired
	TempDao tempDao;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	UtilService utilService;
	
	// ��ȹ� ��� ��� ��ȸ
	public void intrTempInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = tempDao.intrTempInqy1011(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ��ȹ� ��� �� ��ȸ
	public void intrTempInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ��� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = tempDao.intrTempInqy1021(model, paramMap);
			model.addAttribute("defaultInfo", defaultInfo);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// ��ȹ� ��� ��� ��ȸ
	public void intrTempInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// (����)��ȹ� ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = tempDao.intrTempInqy1011(model, paramMap);
			model.addAttribute("tempList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ��ȹ� ��� ���
	public String intrTempProc1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ��� ���
			//--------------------------------------------------------------------------------------------
			resInt = tempDao.intrTempProc1011(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}
			
			//--------------------------------------------------------------------------------------------
			// ��� ��ȯ
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return defaultStr;
	}
	
	// ��ȹ� ��� ����
	public String intrTempProc1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ��� ����
			//--------------------------------------------------------------------------------------------
			resInt = tempDao.intrTempProc1021(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}
			
			//--------------------------------------------------------------------------------------------
			// ��� ��ȯ
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return defaultStr;
	}
	
	// ��ȹ� ��� ����
	public String intrTempProc1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ��� ����
			//--------------------------------------------------------------------------------------------
			resInt = tempDao.intrTempProc1031(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}
			
			//--------------------------------------------------------------------------------------------
			// ��� ��ȯ
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
