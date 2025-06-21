package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.dao.MtgDao;
import com.intr.dao.UtilDao;
import com.intr.svc.MtgService;
import com.intr.svc.UtilService;

import net.sf.json.JSONArray;

@Service
@Transactional(rollbackFor = Exception.class)
public class MtgServiceImpl implements MtgService{
	//
	@Autowired
	UtilService utilService;
	
	@Autowired
	MtgDao mtgDao;
	
	@Autowired
	UtilDao utilDao;
	
	// ȸ�� ��� ��ȸ
	public void intrMtgInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			utilService.setPaging(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ȸ�� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = mtgDao.intrMtgInqy1011(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ȸ�� ��� ��ȸ
	public void intrMtgInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ȸ�� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// ȸ�� ��ȭ�� ��ȸ
	public void intrMtgInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ȸ�� �� ����
			//--------------------------------------------------------------------------------------------
			defaultInfo = mtgDao.intrMtgInqy1031(model, paramMap);
			model.addAttribute("defaultInfo",defaultInfo);

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
	
	// Ķ���� ��ȸ
	public void intrMtgInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		JSONArray jAray = new JSONArray();
		//
		try {
			//--------------------------------------------------------------------------------------------
			// Ķ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = mtgDao.intrMtgInqy2011(model, paramMap);
			model.addAttribute("calList", jAray.fromObject(defaultList));
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// Ķ���� ��� ��ȸ
	public void intrMtgInqy2020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// Ķ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = mtgDao.intrMtgInqy2021(model, paramMap);
			model.addAttribute("calInfo", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	
	// ȸ�� ��� ó��
	public String intrMtgProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ȸ�� ä��
			//--------------------------------------------------------------------------------------------
			defaultInfo = mtgDao.intrMtgInqy1010(model, paramMap);
			paramMap.put("sequenceId", (String)defaultInfo.get("sequenceId"));
			
			//--------------------------------------------------------------------------------------------
			// ȸ�� ��� ó��
			//--------------------------------------------------------------------------------------------
			resInt = mtgDao.intrMtgProc1011(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}

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
	
	// ȸ�� ����
	public String intrMtgProc1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ȸ�� ����
			//--------------------------------------------------------------------------------------------
			resInt = mtgDao.intrMtgProc1021(paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ���� ó��
			//--------------------------------------------------------------------------------------------
			utilDao.intrFileProc1021(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��� ��ȯ
			//--------------------------------------------------------------------------------------------
			if(resInt>0) {
				resStr = "YES";
			}
			//
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}
	
	// ȸ�� ����
	public String intrMtgProc1030(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ȸ�� ����
			//--------------------------------------------------------------------------------------------
			resInt = mtgDao.intrMtgProc1031(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			resStr = utilService.fileUpload(model, paramMap, request);

			//--------------------------------------------------------------------------------------------
			// ��� ��ȯ
			//--------------------------------------------------------------------------------------------
			if(resInt>0) {
				resStr = "YES";
			}
			//
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}
}
