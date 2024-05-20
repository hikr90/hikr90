package vo;

import org.springframework.web.multipart.MultipartFile;

public class PhotoVO {
	
	/*	파일 객체 VO
	 *		- title : 사진의 제목 <input type="text" name="title"/>
	 *		- photo : 사진 파일 자체 <input type="file" name="photo"/>
	 *		- filename : DB에 저장할 사진 파일 제목		
	 *		
	 *		[참고] DB에는 실제 파일을 저장할 수 없으므로 서버(혹은 로컬)의 경로에 저장되며 DB에 경로, 파일 명칭, 확장자, 크기등의 정보를 저장하여 해당 값으로 파일을 불러와 사용한다.
	 */
	private String title;
	private MultipartFile photo;
	private String filename;
	//
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}