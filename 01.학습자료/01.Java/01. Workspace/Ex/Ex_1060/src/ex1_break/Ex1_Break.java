package ex1_break;

public class Ex1_Break {

	public static void main(String[] args) {
		
		/*	Break
		 *		- �ݺ��� ������ ���������� �����̿� �ִ� (break���� ���ΰ��ִ�) �ݺ����� �������� �� ����ϴ� Ű����	
		 *		- if, for, while���� ������ ��� �����ϴ�.
		 *		- break���� �Ʒ��� �ڵ尡 �ִ� ��� ������ �߻��Ѵ�. 
		 */
		for(int i=1;i<=2;i++) {
			for(int j=1;j<=5;j++) {
				// if���� ���� �Ǵ� ����, break�� �ִ� �ݺ����� ���� ���� for������ ���ư���.
				if(j%3==0) {
					break;
				}
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
