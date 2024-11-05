package com.bungeobbang.app.biz.store;

import java.util.ArrayList;import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.bungeobbang.app.biz.storeWork.StoreWorkDTO;


@Repository
public class StoreDTO {
	private int storeNum; // 가게 고유번호(PK)	
	private String storeName; // 가게 상호명
	private String storeAddress; // 가게 기본주소
	private String storeAddressDetail; // 가게 상세주소
	private String storeContact; // 가게 전화번호
	private String storeClosed; // 폐점여부(Y/N)
	private String storeSecret; // 공개여부
	
	// 폐점한 가게 수
	private int storeClosedCnt;
	
	private int maxPK;
	
	//필터 검색을 위한 DTO
	private HashMap<String, String> filterList; //필터검색용 <검색구분용, 검색값>	
	private String storeDeclared; // 신고 여부
	
	private String storeMenuNormal;
	private String storeMenuVeg;
	private String storeMenuMini;
	private String storeMenuPotato;
	private String storeMenuIce;
	private String storeMenuCheese;
	private String storeMenuPastry;
	private String storeMenuOther;
	private String storePaymentCashMoney;
	private String storePaymentCard;
	private String storePaymentAccount;
	

	private String condition; // 
	private int startNum; // 시작 페이지
	private int endNum; // 종료 페이지
	private int cnt; //페이지 네이션 개수 반환용

	//영업일 정보
	private ArrayList<StoreWorkDTO> workList;

	public int getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreAddressDetail() {
		return storeAddressDetail;
	}

	public void setStoreAddressDetail(String storeAddressDetail) {
		this.storeAddressDetail = storeAddressDetail;
	}

	public String getStoreContact() {
		return storeContact;
	}

	public void setStoreContact(String storeContact) {
		this.storeContact = storeContact;
	}

	public String getStoreClosed() {
		return storeClosed;
	}

	public void setStoreClosed(String storeClosed) {
		this.storeClosed = storeClosed;
	}

	public String getStoreSecret() {
		return storeSecret;
	}

	public void setStoreSecret(String storeSecret) {
		this.storeSecret = storeSecret;
	}

	public int getStoreClosedCnt() {
		return storeClosedCnt;
	}

	public void setStoreClosedCnt(int storeClosedCnt) {
		this.storeClosedCnt = storeClosedCnt;
	}

	public int getMaxPK() {
		return maxPK;
	}

	public void setMaxPK(int maxPK) {
		this.maxPK = maxPK;
	}

	public HashMap<String, String> getFilterList() {
		return filterList;
	}

	public void setFilterList(HashMap<String, String> filterList) {
		this.filterList = filterList;
	}

	public String getStoreDeclared() {
		return storeDeclared;
	}

	public void setStoreDeclared(String storeDeclared) {
		this.storeDeclared = storeDeclared;
	}

	public String getStoreMenuNormal() {
		return storeMenuNormal;
	}

	public void setStoreMenuNormal(String storeMenuNormal) {
		this.storeMenuNormal = storeMenuNormal;
	}

	public String getStoreMenuVeg() {
		return storeMenuVeg;
	}

	public void setStoreMenuVeg(String storeMenuVeg) {
		this.storeMenuVeg = storeMenuVeg;
	}

	public String getStoreMenuMini() {
		return storeMenuMini;
	}

	public void setStoreMenuMini(String storeMenuMini) {
		this.storeMenuMini = storeMenuMini;
	}

	public String getStoreMenuPotato() {
		return storeMenuPotato;
	}

	public void setStoreMenuPotato(String storeMenuPotato) {
		this.storeMenuPotato = storeMenuPotato;
	}

	public String getStoreMenuIce() {
		return storeMenuIce;
	}

	public void setStoreMenuIce(String storeMenuIce) {
		this.storeMenuIce = storeMenuIce;
	}

	public String getStoreMenuCheese() {
		return storeMenuCheese;
	}

	public void setStoreMenuCheese(String storeMenuCheese) {
		this.storeMenuCheese = storeMenuCheese;
	}

	public String getStoreMenuPastry() {
		return storeMenuPastry;
	}

	public void setStoreMenuPastry(String storeMenuPastry) {
		this.storeMenuPastry = storeMenuPastry;
	}

	public String getStoreMenuOther() {
		return storeMenuOther;
	}

	public void setStoreMenuOther(String storeMenuOther) {
		this.storeMenuOther = storeMenuOther;
	}

	public String getStorePaymentCashMoney() {
		return storePaymentCashMoney;
	}

	public void setStorePaymentCashMoney(String storePaymentCashMoney) {
		this.storePaymentCashMoney = storePaymentCashMoney;
	}

	public String getStorePaymentCard() {
		return storePaymentCard;
	}

	public void setStorePaymentCard(String storePaymentCard) {
		this.storePaymentCard = storePaymentCard;
	}

	public String getStorePaymentAccount() {
		return storePaymentAccount;
	}

	public void setStorePaymentAccount(String storePaymentAccount) {
		this.storePaymentAccount = storePaymentAccount;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public ArrayList<StoreWorkDTO> getWorkList() {
		return workList;
	}

	public void setWorkList(ArrayList<StoreWorkDTO> workList) {
		this.workList = workList;
	}

	@Override
	public String toString() {
		return "StoreDTO [storeNum=" + storeNum + ", storeName=" + storeName + ", storeAddress=" + storeAddress
				+ ", storeAddressDetail=" + storeAddressDetail + ", storeContact=" + storeContact + ", storeClosed="
				+ storeClosed + ", storeSecret=" + storeSecret + ", storeClosedCnt=" + storeClosedCnt + ", maxPK="
				+ maxPK + ", filterList=" + filterList + ", storeDeclared=" + storeDeclared + ", storeMenuNormal="
				+ storeMenuNormal + ", storeMenuVeg=" + storeMenuVeg + ", storeMenuMini=" + storeMenuMini
				+ ", storeMenuPotato=" + storeMenuPotato + ", storeMenuIce=" + storeMenuIce + ", storeMenuCheese="
				+ storeMenuCheese + ", storeMenuPastry=" + storeMenuPastry + ", storeMenuOther=" + storeMenuOther
				+ ", storePaymentCashMoney=" + storePaymentCashMoney + ", storePaymentCard=" + storePaymentCard
				+ ", storePaymentAccount=" + storePaymentAccount + ", condition=" + condition + ", startNum=" + startNum
				+ ", endNum=" + endNum + ", cnt=" + cnt + ", workList=" + workList + "]";
	}
	
}