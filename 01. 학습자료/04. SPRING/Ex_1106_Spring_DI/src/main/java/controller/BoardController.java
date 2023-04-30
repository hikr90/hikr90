package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardService;


/* CONTROLLER ANNOTATION 
 		- JSP에서의 URL 맵핑처럼 SPRING 역시 외부의 요청을 받아 처리하는 페이지가 있다.
 		- 스프링에서는 컨트롤러가 해당 역할을 수행하는데 해당 클래스가 컨트롤러임을 명시하는 것이 컨트롤러 어노테이션이다.
 		- 어노테이션(프로그래밍 주석)은 스프링에서 특수한 기능으로서 동작하게 만드는 표식이다.
 		- 컨트롤러 어노테이션이 없는 경우 컴파일러가 컨트롤러로 인식하지 못하여 맵핑이 되지 않는다.
*/

@Controller
public class BoardController {
	/* 	BOARDSERVCIE 객체 생성
			- 어노테이션을 수동으로 지정하였으므로 BOARDSERVICE객체를 받아줘야한다.
	*/
	BoardService service;
	
	public void setService(BoardService service) {
		this.service = service;
	}

	/*	CONTROLLER와 SERVLET 차이
			- 컨트롤러는 서블릿의 역할을 대신한다.
			- 한가지의 맵핑만 가능한 서블릿과 다르게 컨트롤러는 맵핑을 메소드를 생성하므로 다수의 맵핑이 가능하다.
			- 포워드와 바인드를 위해서 맵핑 메소드의 변수로 MODEL을 사용한다.
		
		MODEL
			- 서블릿과 컨트롤러의 중간 매개체 역할 수행
			- REQUEST객체와 비슷하나 실제로 REQUEST보다는 설정 범위가 좁다.
	*/
	@RequestMapping(value= {"/","/list.do"})
	public String list(Model model) {
		/* ROOT-CONTEXT >>> SERVLET-CONTEXT의 객체 주입
		 		- ROOT-CONTEXT에서 BOARDDAOIMPL과 BOARDSERVICEIMPL 주입한 SERVICEBEAN객체를
		  		- SERVLET-CONTEXT의 컨트롤러에서 주입하여 SERVICE객체로 사용하여
		 		- SERVICE.SELECTLIST메소드에 접근하여 CRUD로 접근이 가능하다.
		*/
		List list = service.viewList();  
		model.addAttribute("list", list); 	// BINDING
		return "board_list";				// FORWARDING
	}
}
