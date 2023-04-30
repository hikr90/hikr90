package ex1_break;

public class Ex2_break {

	public static void main(String[] args) {
		
		int n = 1;
		
		while(true) {
			System.out.println(n);
			n++;
			
			if(n>5) {
				break;
			}
		}

	System.out.println("-----------------");
	
	n = 1;
	
	// 반복문안에서 switch에 있는 break는 반복문을 건드리지않고 switch문만을 빠져나온다.
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
		
		
		
		n++;
	}

	
	
	}
}
