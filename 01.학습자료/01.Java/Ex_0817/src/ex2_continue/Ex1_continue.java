package ex2_continue;

public class Ex1_continue {
	
	public static void main(String[] args) {
		
		/*
		 continue�� : �ݺ��� ������ Ư�������̳� ���� ������ �����ϰ� �ǳʶٰ����� �� ����ϴ� Ű����
		 (�ʿ���ٰ� �����ϴ� ������ �پ�Ѵ´�, break�� ���������� ���� ����� for���� ����ȴ�.)
		 */

	for(int i=1;i<=2;i++) {
		
		for(int j=1;j<=5;) {
			
			// continue�� ������ ���, �Ʒ��� �ִ� ������ �پ�Ѵ´�. (continue�� ���� ����, ���� ����� �ݺ����� ���������� ����.)
			// continue �ٷ� �ؿ� ���� �ִ� �� ���� �����̴�. 
			// ���� �������� ������ continue�� ���� ��, ���ǽ����� ����.
			if(j%2==0) {
				continue;
			}
			
			System.out.print(j+" ");
			j++;
		}
		System.out.println();
	}
	
	
	
	
	
	
	}
}
