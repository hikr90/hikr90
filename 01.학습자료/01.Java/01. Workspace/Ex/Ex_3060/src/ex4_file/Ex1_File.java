package ex4_file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Ex1_File {
	public static void main(String[] args) {
		/*	file
		 * 		- ���� �⺻���̸鼭 ���� ���Ǵ� ����� ���
		 * 		- �ڹٿ����� �����̳� ���丮�μ� ���ȴ�.
		 * 
		 * 		(1) ������
		 * 			(1.1) File(String fileNm)
		 * 				- �־��� ���ڿ��� �̸����� ���� ���� Ȥ�� ���丮�� ���� File�ν��Ͻ��� �����ϴ� ������
		 * 				- �̸��� �ַ� ��θ� �����ؼ� �����ϳ�, ���ϸ� �ִ� ��� ���α׷��� ����Ǵ� ��ġ�� �⺻ ��η� ��´�.
		 * 
		 *			(1.2) File(String path, String fileNm)
		 *				- ������ ��ο� �̸��� ���� �����Ͽ� ������ �� �ֵ��� �ϴ� ������
		 *				- ��δ� ���ڿ��� �ƴ� ���� �ν��Ͻ��ε� ���� �� �ִ�.
		 *
		 *			(1.3) File(URI uri) : ������ uri�� ������ ����
		 *			
		 *		(2) �ֿ� �޼ҵ�
		 *			(2.1) String getName() : ���� �̸��� String���� ��ȯ
		 *			(2.2) String getPath() : ������ ��θ� String���� ��ȯ
		 *			(2.3) boolean exists() : ������ �����ϴ��� �˻�
		 *			(2.4) boolean isFile() / isDirectory() : ����/���丮���� �˻�
		 *			(2.5) boolean createNewFile() : �� ������ ���� (������ �ִ� ��� �������� �ʴ´�.)
		 *			(2.6) boolean delete() : ������ ����
		 *			(2.7) long length() : ������ ũ�� ��ȯ
		 *			(2.8) String [] list() / File [] listFiles() : ���丮�� ���� ����� ��ȯ (���丮 ����)
		 *			(2.9) boolean mkdir() / mkdirs() : ���Ͽ� ������ ��η� ���丮�� ����, ���� �� true ��ȯ (mkdirs�� �θ���� ���� ����)
		 *
		 *		(3) ��� ������
		 *			(3.1) static String pathSeparator : OS���� ����ϴ� ��� ������
		 *				- window (;) / unix (:)
		 *
		 *			(3.2) static String separator : OS���� ����ϴ� �̸� ������
		 *				- window (\) / unix (/)
		 * 
		 * 
		 */
		String currDir = System.getProperty("user.dir"); // ���� ���丮
		File dir = new File(currDir);
		File [] files = dir.listFiles();
		
		for(int i=0; i<files.length; i++) {
			File f = files[i];
			String name = f.getName();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mma");
			String attribute = "";
			String size = "";
			
			if(files[i].isDirectory()) {
				attribute = "DIR";
			} else {
				size = f.length() + "";
				attribute = f.canRead() ? "R" : " ";
				attribute = f.canWrite() ? "W" : " ";
				attribute = f.isHidden() ? "H" : " ";
			}
			
			System.out.printf("%s %3s %6s %s\n", df.format(new Date(f.lastModified())), attribute, size, name);
		}
	}
}
