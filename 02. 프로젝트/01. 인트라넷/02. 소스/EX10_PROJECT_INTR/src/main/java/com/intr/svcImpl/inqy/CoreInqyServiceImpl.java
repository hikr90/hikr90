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

	// 메뉴 조회
	public void intrCoreInqy101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		EmpVO empInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 정보 세션 조회
			//--------------------------------------------------------------------------------------------
			HttpSession session = request.getSession();
			String menuType = (String)session.getAttribute("menuType");
			// 메뉴 정보가 들어있는 경우
			if(menuType!=null) {
				paramMap.put("menuType", menuType);
			}

			//--------------------------------------------------------------------------------------------
			// 로그인 정보 세션 조회
			//--------------------------------------------------------------------------------------------
			empInfo = (EmpVO)session.getAttribute("empVO");
			//
			if(empInfo!=null) {
				paramMap.put("empIdx", empInfo.getEmpIdx());
			}
			
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			defaultList = coreInqyDao.intrCoreInqy10101010(model, paramMap);
			model.addAttribute("menuList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 메뉴 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

	// 메뉴 세션 저장
	public void intrCoreInqy101020(String menuIdx) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 세션 저장
			// 	- 0 : 사용자 , 1 : 관리자
			//--------------------------------------------------------------------------------------------
			HttpSession session = request.getSession();
			session.setAttribute("menuType", menuIdx);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 메뉴 세션 저장 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

	// 전체 메뉴 조회
	public void intrCoreInqy101030(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 전체 메뉴 조회
			//--------------------------------------------------------------------------------------------
			defaultList = coreInqyDao.intrCoreInqy10103010(model, paramMap);
			model.addAttribute("tMenuList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 전체 메뉴 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 페이징 처리
	public void intrCoreInqy102010(Model model, HashMap<String, Object> paramMap) {
		//
		int nowPage = 1; // 페이지 기본 값 (첫 동작)
		Integer page = null; // 현재 페이지
		String pageStr = (String)paramMap.get("page");
		//
		if(pageStr!=null && pageStr!="") page = Integer.valueOf(pageStr);
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 페이징 처리
			//--------------------------------------------------------------------------------------------
			if(page!=null) {
				// 특정 페이지 값이 있는 경우 대체
				nowPage = page;
			}
					
			// 페이지 첫, 마지막 인덱스
			int sIdx = (nowPage-1)*IntrConst.BLOCKLIST+1;
			int endIdx = sIdx+IntrConst.BLOCKLIST-1;
			//
			//--------------------------------------------------------------------------------------------
			// 페이지 변수 저장
			//--------------------------------------------------------------------------------------------
			paramMap.put("nowPage", nowPage);
			paramMap.put("sIdx",sIdx);
			paramMap.put("eIdx",endIdx);
			paramMap.put("blockList",IntrConst.BLOCKLIST);
			paramMap.put("blockPage",IntrConst.BLOCKPAGE);

			// 페이지 메뉴 구성
			String pageMenu = this.getPaging(paramMap);
			model.addAttribute("pageMenu", pageMenu);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 페이징 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 페이징 메뉴 생성
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
		int totalPage,		/* 전체 페이지수 */
            startPage,		/* 시작 페이지 번호 */
            endPage;		/* 마지막 페이지 번호 */
		
		// 전체 페이지 수
		isPrevPage=isNextPage=false;
		totalPage = (int)(rowTotal/blockList);
		if(rowTotal%blockList!=0)totalPage++;
		
		// 현재 페이지 수가 전체 페이지 수를 초과할 경우 현재 페이지값을 전체 페이지 값으로 변경
		if(nowPage > totalPage)nowPage = totalPage;
		
		// 시작 페이지와 마지막 페이지
		startPage = (int)(((nowPage-1)/blockPage)*blockPage+1);
		endPage = startPage + blockPage - 1; 
		// 
		if(endPage > totalPage)endPage = totalPage; // 마지막 페이지 수가 전체 페이지 수보다 크면 마지막 페이지 값을 변경
		if(endPage < totalPage)isNextPage = true; // 마지막 페이지가 전체 페이지보다 작을 경우 다음 페이징이 적용할 수 있도록 변수 값 설정
		if(startPage > 1)isPrevPage = true; // 시작 페이지의 값이 1보다 작으면 이전 페이지 적용
		
		// HTML 코드 작성
		sb = new StringBuffer();

		//--------------------------------------------------------------------------------------------
		// < (이전) 표시 페이지 처리
		//--------------------------------------------------------------------------------------------
		if(isPrevPage){
			sb.append("<a class=\"pageBtn _prev\" href='"+pageURL+"&page=");
			sb.append( startPage-1 );
			sb.append("'>이전 페이지로 이동</a>");
		} else {
			// < (클릭이 되지 않음)
			sb.append("<a class=\"pageBtn _first\" href=\"#none\">이전 페이지로 이동</a>");
		}
		//--------------------------------------------------------------------------------------------
		// 페이지 목록 출력
		//--------------------------------------------------------------------------------------------
		sb.append("&nbsp;");
		for(int i=startPage; i<= endPage ;i++){
			if(i>totalPage)break;
			// 현재 선택된 페이지
			if(i == nowPage){ 
				sb.append("<li class=\"_active\"><a>");
				sb.append(i); // 페이지 숫자
				sb.append("</a></li>");
			} else {
				// 선택되지 않은 페이지
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
		// > (다음) 표시 페이지 처리
		//--------------------------------------------------------------------------------------------
		if(isNextPage){
			sb.append("<a class=\"pageBtn _next\" href='"+pageURL+"&page=");
			sb.append(endPage + 1);
			sb.append("'>다음 페이지로 이동</a>"); // 클릭이 되는 화살표
		} else {
			sb.append("<a class=\"pageBtn _last\" href=\"#none\">다음 페이지로 이동</a>"); // 클릭이 안되는 화살표
		}
		//
		return sb.toString();
	}
	
	// 검색 조건 저장
	public void intrCoreInqy103010(Model model, HashMap<String, Object> paramMap) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			model.addAttribute("srchMap", paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 검색 조건 저장 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 기초데이터 업로드
	public int intrCoreInqy104010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기초데이터 업로드
			//--------------------------------------------------------------------------------------------
			
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 기초데이터 업로드 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return 0;
	}
}
