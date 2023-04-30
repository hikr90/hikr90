package ex1_array_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex2_ArrayList {
	public static void main(String[] args) {
		
		/* 문제
		// id : aaa
		// [aaa]
		// id : bbb
		// [aaa, bbb]
		// id : aaa
		// 할 경우, 중복된 아이디 입니다.
		 id : */
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		
		out : while(true) {
			
			System.out.println("id : ");
			String id = sc.next();
			
			// 중복체크
			for(int i=0;i<list.size();i++) {
				if(list.get(i).equalsIgnoreCase(id)) {
					System.out.println("중복");
					continue out;
				}
			}
			
			list.add(id);
			System.out.println(list);
			
			}
			

			
			
			
	
		
		
		
	}
}
