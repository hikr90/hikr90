package ex1_break;

public class Ex1_break {

	public static void main(String[] args) {
		
		/* 
		 break�� : �ݺ��� ������ ���������� �����(break�� �����ϰ��ִ�) �ݺ����� �������� �� ����ϴ� Ű���� 
		 
		 */

	for(int i=1;i<=2;i++) {
		
		for(int j=1;j<=5;j++) {
		
			// j�� 3�� �Ǿ� if���� ������ �Ǵ� ����, break�� �����ִ� �ݺ����� ���� ��, i for������ �ٷ� ����.
			// break���� �����ϴ� ���� �Ʒ����� ��� �ڵ嵵 �߰��� �� ����..
			if(j%3==0) {
				break;
			}
			
			System.out.print(j+" ");
		}
		System.out.println();
	}
	
	
	
	}
}
