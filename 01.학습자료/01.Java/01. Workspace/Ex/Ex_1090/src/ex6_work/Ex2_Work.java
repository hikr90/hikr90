package ex6_work;

public class Ex2_Work {
	// �޼ҵ� ����
	public void print(int [] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(i+"�� ���� : ");
			
		// #�� ����ִ� �۾�
		for(int j=0;j<arr[i];j++) {
			System.out.print("#");
		}
			System.out.println(" "+arr[i]);
		}
		
	}
}
