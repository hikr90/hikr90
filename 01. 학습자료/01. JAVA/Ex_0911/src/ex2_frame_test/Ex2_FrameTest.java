package ex2_frame_test;
// window -> show viewer -> console
import java.awt.Color;

public class Ex2_FrameTest {
	public static void main(String[] args) {
		
		// 프레임이 상속을 받는 이유는, 한자리에 여러 창을 만들어야할 상황을 대비하기 위함이다.
		// 자식마다 필요한 속성들만 따로 정의해서 다르게 지정할 수 있다.
		// 공통적인 부분은 부모의 속성대로, 차이를 둬야하는 속성은 자식에서 재설정이 가능하다. 
		MyFrame mf = new MyFrame();
		mf.setBackground(Color.YELLOW);
		
		MyFrame mf2 = new MyFrame();
		mf2.setBackground(Color.CYAN);
		mf2.setTitle("나는 프레임이다.");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
