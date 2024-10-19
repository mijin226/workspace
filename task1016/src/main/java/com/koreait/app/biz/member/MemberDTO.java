package com.koreait.app.biz.member;

public class MemberDTO {
	private String mid;		//회원 아이디	
	private String password;//회원 비밀번호
	private String doublePassword;
	private String name;	//회원명
	private String role;	//회원 권한
	private String condition;
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public String getDoublePassword() {
		return doublePassword;
	}
	public void setDoublePassword(String doublePassword) {
		this.doublePassword = doublePassword;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "MemberDTO [mid=" + mid + ", password=" + password + ", doublePassword=" + doublePassword + ", name="
				+ name + ", role=" + role + ", condition=" + condition + "]";
	}
}
