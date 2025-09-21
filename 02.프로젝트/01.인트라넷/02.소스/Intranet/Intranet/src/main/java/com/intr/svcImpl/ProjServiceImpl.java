package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.dao.CoreDao;
import com.intr.dao.ProjDao;
import com.intr.dao.UtilDao;
import com.intr.svc.CoreService;
import com.intr.svc.EmpService;
import com.intr.svc.ProjService;
import com.intr.svc.UtilService;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProjServiceImpl implements ProjService{
	//
	@Autowired
	UtilService utilService;

	@Autowired
	CoreService coreService;
	
	@Autowired
	EmpService empService;

	@Autowired
	ProjDao projDao;
	
	@Autowired
	CoreDao coreDao;
	
	@Autowired
	UtilDao utilDao;

	// ������Ʈ ��� ��ȸ
	public void intrProjInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			utilService.setPaging(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ������Ʈ ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = projDao.intrProjInqy1011(model, paramMap);
			model.addAttribute("defaultList", defaultList);

			//--------------------------------------------------------------------------------------------
			// �����ڵ� (�������) ��ȸ
			//--------------------------------------------------------------------------------------------
			paramMap.put("commcodeGcd", 	"STAT");
			defaultList = utilDao.intrCodeInqy1011(paramMap);
			model.addAttribute("statList",defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ������Ʈ ��� ��ȸ
	public void intrProjInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �����ڵ� (�������) ��ȸ
			//--------------------------------------------------------------------------------------------
			paramMap.put("commcodeGcd", 	"STAT");
			defaultList = utilDao.intrCodeInqy1011(paramMap);
			model.addAttribute("statList",defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ������Ʈ ��ȭ�� ��ȸ
	public void intrProjInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������Ʈ �� ����
			//--------------------------------------------------------------------------------------------
			defaultInfo = projDao.intrProjInqy1031(model, paramMap);
			model.addAttribute("defaultInfo",defaultInfo);

			//--------------------------------------------------------------------------------------------
			// �����ڵ� (�������) ��ȸ
			//--------------------------------------------------------------------------------------------
			paramMap.put("commcodeGcd", 	"STAT");
			defaultList = utilDao.intrCodeInqy1011(paramMap);
			model.addAttribute("statList",defaultList);
			
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
	
	// ������Ʈ ��� ó��
	public String intrProjProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� ä��
			//--------------------------------------------------------------------------------------------
			defaultInfo = projDao.intrProjInqy1010(model, paramMap);
			paramMap.put("sequenceId", (String)defaultInfo.get("sequenceId"));
			
			//--------------------------------------------------------------------------------------------
			// ������Ʈ ��� ó��
			//--------------------------------------------------------------------------------------------
			resInt = projDao.intrProjProc1011(paramMap);
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
	
	// ������Ʈ ����
	public String intrProjProc1020(Model model, String [] delIdxArr) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �� ����
			//--------------------------------------------------------------------------------------------
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("delIdxArr", delIdxArr);

			//--------------------------------------------------------------------------------------------
			// ������Ʈ ����
			//--------------------------------------------------------------------------------------------
			resInt = projDao.intrProjProc1021(paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ���� ó�� (����)
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
	
	// ������Ʈ ����
	public String intrProjProc1030(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������Ʈ ����
			//--------------------------------------------------------------------------------------------
			resInt = projDao.intrProjProc1031(paramMap);
			
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
