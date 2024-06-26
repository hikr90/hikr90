package ex2_frame_test;

import java.awt.Color;

public class Ex2_FrameTest {
	public static void main(String[] args) {
		
		// 프레임의 상속
		// - 한자리에 여러 개의 프레임을 생성해야할 상황을 대비하기위해서이다.
		// - 자식마다 필요한 속성들만 따로 정의해서 사용할 수 있다.
		// - 공통적인 부분은 부모의 속성을, 각 프레임의 차이는 자식에서 재정의하여 사용한다.
		MyFrame mf = new MyFrame();
		mf.setBackground(Color.YELLOW);
		//
		MyFrame mf2 = new MyFrame();
		mf2.setBackground(Color.CYAN);
		mf2.setTitle("나는 프레임이다.");
	}
}
