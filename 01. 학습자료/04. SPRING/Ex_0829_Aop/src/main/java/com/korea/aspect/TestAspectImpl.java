package com.korea.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*	COMPONENT 어노테이션
 		- 컴포턴트 스캔 설정을 사용하는 경우 해당 어노테이션이 있는 클래스를 자동으로 빈 등록 하도록 지정하는 어노테이션 
 		- 직접 작성한 클래스를 자동으로 빈 등록하는 경우 사용한다.
*/
@Component
@Aspect
public class TestAspectImpl {
	/* # AOP
	 	 	## ASPECT
	 	 		- 로깅이나 보안 등 구현하고자하는 공통적인 보조 기능
	 	 		- 기능을 뜻하는 추상적인 개념으로서, 기능의 코드에 해당하는 어드바이스와 
	 	 		- 적용 지점을 가르키는 조인 포인트로 구성되어있다.
	 	 		
	  		## ADVICE
	 			- ASPECT의 구현체 (클래스)로 보조 기능에 해당하는 코드를 담는 하나의 독립된 클래스를 뜻한다.
	 			- 본 예제에서는 TESTASPECTIMPL 클래스를 뜻한다.
	 			- 어드바이스 내에서 구현된 메소드는 조인 포인트와 포인트 컷으로 어드바이스 적용되는 시점과 영역을 지정할 수 있다.
	 		
	 		## JOINPOINT
	 			- 어드바이스가 적용되는 지점을 의미한다.
	 			- 어드바이스 내에서는 메소드에 어노테이션을 사용하여 적용 지점을 지정한다.
	 			
	 			### 어노테이션 종류
	 				- BEFORE : 메소드가 동작하기 전 동작
	 				- AFTER : 메소드의 동작이 종료된 후 동작
	 				- AFTER-RETURNING : 메소드가 성공적으로 완료되어 리턴된 뒤 동작
	 				- AFTER-THROWING : 메소드 동작 중 예외가 발생하면 동작한다.
	 				
	 				#### AROUND
	 					- 메소드의 동작 전과 후에 동작한다.
	 					- 타 어노테이션과 다르게 반드시 JOINTPOINT를 파라미터로 받아야한다.
	 					- JOINTPOINT객체의 PROCEED 메소드를 통해서 메소드의 리턴 값을 받을 수 있다.
	 		
	 		## POINTCUT
	 			- 어드바이스가 적용되는 대상을 지정한다.
	 			- 포인트컷 정규식을 사용하여 "EXCUTION(리턴타입 패키지경로.클래스명.메소드명(매개 변수))"의 방식으로 지정할 수 있다.
	 			
	 			### 포인트컷 정규표현식
	 					접근제한자
	 						- PUBLIC, PRIVATE등의 타입을 선택할 수 있으며 *으로 전체를 지정할 수 있다.
	 				  		- 접근제한자는 표현식에서 생략할 수 있다.
	 				  		- !VOID등의 방식으로 해당 타입을 제외한 나머지 타입을 포함하여 처리할 수 있다.
	 					
	 					패키지명
	 						- COM.KOREA.SERVICE : 해당 패키지 경로까지만 지정
	 						- COM.KOREA.SERVICE.. : 해당 패키지 경로의 하위 패키지까지 전부 지정
	 						- COM.KOREA.SER..CE : 해당 패키지 경로 내 SER으로 시작하여 CE로 끝나는 패키지 선택
	 					
	 					클래스명
	 						- TESTSERVICE : 해당 명칭의 클래스 선택
	 						- *SERVICE : 클래스명이 SERVICE로 끝나는 클래스 선택
	 						- TEST* : 클래스명이 TEST로 시작하는 클래스 선택
	 						- TESTSERVICE+ : 해당 클래스에서 파생된 모든 자식 클래스 혹은 인터페이스 선택
	 						
	 					메소드
	 						- * : 모든 메소드 선택
	 						- 클래스명과 마찬가지로 앞 뒤로 *를 붙여 사용할 수 있다.
	 						- 메소드 타입은 매개변수 타입과 함께 표현식을 반드시 사용해야한다.
	 						
	 					매개변수
	 						- (..) : 타입과 갯수 상관없이 모든 매개 변수를 가지는 메소드 선택
	 						- (*) : 타입 상관없이 한가지의 매개 변수를 가지는 메소드 선택
	 						- (org.springframework.ui.model) : 매개변수 model을 가지는 메소드 선택, 특정 매개변수를 지정하는 경우 반드시 전체 패키지 경로가 있어야한다.
	 						- (String, ..) / (Integer, *) : 한 개 이상의 파라미터를 가지되 첫 매개변수가 STRING타입인 메소드 / 첫번쨰 파라미터가 INTEGER타입인 두개의 파라미터를 가지는 메소드
	 						
	 		## TARGET
	 			- 어드바이스가 적용되는 클래스를 뜻한다.
	 			- 본 예제에서는 TESTSERVICE 클래스를 의미한다.
	 			
	 		## WEAVING
	 			- 보조 기능 (ADVICE)을 주기능에 적용하는 것을 뜻한다.
	*/
	
