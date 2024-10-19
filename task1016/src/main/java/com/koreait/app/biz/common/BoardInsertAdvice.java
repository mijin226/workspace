package com.koreait.app.biz.common;
public class BoardInsertAdvice {
	//비즈니스 메서드 실행 후, 완료 나타내는 어드바이스
	public void printLog() {
		System.out.println(" 게시물이 작성되었습니다. ");
	}
}

