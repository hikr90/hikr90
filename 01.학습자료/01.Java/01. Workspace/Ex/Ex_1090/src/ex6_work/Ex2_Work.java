package ex6_work;

public class Ex2_Work {
	// 메소드 생성
	public void print(int [] arr) {
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
