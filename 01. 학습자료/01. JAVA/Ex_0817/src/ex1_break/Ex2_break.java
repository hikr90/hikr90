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
	
	// �ݺ����ȿ��� switch�� �ִ� break�� �ݺ����� �ǵ帮���ʰ� switch������ �������´�.
	while(n<10) {
		System.out.println(n);
		
		switch(n){
			case 1:
				System.out.println("����");
				break;
			case 2:
				System.out.println("����");
				break;
		}
		
		
		
		n++;
	}

	
	
	}
}
