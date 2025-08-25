package ex1_frame_test;

import java.awt.Color;
import java.awt.Frame;

public class Ex1_FrameTest {
	public static void main(String[] args) {
		/*	Frame
		 *		- 프레임을 생성하는 클래스
		 */
		Frame frame = new Frame("첫 프레임");	// 파라미터는 프레임의 제목이다.
		//
		frame.setSize(400,300);			// 너비와 높이 지정
		frame.setLocation(500,200);		// 좌 상단을 기준으로 x좌표로부터 500 픽셀, y좌표로부터 200픽셀 떨어진 위치
		frame.setBackground(Color.BLUE);	// 색상을 선택
		frame.setVisible(true);	// 프레임 출력
	}
}
