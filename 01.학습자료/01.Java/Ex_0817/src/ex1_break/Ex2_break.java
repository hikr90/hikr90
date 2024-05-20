package ex1_break;

public class Ex2_break {

	public static void main(String[] args) {
		//
		int n = 1;
		//
		while(true) {
			System.out.println(n);
			n++;
			//
			if(n>5) {
				break;
			}
		}

		System.out.println("-----------------");
		//
		n = 1;
		
		// [참고] switch문에서 break는 switch문만 나오게 된다.
		while(n<10) {
			System.out.println(n);
			
			switch(n){
				case 1:
					System.out.println("여기");
					break;
				case 2:
					System.out.println("조기");
					break;
			}
			//
			n++;
		}
	}
}
