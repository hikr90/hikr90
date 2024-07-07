package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.dao.EmpDao;
import com.intr.dao.MainDao;
import com.intr.dao.UtilDao;
import com.intr.svc.EmpService;
import com.intr.svc.UtilService;

@Service
@Transactional
public class EmpServiceImpl implements EmpService{
	//
	@Autowired
	MainDao mainDao;
	
	@Autowired
	EmpDao empDao;
	
	@Autowired
	UtilDao utilDao;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	HttpServletRequest request;
	
	// ��� ��� ��ȸ
	public void intrEmpInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ���
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqyDao1010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// ������ ���� ����
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL", "intrEmpInqy2010.do");
			//
			if(defaultList!=null && !defaultList.isEmpty()) {
				paramMap.put("rowTotal", defaultList.get(0).get("listCnt"));
			} else {
				paramMap.put("rowTotal", "0");				
			}

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ��� ��� �Ǽ� ��ȸ
	public void intrEmpInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = empDao.intrEmpInqyDao1020(model, paramMap);
			paramMap.put("rowTotal", defaultInfo.get("listCnt"));

			//--------------------------------------------------------------------------------------------
			// ������ (���) ���� ó��
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL","intrEmpInqy2010.do");

			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ��� �� ��ȸ
	public void intrEmpInqyService1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� �� ����
			//--------------------------------------------------------------------------------------------
			defaultInfo = empDao.intrEmpInqyDao1060(model, paramMap);
			model.addAttribute("defaultInfo",defaultInfo);

			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqyDao1010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ��� ���̵� �ߺ� ��ȸ
	public String intrEmpInqyService1040(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		String defaultStr = "";
		String resStr = "NO";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ���̵� �ߺ� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqyDao1050(model, paramMap);
			//
			if(defaultList.size()>0) {
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
	
	// �μ� ���� ��ȸ
	public void intrEmpInqyService1050(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �μ� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqyDao1030(model, paramMap);
			model.addAttribute("deptList", defaultList);

			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqyDao1040(model, paramMap);
			model.addAttribute("gradeList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// �μ� ��� Ʈ�� ��ȸ
	public void intrEmpInqyService1060(Model model) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ���
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqyDao1070(model);
			model.addAttribute("defaultList",defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// �μ� ��� �� ��ȸ
	public void intrEmpInqyService1070(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �μ� ��� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqyDao1080(model, paramMap);
			model.addAttribute("deptEmpList",defaultList);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ��� ���
	public String intrEmpProcService1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ ä�� (���)
			//--------------------------------------------------------------------------------------------
			defaultInfo = mainDao.intrMainInqyDao1030();
			paramMap.put("contId", defaultInfo.get("contId"));

			//--------------------------------------------------------------------------------------------
			// ��� ���
			//--------------------------------------------------------------------------------------------
			resInt = empDao.intrEmpProcDao1010(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}

			//--------------------------------------------------------------------------------------------
			// ���� ���
			//--------------------------------------------------------------------------------------------
			if(!request.getFiles("fileList").isEmpty()) {
				resStr = utilService.intrFileProcService1010(model, paramMap, request);
			}

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
	
	// ��� ����
	public String intrEmpProcService1020(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ����
			//--------------------------------------------------------------------------------------------
			resInt = empDao.intrEmpProcDao1020(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}

			//--------------------------------------------------------------------------------------------
			// ���� ���
			//--------------------------------------------------------------------------------------------
			resStr = utilService.intrFileProcService1010(model, paramMap, request);

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
	
	// ��� ����, ��� ó��
	public String intrEmpProcService1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ����, ��� ó��
			//--------------------------------------------------------------------------------------------
			resInt = empDao.intrEmpProcDao1030(paramMap);
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
		
		return defaultStr;
	}

}
