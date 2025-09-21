package ex1_annotation;

public class Ex2_Meta_Annotation {
	public static void main(String[] args) {
		/*	메타 어노테이션
		 * 	- 어노테이션을 위한 어노테이션
		 * 	- 어노테이션의 적용 대상이나 유지기간 등을 지정한다.
		 * 					
		 * 	(1) @Target
		 * 		- 어노테이션의 범위 지정하는 어노테이션
		 * 		- @Target({TYPE, FILED, METHOD....})
		 * 
		 * 		(1.1) 동작 범위
		 * 			- ANNOTATION_TYPE (어노테이션)
		 * 			- CONSTRUCTOR (생성자)
		 * 			- FILED (필드 : 멤버변수, 열거형 상수)
		 * 			- LOCAL_VARIABLE (지역변수)
		 * 			- METHOD (메소드)
		 * 			- PACKAGE (패키지)
		 * 			- PARAMETER (매개변수)
		 * 			- TYPE (타입 : 클래스, 인터페이스, 열거형 상수)
		 * 			- TYPE_PARAMETER (타입 매개변수)
		 * 			- TYPE_USE (타입이 사용되는 모든 곳)
		 * 
		 * 			[참고] FILED는 기본형, TYPE_USE는 참조형에 사용
		 * 
		 * 	(2) Retention
		 * 		- 어노테이션이 유지되는 기간을 지정하는 어노테이션
		 * 		
		 * 		(2.1) 유지 정책
		 * 			- SOURCE : 소스 파일에만 존재
		 * 			- CLASS : 클래스 파일에만 존재, 실행 시 사용 불가 (기본 값)
		 * 			- RUNTIME : 클래스 파일에만 존재, 실행 시에 사용 가능
		 * 
		 * 	(3) @Documented
		 * 		- 어노테이션 정보가 javadoc으로 작성된 문서에 포함된다.
		 * 		- 자바에서 제공하는 어노테이션 중, Override과 SuppressWarnings 제외하고 전부 포함되어있다. 
		 * 
		 * 	(4) @Inherited
		 * 		- 어노테이션이 자손 클래스에 상속되도록 한다.
		 * 		- 해당 어노테이션이 조상에 있으면 자손도 이 어노테이션이 붙은 것처럼 인식된다.
		 * 
		 */		
		
	}
}
