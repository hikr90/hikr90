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
	public void intrBoardInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� ���
			//--------------------------------------------------------------------------------------------
			defaultList = boardDao.intrBoardInqy1010(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// ������ ���� ����
			//--------------------------------------------------------------------------------------------
			paramMap.put("pageURL", "intrBoardInqy2010.do");
			//
			if(defaultList!=null && defaultList.size()!=0) {
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
	public void intrBoardInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardDao.intrBoardInqy1020(model, paramMap);
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
	public void intrBoardInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� �� ����
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardDao.intrBoardInqy1030(model, paramMap);
			model.addAttribute("defaultInfo",defaultInfo);

			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqy1010(model, paramMap);
			model.addAttribute("defaultList",defaultList);

			//--------------------------------------------------------------------------------------------
			// ��ȸ�� ó��
			//--------------------------------------------------------------------------------------------
			HttpSession session = request.getSession();
			String readhit = (String)session.getAttribute("readhit");
			//
			if(readhit==null) {
				boardDao.intrBoardProc1040(model, paramMap);
				session.setAttribute("readhit", "hit");
			}

			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// �������� ���
	public String intrBoardProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ ä�� (������)
			//--------------------------------------------------------------------------------------------
			defaultInfo = mainDao.intrMainInqy1030();
			paramMap.put("contentIdx", defaultInfo.get("contentIdx"));

			//--------------------------------------------------------------------------------------------
			// �������� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardDao.intrBoardInqy1030(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �������� ��� (INTR_BOARD)
			//--------------------------------------------------------------------------------------------
			if(defaultInfo!=null) {
				resStr = "EXISTS";
			} else {
				// ���
				resInt = boardDao.intrBoardProc1010(paramMap);
				//
				if(resInt>0) {
					resStr = "YES";
				}
			}

			//--------------------------------------------------------------------------------------------
			// ���� ��� (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			if(!request.getFiles("fileList").isEmpty()) {
				resStr = utilService.intrFileProc1010(model, paramMap, request);
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
	public String intrBoardProc1020(Model model, String [] delIdxArr) throws Exception {
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
			resInt = boardDao.intrBoardProc1020(paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ���� (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			utilDao.intrFileProc1050(paramMap);
			
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
	public String intrBoardProc1030(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� ���� (INTR_BOARD)
			//--------------------------------------------------------------------------------------------
			resInt = boardDao.intrBoardProc1030(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ���� (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			resStr = utilService.intrFileProc1010(model, paramMap, request);

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
