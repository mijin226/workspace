package com.koreait.app.view.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.app.biz.member.MemberDTO;
import com.koreait.app.biz.member.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller("login")
public class LoginController {
	@Autowired
	private MemberService memberService;

	// V로 이동할 경우 데이터 전달
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	// C에게 가야하는 경우, 데이터 없음.
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpSession session, MemberDTO memberDTO, Model model) {

		// 특정회원 정보 물러오기
		memberDTO.setCondition("SELECTONE_LOGIN");
		memberDTO = memberService.selectOne(memberDTO);
		String viewName = "redirect:login.do";
		if (memberDTO != null) {// 값이 들어있다면=>회원확인 완료
			session.setAttribute("userID", memberDTO.getMid());
			viewName = "redirect:main.do";
		}
		return viewName;// 값이 들어있지 않다면 로그인 창 다시 되돌아감.
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("userID");
		return "redirect:login.do";
	}
}
