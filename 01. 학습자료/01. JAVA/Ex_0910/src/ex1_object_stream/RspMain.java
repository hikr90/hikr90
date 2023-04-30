package ex1_object_stream;

import java.util.Random;
import java.util.Scanner;

/*유저 id 입력받고 게임 시작하고 승무패 화면 출력*/
public class RspMain {
	public static void main(String[] args) {
		
		RspInfo info = new RspInfo();
		Scanner sc = new Scanner(System.in);
		String id = "";
		int win = 0;
		int lose = 0;
		int draw = 0;
		
		System.out.println("id : ");
		id = sc.next();
		info.setId(id);
		
		// 아이디를 입력받은 뒤, 로드 작업을 해야한다.
		// 생성자로 바로 실행
		try {
		ScoreLoader s1 = new ScoreLoader(id);
		
		// 스코어의 승무패값이 메인의 승무패 변수에 저장이 된다.
		win = s1.getInfo().getWin();
		lose = s1.getInfo().getLose();
		draw = s1.getInfo().getDraw();
		
		// 값이 초기화 되는 상황이 있어 메인의 승무패에 값을 저장해주는 코드를 한번 더 짜자
		// 그리고 저장된 값을 info(rspinfo)클래스의 승무패에 저장해줘야한다. 그래야 info 객체의 승무패가 누적되는 것이 적용된다.
		info.setWin(win);
		info.setLose(lose);
		info.setDraw(draw);
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		// id로 로그인 했을 시, 저장된 기록을 확인할 수 있도록 보여주는 식
		System.out.printf("%d승 %d패 %d무\n",win,lose,draw);
		
		while(true) {
			int random = new Random().nextInt(2);
			
			System.out.println("가위(s) | 바위(r) | 보(p) : ");
			String user = sc.next(); // srp중 선택한 것을 값으로 받음
			
			// 사용자가 입력받은 값을 정수로 변환
			int usercnt = 0;
			
			switch (user) {
			case "s":
				usercnt = 0;
				break;
			case "r":
				usercnt = 1;
				break;
			case "p":
				usercnt = 2;
				break;
			} // switch
			
			// 경우의 수를 판단
			if(usercnt-random==-2||usercnt-random==1) {
				// 선행으로 집어넣자
				info.setWin(++win);
				System.out.println("이겼습니다!");
			}else if(usercnt-random==0) {
				info.setDraw(++draw);
				System.out.println("비겼습니다.");
			}else {
				info.setLose(++lose);
				System.out.println("졌습니다.");
			}
			
			System.out.printf("%d승 %d패 %d무%n",info.getWin(),info.getLose(),info.getDraw());
			
			// 더할건지 질문
			System.out.print("한판 더? y / n : ");
			String exit = sc.next();
			
			if(!exit.equalsIgnoreCase("y")) {
				System.out.println("게임을 종료합니다.");
				break;
			}else {
				
			}
			
			
		} // while
		
		// 오브젝트스트림 (클래스를 저장)
		// while문을 나왔으니 게임이 종료 되었으니 info객체(id,win,lose,draw의 정보)를 저장한다.
		// 저장은 한번만하니 익명으로 생성
		// 아이디와 승무패가 들어있는 info
		new ScoreWriter(info);
		
		
		
		
		
	} //main
}
