package ex2_continue;

public class Ex2_continue {

	public static void main(String[] args) {
		
		// wihle���� continue ���� while���� ���ǽ����� �̵��Ѵ�.
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
		
		// switch���� continue�� ������ ��� switch�� �����ִ� �ݺ����� ���ǽ����� �̵��Ѵ�.
		n = 1;
		while(n<5) {
			n++;
			//
			switch(n) {
			case 2:
				System.out.println("2�� ����");
				continue;
			}
			//
			System.out.println(n);
		}
	}
}
