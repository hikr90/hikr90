package ex2_continue;

public class Ex3_lable_continue {

	public static void main(String[] args) {
		
		/* continue���� label�� ����ϴ� ���, label�� ���������� ����.
		 �������� �������������� ������ ���� ���ǽ����� ����. */
		
		outer : for(int i=1;i<=3;i++) {
			
			for(int j=1;j<=5;j++) {
				
				if(j%2==0) {
					continue outer;
				}
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
