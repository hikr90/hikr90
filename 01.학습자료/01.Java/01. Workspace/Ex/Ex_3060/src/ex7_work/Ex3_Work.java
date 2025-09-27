package ex7_work;

import java.util.Random;
import java.util.Scanner;

public class Ex3_Work {
	public static void main(String[] args) {
		//
		Ex4_Work info = new Ex4_Work();
		Scanner sc = new Scanner(System.in);
		String id = "";
		int win = 0;
		int lose = 0;
		int draw = 0;
		//
		System.out.println("id : ");
		id = sc.next();
		info.setId(id);
		//
		try {
			// 정보를 가져오는 클래스를 선언
			Ex5_Work s1 = new Ex5_Work(id);
			// 전적 변수로 저장
			win = s1.getInfo().getWin();
			lose = s1.getInfo().getLose();
			draw = s1.getInfo().getDraw();
			// 전적 세팅
			info.setWin(win);
			info.setLose(lose);
			info.setDraw(draw);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// 전적 확인
		System.out.printf("%d승 %d패 %d무\n",win,lose,draw);
		//
		while(true) {
			//
			int random = new Random().nextInt(2);
			//
			System.out.println("가위(s) | 바위(r) | 보(p) : ");
			String user = sc.next();
			int usercnt = 0;
			//
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
				// 선행으로 집어넣는다.
				info.setWin(++win);
				System.out.println("이겼습니다!");
			} else if(usercnt-random==0) {
				info.setDraw(++draw);
				System.out.println("비겼습니다.");
			} else {
				info.setLose(++lose);
				System.out.println("졌습니다.");
			}
			//
			System.out.printf("%d승 %d패 %d무%n",info.getWin(),info.getLose(),info.getDraw());
			
			// 더할건지 질문
			System.out.print("한판 더? y / n : ");
			String exit = sc.next();
			//
			if(!exit.equalsIgnoreCase("y")) {
				System.out.println("게임을 종료합니다.");
				break;
			} else {
				
			}
		} // while
		
		// Object Stream 동작
		// - 게임이 종료되었으므로 객체를 저장한다.
		// - 저장은 한번만해주면 되니까 익명클래스로 선언
		new Ex6_Work(info);
	} //main
}
