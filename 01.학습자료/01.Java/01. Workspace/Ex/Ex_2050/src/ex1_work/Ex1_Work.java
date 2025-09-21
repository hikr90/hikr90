package ex1_work;

public class Ex1_Work {
	public static void main(String[] args) {
		// 주의사항
		// - try catch는 개발자의 입장에서 예측 가능하나 수정이 어려운 여건에서 사용한다.
		// - 단순한 개발자의 실수를 덮기위한 용도로 사용해서는 안된다.
		int [] var = {10,20,30};
		
		for (int i=0;i<=var.length;i++) {
			//
			try {
					System.out.println(var[i]);
		
			} catch(Exception e) {
			
			}
		}
		//
		System.out.println("프로그램 종료");
	}
}
