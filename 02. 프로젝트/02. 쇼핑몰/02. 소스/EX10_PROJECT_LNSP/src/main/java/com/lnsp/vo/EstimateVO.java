package com.lnsp.vo;

import java.sql.Date;

public class EstimateVO {
	// 	VIEW TABLE view_estimate 의 VALUES
	// 	RANK		EST_IDX		M_NUM		EST_TYPE	EST_PLACE	
	//	EST_PRICE	EST_DAY		EST_REGION	EST_SPACE	EST_MEMO	
	//	STATUS		EST_DATE	M_NAME		M_PHONE		M_EMAIL
	private int rank;
	private int est_idx;
	private int m_num;
	private String est_type;
	private String est_place;
	private String est_price;
	private String est_day;
	private String est_region;
	private String est_space;
	private String est_memo;
	private int status;
	private Date est_date;
	private String m_name;
	private String m_phone;
	private String m_email;
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getEst_idx() {
		return est_idx;
	}
	public void setEst_idx(int est_idx) {
		this.est_idx = est_idx;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getEst_type() {
		return est_type;
	}
	public void setEst_type(String est_type) {
		this.est_type = est_type;
	}
	public String getEst_place() {
		return est_place;
	}
	public void setEst_place(String est_place) {
		this.est_place = est_place;
	}
	public String getEst_price() {
		return est_price;
	}
	public void setEst_price(String est_price) {
		this.est_price = est_price;
	}
	public String getEst_day() {
		return est_day;
	}
	public void setEst_day(String est_day) {
		this.est_day = est_day;
	}
	public String getEst_region() {
		return est_region;
	}
	public void setEst_region(String est_region) {
		this.est_region = est_region;
	}
	public String getEst_space() {
		return est_space;
	}
	public void setEst_space(String est_space) {
		this.est_space = est_space;
	}
	public String getEst_memo() {
		return est_memo;
	}
	public void setEst_memo(String est_memo) {
		this.est_memo = est_memo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getEst_date() {
		return est_date;
	}
	public void setEst_date(Date est_date) {
		this.est_date = est_date;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	
	
}
