package ex1_file;

import java.io.File;

public class Ex3_File {
	public static void main(String[] args) {
		
		// list는 파일과 폴더를 구분해서 가져오는 것이 가능하다.
		String path = "C:/JAVA1_0713_KTH";
		File f1 = new File(path);
		
		// 하위목록중 폴더만 출력
		if(f1.isDirectory()) {
			
			// listFiles은 파일클래스로 반환하는데, 파일로 받아야 용량이나 폴더 혹은 파일의 유무를 파악할 수 있기 때문이다.
			// 파일 클래스이기에 파일 클래스의 배열로 받아야한다.
			File [] ar = f1.listFiles();
			
			// for문으로 출력
			for(int i=0;i<ar.length;i++) {
				// isDirectory는 폴더의 유무를 파악한다.
				// getName으로 File클래스 배열의 이름을 가져올 수 있다.
				if(ar[i].isDirectory()) {
					System.out.println(ar[i].getName());
				}
				
				// 파일클래스의 단점 : 용량 파악 및 폴더, 파일 유무는 확인 가능하나 파일 안의 내용을 가지고오는 것은 불가능하다.
				
			}
			
			
		}
		
		
		
		
		
		
		
	}
}
