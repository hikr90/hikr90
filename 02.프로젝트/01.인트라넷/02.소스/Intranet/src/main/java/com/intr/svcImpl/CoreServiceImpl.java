package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;

import com.intr.dao.CoreDao;
import com.intr.dao.UtilDao;
import com.intr.svc.CoreService;
import com.intr.vo.EmpVO;

@Service 
public class CoreServiceImpl implements CoreService{
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	//
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	CoreDao coreDao;
	
	@Autowired
	UtilDao utilDao;
	
	// Ʈ������ ����
	public void setTx(HashMap<String, Object> paramMap, boolean txYn) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// Ʈ������ ó��
			//--------------------------------------------------------------------------------------------
			
			
		} catch (Exception e) {
			//
			logger.debug("Exception : Ʈ������ ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// �޴� ��ȸ
	public void intrCoreInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		EmpVO empInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			HttpSession session = request.getSession();
			String menuType = "";
			String menuSet = "";

			// (1) MenuType
			menuType = (String)session.getAttribute("menuType");
			if(menuType!=null) {
				paramMap.put("menuType", menuType);
			}
			
			// (2) menuSet
			menuSet = paramMap.get("menuSet")!=null?(String)paramMap.get("menuSet"):null;
			if(menuSet!=null) {
				session.setAttribute("menuSet", menuSet);
			}

			//--------------------------------------------------------------------------------------------
			// �α��� ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			empInfo = (EmpVO)session.getAttribute("empVO");
			if(empInfo!=null) {
				paramMap.put("setEmpIdx", empInfo.getEmpIdx());
			}
			
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = coreDao.intrCoreInqy1011(model, paramMap);
			model.addAttribute("menuList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// ��ü �޴� ��ȸ
	public void intrCoreInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ü �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = coreDao.intrCoreInqy1021(model, paramMap);
			model.addAttribute("tMenuList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// �޴� ���� ����
	public void intrCoreInqy1030(String menuType) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ����
			// 	- 0 : ����� , 1 : ������
			//--------------------------------------------------------------------------------------------
			HttpSession session = request.getSession();
			session.setAttribute("menuType", menuType);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
}
