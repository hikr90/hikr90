package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.AuthDao;
import com.intr.dao.MainDao;
import com.intr.svc.BoardService;
import com.intr.svc.MainService;
import com.intr.svc.UtilService;
import com.intr.utils.Paging;
import com.intr.vo.EmpVO;

@Service 
@Transactional
public class MainServiceImpl implements MainService{
	//
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	MainDao mainDao;
	
	@Autowired
	AuthDao authDao;
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	UtilService utilService;
	
	// 메뉴 조회
	public void intrMainInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception {
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
			//
			if(empInfo!=null) {
				paramMap.put("empIdx", empInfo.getEmpIdx());
			}
			
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			defaultList = mainDao.intrMainInqyDao1010(model, paramMap);
			model.addAttribute("menuList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// 메뉴 세션 저장
	public void intrMainInqyService1030(String menuType) throws Exception {
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

	// 전체 메뉴 조회
	public void intrMainInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 전체 메뉴 조회
			//--------------------------------------------------------------------------------------------
			defaultList = mainDao.intrMainInqyDao1020(model, paramMap);
			model.addAttribute("tMenuList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 페이징 처리
	public void intrMainInqyService1050(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		int nowPage = 1; // 페이지 기본 값 (첫 동작)
		Integer page = null; // 현재 페이지
		String pageStr = (String)paramMap.get("page");
		//
		if(pageStr!=null && pageStr!="") page = Integer.valueOf(pageStr);
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 페이징 처리
			//--------------------------------------------------------------------------------------------
			if(page!=null) {
				// 특정 페이지 값이 있는 경우 대체
				nowPage = page;
			}
					
			// 페이지 첫, 마지막 인덱스
			int sIdx = (nowPage-1)*Paging.BLOCKLIST+1;
			int endIdx = sIdx+Paging.BLOCKLIST-1;
			//
			//--------------------------------------------------------------------------------------------
			// 페이지 변수 저장
			//--------------------------------------------------------------------------------------------
			paramMap.put("nowPage", nowPage);
			paramMap.put("sIdx",sIdx);
			paramMap.put("eIdx",endIdx);
			paramMap.put("blockList",Paging.BLOCKLIST);
			paramMap.put("blockPage",Paging.BLOCKPAGE);

			// 페이지 메뉴 구성
			String pageMenu = utilService.intPageInqyService1010(paramMap);
			model.addAttribute("pageMenu", pageMenu);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 검색 조건 저장
	public void intrMainInqyService1060(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			model.addAttribute("resultParam", paramMap);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 로그인 처리
	public String intrLoginProcService1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "";
		EmpVO defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 로그인 사용자 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = mainDao.intrLoginInqyDao1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 아이디 / 비밀번호 체크
			//--------------------------------------------------------------------------------------------
			if(defaultInfo!=null) {
				String paramPwd = (String)paramMap.get("empPwd");
				String defaultPwd = (String)defaultInfo.getEmpPwd();
				//
				if(!paramPwd.equalsIgnoreCase(defaultPwd)) {
					resStr = "NO_PWD";
				} else {
					//
					resStr = "YES";
					session.setAttribute("empVO", defaultInfo);
					session.setMaxInactiveInterval(60*60); // 저장 시간 1시간
				}
				
			} else {
				resStr = "NO_ID";
			}
			
			//
			defaultStr = String.format("[{'res':'%s'}]", resStr);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}

	// 로그인 권한 사용자 조회
	public void intrMainInqyService1040(Model model) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 로그인 권한 사용자 조회
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqyDao1060(model);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
}
