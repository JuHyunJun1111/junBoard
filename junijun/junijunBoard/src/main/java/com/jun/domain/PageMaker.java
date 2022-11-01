package com.jun.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	
	private int totalCount; //총갯수
	private int startPage; //시작번호	
	private int endPage; // 끝번호
	private boolean prev; //이전페이지
	private boolean next; //다음페이지
	
	private int displayPageNum = 10;
	
	private Criteria cri;
	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	private void calcData() {
		endPage = (int) (Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double)cri.getPerPageNum()));
		  if (endPage > tempEndPage) {
			  endPage = tempEndPage;
		  }
		  prev = startPage == 1 ? false : true;
		  next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
	}
	
	public String makeQuery(int page) {
		UriComponents UriComponents = UriComponentsBuilder
				.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.build();
		return UriComponents.toUriString();
	}
	
	public String makeSearch(int page) {
		 UriComponents uriComponents =
		            UriComponentsBuilder.newInstance()
		            .queryParam("page", page)
		            .queryParam("perPageNum", cri.getPerPageNum())
		            .queryParam("searchType", ((SearchCriteria)cri).getSearchType())
		            .queryParam("keyword", encoding(((SearchCriteria)cri).getKeyword()))
		            .build(); 
		 return uriComponents.toUriString();  
	}

	private String encoding(String keyword) {
		if(keyword == null || keyword.trim().length() == 0) {
			return ""; 
		}
		try {
			return URLEncoder.encode(keyword, "UTF-8");
	  } catch(UnsupportedEncodingException e) {
		  return ""; 
		  }
	}
	
	
	

}
