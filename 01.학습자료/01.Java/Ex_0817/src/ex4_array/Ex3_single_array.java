package ex4_array;

public class Ex3_single_array {

	public static void main(String[] args) {
		
		// ����
		// - �迭 �� ��� ��� ���� ���� ���ϼ���.
		// - �Ϲ� �ݺ����� ������ �ݺ������� �����ּ���.
		int [] arr = {15,22,17,30,50};
		int result = 0;
		//
		for(int i=0;i<arr.length;i++) {
			result += arr[i];
		}
		System.out.printf("�� �� : %d\n",result);
		
		System.out.println("------------");
		result = 0;
		
		//
		for(int i : arr) {
			result += i;
		}
		System.out.println("�� �� : "+result);
	}
}
