package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.AuthDao;
import com.intr.dao.TempDao;
import com.intr.svc.AuthService;
import com.intr.svc.TempService;

@Service
@Transactional
public class AuthServiceImpl implements AuthService{
	//
	@Autowired
	AuthDao authDao;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// ���� ��� ��ȸ
	public void intrAuthInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy10101010(model, paramMap);
			model.addAttribute("defaultList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[����] ������ ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ���� �� ��ȸ
	public void intrAuthInqy102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �����ڵ� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = authDao.intrAuthInqy10201010(model, paramMap);
			model.addAttribute("defaultInfo", defaultInfo);
			
		} catch (Exception e) {
			//
			logger.debug("[����] ������ ���� �� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// �޴� ���� ��� ��ȸ
	public void intrAuthInqy201010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy20101010(model, paramMap);
			model.addAttribute("authMenuList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[����] ������ �޴� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ����� ��� ��ȸ
	public void intrAuthInqy301010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy30101010(model, paramMap);
			model.addAttribute("empList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[����] ������ ����� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ����� ���� ��� ��ȸ
	public void intrAuthInqy301020(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����� ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy30101020(model, paramMap);
			model.addAttribute("authEmpList", defaultList);

		} catch (Exception e) {
			//
			logger.debug("[����] ������ ����� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ���� ��� ó��
	public String intrAuthProc101010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ��� ó��
			//--------------------------------------------------------------------------------------------
			resInt = authDao.intrAuthProc10101010(paramMap);
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
			logger.debug("[����] ������ ���� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// ���� ���� ó��
	public String intrAuthProc102010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ���� ó��
			//--------------------------------------------------------------------------------------------
			resInt = authDao.intrAuthProc10201010(paramMap);
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
			logger.debug("[����] ������ ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// ���� ���� ó��
	public String intrAuthProc103010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ���� ó��
			//--------------------------------------------------------------------------------------------
			resInt = authDao.intrAuthProc10301010(paramMap);
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
			logger.debug("[����] ������ ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// �޴� ���� ���� ó��
	public String intrAuthProc201010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		HashMap<String, Object> tempMap = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ���� ó��
			//--------------------------------------------------------------------------------------------
			authDao.intrAuthProc20101010(paramMap);

			//--------------------------------------------------------------------------------------------
			// �޴� ���� ���� ó��
			//--------------------------------------------------------------------------------------------
			for(int i=0;i<paramMap.size();i++) {
				//
				if(paramMap.get("menuCd"+i)!=null) {
					//
					tempMap = new HashMap<String, Object>();
					tempMap.put("menuCd", (String)paramMap.get("menuCd"+i));
					tempMap.put("authCd", (String)paramMap.get("authCd"));
					//
					resInt += authDao.intrAuthProc20101020(tempMap);
				}
			}
			
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
			logger.debug("[����] ������ �޴� ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// ����� ���� ���� ó��
	public String intrAuthProc301010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		HashMap<String, Object> tempMap = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����� ���� ���� ó��
			//--------------------------------------------------------------------------------------------
			authDao.intrAuthProc30101010(paramMap);

			//--------------------------------------------------------------------------------------------
			// ����� ���� ���� ó��
			//--------------------------------------------------------------------------------------------
			for(int i=0;i<paramMap.size();i++) {
				//
				if(paramMap.get("empIdx"+i)!=null) {
					//
					tempMap = new HashMap<String, Object>();
					tempMap.put("empIdx", (String)paramMap.get("empIdx"+i));
					tempMap.put("authCd", (String)paramMap.get("authCd"));
					//
					resInt += authDao.intrAuthProc30101020(tempMap);
				}
			}
			
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
			logger.debug("[����] ������ ����� ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

}
