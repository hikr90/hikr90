package ex5_map;

import java.util.HashMap;
import java.util.Scanner;

public class Ex4_Work {
	public static void main(String[] args) {
	
		// 문제
		// - 결과
		// - id : aaaa
		// - pw : 1111
		// - 아이디가 존재하지 않습니다.
		
		// - id : lee
		// - pw : 4444
		// - 비밀번호가 존재하지 않습니다.
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("kim", 1111);
		map.put("lee", 2222);
		map.put("park", 3333);
		//
		Scanner sc = new Scanner(System.in);
		System.out.println("id : ");
		String id = sc.next();
		//
		System.out.println("pw : ");
		int pw = sc.nextInt();
		//
		if(!map.containsKey(id)) {
			System.out.println("id가 존재하지 않습니다.");
		} else {
			if(map.get(id)!=pw) {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}else {
				System.out.println("로그인에 성공하였습니다.");
			}
		}
	} // main
}
