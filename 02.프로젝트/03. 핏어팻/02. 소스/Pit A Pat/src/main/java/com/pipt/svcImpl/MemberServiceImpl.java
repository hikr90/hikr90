package com.pipt.svcImpl;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.pipt.dao.MemberDAO;
import com.pipt.svc.MemberService;
import com.pipt.utils.Path;

@Service 
public class MemberServiceImpl implements MemberService{
	//
	@Autowired
	SqlSession sqlsession;

	@Autowired
	HttpSession session;
	
	@Autowired
	MemberDAO memberDao;

	// 로그인 처리
	public String piptMemberInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String returnUrl = Path.LOGIN_PATH + "pipt_login_inqy_1010.jsp";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 회원정보 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = memberDao.piptMemberInqy1010(paramMap);
			//
			if(defaultInfo!=null) {
				session.setAttribute("memberVO", defaultInfo);
				returnUrl = Path.VIEW_PATH + "pipt_main_inqy_1010.jsp";
			}
			  
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return returnUrl;
	}
	
	// 아이디 중복 체크
	public String piptMemberProc1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String res = "no";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 회원정보 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = memberDao.piptMemberInqy1010(paramMap);
			//
			if(defaultInfo==null) {
				res = "yes";
			}
			// 결과 저장
			defaultStr = String.format("[{'result' : '%s'}, {'memberId':'%s'}]", res, (String)paramMap.get("memberId"));
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return defaultStr;
	}
	
	// 회원가입 처리
	public void piptMemberProc1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 회원가입 처리
			//--------------------------------------------------------------------------------------------
			memberDao.piptMemberProc1020(paramMap);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 아이디 찾기
	public String piptMemberProc1040(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String res = "no";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 회원정보 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = memberDao.piptMemberInqy1010(paramMap);
			//
			if(defaultInfo==null) {
				res = "yes";
			}
			// 결과 저장
			defaultStr = String.format("[{'result' : '%s'}, {'memberId':'%s'}]", res, (String)paramMap.get("memberId"));
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return defaultStr;
	}
	
	// 비밀번호 찾기
	public String piptMemberProc1050(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String defaultStr = "";
		String res = "no";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 회원정보 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = memberDao.piptMemberInqy1010(paramMap);
			//
			if(defaultInfo==null) {
				res = "yes";
			}
			// 결과 저장
			defaultStr = String.format("[{'result' : '%s'}, {'memberPwd':'%s'}]", res, (String)paramMap.get("memberPwd"));
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return defaultStr;
	}
}
