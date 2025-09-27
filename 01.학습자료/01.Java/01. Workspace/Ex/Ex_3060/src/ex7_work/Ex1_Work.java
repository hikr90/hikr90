package ex7_work;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Ex1_Work {
	/*가위|(s)|바위(r)|보(p) : s
	 * 컴퓨터도 난수로 넣고 결과를 출력
	 * 
	 * 예) 당신이 이겼습니다.
	 * 1승 0무 0패
	 * 다시 하겠습니까? y|n: y
	 * 
	 * 가위|(s)|바위(r)|보(s)| : s
	 * 비겼습니다.
	 * 1승 1무 0패
	 * ...
	 * 
	 * 기록이 저장되도록
	 * 
	 * */

	public static void main(String[] args) throws IOException {
		
		// 문제
		// - 가위 (s) / 바위 (r) / 보 (p) : s
		// - 컴퓨터로 난수로 넣고 결과를 받는다.
		//
		// - 예) 당신이 이겼습니다.
		// - 1승 0무 0패
		// - 다시 하시겠습니까? Y/N : y
		
		// - 가위 (s) / 바위 (r) / 보 (p) : s
		// - 비겼습니다.
		// - 1승 1무 0패
		// - .....
		
		// - 기록은 파일 내에 저장되어야합니다.
		Scanner sc = new Scanner(System.in);
		String path = "C://JAVA1_0713_KTH/Work.txt";
		File f = new File(path);
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		//
		int win = 0;
		int lose = 0;
		int draw = 0;
		//
		try {
			//
			fos = new FileOutputStream(f);
			bos = new BufferedOutputStream(fos);
			//
			outer :	while(true) {
				System.out.println("가위|(s)|바위(r)|보(p) :");
				String act = sc.next();
				int n_act = 0;
				String s_act = "";
				int rnd = new Random().nextInt(3)+1;
				//
				if(act.equalsIgnoreCase("s")) {
					n_act = 1;
				} else if(act.equalsIgnoreCase("r")) {
					n_act = 2;
				} else if(act.equalsIgnoreCase("p")) {
					n_act = 3;
				} else {
					System.out.println("올바른 값을 입력해주세요.");
					continue;
				}
				//
				if(n_act-rnd==-2||n_act-rnd==1) {
					// 선행으로 집어넣자
					win++;
				} else if(n_act-rnd==0) {
					draw++;
				} else {
					lose++;
				}
				//
				System.out.printf("%d승 %d무 %d패%n",win,draw,lose);
				System.out.println("다시 하시겠습니까? Y/N : ");
				//
				s_act = sc.next();
				//
				if(s_act.equalsIgnoreCase("y")) {
					continue;
				} else if(s_act.equalsIgnoreCase("n")){
					String msg = "당신의 최종 전적은 : "+win+"승 "+draw+"무 "+lose+"패입니다.";
					bos.write(msg.getBytes());
					break;
				} else {
					System.out.println("잘못된 값입니다.");
					break outer;
				}
			}
			//
			bos.flush();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("올바른 값을 입력해주세요.");
			e.printStackTrace();
		}
		//
		bos.close();
		fos.close();
	}
}
