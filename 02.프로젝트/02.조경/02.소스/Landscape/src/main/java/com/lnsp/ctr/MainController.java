package com.lnsp.ctr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lnsp.dao.MemberDAO;
import com.lnsp.svc.MainService;
import com.lnsp.utils.Path;
import com.lnsp.vo.MemberVO;

@Controller
public class MainController {
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	MainService mainService;

	// 메인화면 조회
	@RequestMapping(value={"/","/index.do"})
	public String index(Locale locale, Model model) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메인화면 조회
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 메인화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH + "index.jsp";
	}
	
	// 로그인화면 조회
	@RequestMapping("/login_form.do")
	public String login_form(Locale locale, Model model) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 로그인 화면 조회
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 로그인화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH + "login.jsp";
	}
	
	/*
	 * @RequestMapping("/login_form.do") public String login_form() {
	 * 
	 * return VIEW_PATH + "login.jsp"; }
	 * 
	 * @RequestMapping("/login.do") public String login(HttpServletResponse
	 * response, String id, String pwd) throws IOException {
	 * 
	 * HttpSession session = request.getSession();
	 * 
	 * Map<String, String> map = new HashMap<String, String>();
	 * 
	 * map.put("id", id); map.put("pwd", pwd);
	 * 
	 * MemberVO user = member_dao.selectOne(map);
	 * 
	 * response.setContentType("text/html; charset=UTF-8");
	 * 
	 * if (user != null) { session.setAttribute("user", user); PrintWriter out =
	 * response.getWriter();
	 * 
	 * out.println("<script>alert('로그인 성공!');</script>");
	 * 
	 * out.flush(); } else { PrintWriter out = response.getWriter();
	 * 
	 * out.println("<script>alert('로그인 실패!'); </script>");
	 * 
	 * out.flush();
	 * 
	 * return VIEW_PATH + "login.jsp"; }
	 * 
	 * // 일반 유저 / 관리자 확인 MemberVO user_check = (MemberVO)
	 * (session.getAttribute("user"));
	 * 
	 * if (user_check.getM_id().equals("admin")) { return "forward:manager.do"; //
	 * 관리자 전용 페이지로 이동 // redirect 사용시 버그발생 // 아마 Session관련으로 작동오류로 보임 }
	 * 
	 * return VIEW_PATH + "index.jsp"; }
	 * 
	 * @RequestMapping("/signup_form.do") public String signup_form() {
	 * 
	 * return VIEW_PATH + "joinForm.jsp"; }
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("/check_id.do") public String check_id(String m_id) {
	 * 
	 * MemberVO vo = member_dao.check_id(m_id);
	 * 
	 * String res = "no";
	 * 
	 * if (vo == null) { res = "yes"; }
	 * 
	 * String resultStr = String.format("[{'result' : '%s'}, {'m_id':'%s'}]", res,
	 * m_id);
	 * 
	 * return resultStr; }
	 * 
	 * @RequestMapping("/signup.do") public String signup(MemberVO vo) {
	 * 
	 * String birth1 = request.getParameter("birth1"); String birth2 =
	 * request.getParameter("birth2"); String birth3 =
	 * request.getParameter("birth3");
	 * 
	 * String m_birth = birth1 + "-" + birth2 + "-" + birth3;
	 * 
	 * String hp1 = request.getParameter("hp1"); String hp2 =
	 * request.getParameter("hp2"); String hp3 = request.getParameter("hp3");
	 * 
	 * String m_phone = hp1 + "-" + hp2 + "-" + hp3;
	 * 
	 * String tel1 = request.getParameter("tel1"); String tel2 =
	 * request.getParameter("tel2"); String tel3 = request.getParameter("tel3");
	 * 
	 * String m_tell = tel1 + "-" + tel2 + "-" + tel3;
	 * 
	 * String zipcode = request.getParameter("zipcode"); String addr =
	 * request.getParameter("addr"); String address =
	 * request.getParameter("address");
	 * 
	 * String m_addr = zipcode + " " + addr + " " + address;
	 * 
	 * String email1 = request.getParameter("email1"); String email2 =
	 * request.getParameter("email2");
	 * 
	 * String m_email = email1 + "@" + email2;
	 * 
	 * vo.setM_birth(m_birth); vo.setM_phone(m_phone); vo.setM_tell(m_tell);
	 * vo.setM_addr(m_addr); vo.setM_email(m_email);
	 * 
	 * member_dao.signup(vo);
	 * 
	 * return "redirect:index.do"; }
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("/logout.do") public String logout() { HttpSession session =
	 * request.getSession(); session.removeAttribute("user");
	 * 
	 * String res = "yes";
	 * 
	 * String resultStr = String.format("[{'result' : '%s'}]", res);
	 * 
	 * return resultStr; }
	 * 
	 * // 아이디 찾기
	 * 
	 * @RequestMapping("/searchID.do") public String searchID(Model model) { return
	 * VIEW_PATH + "searchID.jsp"; }
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("/searchID_action.do") public String searchID_action(Model
	 * model, String m_name, String m_phone) { HashMap<String, String> map = new
	 * HashMap<String, String>(); map.put("m_name", m_name); map.put("m_phone",
	 * m_phone); int res = member_dao.check_memberid(map);
	 * 
	 * String m_id = ""; if( res == 1 ) { m_id = member_dao.get_memberid(map); }
	 * 
	 * String resultStr = String.format("[{'result':'%d','m_id':'%s'}]",res,m_id);
	 * 
	 * return resultStr; }
	 * 
	 * // 비밀번호 찾기
	 * 
	 * @RequestMapping("/searchPW.do") public String searchPW(Model model) { return
	 * VIEW_PATH + "searchPW.jsp"; }
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("/searchPW_action.do") public String searchPW_action(Model
	 * model, String m_id, String m_email) { HashMap<String, String> map = new
	 * HashMap<String, String>(); map.put("m_id", m_id); map.put("m_email",
	 * m_email); int res = member_dao.check_memberpwd(map);
	 * 
	 * String m_pwd = ""; if( res == 1 ) { m_pwd = member_dao.get_memberpwd(map); }
	 * 
	 * String resultStr = String.format("[{'result':'%d','m_pwd':'%s'}]",res,m_pwd);
	 * 
	 * return resultStr; }
	 */
}
