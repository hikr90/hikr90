package ex1_file;

import java.io.File;

public class Ex2_File {
	public static void main(String[] args) {

		// 경로상에 있는 하위 목록의 명칭을 가지고오는 방법
		String path = "C:/JAVA1_0713_KTH"; // 폴더
		File f = new File(path);
		
		// File클래스의 접근경로가 파일 형식이 아닌 폴더 형식인 경우 
		if(!f.isFile()) {
			
			// f.list()로 하위 폴더의 목록을 가지고올 수 있다.
			// list는 String타입의 배열형태로 반환한다.
			// list는 알파벳 순서로 정렬한다.
			String [] name = f.list();

			for(int i=0;i<name.length;i++) {
				System.out.println(name[i]);
			}
					
		
		}
	
	
	
	
	
	
	
	
	
	
	
	}
}
