package mail;

public interface MailService {
	
	/** 메일 전송을 위한 인터페이스
     *  @param subject 제목
     *  @param text 내용
     *  @param from 보내는 이 주소
     *  @param to 받는 이 주소
     *  @param filePath FILEPATH 첨부파일 경로, 없는 경우 NULL **/
	boolean send(String subject, String text, String from, String to, String filePath);
	
}
