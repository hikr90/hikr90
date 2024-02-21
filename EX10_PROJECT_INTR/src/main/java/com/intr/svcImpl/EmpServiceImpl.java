package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// ��� ��� ��ȸ
	public void intrEmpInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ���
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy10101010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// ������ ���� ����
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL", "intrEmpInqy2010.do");
			//
			if(defaultList!=null) {
				paramMap.put("rowTotal", defaultList.get(0).get("listCnt"));
			} else {
				paramMap.put("rowTotal", "0");				
			}

		} catch (Exception e) {
			//
			logger.debug("[����] ������ ��� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ��� ��� �Ǽ� ��ȸ
	public void intrEmpInqy101011(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = empDao.intrEmpInqy10101011(model, paramMap);
			paramMap.put("rowTotal", defaultInfo.get("listCnt"));

			//--------------------------------------------------------------------------------------------
			// ������ (���) ���� ó��
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL","intrEmpInqy2010.do");

			
		} catch (Exception e) {
			//
			logger.debug("[����] ��� ��� �Ǽ� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// �μ�, ���� ��ȸ
	public void intrEmpInqy101012(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �μ� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy10101210(model, paramMap);
			model.addAttribute("deptList", defaultList);

			//--------------------------------------------------------------------------------------------
			// �μ� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy10101211(model, paramMap);
			model.addAttribute("gradeList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[����] �μ�, ���� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}

	
	// ��� ���̵� �ߺ� ��ȸ
	public String intrEmpInqy101110(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		String defaultStr = "";
		String resStr = "NO";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ���̵� �ߺ� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy10111010(model, paramMap);
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
			logger.debug("[����] ������ ��� ���̵� �ߺ� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// ��� �� ��ȸ
	public void intrEmpInqy102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� �� ����
			//--------------------------------------------------------------------------------------------
			defaultInfo = empDao.intrEmpInqy10102010(model, paramMap);
			model.addAttribute("defaultInfo",defaultInfo);

			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqy101010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[����] ������ ��� ��ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// �μ� ��� Ʈ�� ��ȸ
	public void intrEmpInqy103010(Model model) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ���
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy10301010(model);
			model.addAttribute("defaultList",defaultList);

		} catch (Exception e) {
			//
			logger.debug("[����] �μ� ��� Ʈ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}

	// �μ� ��� �� ��ȸ
	public void intrEmpInqy104010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �μ� ��� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy10401010(model, paramMap);
			model.addAttribute("deptEmpList",defaultList);

		} catch (Exception e) {
			//
			logger.debug("[����] �μ� ��� �� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ��� ���
	public String intrEmpProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
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
			defaultInfo = mainDao.intrMainInqy10301011();
			paramMap.put("contentIdx", defaultInfo.get("contentIdx"));

			//--------------------------------------------------------------------------------------------
			// ��� ���
			//--------------------------------------------------------------------------------------------
			resInt = empDao.intrEmpProc10101010(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}

			//--------------------------------------------------------------------------------------------
			// ���� ��� (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			if(!request.getFiles("fileList").isEmpty()) {
				resStr = utilService.intrFileProc101010(model, paramMap, request);
			}

			//--------------------------------------------------------------------------------------------
			// ��� ��ȯ
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			logger.debug("[����] ��� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}
	
	// ��� ����
	public String intrEmpProc102010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ����
			//--------------------------------------------------------------------------------------------
			resInt = empDao.intrEmpProc10201010(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}

			//--------------------------------------------------------------------------------------------
			// ���� ��� (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			resStr = utilService.intrFileProc101010(model, paramMap, request);

			//--------------------------------------------------------------------------------------------
			// ��� ��ȯ
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			logger.debug("[����] ��� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}
	
	// ��� ����, ��� ó��
	public String intrEmpProc103010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ����, ��� ó��
			//--------------------------------------------------------------------------------------------
			resInt = empDao.intrEmpProc10301010(paramMap);
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
			logger.debug("[����] ��� ����, ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}

}
