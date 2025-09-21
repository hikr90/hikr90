package ex5_inner_class;

// 외부 클래스
public class Ex1_Inner_Class {
		// 내부 클래스
		class inner_class {
			// 내부 클래스의 메소드
			public void print() {
				System.out.println("INNER 클래스의 메소드");
			}
		}
		
		// 메인 영역
		public static void main(String[] args) {
			/*	내부 클래스
			 * 		- 클래스 내에 선언된 클래스
			 * 		- 서로 관계있는 클래스 간 쉽게 접근하고 코드의 복잡성을 줄인다는 장점(캡슐화)이 있다.
			 * 
			 * 		(1) 내부 클래스의 종류
			 * 			class Outer {
			 * 				class InstanceInner { }				-- (1.1) 
			 * 				static class StaticInner { }		-- (2.1)
			 * 				
			 * 				void myMethod(){
			 * 					class LocalInner { }			-- (1.3)
			 * 				}
			 * 			}
			 * 
			 * 			(1.1) 인스턴스 클래스
			 * 				- 외부 클래스의 멤버 변수 위치에 선언
			 * 				- 외부 클래스의 인스턴스 멤버 접근이 가능하다.
			 * 
			 * 			(2.1) static 클래스
			 * 				- 외부 클래스의 멤버 변수 위치에 선언
			 * 				- 외부 클래스의 객체 생성없이 인스턴스 멤버 접근이 불가하다. (단, static 내부 클래스의 인스턴스는 외부 클래스 인스턴스 생성없이 접근 가능하다.)
			 * 				 - 내부 클래스 중, static 클래스만 static 멤버 보유가 가능하다.
			 * 
			 * 			(1.3) 지역 클래스
			 * 				- 외부 클래스의 메소드나, 초기화 블럭 내 선언
			 * 				- 선언된 영역 내부에서만 사용될 수 있고 외부에서는 접근이 불가하다.
			 * 
			 * 			(1.4) 익명 클래스
			 * 				- 클래스의 선언과 객체의 생성을 동시에 하는 일회용 목적의 이름없는 클래스
			 * 
			 * 		[참고] 내부 클래스 생성 시, 생성되는 파일의 명칭은 외부클래스명$내부클래스명.class 이다.
			 * 			- 이 방식처럼 this.변수명 혹은 외부클래스.변수명으로 값을 가져오는 것이 가능하다.
			 */
			Ex1_Inner_Class out_class = new Ex1_Inner_Class();
			Ex1_Inner_Class.inner_class ic = out_class.new inner_class();
			
			// 내부 클래스의 메소드 사용
			ic.print();
		}
}
