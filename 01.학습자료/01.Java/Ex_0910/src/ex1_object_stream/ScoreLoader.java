package ex1_object_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*저장된 데이터를 불러오는 클래스*/
public class ScoreLoader {
	
	// 승무패 기록을 불러와서 그 값들을 저장할 클래스 생성 
	private RspInfo info;
	
	// private이니까 따로 부를 수 있는 info 클래스의 로드 메서드가 필요하다.
	public RspInfo getInfo() {
		return info;
	}
	
	// 생성자
	public ScoreLoader(String id) {
		String path = "C://JAVA1_0713_KTH/Game/"+id+"/Gamesav.sav";
		File f = new File(path);
		
		if(f.exists()) {
			// 처음이 아닌 사람인 경우
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			
			// 파일 로드
			try {
				
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);
				// 로더의 info클래스에 주소값을 넘겨줌 (new가 없어도 주소값을 받으니 힙영역에 공간을 부여받음) = 로더가 받은 rspinfo객체에 저장된 get메서드 사용가능 
				// 큰(object)객체가 작은(class)객체로 들어오기때문에 어떤 클래스(위에 생성한 클래스타입)로 받을지 정해줘야한다.
				// object로 받아온 ois.readObject()를 (RspInfo)타입으로 받아서 info에 저장한다.
				info = (RspInfo)ois.readObject();
				System.out.println("로드 완료");
				
				// info안에는 해당 아이디에대한 승무패 기록이 있을 것이다.
				
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("로드 실패");
			}finally {
				// 메인에서 다시 스로우 하지 않도록 try 처리
				try {
					ois.close();
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}else {
			// 처음 게임을 하거나 존재하지 않는 아이디로 접속한 경우
			// game 폴더, id, gamesav.sav도 없는 상태
			System.out.println("아이디 생성을 환영합니다.");
		}
		
	}

















}
