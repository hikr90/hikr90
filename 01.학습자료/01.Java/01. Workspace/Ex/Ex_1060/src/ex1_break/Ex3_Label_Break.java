package ex1_break;

public class Ex3_Label_Break {

	public static void main(String[] args) {

		/* Label 
		 *		- �ĺ��ڷ� Ư�� �ݺ����� �̸��� �����Ͽ� �ѹ��� �ΰ� �̻��� �ݺ����� ������ �� �ְ� ���� Ű����
		 *		- ��Ī�� ���Ƿ� �ۼ� �����ϴ�.
		 *		- break���� �����ڰ� ������ �ƴ� Ư�� �������� ������ �� �ְ��ϴ� ���� �۾��� �����ϴ�. 
		 */
		out : for(int i=1;i<=3;i++) {

			for(int j=1;j<=5;j++) {

				if(j%2==0) {
					// �� out �� �ݺ����� �����ϰ� �����ÿ�.
					break out;
				}
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
