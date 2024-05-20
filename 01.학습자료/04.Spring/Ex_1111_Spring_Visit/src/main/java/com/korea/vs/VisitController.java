package com.korea.vs;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.VisitDAO;
import util.Util;
import vo.VisitVO;

@Controller
public class VisitController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ServletContext application;
	
	VisitDAO visit_dao;
	
	public void setVisit_dao(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}
	
	// 방명록 리스트
	@RequestMapping(value= {"/","/list.do"})
	public String list(Model model) {
		//
		List<VisitVO> list = visit_dao.selectList();
		model.addAttribute("list",list);
		return Util.Visit.VIEW_PATH + "visit_list.jsp";
	}
	
	// 방명록 입력폼 이동
	@RequestMapping("/insert_form.do")
	public String insert_form() {
		//
		return Util.Visit.VIEW_PATH + "visit_insert_form.jsp";
	}
	
	// 방명록 글 등록
	@RequestMapping("/insert.do")
	public String insert(VisitVO vo) throws IllegalStateException, IOException {
		// IP
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		// 절대 경로 설정
		String webPath = "/resources/upload/";
		String savePath = application.getRealPath(webPath);
		System.out.println(savePath);
		
		// 업로드된 파일 정보 가져오기
		MultipartFile photo = vo.getPhoto();
		String filename = "no_file";
		//
		if(!photo.isEmpty()) {
			filename = photo.getOriginalFilename();
			File saveFile = new File(savePath, filename);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}else {
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time,filename);
				saveFile = new File(savePath, filename);
			}
			//
			photo.transferTo(saveFile);
		}
		//
		vo.setFilename(filename);
		
		int res = visit_dao.insert(vo);
		
		/*	redirect
		 *		- 컨트롤러 내에 있는 타 맵핑주소의 메소드를 바로 호출하는 기능
		 *		- 만약 아래의 리턴값을 Jsp명칭으로 할 경우 데이터 처리 없이 화면으로 이동하므로 빈 화면만 보이게 된다.
		 */
		return "redirect:list.do";
	}
	
	// 방명록 글 삭제
	@RequestMapping("/delete.do")
	
	
	/*	@ResponseBody
	 *		- Ajax로 요청받은 url맵핑 메소드는 반드시 해당 어노테이션을 붙여줘야한다.
	 *		- 해당 어노테이션이 처리된 메소드는 return의 값을 콜백 메소드로 반환되며 메소드의 리턴값이 반환된다.
	 */
	@ResponseBody()
	public String delete(int idx) {
		//
		int res = visit_dao.delete(idx);
		String result = "no";
		//
		if(res==1) {
			result = "yes";
		}
		//
		return result;
	}
	
	// 방명록 수정 페이지로 이동 
	@RequestMapping("/modify_form.do")
	public String modify_form(int idx, Model model) {
		//
		VisitVO vo = visit_dao.selectOne(idx);	
		model.addAttribute("vo",vo);
		return Util.Visit.VIEW_PATH + "visit_modify_form.jsp";
	}
	
	// 방명록 수정
	@RequestMapping("/modify.do")
	public String modify(VisitVO vo) throws IllegalStateException, IOException {
		//
		String ip = request.getRemoteAddr(); 
		vo.setIp(ip);
		//
		String webPath = "/resources/upload/";
		String savePath = application.getRealPath(webPath);
		System.out.println(savePath);
		//
		MultipartFile photo = vo.getPhoto();
		String filename = "no_file";
		//
		if(!photo.isEmpty()) {
			filename = photo.getOriginalFilename();
			File saveFile = new File(savePath,filename);
			//
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}else {
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time,filename);
				saveFile = new File(savePath,filename);
			}
			//
			photo.transferTo(saveFile);
		}
		// 파일 명칭 저장
		vo.setFilename(filename);
		// 방명록 수정 처리
		int res = visit_dao.update(vo);
		//
		return "redirect:list.do";
	}
}
