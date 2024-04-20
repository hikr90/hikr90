package ex1_try_catch;

// try는 개발자의 입장에서 예측 가능하지만 수정이 어려운 상황에서 쓴다.
// 단순한 개발자의 실수에서 try-catch를 사용해서는 안된다.
public class Ex1_Try_Catch {
	public static void main(String[] args) {
		
		int [] var = {10,20,30};
		
		
		
		
		for (int i=0;i<=var.length;i++) {
		
			try {
			System.out.println(var[i]);
		}catch(Exception e) {
			
		}
			
		}
		
		
		System.out.println("프로그램 종료");
		
		
		
		
		
		
	}
}
