package ex2_continue;

public class Ex2_continue {

	public static void main(String[] args) {
		
		/* while문에서의 continue는 아래 식을 실행하지 않고 가장 가까운 while문의 조건식으로 간다. */
		
		int n = 0;
		
		while(n<10) {
			n++;
			
			if(n%3==0) {
				continue;
			}
			
			System.out.println(n);
		}
		
		
		System.out.println("----------------");
		
		/* switch안에서 continue를 사용하고자한다면 반드시 반복문안에서만 사용이 가능하다.
		 switch문에서 continue를 만나면 while문의 조건식으로 간다. */
		n = 1;
		while(n<5) {
			n++;
			
			switch(n) {
			case 2:
				System.out.println("2로 들어옴");
				continue;
			}
			
			System.out.println(n);
		}
		
		
		
		
		
		
		
		
		
	}
}
