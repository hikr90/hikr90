package com.intr.svcImpl.proc;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.inqy.LoginInqyDao;
import com.intr.dao.proc.LoginProcDao;
import com.intr.svc.proc.LoginProcService;
import com.intr.vo.EmpVO;

@Service
@Transactional
public class LoginProcServiceImpl implements LoginProcService{
	//
	@Autowired
	HttpSession session;

	@Autowired
	LoginProcDao loginProcDao;

	@Autowired
	LoginInqyDao loginInqyDao;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// 로그인_로그인 처리
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
	
	// 로그인_관리자 계정 등록
	public String intrLoginProc102010(Model model) {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String resStr = "NO";
		int resInt = 0;
		
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 관리자 여부 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = loginInqyDao.intrLoginInqy10201010(model);
			
			//
			if(defaultInfo==null) {
				//--------------------------------------------------------------------------------------------
				// 관리자 계정 등록 (INTR_EMP)
				//--------------------------------------------------------------------------------------------
				resInt = loginProcDao.intrLoginProc10201020(model);
				// 
				if(resInt>0) {
					resStr = "YES";
				}
				
			} 
			
			//
			defaultStr = String.format("[{'res':'%s'}]", resStr);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 관리자 계정 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		return defaultStr;
	}
	
}
