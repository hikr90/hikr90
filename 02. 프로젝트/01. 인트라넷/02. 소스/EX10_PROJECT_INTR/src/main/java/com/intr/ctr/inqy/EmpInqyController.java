package com.intr.ctr.inqy;

import java.io.File;
import java.io.IOException;
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

import com.intr.constant.IntrConstant;
import com.intr.svc.inqy.TempInqyService;
import com.intr.svc.inqy.CoreInqyService;
import com.intr.svc.inqy.EmpInqyService;
import com.intr.svc.inqy.FileInqyService;

@Controller
public class EmpInqyController {
	//
	@Autowired
	EmpInqyService empInqyService;
	
	@Autowired
	CoreInqyService coreInqyService;
	
	@Autowired
	FileInqyService fileInqyService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/* ��Ī : intrEmpInqy1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.25
	 * ���� : ������ ��� ��� ȭ��
	 */
	@RequestMapping("/intrEmpInqy1010.do")
	public String intrEmpInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			empInqyService.intrEmpInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ��� ���� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_EMP + IntrConstant.INTR_EMP_LIST_1010;
	}
	
	/* ��Ī : intrEmpInqy1011
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.14
	 * ���� : ��� ���̵� �ߺ� ��ȸ
	 */
	@RequestMapping("/intrEmpInqy1011.do")
	@ResponseBody
	public String intrEmpInqy1011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ���̵� �ߺ� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultStr = empInqyService.intrEmpInqy101110(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ��� ���̵� �ߺ� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* ��Ī : intrEmpInqy1012
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.15
	 * ���� : ��� ������ ���� ��ȸ
	 */
	@RequestMapping("/intrEmpInqy1012.do")
	public void intrEmpInqy1012(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletResponse response) throws IOException {
		//
		String workPath = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� �̹��� ��ȸ
			//--------------------------------------------------------------------------------------------
			workPath = fileInqyService.intrFileInqy101010(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// URL��ü ���� (���ܻ��� �߰�)
			//--------------------------------------------------------------------------------------------
			URL fileUrl = new URL("file:"+workPath + File.separator + (String)paramMap.get("fileOrglNm"));

			//--------------------------------------------------------------------------------------------
			// ���� ����� (���䰴ü�� �ѷ��� ���� ������ JSP�� ����)
			//--------------------------------------------------------------------------------------------
			IOUtils.copy(fileUrl.openStream(), response.getOutputStream());
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ��� ������ ���� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	/* ��Ī : intrEmpInqy1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.25
	 * ���� : ������ ��� ��� ȭ��
	 */
	@RequestMapping("/intrEmpInqy1020.do")
	public String intrEmpInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �μ�, ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			empInqyService.intrEmpInqy101012(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ��� ��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_EMP + IntrConstant.INTR_EMP_DETL_1020;
	}
	
	/* ��Ī : intrEmpInqy1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.14
	 * ���� : ������ ��� ����ȸ
	 */
	@RequestMapping("/intrEmpInqy1030.do")
	public String intrEmpInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ������ ��� ����ȸ
			//--------------------------------------------------------------------------------------------
			empInqyService.intrEmpInqy102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ��� �� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_EMP + IntrConstant.INTR_EMP_DETL_1010;
	}
	
	/* ��Ī : intrEmpInqy1040
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.15
	 * ���� : ������ ��� ������ȸ
	 */
	@RequestMapping("/intrEmpInqy1040.do")
	public String intrEmpInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �μ�, ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			empInqyService.intrEmpInqy101012(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ������ ��� ����ȸ
			//--------------------------------------------------------------------------------------------
			empInqyService.intrEmpInqy102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ��� ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_EMP + IntrConstant.INTR_EMP_DETL_1030;
	}
	
	/* ��Ī : intrEmpInqy2010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.18
	 * ���� : ��� ����ó ��� ȭ��
	 */
	@RequestMapping("/intrEmpInqy2010.do")
	public String intrEmpInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ��� ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			empInqyService.intrEmpInqy101011(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy102010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			empInqyService.intrEmpInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ��� ����ó ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_EMP + IntrConstant.INTR_EMP_LIST_2010;
	}

}
