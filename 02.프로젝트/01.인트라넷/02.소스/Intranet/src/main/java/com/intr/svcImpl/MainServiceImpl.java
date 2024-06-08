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
import com.intr.util.Paging;
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
	
	// �޴� ��ȸ
	public void intrMainInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		EmpVO empInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			HttpSession session = request.getSession();
			String menuType = (String)session.getAttribute("menuType");
			// �޴� ������ ����ִ� ���
			if(menuType!=null) {
				paramMap.put("menuType", menuType);
			}

			//--------------------------------------------------------------------------------------------
			// �α��� ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			empInfo = (EmpVO)session.getAttribute("empVO");
			//
			if(empInfo!=null) {
				paramMap.put("empIdx", empInfo.getEmpIdx());
			}
			
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = mainDao.intrMainInqy1010(model, paramMap);
			model.addAttribute("menuList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// �޴� ���� ����
	public void intrMainInqy1030(String menuIdx) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ����
			// 	- 0 : ����� , 1 : ������
			//--------------------------------------------------------------------------------------------
			HttpSession session = request.getSession();
			session.setAttribute("menuType", menuIdx);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// ��ü �޴� ��ȸ
	public void intrMainInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ü �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = mainDao.intrMainInqy1020(model, paramMap);
			model.addAttribute("tMenuList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ����¡ ó��
	public void intrMainInqy1050(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		int nowPage = 1; // ������ �⺻ �� (ù ����)
		Integer page = null; // ���� ������
		String pageStr = (String)paramMap.get("page");
		//
		if(pageStr!=null && pageStr!="") page = Integer.valueOf(pageStr);
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			if(page!=null) {
				// Ư�� ������ ���� �ִ� ��� ��ü
				nowPage = page;
			}
					
			// ������ ù, ������ �ε���
			int sIdx = (nowPage-1)*Paging.BLOCKLIST+1;
			int endIdx = sIdx+Paging.BLOCKLIST-1;
			//
			//--------------------------------------------------------------------------------------------
			// ������ ���� ����
			//--------------------------------------------------------------------------------------------
			paramMap.put("nowPage", nowPage);
			paramMap.put("sIdx",sIdx);
			paramMap.put("eIdx",endIdx);
			paramMap.put("blockList",Paging.BLOCKLIST);
			paramMap.put("blockPage",Paging.BLOCKPAGE);

			// ������ �޴� ����
			String pageMenu = utilService.intPageInqy1010(paramMap);
			model.addAttribute("pageMenu", pageMenu);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// �˻� ���� ����
	public void intrMainInqy1060(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			model.addAttribute("srchMap", paramMap);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// �α��� ó��
	public String intrLoginProc1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "";
		EmpVO defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �α��� ����� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = mainDao.intrLoginInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���̵� / ��й�ȣ üũ
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
					session.setMaxInactiveInterval(60*60); // ���� �ð� 1�ð�
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

	// �α��� ���� ����� ��ȸ
	public void intrMainInqy1040(Model model) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �α��� ���� ����� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy1060(model);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
}
