package ex4_method;

public class ParamMain {

	public static void main(String[] args) {
		
		int [] arr = {1,2,3,4,5};
		
		MyParam mp = new MyParam();
		mp.test(arr);
		
		System.out.println("main의 arr");
		// 다시 4번방을 출력
		// 여기서는 몇번으로 나올까?
		// 10으로 나온다.
		for(int i=0;i<arr.length;i++) {
			
			System.out.println(arr[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
