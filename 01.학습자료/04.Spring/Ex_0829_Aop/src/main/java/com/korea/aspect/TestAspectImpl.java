package com.korea.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*	@Component 어노테이션
 		- 컴포턴트 스캔 설정을 사용하는 경우 해당 어노테이션이 있는 클래스를 자동으로 빈 등록 하도록 지정하는 어노테이션 
 		- 직접 작성한 클래스를 자동으로 빈 등록하는 경우 사용한다.
*/
@Component
@Aspect
public class TestAspectImpl {
	/* AOP
	 * 	- Aspect Oriented Programming
	 * 	- 메소드 안의 주 기능과 보조 기능을 분리한 뒤 선택적으로 메소드에 적용해서 사용하는 방식을 뜻한다.
	 * 	- 반복적인 공통 기능을 독립적으로 분리하여 쉽게 재사용할 수 있도록 하는데 목적을 둔다.
	 * 	- 클래스의 메소드마다 기능을 구현하지 않고 한 곳의 장소에 모아 관리하므로 코드의 가독성이 좋아진다.
	 * 
	 * 
	 * 		용어
	 * 			(1) Aspect
	 * 				- 로깅이나 보안 등 구현하고자하는 공통적인 보조 기능
	 * 				- 기능을 뜻하는 추상적인 개념으로서, 기능의 코드에 해당하는 어드바이스와 작용지점을 가르키는 조인 포인트로 나누어져있다.
	 * 		
	 * 			(2) Advice
	 * 				- 메소드의 호출을 기준으로 여러 지점에서 동작한다.
	 * 				- aspect의 구현체 (클래스)를 보조 기능에 해당하는 코드를 담는 하나의 독립된 클래스를 뜻한다.
	 * 				- 어드바이스 내에서 구현된 메소드는 조인 포인트와 포인트 컷으로 적용되는 시점과 영역을 지정할 수 있다.
	 * 
	 * 			(3) JoinPoint
	 * 				- 어드바이스가 적용되는 시점을 뜻한다.
	 * 				- 어드바이스 내에서는 메소드에 @Aspect를 사용하여 적용 지점을 지정한다.
	 * 
	 * 				(3.1) before : 메소드가 동작하기 전 동작
	 * 				(3.2) after : 메소드의 동작이 종료된 후 동작
	 * 				(3.3) after-returning : 메소드가 성공적으로 완료되어 리턴된 뒤 동작
	 * 				(3.4) after-throwing : 메소드 동작 중 예외가 발생하면 동작
	 * 
	 * 				# around
	 * 					- 메소드의 동작 전과 후에 동작하는 기능
	 * 					- 타 어노테이션과 다르게 반드시 joinpoint를 파라미터로 받아야한다.
	 * 					- joinpoint객체의 procced메소드를 통해서 메소드의 리턴 값을 받을 수 있다.
	 * 	
	 * 			(4) PointCut
	 * 				- 어드바이스가 적용되는 대상을 지정한다.
	 * 				- 포인트컷 정규식을 사용하여 excution(리턴타입 패키지 경로.클래스명.메소드명(매개변수))의 방식으로 지정할 수 있다.
	 * 
	 *	 			# 포인트컷 정규표현식
	 * 					(4.1) 접근제한자
	 * 						- public, private등의 타입을 선택할 수 있으며 *으로 전체를 지정할 수 있다.
	 * 						- 접근제한자는 표현식에서 생략할 수 있다.
	 * 						- !void등의 방식으로 해당 타입을 제외한 나머지 타입을 한번에 처리할 수 있다.
	 * 
	 * 					(4.2) 패키지명
	 * 						- com.korea.service : 해당 패키지 경로까지만 지정
	 * 						- com.korea.service.. : 해당 패키지 경로의 하위 패키지까지 전부 지정
	 * 						- com.korea.ser..ce : 해당 패키지 경로 내 ser로 시작하여 ce로 끝나는 패키지를 선택
	 * 
	 * 					(4.3) 클래스명
	 * 						- TestService : 해당 명칭의 클래스 선택
	 * 						- *Service : 클래스명이 Service로 끝나는 클래스 선택
	 * 						- Test* : 클래스명이 Test로 시작하는 클래스 선택
	 * 						- TestService+ : 해당 클래스에서 파생된 모든 자식 클래스 혹은 인터페이스 선택
	 * 
	 * 					(4.4) 메소드
	 * 						- * : 모든 메소드 선택
	 * 						- 클래스명과 마찬가지로 앞 뒤로 *를 붙여 사용할 수 있다.
	 * 						- 메소드 타입은 매개변수 타입과 함께 표현식을 반드시 사용해야한다.
	 * 
	 * 					(4.5) 매개변수
	 * 						- (..) : 타입과 갯수 상관없이 모든 매개 변수를 가지는 메소드를 선택
	 * 						- (*) : 타입 상관없이 한가지의 매개 변수를 가지는 메소드 선택
	 * 						- (org.springframework.ui.model) : 매개변수 model을 가지는 메소드 선택 (특정 매개변수를 지정하는 경우 반드시 전체 패키지 경로를 기입해야한다.)
	 * 						- (String, ..) : 한 개 이상의 파라미터를 가지되 첫 매개변수가 String 타입인 메소드
	 * 						- (Integer, *) : 첫번째 파라미터가 Integer타입인 두가지의 파라미터를 가지는 메소드
	 * 			
	 *			(5) Target
	 *				- 어드바이스가 적용되는 클래스를 뜻한다.
	 *				- 본 예제에서는 TestServiceImpl 클래스를 뜻한다.
	 *	
	 *			(6) Weaving
	 *				- 보조 기능 (어드바이스)을 주기능에 적용하는 것을 뜻한다.
	 *
	 *		메소드
	 *			# JointPoint
	 *				(1) getTarget : 클라이언트가 호출한 클래스의 메소드를 포함하는 Object 객체 반환
	 *				(2) getTargs : 클라이언트가 호출한 클래스의 메소드의 인자를 Object타입의 배열로 반환
	 *				(3) getSignature : 시그니처 (메소드명, 명칭, 매개변수 정보) 객체 반환
	 *
	 *			# Signature
	 *				(1) getName : 클라이언트가 호출한 메소드 명칭
	 *				(2) toLongString : 클라이언트가 호출한 메소드의 리턴 타입, 명칭, 매개변수를 전체 패키지 경로 반환
	 *				(3) toShortString : 클라이언트가 호출한 메소드의 시그니처를 축약하여 문자열로 반환
	 */
	
