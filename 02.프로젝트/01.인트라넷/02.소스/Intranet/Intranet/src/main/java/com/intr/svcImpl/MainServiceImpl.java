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
import com.intr.svc.MainService;
import com.intr.svc.UtilService;
import com.intr.vo.EmpVO;

@Service
@Transactional(rollbackFor = Exception.class)
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
	UtilService utilService;
	
	// 로그인 권한 사용자 조회
	public void intrMainInqy1010(Model model) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 로그인 권한 사용자 조회
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy5011(model);
			//
			if(defaultList != null) {
				for(int i=0;i<defaultList.size();i++) {
					String decPwd = utilService.decryptProc((String)defaultList.get(i).get("empPwd"));
					defaultList.get(i).put("decpwd", decPwd);
				}
			}
			//
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 로그인 처리
	public String intrMainProc1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		String resStr = "";
		EmpVO defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 로그인 사용자 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = mainDao.intrMainInqy1011(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 아이디 / 비밀번호 체크
			//--------------------------------------------------------------------------------------------
			if(defaultInfo!=null) {
				String paramPwd = (String)paramMap.get("empPwd");		// 비밀번호 (입력)
				String encryptPwd = (String)defaultInfo.getEmpPwd();		// 비밀번호 (DB)
				
				//--------------------------------------------------------------------------------------------
				// 비밀번호 복호화
				//--------------------------------------------------------------------------------------------
				String decryptPwd = utilService.decryptProc(encryptPwd);
				//
				if(!paramPwd.equalsIgnoreCase(decryptPwd)) {
					resStr = "NO_PWD";
				} else {
					//
					resStr = "YES";
					session.setAttribute("empVO", defaultInfo);
					session.setMaxInactiveInterval(60*60); // 1시간
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
}
