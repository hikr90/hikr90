package ex3_frame_event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
	// �������� ���� ��ư �̺�Ʈ�� �ݵ�� WindowListener��� �������̽��� �ʿ��ϴ�.
public class MyEventTest implements WindowListener{

	// ��� â���� x ���ý� �ٷ� ������ ��쵵, �����Ͻðڽ��ϱ�? ��� �Ǵٸ� â�� �ߴ� ��쵵 �ֱ⿡ �̺�Ʈ ó���� ���� �ʰ� �⺻������ �Ǿ��ִ�.

	// �̺�Ʈ ������ : _��x�� � ���� Ŭ���Ǿ����� Ȯ���ϴ� ������
	// ������ : �������̵� �޼��带 �������ִ� �������̽�
	
	@Override
	public void windowActivated(WindowEvent e) {
		//  TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// ���� x��ư Ŭ���� �����ϴ� �޼���
		System.out.println("x��ư Ŭ����!!");
		System.exit(0); // ������ ���� (�������� : 0 / ������ �� ���¿��� ���� : -1)
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// �ּ�ȭ �ܰ迡�� ���� ������� ���ƿ��� �� ȣ��Ǵ� �޼���
		System.out.println("���� ũ��� ���ƿ�!!");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// �ּ�ȭ ��ư�� Ŭ������ �� �����ϴ� �޼���
		System.out.println("�ּ�ȭ ��ư Ŭ����!!");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
		









}
