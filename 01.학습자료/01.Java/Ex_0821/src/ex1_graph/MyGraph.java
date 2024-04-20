package ex1_graph;

import java.util.Random;

public class MyGraph {
	
	/*0에서 9사이의 난수를 100개를 만든다.
	 * 발생한 난수를 통해 아래의 결과를 도출
	 * 
	 * 결과 : 1240912850198309128310901 <-- 난수 100개
	 * 0의 갯수:### 3
	 * 1의 갯수:##### 5
	 * 2의 갯수:# 1
	 * ....
	 * 9의 갯수:#### 4*/
	
	public static void main(String[] args) {
		
		String numbers = "";
		for(int i=0;i<100;i++) {
			
			numbers += new Random().nextInt(10);
		}

		System.out.println(numbers);
	
		int [] nArr = new int[10];
		
		for(int i=0;i<numbers.length();i++) {
			
			// 첫번째 문자가 ""과 더해져 문자열이 된다.
			// String.valueOf(numbers.charAt(i)); 로도 된다.
			String s = ""+numbers.charAt(i);
			
			
			nArr[Integer.parseInt(s)]++;
			
		}
	
		// nArr배열을 그래프로 그려주는 클래스
		PrintGraph pg = new PrintGraph();
		
		// 파라미터로 배열을 받으려면 정수의 배열을 받아야한다. 
		pg.print(nArr);
	
	
	
	
	
	
	
	}
}
