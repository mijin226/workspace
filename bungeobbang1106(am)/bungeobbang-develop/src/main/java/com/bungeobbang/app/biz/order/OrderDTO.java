package com.bungeobbang.app.biz.order;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDTO {
	private int orderNum; 	//주문번호
	private String orderAddress;	//배송주소
	private Date orderDate;	//주문 날짜
	private String adminChecked; //관리자 확인

	private int memberNum;	//회원번호(외래키)
	private String memberName; //회원 이름
	
	private int orderDetailNum;	//주문 상세 정보
	private int orderQuantity;	//상품 수량

	private int productNum;	//상품 번호(외래키)
	private String productName; //상품 이름
	private int productPrice; // 상품 가격

	private int totalPrice; // 총가격
	
	private String condition;
	private String desc; // 내림차순 정렬

}
