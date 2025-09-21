package ex1_work;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex2_Work {
	public static void main(String[] args) {
		
		// 문제
		// - id : aaa
		// - [aaa]
		
		// - id : bbb
		// - [aaa, bbb]
		
		// - id : aaa 로 중복된 값 추가 시
		// - 중복된 아이디입니다. 라고 보여주세요.
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		//
		out : while(true) {
			//
			System.out.println("id : ");
			String id = sc.next();
			
			// 중복체크
			for(int i=0;i<list.size();i++) {
				if(list.get(i).equalsIgnoreCase(id)) {
					System.out.println("중복");
					continue out;
				}
			}
			//
			list.add(id);
			System.out.println(list);
		}
	}
}
