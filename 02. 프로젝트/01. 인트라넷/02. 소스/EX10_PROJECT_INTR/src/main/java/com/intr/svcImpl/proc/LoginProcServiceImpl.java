package com.intr.svcImpl.proc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.dao.inqy.LoginInqyDao;
import com.intr.svc.inqy.CoreInqyService;
import com.intr.svc.proc.LoginProcService;
import com.intr.vo.EmpVO;

@Service
@Transactional
public class LoginProcServiceImpl implements LoginProcService{
	//
	@Autowired
	HttpSession session;

	@Autowired
	LoginInqyDao loginInqyDao;

	@Autowired
	CoreInqyService coreInqyService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// 로그인 처리
	public String intrLoginProc101010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		String resStr = "";
		EmpVO defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 로그인 사용자 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = loginInqyDao.intrLoginInqy10101010(model, paramMap);

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
			logger.debug("[서비스] 로그인 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}
	
	// 기초데이터 업로드 처리
	public String intrLoginProc102010(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기초데이터 업로드
			//--------------------------------------------------------------------------------------------
			resInt = coreInqyService.intrCoreInqy104010(model, paramMap, request);	
			
			if(resInt>0) {
				resStr = "YES";
			}
				
			//
			defaultStr = String.format("[{'res':'%s'}]", resStr);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 기초데이터 업로드 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}
	
}
