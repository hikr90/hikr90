package ex1_break;

public class Ex3_label_break {

	public static void main(String[] args) {

		/*
		 label(�ĺ���) : Ư�� �ݺ����� �̸�ǥ�� �ٿ� �ѹ��� �ΰ� �̻��� �ݺ����� ������ �� �ֵ����ϴ� Ű���� 


		 */

		out : for(int i=1;i<=3;i++) {

			for(int j=1;j<=5;j++) {

				if(j%2==0) {
					// out�̶�� �̸��� �ݺ����� ����������
					break out;
				}
				System.out.print(j+" ");
			}
			System.out.println();
		}







	}
}
