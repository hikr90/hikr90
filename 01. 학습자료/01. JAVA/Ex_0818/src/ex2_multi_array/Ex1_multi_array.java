package ex2_multi_array;

public class Ex1_multi_array {
	
	public static void main(String[] args) {
		
		
		/* �������迭 : 1���� �迭�� 2�� ���̸� 2���� �迭�� �ȴ�.
		 (1���� �迭�� 3�� ���ִ� ���, 3���� �迭���� �θ���.) */
		
		// 2���� �迭 ����
		// [2] : 1���� �迭�� �� (ū ��)
		// [3] : �� 1���� �迭�� index�� (���� ��)
		// 2�����迭�� 2�� 3���� ǥ�� �����ȴٰ� �����ϸ� �ȴ�. 
		int [][] test = new int[2][3];
		
		// 2���� �迭�� ���� �ִ� ���
		// 2���� �迭�� ���� ���� �濡�� ���� ���� �� �ְ�, ū �濡�� ���� ���� �� ����. (���� �濡 �����ϱ����� ���Է� : ū ��)		
		test[0][0] = 100;
		test[0][1] = 200;
		test[0][2] = 300;
		test[1][0] = 400;
		test[1][1] = 500;
		test[1][2] = 600;
		
		// for���� ���� 2���� �迭 ���
		// test.length : ū���� ��
		// test[i].length : �������� ��
		for(int i=0;i<test.length;i++) {	// y��
			
			for(int j=0;j<test[i].length;j++) { // x��
				System.out.print(test[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
}
