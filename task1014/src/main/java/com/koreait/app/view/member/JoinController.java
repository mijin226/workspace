package com.koreait.app.view.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.app.biz.member.MemberDAO;
import com.koreait.app.biz.member.MemberDTO;
import com.koreait.app.biz.member.MemberService;

@Controller("join")
public class JoinController {
	
	MemberDAO memberDAO;
	
	@Autowired
	private MemberService memberService;
	
	//V로 이동할 경우 데이터 전달
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		return "join";
	}
	//C에게 가야하는 경우, 전달데이터 없음.
	@RequestMapping(value="/joinInsert.do", method=RequestMethod.POST)
	public String join(MemberDTO memberDTO) {
		
		//회원정보 등록하기
		boolean flag = memberService.insert(memberDTO);
		if(flag) {//회원정보 등록 성공시,
			System.out.println("[회원등록되었습니다.]");
			return "redirect:login.do";	//회원등록되면 로그인 페이지로
		}else{
			System.out.println("[회원등록에 실패했습니다.]");
		}return "redirect:main.do"; //메인 페이지로
	}	
}
