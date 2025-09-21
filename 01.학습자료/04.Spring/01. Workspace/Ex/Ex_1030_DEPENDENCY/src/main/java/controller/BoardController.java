package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardService;


/* @Controller
 *		- 스프링에서 컨트롤러가 해당 역할을 수행하는데 해당 클래스가 컨트롤러임을 명시한다.
 *		- 컨트롤러 어노테이션이 없는 경우 컴파일러가 컨트롤러로 인식하지 못하여 맵핑 주소를 감지하지 못한다.
 *
 *		[참고] 컨트롤러와 서블릿의 차이
 *			- 컨트롤러는 서블릿의 역할을 대신한다.
 *			- 한가지 맵핑만 가능한 서블릿과 다르게 컨트롤러는 맵핑을 메소드 단위로 여러가지 메소드의 맵핑이 가능하다.
 */

@Controller
public class BoardController {
	
	// 수동 주입 방식이므로 따로 서비스 객체를 받아줘야한다.
	BoardService service;
	
	public void setService(BoardService service) {
		this.service = service;
	}
	
	// 목록 조회
	@RequestMapping(value= {"/","/list.do"})
	public String list(Model model) {
		/* root-context.xml > servlet-context.xml을 통한 객체 주입
		 * 	- root-context에서 BoardDaoImpl과 BoardServiceImpl을 주입한 serviceBean 객체를 servlet-context의 컨트롤러에 주입하여	
		 * 	- servlet-context의 컨트롤러에서 주입하여 service 객체로 사용한다.
		 * 	- Service객체에서 생성해둔 CRUD 메소드로 접근이 가능하다.
		 */
		List list = service.viewList();  
		model.addAttribute("list", list); 	// Binding
		return "board_list";				// Forwarding
	}
}
