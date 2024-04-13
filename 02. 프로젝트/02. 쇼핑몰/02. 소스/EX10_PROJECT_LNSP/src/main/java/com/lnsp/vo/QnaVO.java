package com.lnsp.vo;

public class QnaVO {

	private int q_idx;
	private int q_infonum;		//문의번호
	private int q_category;		//상품 or 1대1 	1대1 = 1 / 상품 = 2
	private int goods_idx;		//상품번호(goods G_NUM 외래키)
	private int member_idx;		//회원번호(member m_idx 외래키)
	private int q_qnapart;		//상담구분,문의문야(배송1, 주문2, 취소3, 교환4, 반품5)
	private String q_title;		//제목
	private String q_content;	//내용
	private String q_regdate;	//날짜
	private int q_qnayn;		//답변여부
	private String q_ip;		//ip
	private int q_delete;		//삭제여부(삭제x 0, 삭제 1)
	
	
	private String g_name;
	private String m_name;
	private String m_id;
	private String m_email;
	
	public int getQ_idx() {
		return q_idx;
	}
	public void setQ_idx(int q_idx) {
		this.q_idx = q_idx;
	}
	public int getQ_infonum() {
		return q_infonum;
	}
	public void setQ_infonum(int q_infonum) {
		this.q_infonum = q_infonum;
	}
	public int getQ_category() {
		return q_category;
	}
	public void setQ_category(int q_category) {
		this.q_category = q_category;
	}
	public int getGoods_idx() {
		return goods_idx;
	}
	public void setGoods_idx(int goods_idx) {
		this.goods_idx = goods_idx;
	}
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public int getQ_qnapart() {
		return q_qnapart;
	}
	public void setQ_qnapart(int q_qnapart) {
		this.q_qnapart = q_qnapart;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public String getQ_regdate() {
		return q_regdate;
	}
	public void setQ_regdate(String q_regdate) {
		this.q_regdate = q_regdate;
	}
	public int getQ_qnayn() {
		return q_qnayn;
	}
	public void setQ_qnayn(int q_qnayn) {
		this.q_qnayn = q_qnayn;
	}
	public String getQ_ip() {
		return q_ip;
	}
	public void setQ_ip(String q_ip) {
		this.q_ip = q_ip;
	}
	public int getQ_delete() {
		return q_delete;
	}
	public void setQ_delete(int q_delete) {
		this.q_delete = q_delete;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	
	
	
	
	
	
}
