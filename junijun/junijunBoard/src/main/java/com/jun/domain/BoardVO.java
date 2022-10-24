package com.jun.domain;

import java.util.Date;

public class BoardVO {
	
	private int bno;
	private String title;
	private String contetn;
	private String writer;
	private Date regDate;
	private int viewCnt;
	
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContetn() {
		return contetn;
	}
	public void setContetn(String contetn) {
		this.contetn = contetn;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	

}
