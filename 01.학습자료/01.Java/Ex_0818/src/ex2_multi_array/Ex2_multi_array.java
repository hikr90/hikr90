package ex2_multi_array;

public class Ex2_multi_array {

	public static void main(String[] args) {
		
		/* ���簢���� ���°� �ƴ�, String Ÿ���� 2���� �迭  
		 * ����, ����, �ʱ�ȭ�� �Ʒ��� ���� ���ÿ��ϸ� ���簢���� �ƴ� �迭�� ��絵 ���� �� �ִ�. (2��2��,1��)*/
		String [][] student = {{"����","j:100","a:95"},
								{"ö��","j:90"}};
		
		
		// ���� for������ ����� ���� ���
		for(int i=0;i<student.length;i++) {
			
			for(int j=0;j<student[i].length;j++) {
				System.out.print(student[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
	}
}
