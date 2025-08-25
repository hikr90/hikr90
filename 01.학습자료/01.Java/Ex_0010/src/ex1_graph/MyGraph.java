package ex1_graph;

import java.util.Random;

public class MyGraph {

	public static void main(String[] args) {
		
		// 문제
		// - 0 ~ 9 사이의 난수를 100개 생성한다.
		// - 발생한 난수를 통해서 아래의 결과를 생성한다.
		// 
		// - 결과 : 1240912850198309128310901...
		// - 0의 개수 : ### 3
		// - 1의 개수 : ##### 5
		// - 2의 개수 : # 1 
		// - ....
		// - 9의 개수 : #### 4
		String numbers = "";
		//
		for(int i=0;i<100;i++) {
			numbers += new Random().nextInt(10);
		}
		//
		System.out.println(numbers);
		int [] nArr = new int[10];
		//
		for(int i=0;i<numbers.length();i++) {
			// 첫번째 문자가 ""과 더해져 문자열이 된다.
			// String.valueOf(numbers.charAt(i)); 로도 된다.
			String s = ""+numbers.charAt(i);
			nArr[Integer.parseInt(s)]++;
		}
	
		// 배열을 그래프로 그려주는 클래스
		PrintGraph pg = new PrintGraph();
		
		// 파라미터로 배열을 받으려면 정수의 배열을 받아야한다. 
		pg.print(nArr);
	}
}
