package com.bungeobbang.app.view.memberController;

import com.bungeobbang.app.biz.member.MemberDTO;
import com.bungeobbang.app.biz.member.MemberService;
import com.bungeobbang.app.biz.point.PointDTO;
import com.bungeobbang.app.biz.point.PointService;
import com.bungeobbang.app.biz.point.PointServiceImpl;
import com.bungeobbang.app.view.util.FileUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
public class MypageController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private PointService pointService;

	private final String FAIL_DO = "redirect:failInfo.do"; //기본 실패 처리

	private final String DEFAULT_IMG = "default_profile.png";//기본 이미지

	//page
	private final String PAGE_MYPAGE = "mypage"; //마이페이지
	private final String PAGE_MYPAGE_UPDATE = "mypageUpdate"; //개인정보 수정

	//session
	private final String SESSION_ROLE = "userRole";
	private final String SESSION_PK = "userPk";
	private final String SESSION_NICKNAME = "userNickname";
	private final String SESSION_PROFILE = "userProfile";
	private final String SESSION_POINT = "userPoint";

	@GetMapping("/infoMypage.do")
	public String infoMypage(HttpSession session, Model model) {
		log.info("log: /infoMypage.do infoMypage - start");
		MemberDTO memberDTO = new MemberDTO(); //빈 객체 생성
		memberDTO.setMemberNum((int)session.getAttribute(SESSION_PK)); //세션값 저장
		memberDTO.setCondition("INFO_CONDITION");
		//세션(로그인 중인 사용자) 정보 호출
		memberDTO = memberService.selectOne(memberDTO);

		//데이터 전달
		model.addAttribute("member", memberDTO); //반환
		//확인
		log.info("log: infoMypage - send member : [{}]", memberDTO);
		log.info("log: /infoMypage.do infoMypage - end");
		return PAGE_MYPAGE;
	}

	@GetMapping("/updateMypage.do") // 마이페이지에서 회원정보 수정 페이지로 이동할 때 데이터 전송 로직
	public String ProfileChange(HttpSession session, MemberDTO memberDTO, Model model) {
		log.info("[UpdateMypage] 시작");
		// 회원 번호(PK) 가져오기
		int memberPK = (int) session.getAttribute(SESSION_PK);

		memberDTO.setCondition("INFO_CONDITION");
		memberDTO.setMemberNum(memberPK);
		log.info("[UpdateMypage View에서 전달 받은 값] : {}", memberDTO);
		memberDTO = memberService.selectOne(memberDTO);
		if (memberDTO == null) {
			return FAIL_DO;
		}
		model.addAttribute("memberDTO", memberDTO);
		log.info("log: updateMypage - send member : [{}]", memberDTO);
		log.info("log: /updateMypage.do infoMypage - end");
		return PAGE_MYPAGE_UPDATE;
	}

	@PostMapping(value = "/updateMypage.do") // 회원 정보 변경 후 DB에 변경된 데이터 저장 해주는 controller
	public String updateProfile(HttpSession session, HttpServletRequest request, MemberDTO memberDTO) {
		log.info("[UpdateProfile] 시작");
		log.info("[UpdateProfile View에서 전달 받은 값] : {}", memberDTO);
		memberDTO.setMemberNum((int)session.getAttribute(SESSION_PK));

		MultipartFile file = memberDTO.getFile();
		memberDTO.setCondition("PROFILE_WAY_CONDITION");
		String profilePicPath = memberService.selectOne(memberDTO).getMemberProfileWay(); //가지고 있던 이미지 정보
		//변경할 파일이 있다면
		if(file != null && !file.isEmpty()) {
			// 프로필 사진 업로드 처리
			String path = "uploads/"; // 업로드할 경로
			String fileName = FileUtil.createFileName(); // 파일 이름 생성

			//파일 저장
			profilePicPath = FileUtil.insertFile(request.getServletContext(), path, memberDTO.getFile(), fileName); //새 이미지로 변경
			log.info("[UpdateProfile 새로 생성한 프로필 이미지 이름] : {}", profilePicPath);
		}
		memberDTO.setCondition("UPDATE_CONDITION");//업데이트 컨디션으로 변경
		memberDTO.setMemberProfileWay(profilePicPath); //DB에 저장하기 위해 저장한 파일명 세팅

		//비밀번호를 제외한 업데이트 진행
		if(!memberService.update(memberDTO)) {
			log.error("log: updateMypage - normal update error");
			return FAIL_DO; //기본 실패처리로 진행
		}
		log.info("log: updateMypage - normal update success");

		//비밀번호 업데이트
		if(!memberDTO.getMemberPassword().isEmpty()){ //view에서 검증, input값이 넘어오기 때문에 null일 경우 없음
			log.info("log: updateMypage - password update progress");
			//비밀번호 업데이트도 진행된다면
			memberDTO.setCondition("UPDATE_PASSWORD_CONDTION");
			if(!memberService.update(memberDTO)){
				//비밀번호 업데이트 실패 시
				log.error("log: updateMypage - password update error");
				return FAIL_DO; //기본 실패처리로 진행
			}
			log.info("log: updateMypage - password update success");
		}
		//변경될 수 있는 회원 정보 세션 업데이트 진행
		session.setAttribute(SESSION_NICKNAME, memberDTO.getMemberNickname());
		session.setAttribute(SESSION_PK, memberDTO.getMemberNum());
		session.setAttribute(SESSION_PROFILE, memberDTO.getMemberProfileWay());
		//포인트 갱신//////////////////////////////////////////////////////////////////////////////////
		PointDTO pointDTO = new PointDTO();
		pointDTO.setMemberNum(memberDTO.getMemberNum());
		pointDTO.setCondition("SELECTONE_MEMBER_POINT");
		pointDTO = pointService.selectOne(pointDTO);
		session.setAttribute(SESSION_POINT, pointDTO.getTotalMemberPoint());
		log.info("log: pointDTO [{}], point [{}]", pointDTO, pointDTO.getTotalMemberPoint());
		//////////////////////////////////////////////////////////////////////////////////////////////
		//마이페이지로 이동
		return "redirect:infoMypage.do";
	}
}
