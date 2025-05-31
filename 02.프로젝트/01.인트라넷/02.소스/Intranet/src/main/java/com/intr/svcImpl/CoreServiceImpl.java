package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.intr.dao.CoreDao;
import com.intr.dao.UtilDao;
import com.intr.svc.CoreService;
import com.intr.svc.UtilService;
import com.intr.utils.Const;
import com.intr.vo.EmpVO;

@Service 
public class CoreServiceImpl implements CoreService{
	//
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	CoreDao coreDao;
	
	@Autowired
	UtilDao utilDao;
	
	// 메뉴 조회
	public void intrCoreInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> tempMap = null;
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
			menuSet =  utilService.nvlProc((String)paramMap.get("menuSet"));
			if(menuSet!="") {
				session.setAttribute("menuSet", menuSet);
			} else {
				menuSet = (String)session.getAttribute("menuSet");
			}

			//--------------------------------------------------------------------------------------------
			// 로그인 정보 세션 조회
			//--------------------------------------------------------------------------------------------
			empInfo = (EmpVO)session.getAttribute("empVO");
			if(empInfo!=null) {
				paramMap.put("idxSet", empInfo.getEmpIdx());
			}
			
			//--------------------------------------------------------------------------------------------
			// 상단 메뉴 조회
			//--------------------------------------------------------------------------------------------
			tempMap = new HashMap<String, Object>();
			tempMap.put("idxSet", utilService.nvlProc((String)paramMap.get("idxSet")));
			tempMap.put("menuType", utilService.nvlProc((String)paramMap.get("menuType")));
			//
			defaultList = coreDao.intrCoreInqy1011(model, tempMap);
			model.addAttribute("menuList", defaultList);

			//--------------------------------------------------------------------------------------------
			// 좌측 메뉴 조회
			//--------------------------------------------------------------------------------------------
			tempMap = new HashMap<String, Object>();
			tempMap.put("menuSet", menuSet);
			tempMap.put("menuCd", utilService.nvlProc((String)paramMap.get("menuCd")));
			tempMap.put("idxSet", utilService.nvlProc((String)paramMap.get("idxSet")));
			tempMap.put("menuType", utilService.nvlProc((String)paramMap.get("menuType")));
			//
			defaultList = coreDao.intrCoreInqy1011(model, tempMap);
			model.addAttribute("leftList", defaultList);
			
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
			// 	- 0 : 사용자
			//		- 1 : 관리자
			//--------------------------------------------------------------------------------------------
			HttpSession session = request.getSession();
			session.setAttribute("menuType", menuType);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 시퀀스 채번
	public HashMap<String, Object> intrCoreInqy1040() throws Exception {
		//
		HashMap<String, Object> paramMap = null;
		
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 시퀀스 채번
			//--------------------------------------------------------------------------------------------
			paramMap = coreDao.intrCoreInqy1041();
			
			//--------------------------------------------------------------------------------------------
			// 시퀀스 저장
			//--------------------------------------------------------------------------------------------
			coreDao.intrCoreInqy1042(paramMap);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return paramMap;
	}
}
