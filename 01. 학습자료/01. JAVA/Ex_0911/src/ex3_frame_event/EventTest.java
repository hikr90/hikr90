package ex3_frame_event;
// �ٸ� ��Ű���� �ִ� ���, import�ʿ�
import ex2_frame_test.MyFrame;

public class EventTest extends MyFrame{
	public static void main(String[] args) {
		
		MyFrame mf = new MyFrame();
		
		// ������ frame�� �̺�Ʈ ���� ������ ���
		// ��ư �����ڸ� ����ϴµ� MyeventTest�ȿ� �ִ� �������̽��� ����ϰھ�
		mf.addWindowListener(new MyEventTest());
		
		
	}
}