	// before
	@Before("execution(* com.korea.service.TestService.*List(..))") // 타겟 메소드 중 List로 끝나는 명칭의 메소드만 동작
	public void before(JoinPoint jp) throws Throwable {
		//
		System.out.println("");
		System.out.println("# before");
		System.out.println("getNmae : " + jp.getSignature().getName());
		System.out.println("toLongString : " + jp.toLongString());
		System.out.println("toShortString : " + jp.toShortString());
		System.out.println("");
	}
	
	// after
	@After("execution(* com.korea.service.TestService.*Commit(..))")
	public void after(JoinPoint jp) throws Throwable {
		//
		System.out.println("");
		System.out.println("# after");
		System.out.println("getName : " + jp.getSignature().getName());
		System.out.println("toLongString : " + jp.toLongString());
		System.out.println("toShortString : " + jp.toShortString());
		System.out.println("getTarget : " + jp.getTarget());
		System.out.println("");

	}
	
	// around
	@Around("execution(* com.korea.service.TestService.*(String))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		/*	@Around의 특징
		 *		- 해당 어노테이션은 클라이언트의 비즈니스 메소드 호출을 중간에서 가로채는 방식으로 동작하므로 
		 *		- 어드바이스 내 @Around 메소드에서 비즈니스 메소드의 처리를 책임져야한다.
		 *		
		 *		- 이를 위해서 스프링에서는 비즈니스 메소드의 정보가 담겨있는 ProceedingJoinPoint 객체를 넘겨주게 된다.
		 *		- 그런 이유로 @Around 메소드에서는 반드시 첫번째 매개변수로 ProceedingJoinPoint 객체를 받도록 되어있다. 
		 *
		 *		# Proceed
		 *			- 해당 메소드를 기준으로 비즈니스 메소드 수행 전과 후가 구분된다.
		 *			- 해당 메소드는 Object를 반환하는데 이 값은 비즈니스 메소드 (본 예제에서는 testCommit메소드)의 리턴 값이 된다.
		*/
		System.out.println("");
		System.out.println("# around(전) : " + pjp.getSignature().getName());
		Object obj = pjp.proceed();
		
		//
		if(obj!=null) {
			System.out.println("# Object : " + obj);
		}
		
		System.out.println("# around(후) : " + pjp.getSignature().getName());
		System.out.println("");

		return obj;
	}
	
}
