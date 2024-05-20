package ex2_continue;

public class Ex2_continue {

	public static void main(String[] args) {
		
		// wihle문의 continue 역시 while문의 조건식으로 이동한다.
		int n = 0;
		//
		while(n<10) {
			n++;
			
			if(n%3==0) {
				continue;
			}
			//
			System.out.println(n);
		}
		
		System.out.println("----------------");
		
		// switch에서 continue를 만나는 경우 switch이 속해있는 반복문의 조건식으로 이동한다.
		n = 1;
		while(n<5) {
			n++;
			//
			switch(n) {
			case 2:
				System.out.println("2로 들어옴");
				continue;
			}
			//
			System.out.println(n);
		}
	}
}
