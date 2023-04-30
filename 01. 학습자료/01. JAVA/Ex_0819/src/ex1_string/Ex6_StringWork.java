package ex1_string;

import java.util.Scanner;

public class Ex6_StringWork {

	public static void main(String[] args) {
		
		/*숙제 
		 아래 배열을 통해 배우와 작품을 검색하는 로직을 작성
		 
		 배우명 : 송강호
		 [송강호]
		 박쥐
		 괴물
		 관상
		 
		 배우명 : aaa 을 할 경우
		 해당 배우가 존재하지 않습니다.
		 * */
		String[][] actor = {{"[송강호]","박쥐","괴물","관상"},
								{"[이병헌]","광해","내부자들","놈놈놈"},
								{"[마동석]","성난황소","부산행","범죄도시"} };
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("배우명 : ");
		String actName = sc.next();
		int cnt = 0;
		
		for(int i=0;i<actor.length;i++) {
			if(actor[i][0].equals("["+actName+"]")) {
				
				for(int j=0;j<actor[i].length;j++) {
					System.out.println(actor[i][j]);
				}
			}else {
				cnt++;
				if(cnt==3) {					
					System.out.println("해당 배우는 존재하지 않습니다.");
				}
			}
			
		}
		
		
				
					
			
		
	

	
	}
}
