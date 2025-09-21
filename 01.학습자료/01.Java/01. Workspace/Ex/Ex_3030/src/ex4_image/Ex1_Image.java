package ex4_image;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ex1_Image {
	
	static boolean test = false;
	
	public static void main(String[] args) {

		// 이미지 복사 후, 자바 프로젝트 클릭한 뒤 붙여넣기
		Frame f = new Frame();
		f.setLayout(null);
		f.setBounds(500, 200, 600, 600);
		
		// 이미지
		ImageIcon img1 = new ImageIcon("라이언.png");
		
		// JLable : 이미지와 텍스트를 같이 넣는 클래스
		JLabel jl1 = new JLabel(img1);
		jl1.setBounds(10, 50, 200, 200);
		//
		ImageIcon img2 = new ImageIcon("심슨.jpg");
		JLabel jl2 = new JLabel(img2);
		jl2.setBounds(50, 60, 300, 300);
		
		// 버튼 추가
		Button btn = new Button("확인");
		btn.setBounds(360, 60, 100, 100);
		
		// 버튼 감지자
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// - 누를 때마다 true, false가 변경 (flag기능)
				test = !test;
				if(test) {
					// - setIcon : 이미지 삽입
					jl2.setIcon(img1);
				}else {
					jl2.setIcon(img2);
				}
			}
		});
		
		// - 이미지는 겹쳐서 집어넣을 수 있다, 또한 나중에 add된 것이 더 밑에 보인다.
		f.add(jl1);
		f.add(jl2);
		f.add(btn);
		
		// 이벤트 우상단
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//
		f.setVisible(true);
	} // main
}
