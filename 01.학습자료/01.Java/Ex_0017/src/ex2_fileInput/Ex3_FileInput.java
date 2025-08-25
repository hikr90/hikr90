package ex2_fileInput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex3_FileInput {
	public static void main(String[] args) throws IOException {
		
		// 문제
		// - 공유폴더에 test.txt 를 읽어서
		// - 파일 안의 내용이 회문수인지 아닌지를 판단하세요.

		String path = "C:\\JAVA1_0713_KTH/test.txt";
		File f = new File(path);	// 파일 객체화
		//
		FileInputStream fis = null;
		byte [] b_read = new byte[(int)f.length()];
		String rev = "";
		//
		if(f.exists()) {
			//
			try {
				fis = new FileInputStream(f); // 스트림 생성
				fis.read(b_read); // 읽음
				//
				String ori = new String(b_read);
				//
				for(int i=ori.length()-1;i>=0;i--) {
					rev += ori.charAt(i);
				}
				//
				if(ori.equals(rev)) {
					System.out.println(ori+"(은)는 회문수입니다.");
				}else {
					System.out.println(ori+"(은)는 회문수가 아닙니다.");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(fis!=null) {
					fis.close(); // 통로 닫음
				}
			}
		}
	}
}
