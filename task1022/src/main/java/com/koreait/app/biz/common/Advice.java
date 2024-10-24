package com.koreait.app.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
public class Advice {
	@Pointcut("execution(* com.koreait.app.biz..*Impl.selectOne(..))")
	public void bPointcut() {// 참조 메서드
	}
//	@Pointcut("execution(* com.koreait.app.biz..*Impl.*(..))")
//	   public void aPointcut() {} // 참조 메서드

//서비스 기능에 아웃풋이 배열일 때 아무 작동 X 반환값이 DTO일 때 어떤 DTO인지 로그 찍기!!
//Read 진행 후에 작동!selectOne에만 반응. => 아이디 중복확인, 로그인 시 활용됨!
//CUD 진행 전 DB 접근 발생! CUD 진행 후 DB 변경 완료!
	@Pointcut("execution(* com.koreait.app.biz..*Impl.insert(..))")
	public void cPointcut() {// 참조 메서드
	}
}