package ex1_object_stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*기록 저장을 위한 클래스를 따로 생성*/
public class ScoreWriter {
	// 객체(RspInfo)를 통쨰로 저장하기위한 클래스
	
	// 객체가 넘어오면 주소값이 넘어간다.
	// 그래서 main의 info의 정보(승무패,아이디)가 아래의 info로 넘어간다. 
	public ScoreWriter(RspInfo info) {
	
		String path = "C://JAVA1_0713_KTH/Game/"+info.getId()+"/Gamesav.sav";
		
		// game폴더가 없으므로 생성
		File dir1 = new File("C://JAVA1_0713_KTH/Game/");
		if(!dir1.exists()) {
			// game이 없으니 아래 식 동작하여 game폴더 생성
			dir1.mkdirs();
		}
		
		// game폴더는 반드시 존재하는 상황
		// dir1경로의 game폴더 안에 info.getid()의 폴더가 있나?
		File dir2 = new File(dir1,info.getId());
		if(!dir2.exists()) {
			dir2.mkdirs();
		}
		
		// game과 유저아이디 명칭까지 있는 상황
		// 파라미터를 넘겨받은 info객체를 통째로 저장
		// (중요!) 클래스 저장시 바이트 기반으로만 가능하다.
		FileOutputStream fos = null;
		ObjectOutputStream oos = null; // 클래스를 통째로 저장할 수 있게하는 보조적인 스트림
		
		try {
			// 파일을 쓰기
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			
			// info객체를 저장하는 경우, writeObject를 사용해야한다.
			// 어떤 클래스로 줄지 몰라서 object로 즉, 어떤 클래스로든지 다 받을 수 있게 해놓는다. (모든 클래스는 오브젝트의 자식이니)
			// info객체를 Gamesav.sav로 저장
			oos.writeObject(info);
			
					
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("기록저장 실패");
		}finally {
			
			// main에서 또 thorws하기 그러니 여기서 try처리
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				}
		}

		
		
		
		
		
	} // constructor
	
	
	// getclass는 그냥 내 클래스를 뜻한다.
	
	
	
}
