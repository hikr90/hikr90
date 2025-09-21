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
import com.intr.dao.UtilDao;
import com.intr.svc.BoardService;
import com.intr.svc.CoreService;
import com.intr.svc.EmpService;
import com.intr.svc.MainService;
import com.intr.svc.UtilService;

@Service
@Transactional(rollbackFor = Exception.class)
public class BoardServiceImpl implements BoardService{
	//
	@Autowired
	HttpServletRequest request;

	@Autowired
	CoreService coreService;

	@Autowired
	MainService mainService;
	
	@Autowired
	EmpService empService;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	UtilDao utilDao;
	
	// �������� ��� ��ȸ
	public void intrBoardInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			utilService.setPaging(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ���
			//--------------------------------------------------------------------------------------------
			defaultList = boardDao.intrBoardInqy1011(model, paramMap);
			model.addAttribute("defaultList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// �����ڵ� (��뿩��) ��ȸ
			//--------------------------------------------------------------------------------------------
			paramMap.put("commcodeGcd", 	"USE");
			defaultList = utilDao.intrCodeInqy1011(paramMap);
			model.addAttribute("useList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// ��ȸ�� ���� �ʱ�ȭ
			//--------------------------------------------------------------------------------------------
			request.getSession().removeAttribute("readHit");
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// �������� ��ȭ�� ��ȸ
	public void intrBoardInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� �� ����
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardDao.intrBoardInqy1021(model, paramMap);
			model.addAttribute("defaultInfo",defaultInfo);

			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqy1011(model, paramMap);
			model.addAttribute("fileList",defaultList);

			//--------------------------------------------------------------------------------------------
			// ��ȸ�� ó��
			//--------------------------------------------------------------------------------------------
			HttpSession session = request.getSession();
			String readHit = (String)session.getAttribute("readHit");
			//
			if(readHit==null) {
				boardDao.intrBoardProc1032(model, paramMap);
				session.setAttribute("readHit", "hit");
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
			// �������� ä��
			//--------------------------------------------------------------------------------------------
			defaultInfo = boardDao.intrBoardInqy1010(model, paramMap);
			paramMap.put("sequenceId", (String)defaultInfo.get("sequenceId"));
			
			//--------------------------------------------------------------------------------------------
			// �������� ���
			//--------------------------------------------------------------------------------------------
			resInt = boardDao.intrBoardProc1011(paramMap);
			//
			if(resInt>0) {
				resStr = "YES";
			}

			//--------------------------------------------------------------------------------------------
			// ���� ���
			//--------------------------------------------------------------------------------------------
			resStr = utilService.fileUpload(model, paramMap, request);
			
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
			resInt = boardDao.intrBoardProc1021(paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ���� ó�� (����)
			//--------------------------------------------------------------------------------------------
			utilDao.intrFileProc1022(paramMap);
			
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
			// �������� ����
			//--------------------------------------------------------------------------------------------
			resInt = boardDao.intrBoardProc1031(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			resStr = utilService.fileUpload(model, paramMap, request);

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
