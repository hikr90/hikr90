package ex5_work;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ex5_Work {
	// ���� Ŭ����
	private Ex4_Work info;
	
	// ������ �������� �޼ҵ�
	public Ex4_Work getInfo() {
		return info;
	}
	
	// ������
	public Ex5_Work(String id) {
		String path = "C://JAVA1_0713_KTH/Game/"+id+"/Gamesav.sav";
		File f = new File(path);
		//
		if(f.exists()) {
			// ó���� �ƴ� ����� ���
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			
			// ���� �ε�
			try {
				//
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);
				
				// readObject �޼ҵ�� ��ü ��ü�� �޾ƿ´�.
				// Object�� �� ū ��ü�̹Ƿ� ū ��ü�� ���� ��ü�� �����ϱ� ����ȯ�� ������Ѵ�.
				info = (Ex4_Work)ois.readObject();	// New�� ���, �ּ� ���� ������ heap ������ �ִ�.
				System.out.println("�ε� �Ϸ�");
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("�ε� ����");
			} finally {
				// ���ο��� �ٽ� ���ο� ���� �ʵ��� try ó��
				try {
					ois.close();
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} else {
			// ù ������ ���
			System.out.println("���̵� ������ ȯ���մϴ�.");
		}
	}
}
