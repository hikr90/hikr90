package ex2_continue;

public class Ex2_continue {

	public static void main(String[] args) {
		
		/* while�������� continue�� �Ʒ� ���� �������� �ʰ� ���� ����� while���� ���ǽ����� ����. */
		
		int n = 0;
		
		while(n<10) {
			n++;
			
			if(n%3==0) {
				continue;
			}
			
			System.out.println(n);
		}
		
		
		System.out.println("----------------");
		
		/* switch�ȿ��� continue�� ����ϰ����Ѵٸ� �ݵ�� �ݺ����ȿ����� ����� �����ϴ�.
		 switch������ continue�� ������ while���� ���ǽ����� ����. */
		n = 1;
		while(n<5) {
			n++;
			
			switch(n) {
			case 2:
				System.out.println("2�� ����");
				continue;
			}
			
			System.out.println(n);
		}
		
		
		
		
		
		
		
		
		
	}
}
