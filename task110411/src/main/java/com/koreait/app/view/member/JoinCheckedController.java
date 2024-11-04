package com.koreait.app.view.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.app.biz.member.MemberDTO;
import com.koreait.app.biz.member.MemberService;

@RestController("joinChecked")
public class JoinCheckedController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/checkedMID.do", method = RequestMethod.POST)
	public @ResponseBody String checkedMID(MemberDTO memberDTO) {
		memberDTO.setMid(memberDTO.getMid());
		System.out.println("JoinCheckedController checkedMID.do method memberDTO getMid ["+ memberDTO.getMid() +"]");
		memberDTO.setCondition("SELECTONE_DOUBLEMID");
		System.out.println("JoinCheckedController checkedMID.do method memberDTO getCondition ["+ memberDTO.getCondition() +"]");
		
		memberDTO = memberService.selectOne(memberDTO);
		System.out.println("memberDTO ["+ memberDTO +"]");

		String resultMID = "false";// 데이터가 null 없다면 == 가능아이디
		if (memberDTO != null) {// 데이터가 들어가 있다면 == 중복아이디
			resultMID = "true";
		}System.out.println("return resultMID : " + resultMID);
		return resultMID;
	}
	@RequestMapping(value = "/checkedPW.do", method = RequestMethod.POST)
	public @ResponseBody String checkedPW(MemberDTO memberDTO) {
		//사용자 입력 비밀번호 가져오기
		memberDTO.setPassword(memberDTO.getPassword());
		System.out.println("JoinCheckedController checkedPW.do method memberDTO getPassword ["+ memberDTO.getPassword() +"]");
		
		//사용자 입력 일치여부용 비밀번호 가져오기
		memberDTO.setDoublePassword(memberDTO.getDoublePassword());
		System.out.println("JoinCheckedController checkedPW.do method memberDTO getDoublePassword ["+ memberDTO.getDoublePassword() +"]");
		
		String resultPW = "true";//만약에 두 비밀번호가 서로 같다면 == true
		
		if(!(memberDTO.getPassword().equals(memberDTO.getDoublePassword()))){//두 비밀번호가 서로 다르다면 == false
			resultPW = "false";
		}System.out.println("return resultPW : " + resultPW);
		return resultPW;
	}
}
