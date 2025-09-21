package ex2_choice;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ex1_Choice implements ItemListener{
	// ItemListener 인터페이스 구현 후 재정의
	@Override
	public void itemStateChanged(ItemEvent e) {
		// String 저장
		String str = (String)e.getItem();
		//
		if(str.equals("혈액형은 무엇입니까?")) {
			System.out.println("한가지는 반드시 선택하셔야합니다.");
		}
	}
}
