package ex6_inner_class;

public class Ex1_Inner_Class {
	// 외부 클래스
		
		// 내부 클래스 (INSTANCE CLASS)
		class inner_class {
			
			// 내부 클래스의 PRINT 메소드
			public void print() {
				System.out.println("INNER 클래스의 메소드");
			}
		}
		
		// 메인 영역
		public static void main(String[] args) {
			
			/*		일반 내부 클래스 사용 방법
			 			외부클래스 선언 뒤,
			 			외부클래스.내부클래스 내부클래스 선언 명칭 = 외부클래스 명칭.NEW 내부클래스();
			 */
			Ex1_Inner_Class out_class = new Ex1_Inner_Class();
			Ex1_Inner_Class.inner_class ic = out_class.new inner_class();
			
			// 내부 클래스의 메소드 사용
			ic.print();
		}
}
