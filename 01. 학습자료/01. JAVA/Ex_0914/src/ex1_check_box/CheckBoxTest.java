package ex1_check_box;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout.Group;

public class CheckBoxTest {
	public static void main(String[] args) {
		
		Frame f = new Frame("여러가지 질문");
		f.setBounds(500, 200, 800, 250);
		f.setLayout(null);
		
		// 텍스트 추가
		// 버튼과 마찬가지로 레이아웃이 null인 경우, 크기와 위치를 지정해줘야한다.
		Label q1 = new Label("1.관심분야는 무엇입니까?");
		
		// 글자 스타일을 지정
		// Font(글자체, 글자 스타일, 글자 크기)
		Font font = new Font("궁서체", Font.BOLD, 30);
		
		q1.setFont(font);
		q1.setBounds(10, 50, 380, 50);
		
		// 프레임에 Lable 추가
		f.add(q1);
		
		// CheckBox 추가
		Checkbox sports = new Checkbox("운동");
		Checkbox movie = new Checkbox("영화 관람");
		Checkbox music = new Checkbox("음악 감상");
		
		sports.setBounds(10, 110, 50, 30);
		sports.setBackground(Color.LIGHT_GRAY);
		f.add(sports);
		
		movie.setBounds(70, 110, 80, 30);
		movie.setBackground(Color.LIGHT_GRAY);
		f.add(movie);
		
		music.setBounds(160, 110, 80, 30);
		music.setBackground(Color.LIGHT_GRAY);
		f.add(music);
		
		// 체크 박스 선택 여부 감지자
		// 운동에 체크한 경우
		sports.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				// 체크 시 1, 체크 해제시 2로 넘어간다. 
				String str = e.getStateChange() == 1 ? "운동 선택" : "운동 해제";
				System.out.println(str);
			}
		});
		
		
		// 두번째 레이블(텍스트) 생성
		Label q2 = new Label("2.성별은 무엇입니까?");
		q2.setFont(font);
		q2.setBounds(10, 150, 400, 30);
		f.add(q2);
		
		// 라디오 버튼 생성
		// 그룹 생성시, 같은 그룹 내에서는 중복 선택이 안된다. 
		// CheckBox는 디폴트 값이 있어야한다. 
		CheckboxGroup group = new CheckboxGroup();
		Checkbox male = new Checkbox("남자",group,true);
		Checkbox female = new Checkbox("여자",group,false);
		
		// 남자, 여자 버튼 추가
		male.setBounds(10, 190, 50, 30);
		female.setBounds(70, 190, 50, 30);
		
		// 버튼 추가
		f.add(male);
		f.add(female);

		// 남자, 여자 버튼 이벤트 감지자
		male.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println("남자 선택됨");
			}
		});
		
		
		female.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println("여자 선택됨");
			}
		});
				
		
		
		// 프레임 우상단 버튼 관리자 
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		f.setVisible(true);
		
		
		
		
		
		
		
		
		
		
	} // main 
}
