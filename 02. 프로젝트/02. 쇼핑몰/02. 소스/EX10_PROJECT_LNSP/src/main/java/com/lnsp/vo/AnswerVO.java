package com.lnsp.vo;

public class AnswerVO {

	private int qa_idx;			
	private int goods_idx;		//상품idx(goods idx 외래키)
	private String qa_regdate;	//답변일시
	private int qna_idx;		//QNA q_idx 외래키
	private String qa_content;	//답변내용
	private int status;			//삭제여부
	
	public int getQa_idx() {
		return qa_idx;
	}
	public void setQa_idx(int qa_idx) {
		this.qa_idx = qa_idx;
	}

	public String getQa_regdate() {
		return qa_regdate;
	}
	public void setQa_regdate(String qa_regdate) {
		this.qa_regdate = qa_regdate;
	}
	public int getGoods_idx() {
		return goods_idx;
	}
	public void setGoods_idx(int goods_idx) {
		this.goods_idx = goods_idx;
	}
	public int getQna_idx() {
		return qna_idx;
	}
	public void setQna_idx(int qna_idx) {
		this.qna_idx = qna_idx;
	}
	public String getQa_content() {
		return qa_content;
	}
	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
