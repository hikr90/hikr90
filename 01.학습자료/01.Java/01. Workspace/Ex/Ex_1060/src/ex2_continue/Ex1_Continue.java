package ex2_continue;

public class Ex1_Continue {
	
	public static void main(String[] args) {
		
		/*	Continue
		 * 		- for, while ���� �ݺ������� Ư�� �����̳� ���� ������ �����ϰ� �ǳʶٰ����ϴ� ��� ����ϴ� Ű����
		 * 		- �ʿ���ٰ� �����ϴ� ������ �پ�Ѿ� ���� ������ �ִ� ���������� �̵��Ѵ�. (�������� ���� ��� ���ǽ����� �̵��Ѵ�.)
		 * 		- break�� ���������� ���� ������ �ִ� for���� ����Ǹ� continue ���� �Ʒ� �ڵ尡 �ִ� ��� ������ �߻��Ѵ�.
		 * 
		 *		- continue �� �������� �ۼ��ϴ� ��� �� ��Ī�� ���� �ݺ����� ���������� �̵��Ѵ�.
		 */
		for(int i=1;i<=2;i++) {
			for(int j=1;j<=5;) {
				// 
				if(j%2==0) {
					// ���� ������ �ִ� �ݺ����� ���������� �̵�
					continue;
				}
				//
				System.out.print(j+" ");
				j++;
			}
			System.out.println();
		}
	}
}
