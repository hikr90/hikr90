package ex1_frame_test;

import java.awt.Color;
import java.awt.Frame;

public class Ex1_FrameTest {
	public static void main(String[] args) {
		
		// Frame클래스 준비 
		// ()의 내용은 프레임의 제목이 된다.
		Frame frame = new Frame("첫 프레임");
		
		// 너비와 높이 지정
		frame.setSize(400,300);
		
		// 프레임의 위치 좌상단을 기준으로 x좌표로부터 500픽셀 떨어지고 y좌표로부터 200픽셀 떨어져있다.
		frame.setLocation(500,200);
		
		// Color클래스의 blue 색상 선택
		// blue는 메모리상에 하나뿐인 static변수이자 상수이다.
		frame.setBackground(Color.BLUE);
		
		// 프레임 출력
		frame.setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
