package ex3_work;

/*	숙제
	과수원이 있다.
	배, 사과, 오렌지를 키우고 있는데, 하루 생산량은 각각 
	5개, 7개, 5개이다. 
	
	과수원에서 하루에 생상되는 과일의 총 갯수를 출력하고, 시간당 전체 과일의 평균 생산량을 출력하라
	
	단, 과일의 갯수와 하루 생산량을 저장할 변수는 int타입으로 
	평균 생산량을 저장할 변수는 float타입으로 지정하도록 한다.
	
*/

public class Ex1_Work {
	public static void main(String[] args) {
	
		int peer = 5;
		int apple = 7;
		int orange = 5;
		
		int total = peer+apple+orange;
		// 혹은 float f = total/24.0f 의 방식으로도 가능하다.
		float f = (float)(total)/24;
		
		System.out.printf("하루 과일의 총 생산량 : %d개\n",total);
		System.out.printf("시간당 전체 과일의 평균 생산량 : %.2f개\n",f);
		
		
		
		
	}
}
