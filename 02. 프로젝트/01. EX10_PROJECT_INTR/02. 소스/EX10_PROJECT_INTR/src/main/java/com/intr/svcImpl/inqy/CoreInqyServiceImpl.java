package com.intr.svcImpl.inqy;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.constant.IntrConst;
import com.intr.dao.inqy.CoreInqyDao;
import com.intr.svc.inqy.BoardInqyService;
import com.intr.svc.inqy.CoreInqyService;
import com.intr.vo.EmpVO;

@Service
@Transactional
public class CoreInqyServiceImpl implements CoreInqyService{
	//
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	CoreInqyDao coreInqyDao;
	
	@Autowired
	BoardInqyService boardInqyService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// �޴� ��ȸ
	public void intrCoreInqy101010(Model model, HashMap<String, Object> paramMap) {
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
			defaultList = coreInqyDao.intrCoreInqy10101010(model, paramMap);
			model.addAttribute("menuList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[����] �޴� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}

	// �޴� ���� ����
	public void intrCoreInqy101020(String menuIdx) {
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
			logger.debug("[����] �޴� ���� ���� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}

	// ��ü �޴� ��ȸ
	public void intrCoreInqy101030(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ü �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = coreInqyDao.intrCoreInqy10103010(model, paramMap);
			model.addAttribute("tMenuList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[����] ��ü �޴� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ����¡ ó��
	public void intrCoreInqy102010(Model model, HashMap<String, Object> paramMap) {
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
			int sIdx = (nowPage-1)*IntrConst.BLOCKLIST+1;
			int endIdx = sIdx+IntrConst.BLOCKLIST-1;
			//
			//--------------------------------------------------------------------------------------------
			// ������ ���� ����
			//--------------------------------------------------------------------------------------------
			paramMap.put("nowPage", nowPage);
			paramMap.put("sIdx",sIdx);
			paramMap.put("eIdx",endIdx);
			paramMap.put("blockList",IntrConst.BLOCKLIST);
			paramMap.put("blockPage",IntrConst.BLOCKPAGE);

			// ������ �޴� ����
			String pageMenu = this.getPaging(paramMap);
			model.addAttribute("pageMenu", pageMenu);
			
		} catch (Exception e) {
			//
			logger.debug("[����] ����¡ ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ����¡ �޴� ����
	public String getPaging(HashMap<String, Object> paramMap){
		//
		String srchNm = (String)paramMap.get("srchNm")!=null?(String)paramMap.get("srchNm"):"";
		String srchSdt = (String)paramMap.get("srchSdt")!=null?(String)paramMap.get("srchSdt"):""; 
		String srchEdt = (String)paramMap.get("srchEdt")!=null?(String)paramMap.get("srchEdt"):"";
		// 
		String pageURL = (String)paramMap.get("pageURL");
		Integer nowPage = Integer.valueOf(String.valueOf(paramMap.get("nowPage")));
		Integer rowTotal = Integer.valueOf(String.valueOf(paramMap.get("rowTotal"))); 
		Integer blockList = Integer.valueOf(String.valueOf(paramMap.get("blockList")));
		Integer blockPage = Integer.valueOf(String.valueOf(paramMap.get("blockPage")));
		//
		boolean isPrevPage,isNextPage;
		StringBuffer sb; 
		//
		pageURL = pageURL+"?srchNm="+srchNm+"&srchSdt="+srchSdt+"&srchEdt="+srchEdt;
		int totalPage,		/* ��ü �������� */
            startPage,		/* ���� ������ ��ȣ */
            endPage;		/* ������ ������ ��ȣ */
		
		// ��ü ������ ��
		isPrevPage=isNextPage=false;
		totalPage = (int)(rowTotal/blockList);
		if(rowTotal%blockList!=0)totalPage++;
		
		// ���� ������ ���� ��ü ������ ���� �ʰ��� ��� ���� ���������� ��ü ������ ������ ����
		if(nowPage > totalPage)nowPage = totalPage;
		
		// ���� �������� ������ ������
		startPage = (int)(((nowPage-1)/blockPage)*blockPage+1);
		endPage = startPage + blockPage - 1; 
		// 
		if(endPage > totalPage)endPage = totalPage; // ������ ������ ���� ��ü ������ ������ ũ�� ������ ������ ���� ����
		if(endPage < totalPage)isNextPage = true; // ������ �������� ��ü ���������� ���� ��� ���� ����¡�� ������ �� �ֵ��� ���� �� ����
		if(startPage > 1)isPrevPage = true; // ���� �������� ���� 1���� ������ ���� ������ ����
		
		// HTML �ڵ� �ۼ�
		sb = new StringBuffer();

		//--------------------------------------------------------------------------------------------
		// < (����) ǥ�� ������ ó��
		//--------------------------------------------------------------------------------------------
		if(isPrevPage){
			sb.append("<a class=\"pageBtn _prev\" href='"+pageURL+"&page=");
			sb.append( startPage-1 );
			sb.append("'>���� �������� �̵�</a>");
		} else {
			// < (Ŭ���� ���� ����)
			sb.append("<a class=\"pageBtn _first\" href=\"#none\">���� �������� �̵�</a>");
		}
		//--------------------------------------------------------------------------------------------
		// ������ ��� ���
		//--------------------------------------------------------------------------------------------
		sb.append("&nbsp;");
		for(int i=startPage; i<= endPage ;i++){
			if(i>totalPage)break;
			// ���� ���õ� ������
			if(i == nowPage){ 
				sb.append("<li class=\"_active\"><a>");
				sb.append(i); // ������ ����
				sb.append("</a></li>");
			} else {
				// ���õ��� ���� ������
				sb.append("<li class=\"\"><a href='"+pageURL+"&page=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a></li>");
			}
		}
		//
		sb.append("&nbsp;&nbsp;");
		
		//--------------------------------------------------------------------------------------------
		// > (����) ǥ�� ������ ó��
		//--------------------------------------------------------------------------------------------
		if(isNextPage){
			sb.append("<a class=\"pageBtn _next\" href='"+pageURL+"&page=");
			sb.append(endPage + 1);
			sb.append("'>���� �������� �̵�</a>"); // Ŭ���� �Ǵ� ȭ��ǥ
		} else {
			sb.append("<a class=\"pageBtn _last\" href=\"#none\">���� �������� �̵�</a>"); // Ŭ���� �ȵǴ� ȭ��ǥ
		}
		//
		return sb.toString();
	}
	
	// �˻� ���� ����
	public void intrCoreInqy103010(Model model, HashMap<String, Object> paramMap) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			model.addAttribute("srchMap", paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[����] �˻� ���� ���� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ���ʵ����� ���ε�
	public int intrCoreInqy104010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���ʵ����� ���ε�
			//--------------------------------------------------------------------------------------------
			
			
		} catch (Exception e) {
			//
			logger.debug("[����] ���ʵ����� ���ε� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return 0;
	}
}
