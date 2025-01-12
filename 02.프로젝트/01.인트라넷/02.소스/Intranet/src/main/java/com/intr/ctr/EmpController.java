package com.intr.ctr;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.svc.CoreService;
import com.intr.svc.EmpService;
import com.intr.svc.UtilService;
import com.intr.utils.Jsp;
import com.intr.utils.Path;

@Controller
public class EmpController {
	//
	@Autowired
	CoreService coreService;
	
	@Autowired
	EmpService empService;
	
	@Autowired
	UtilService utilService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// ��� ��� ȭ��
	@RequestMapping("/intrEmpInqy1010.do")
	public String intrEmpInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��� ���� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Jsp.INTR_EMP_LIST_1010;
	}
	
	// ��� ��� ȭ��
	@RequestMapping("/intrEmpInqy1020.do")
	public String intrEmpInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �μ� ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��� ��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Jsp.INTR_EMP_DETL_1020;
	}
	
	// ��� �� ��ȸ
	@RequestMapping("/intrEmpInqy1030.do")
	public String intrEmpInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��� �� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Jsp.INTR_EMP_DETL_1010;
	}
	
	// ��� ���� ��ȸ
	@RequestMapping("/intrEmpInqy1040.do")
	public String intrEmpInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��� ����ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��� ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Jsp.INTR_EMP_DETL_1030;
	}
	
	// ��� ������ ���� ��ȸ
	@RequestMapping("/intrEmpInqy1099.do")
	public void intrEmpInqy1099(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletResponse response){
		//
		String workPath = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� �̹��� ��ȸ
			//--------------------------------------------------------------------------------------------
			workPath = utilService.setFilePath(paramMap);

			//--------------------------------------------------------------------------------------------
			// URL��ü ���� (���ܻ��� �߰�)
			//--------------------------------------------------------------------------------------------
			URL fileUrl = new URL("file:"+workPath + File.separator + (String)paramMap.get("fileNm"));
			
			//--------------------------------------------------------------------------------------------
			// ���� ����� (���䰴ü�� �ѷ��� ���� ������ JSP�� ����)
			//--------------------------------------------------------------------------------------------
			IOUtils.copy(fileUrl.openStream(), response.getOutputStream());
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��� ������ ���� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ��� ����ó ��� ȭ��
	@RequestMapping("/intrEmpInqy2010.do")
	public String intrEmpInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��� ����ó ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Jsp.INTR_EMP_LIST_2010;
	}
	
	// ��� ���̵� �ߺ� ��ȸ
	@RequestMapping("/intrEmpInqy2020.do")
	@ResponseBody
	public String intrEmpInqy2020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ���̵� �ߺ� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultStr = empService.intrEmpInqy2020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��� ���̵� �ߺ� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// ��� ��� ó��
	@RequestMapping("/intrEmpProc1010.do")
	@ResponseBody
	public String intrEmpProc1010(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ���
			//--------------------------------------------------------------------------------------------
			defaultStr = empService.intrEmpProc1010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// ��� ���� ó��
	@RequestMapping("/intrEmpProc1020.do")
	@ResponseBody
	public String intrEmpProc1020(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = empService.intrEmpProc1020(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// ��� ����, ��� ó��
	@RequestMapping("/intrEmpProc1030.do")
	@ResponseBody
	public String intrEmpProc1030(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ����, ��� ó��
			//--------------------------------------------------------------------------------------------
			defaultStr = empService.intrEmpProc1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��� ����, ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// ��� ���� ó��
	@RequestMapping("/intrEmpProc1040.do")
	@ResponseBody
	public String intrEmpProc1040(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ���� ó��
			//--------------------------------------------------------------------------------------------
			defaultStr = empService.intrEmpProc1040(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}
