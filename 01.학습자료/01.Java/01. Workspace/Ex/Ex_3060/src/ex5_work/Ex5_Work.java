package ex5_work;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ex5_Work {
	// 정보 클래스
	private Ex4_Work info;
	
	// 정보를 가져오는 메소드
	public Ex4_Work getInfo() {
		return info;
	}
	
	// 생성자
	public Ex5_Work(String id) {
		String path = "C://JAVA1_0713_KTH/Game/"+id+"/Gamesav.sav";
		File f = new File(path);
		//
		if(f.exists()) {
			// 처음이 아닌 사람인 경우
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			
			// 파일 로드
			try {
				//
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);
				
				// readObject 메소드로 객체 자체를 받아온다.
				// Object가 더 큰 객체이므로 큰 객체를 작은 객체에 넣으니까 형변환을 해줘야한다.
				info = (Ex4_Work)ois.readObject();	// New가 없어도, 주소 값을 받으니 heap 영역이 있다.
				System.out.println("로드 완료");
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("로드 실패");
			} finally {
				// 메인에서 다시 스로우 하지 않도록 try 처리
				try {
					ois.close();
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} else {
			// 첫 시작인 사람
			System.out.println("아이디 생성을 환영합니다.");
		}
	}
}
