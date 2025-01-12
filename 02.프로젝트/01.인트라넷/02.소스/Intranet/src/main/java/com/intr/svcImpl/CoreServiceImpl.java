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
	
	// 트랜젝션 시작
	public void setTx(HashMap<String, Object> paramMap, boolean txYn) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 트랜젝션 처리
			//--------------------------------------------------------------------------------------------
			
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 트랜젝션 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 메뉴 조회
	public void intrCoreInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		EmpVO empInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 정보 세션 조회
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
			// 로그인 정보 세션 조회
			//--------------------------------------------------------------------------------------------
			empInfo = (EmpVO)session.getAttribute("empVO");
			if(empInfo!=null) {
				paramMap.put("setEmpIdx", empInfo.getEmpIdx());
			}
			
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			defaultList = coreDao.intrCoreInqy1011(model, paramMap);
			model.addAttribute("menuList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// 전체 메뉴 조회
	public void intrCoreInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 전체 메뉴 조회
			//--------------------------------------------------------------------------------------------
			defaultList = coreDao.intrCoreInqy1021(model, paramMap);
			model.addAttribute("tMenuList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 메뉴 세션 저장
	public void intrCoreInqy1030(String menuType) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 세션 저장
			// 	- 0 : 사용자 , 1 : 관리자
			//--------------------------------------------------------------------------------------------
			HttpSession session = request.getSession();
			session.setAttribute("menuType", menuType);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
}
