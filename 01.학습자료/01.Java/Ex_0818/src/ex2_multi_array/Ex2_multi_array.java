package ex2_multi_array;

public class Ex2_multi_array {

	public static void main(String[] args) {
		
		/* 직사각형의 형태가 아닌, String 타입의 2차원 배열  
		 * 생성, 선언, 초기화를 아래와 같이 동시에하면 직사각형이 아닌 배열의 모양도 나올 수 있다. (2행2열,1열)*/
		String [][] student = {{"영희","j:100","a:95"},
								{"철수","j:90"}};
		
		
		// 문제 for문으로 결과를 전부 출력
		for(int i=0;i<student.length;i++) {
			
			for(int j=0;j<student[i].length;j++) {
				System.out.print(student[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
	}
}
