package ex1_graph;

public class PrintGraph {

	public void print(int [] arr) {
		
		// arr.length�� 10�̴�.
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
