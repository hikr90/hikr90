package ex4_method;

public class ParamMain {

	public static void main(String[] args) {
		//
		int [] arr = {1,2,3,4,5};
		//
		MyParam mp = new MyParam();
		mp.test(arr);		// 인덱스 4번의 값을 10으로 수정하여 출력
		
		System.out.println("main의 arr");
		
		// 변수와 다르게 주소 값의 숫자가 변경되었으므로 값이 변경되었다.
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
