package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.dao.BoardDao;
import com.intr.dao.MainDao;
import com.intr.dao.UtilDao;
import com.intr.svc.BoardService;
import com.intr.svc.UtilService;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	//
	@Autowired
	MainDao mainDao;
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	UtilDao utilDao;
	
	@Autowired
	HttpServletRequest request;
	
	// �������� ��� ��ȸ
	public void intrBoardInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� ���
			//--------------------------------------------------------------------------------------------
			defaultList = boardDao.intrBoardInqyDao1010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// ������ ���� ����
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL", "intrBoardInqy2010.do");
			//
			if(defaultList!=null && !defaultList.isEmpty() && defaultList.size()!=0) {
				paramMap.put("rowTotal", defaultList.get(0).get("listCnt"));
			} else {
				paramMap.put("rowTotal", "0");				
			}

			//--------------------------------------------------------------------------------------------
			// ��ȸ�� ���� �ʱ�ȭ
			//--------------------------------------------------------------------------------------------
			request.getSession().removeAttribute("readhit");
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// �������� ��� �Ǽ� ��ȸ
	public void intrBoardInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardDao.intrBoardInqyDao1020(model, paramMap);
			paramMap.put("rowTotal", defaultInfo.get("listCnt"));

			//--------------------------------------------------------------------------------------------
			// ������ (��������) ���� ó��
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL","intrBoardInqy2010.do");
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// �������� ��ȭ�� ��ȸ
	public void intrBoardInqyService1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� �� ����
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardDao.intrBoardInqyDao1030(model, paramMap);
			model.addAttribute("defaultInfo",defaultInfo);

			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqyDao1010(model, paramMap);
			model.addAttribute("defaultList",defaultList);

			//--------------------------------------------------------------------------------------------
			// ��ȸ�� ó��
			//--------------------------------------------------------------------------------------------
			HttpSession session = request.getSession();
			String readhit = (String)session.getAttribute("readhit");
			//
			if(readhit==null) {
				boardDao.intrBoardProcDao1040(model, paramMap);
				session.setAttribute("readhit", "hit");
			}

			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// �������� ���
	public String intrBoardProcService1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ ä��
			//--------------------------------------------------------------------------------------------
			defaultInfo = mainDao.intrMainInqyDao1030();
			paramMap.put("contId", defaultInfo.get("contId"));

			//--------------------------------------------------------------------------------------------
			// �������� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardDao.intrBoardInqyDao1030(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �������� ���
			//--------------------------------------------------------------------------------------------
			if(defaultInfo!=null) {
				resStr = "EXISTS";
			} else {
				// ���
				resInt = boardDao.intrBoardProcDao1010(paramMap);
				//
				if(resInt>0) {
					resStr = "YES";
				}
			}

			//--------------------------------------------------------------------------------------------
			// ���� ���
			//--------------------------------------------------------------------------------------------
			if(!request.getFiles("fileList").isEmpty()) {
				resStr = utilService.intrFileProcService1010(model, paramMap, request);
			}

			//--------------------------------------------------------------------------------------------
			// ��� ��ȯ
			//--------------------------------------------------------------------------------------------
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}
	
	// �������� ����
	public String intrBoardProcService1020(Model model, String [] delIdxArr) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �� ����
			//--------------------------------------------------------------------------------------------
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("delIdxArr", delIdxArr);

			//--------------------------------------------------------------------------------------------
			// �������� ����
			//--------------------------------------------------------------------------------------------
			resInt = boardDao.intrBoardProcDao1020(paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			utilDao.intrFileProcDao1050(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��� ��ȯ
			//--------------------------------------------------------------------------------------------
			if(resInt>0) {
				resStr = "YES";
			}
			//
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}
	
	// �������� ����
	public String intrBoardProcService1030(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� ����
			//--------------------------------------------------------------------------------------------
			resInt = boardDao.intrBoardProcDao1030(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			resStr = utilService.intrFileProcService1010(model, paramMap, request);

			//--------------------------------------------------------------------------------------------
			// ��� ��ȯ
			//--------------------------------------------------------------------------------------------
			if(resInt>0) {
				resStr = "YES";
			}
			//
			defaultStr = String.format("[{'res':'%s'}]", resStr);			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		
		return defaultStr;
	}

}
