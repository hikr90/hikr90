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

import com.intr.svc.MainService;
import com.intr.comm.Page;
import com.intr.comm.Path;
import com.intr.svc.EmpService;
import com.intr.svc.UtilService;
import com.intr.svc.TempService;

@Controller
public class EmpController {
	//
	@Autowired
	EmpService empService;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	UtilService utilService;
	
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
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ��� ���� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Page.INTR_EMP_LIST_1010;
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
			defaultStr = empService.intrEmpInqy101110(model, paramMap);
			
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
	public void intrEmpInqy1012(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletResponse response){
		//
		String workPath = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� �̹��� ��ȸ
			//--------------------------------------------------------------------------------------------
			workPath = utilService.intrFileInqy101010(paramMap);
			
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
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �μ�, ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy101012(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ��� ��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Page.INTR_EMP_DETL_1020;
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
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ������ ��� ����ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ��� �� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Page.INTR_EMP_DETL_1010;
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
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �μ�, ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy101012(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ������ ��� ����ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ��� ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Page.INTR_EMP_DETL_1030;
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
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ��� ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy101011(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy102010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ��� ����ó ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Page.INTR_EMP_LIST_2010;
	}
	
	/* ��Ī : intrEmpProc1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.14
	 * ���� : ��� ��� ó��
	 */
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
			defaultStr = empService.intrEmpProc101010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ��� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* ��Ī : intrEmpProc1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.16
	 * ���� : ��� ���� ó��
	 */
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
			defaultStr = empService.intrEmpProc102010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ��� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* ��Ī : intrEmpProc1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.17
	 * ���� : ��� ����, ��� ó��
	 */
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
			defaultStr = empService.intrEmpProc103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ��� ����, ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}
