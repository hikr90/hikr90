package ex2_choice;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// ItemListener �������̽� ����ȭ��Ų ��, �������̵�
public class ChoiceHandler implements ItemListener{

	@Override
	public void itemStateChanged(ItemEvent e) {
		// String���� ������´�. 
		String str = (String)e.getItem();
		
		if(str.equals("�������� �����Դϱ�?")) {
			System.out.println("�Ѱ����� �ݵ�� �����ϼž��մϴ�.");
		}
	}
	
	
	
	
	
	
	
	
}
