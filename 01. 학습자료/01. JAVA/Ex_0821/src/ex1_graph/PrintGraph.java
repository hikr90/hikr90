package ex1_graph;

public class PrintGraph {

	public void print(int [] arr) {
		
		// arr.length는 10이다.
		for(int i=0;i<arr.length;i++) {
			System.out.print(i+"의 갯수 : ");
		
		// #을 찍어주는 작업
		for(int j=0;j<arr[i];j++) {
			System.out.print("#");
		}
			System.out.println(" "+arr[i]);
		}
		
	}
}
