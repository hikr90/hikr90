package ex4_file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Ex1_File {
	public static void main(String[] args) {
		/*	file
		 * 		- 가장 기본적이면서 많이 사용되는 입출력 대상
		 * 		- 자바에서는 파일이나 디렉토리로서 사용된다.
		 * 
		 * 		(1) 생성자
		 * 			(1.1) File(String fileNm)
		 * 				- 주어진 문자열을 이름으로 갖는 파일 혹은 디렉토리를 위한 File인스턴스를 생생하는 생성자
		 * 				- 이름은 주로 경로를 포함해서 지정하나, 파일만 있는 경우 프로그램이 실행되는 위치를 기본 경로로 잡는다.
		 * 
		 *			(1.2) File(String path, String fileNm)
		 *				- 파일의 경로와 이름을 따로 구분하여 지정할 수 있도록 하는 생성자
		 *				- 경로는 문자열이 아닌 파일 인스턴스로도 받을 수 있다.
		 *
		 *			(1.3) File(URI uri) : 지정된 uri로 파일을 생성
		 *			
		 *		(2) 주요 메소드
		 *			(2.1) String getName() : 파일 이름을 String으로 변환
		 *			(2.2) String getPath() : 파일의 경로를 String으로 변환
		 *			(2.3) boolean exists() : 파일이 존재하는지 검사
		 *			(2.4) boolean isFile() / isDirectory() : 파일/디렉토리인지 검사
		 *			(2.5) boolean createNewFile() : 빈 파일을 생성 (파일이 있는 경우 생성하지 않는다.)
		 *			(2.6) boolean delete() : 파일을 삭제
		 *			(2.7) long length() : 파일의 크기 반환
		 *			(2.8) String [] list() / File [] listFiles() : 디렉토리의 파일 목록을 반환 (디렉토리 포함)
		 *			(2.9) boolean mkdir() / mkdirs() : 파일에 지정된 경로로 디렉토리를 생성, 성공 시 true 반환 (mkdirs는 부모까지 폴더 생성)
		 *
		 *		(3) 경로 구분자
		 *			(3.1) static String pathSeparator : OS에서 사용하는 경로 구분자
		 *				- window (;) / unix (:)
		 *
		 *			(3.2) static String separator : OS에서 사용하는 이름 구분자
		 *				- window (\) / unix (/)
		 * 
		 * 
		 */
		String currDir = System.getProperty("user.dir"); // 현재 디렉토리
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