	// BEFORE
	@Before("execution(* com.korea.service.TestService.*List(..))") // 타겟 메소드 중 List로 끝나는 명칭의 메소드만 동작
	public void before(JoinPoint jp) throws Throwable {
		/*	JOINPOINT객체 메소드 
		 		## GETSIGNATURE : 클라이언트가 호출한 메소드의 리턴타입, 명칭, 매개변수 정보로 구성된 시그니처를 리턴
		 		
		 			### 시그니처 객체의 메소드
		 				- GETNAME : 클라이언트가 호출한 메소드 명칭
		 				- TOLONGSTRING : 클라이언트가 호출한 메소드의 리턴 타입, 명칭, 매개변수를 전체 패키지 경로로 리턴
		 				- TOSHORTSTRING : 클라이언트가 호출한 메소드의 시그니처를 축약하여 문자열로 리턴
		 				
		 		## GETTARGET
		 			- 클라이언트가 호출한 클래스의 메소드를 포함하는 OBJECT 객체 리턴
		 		
		 		## GETARGS
		 			- 클라이언트가 호출한 클래스의 메소드의 인자를 OBJECT타입의 배열로 리턴
		*/
		System.out.println("");
		System.out.println("// BEFORE //");
		System.out.println("// GETNAME : " + jp.getSignature().getName() + " //");
		System.out.println("// TOLONGSTRING : " + jp.toLongString() + " //");
		System.out.println("// TOSHORTSTRING : " + jp.toShortString() + " //");
		System.out.println("");
	}
	
	// AFTER
	@After("execution(* com.korea.service.TestService.*Commit(..))")
	public void after(JoinPoint jp) throws Throwable {
		//
		System.out.println("");
		System.out.println("// AFTER //");
		System.out.println("// GETNAME : " + jp.getSignature().getName() + " //");
		System.out.println("// TOLONGSTRING : " + jp.toLongString() + " //");
		System.out.println("// TOSHORTSTRING : " + jp.toShortString() + " //");
		System.out.println("// GETTARGET : " + jp.getTarget() + " //");
		System.out.println("");

	}
	
	// AROUND
	@Around("execution(* com.korea.service.TestService.*(String))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		/*	AROUND 어노테이션의 특징 
		 		- 해당 어노테이션은 클라이언트의 비즈니스 메소드 호출을 중간에서 가로채는 방식으로 동작하므로 
		 		- 어드바이스 내 AROUND 어노테이션 메소드에서 비즈니스 메소드의 처리를 책임져야한다.
		 		
		 		- 이를 위해서 스프링에서는 비즈니스 메소드의 정보가 담겨있는 객체를 넘겨주는데
		 		- 해당 객체가 PROCEEDINGJOINPOINT이다.
		 		- 그런 이유로 AROUND 어노테이션 메소드에서는 반드시 첫번째 매개변수로 PJP 객체를 받도록 되어있다. 

				# PROCEED
		 			- PROCEED의 뜻은 진행하다는 뜻으로서, 해당 메소드를 기준으로 비즈니스 메소드 수행 전 / 후 가 구분된다.
		 			- 해당 메소드는 OBJECT를 리턴하는데 이 값은 비즈니스 메소드 (본 예제에서는 TESTCOMMIT)의 리턴 값이 된다.
		*/
		System.out.println("");
		System.out.println("// AROUND(전) : " + pjp.getSignature().getName() + " //");
		Object obj = pjp.proceed();
		
		// AROUND에서
		if(obj!=null) {
			System.out.println("// OBJ : " + obj + " //");
		}
		
		System.out.println("// AROUND(후) : " + pjp.getSignature().getName() + " //");
		System.out.println("");

		return obj;
	}
	
}
