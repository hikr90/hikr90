package ex2_while;

public class Ex1_while {
	public static void main(String[] args) {
		
		/* while : 간편한 구성을 가진 반복문
		  선 비교 후 처리
		 
		 while(조건식){
		 	조건식이 참일 때, 실행되는 영역
		 }
		 
		
		조건식이 참 -> 실행문 수행 -> 다시 비교 후 참 -> 실행문 수행
		즉, while(true)를 주는 경우 무한반복을 할 수 있다.
		
		 */
		
		int num = 1;
		
		while(num<=3) {
			System.out.println(num);
			num++;
		}
		
		System.out.println("---------------");
		
		
		while(true) {
			System.out.println("안녕");
		}
		
		// 위에 만들어진 코드가 무한반복인 경우, 아래의 식은 실행이 안되므로 오류가 난다.
		// System.out.println("---------------");
	}
}
