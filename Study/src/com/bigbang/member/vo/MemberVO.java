package com.bigbang.member.vo;

public class MemberVO {
	String name;
	String id;
	String pw;
	String phone1;
	String phone2;
	String phone3;
	String gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "[이름 : " + name + ", 아이디 : " + id + ", 비밀번호 :" + pw + ", 전화번호 : " + phone1 + phone2
				+ phone3 + ", 성별" + gender + "]";
	}
	
	
	
}
