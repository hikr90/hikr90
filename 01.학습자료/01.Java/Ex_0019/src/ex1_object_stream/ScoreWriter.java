package ex1_object_stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ScoreWriter {
	public ScoreWriter(RspInfo info) {
		//
		String path = "C://JAVA1_0713_KTH/Game/"+info.getId()+"/Gamesav.sav";
		
		// 전적 정보를 저장한다.
		File dir1 = new File("C://JAVA1_0713_KTH/Game/");
		//
		if(!dir1.exists()) {
			// 폴더가 없으면 생성한다.
			dir1.mkdirs();
		}

		// 분류 폴더는 생성되었으니, 사용자별 폴더가 있는지 확인
		File dir2 = new File(dir1,info.getId());
		if(!dir2.exists()) {
			// 없으면 생성
			dir2.mkdirs();
		}
		
		/*	ObjectOutputStream
		 *		- 클래스를 통으로 저장할 수 있게해주는 보조적인 스트림
		 *		- 클래스를 입출력하는 경우 반드시 바이트 기반으로 진행해야한다. 
		 *		- 전송하는 객체 파일은 반드시 직렬화 인터페이스를 구현해야한다.
		 */
		
		// RspInfo로 아이디, 명칭, 전적까지 전부 받았다.
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		//
		try {
			// 파일 쓰기
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			
			// 객체를 저장하는 경우 writeObject를 사용한다.
			oos.writeObject(info);	// 아이디 폴더 안에 Gamesave.sav 로 저장한다.
					
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("기록저장 실패");
		} finally {
			// 메인에서 throws를 사용하지 않도록 try - catch 사용
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				
			}
		}
	} // constructor
}
