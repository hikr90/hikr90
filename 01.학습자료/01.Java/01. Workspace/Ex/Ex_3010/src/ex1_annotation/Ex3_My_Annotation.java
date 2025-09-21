package ex1_annotation;

public @interface Ex3_My_Annotation {
	/* 어노테이션 생성 (타입 정의)
	 * 	- @앞에 붙여서 인터페이스 생성하듯이 선언
	 * 	- 어노테이션 내에 선언된 메소드는 어노테이션의 요소라고 부른다.
	 * 	
	 * 	(1) 어노테이션의 요소
	 * 		- 반환 값이 있고
	 * 		- 매개변수는 없는 추상 메소드의 형태
	 * 		- 상속을 통해서 따로 구현할 필요가 없다.
	 * 		- 단, 다른 파일에서 해당 어노테이션 적용 시 이 요소들의 값이 전부 들어가야 한다.
	 * 
	 */
	
	// [참고] 어노테이션의 요소
	// int count();
	// String testBy();
	// DateTime testDate();		// 다른 어노테이션 생성
	
	// [참고] 어노테이션의 기본 값
	// - 각 요소는 기본 값을 가질 수 있으며, 어노테이션 적용 시 값 지정이 안되어있다면 기본 값이 사용된다.
	// - 기본 값은 null을 제외하고 전부 가능하다.
	
	// [예시] @Ex3_my_annotation(cnt=1) 과 동일
	// - 만약 요소가 하나고 이름이 value인 경우에는 요소의 이름을 생략하고 값만 적어도 된다.
	int cnt() default 1;
	
	// [참고] 배열 요소
	// - (1) 값이 여러개인 경우 : @Ex3_my_annotation(testTools={"AA", "BB"})
	// - (2) 값이 하나일 때 : @Ex3_my_annotation(testTools"AA")
	// - (3) 값이 없는 경우 : @Ex3_my_annotation(testTools={})
	// String [] testTools();	
}

@interface DateTime {
	String ymd();
	String hhmms();
}
