package ex2_stack_queue;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class Ex3_Queue {
	// 큐의 활용
	// - 최근 사용문서, 인쇄작업 대기목록
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;
	
	public static void main(String[] args) {
		//
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
		
		while (true) {
			System.out.println(">>");
			
			try {
				// 입력
				Scanner sc = new Scanner(System.in);
				String input = sc.nextLine().trim();
				
				// 입력 값이 없는 경우 재 반복
				if("".equalsIgnoreCase(input)) continue;
				
				//
				if(input.equalsIgnoreCase("q")) {
					System.exit(0);
				
				} else if(input.equalsIgnoreCase("help")) {
					System.out.println(" help - 도움말을 보여줍니다.");
					System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
					System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
				
				} else if(input.equalsIgnoreCase("history")) {
					// 저장 처리
					int i = 0;
					save(input);
					// 큐의 데이터를 링크드 리스트에 복사
					// (반복문 사용 위함)
					LinkedList tmp = (LinkedList)q;
					ListIterator it = tmp.listIterator();
					// 출력
					while(it.hasNext()) System.out.println(++i + "." + it.next());
				
				} else {
					save(input);
					System.out.println(input);
				}
				
			} catch (Exception e) {
				System.out.println("입력 오류입니다.");
			}
		}
	}
	
	//
	public static void save(String input) {
		// 큐 저장
		if(!"".equals(input)) q.offer(input);
		
		// 큐 최대 크기를 넘어설 경우 가장 처음 입력된 것을 삭제
		if(q.size() > MAX_SIZE) q.remove();
	}
}
