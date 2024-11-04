package com.koreait.app.biz.board;

public class BoardDTO {
	private int bid;			//아이디
	private String content;		//내용
	private String writer;		//작성자
	private String condition; 	//상태변수
	private String searchContent;//검색키워드
	
	
	public int getBid() {
		return bid;
	}
	public String getSearchContent() {
		return searchContent;
	}
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	@Override
	public String toString() {
		return "BoardDTO [bid=" + bid + ", content=" + content + ", writer=" + writer + ", condition=" + condition
				+ ", searchContent=" + searchContent + "]";
	}	
}
