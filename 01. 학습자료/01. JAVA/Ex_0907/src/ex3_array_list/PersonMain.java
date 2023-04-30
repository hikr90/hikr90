package ex3_array_list;

/*	문제
 * 	키보드에서 id값과 pw값을 받아 arraylist 클래스 타입을 이용하여 아이디와 패스워드를 저장하는 결과를 만드시오
 * 	
 * 	결과 :
 * 	id : aaa
 * 	pw : 111
 * 	aaa / 111
 * 
 * 	id : bbb
 * 	pw : 222
 * 	aaa / 111
 * 	bbb / 222
 * 
 * 	id : aaa
 * 	pw : 111
 * 	중복된 아이디입니다.
 * 
 * 	출력과 동시에 while문 정지 혹은 다시 id : 으로 돌아가는 식을 만드세요.
 * 
 * 		  
 * */


import java.util.ArrayList;
import java.util.Scanner;

public class PersonMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Person> arr = new ArrayList<>();
		
		outer : while(true) {
			// add를 통해서, arr의 사이즈는 계속 늘어나지만 참조하고있는 p객체의 값은 변경되어있기에 
			// 값이 계속 갱신된다. (주소값을 참조하기때문에)

			// 객체 생성을 while문 안에 넣게되면
			// while문으로 들어올때마다 클래스가 계속해서 집을 생성하게된다.
			// (중요!)같은 이름으로 new를 사용할 경우, 방만 새로 만드는 작업을 하게된다.
			// (중요!) 전에 있던 집은 까먹게된다.
			// (중요!) 단, 까먹은 집은 arr이 참조하고있기에 이 기존의 p의 집은 날아가지않는다. (가비지 컬렉터가 가져가지못함)
			// 그래서 기존의 값을 보존할 수 있다.
			Person p = new Person();
			
			System.out.println("id : ");
			p.setId(sc.next());
			
			System.out.println("pwd : ");
			p.setPwd(sc.nextInt());
						
			// 중복체크
			for(int i=0;i<arr.size();i++) {
				
				if(p.getId().equalsIgnoreCase(arr.get(i).getId())) {
					System.out.println("중복된 아이디입니다.");
					continue outer;
				}
			}
			
			
			arr.add(p);
			
			// for문을 밖으로 빼내는 경우, if문으로 break를 걸어줘야만 reachable 오류가 걸리지 않는다.
			for(int i=0;i<arr.size();i++) {
				System.out.printf("%s / %d\n",arr.get(i).getId(),arr.get(i).getPwd());
			}
			
			
		}	// while
		

		
		
		
		
		
	} // main
}
