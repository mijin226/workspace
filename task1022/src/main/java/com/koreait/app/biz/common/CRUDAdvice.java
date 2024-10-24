package com.koreait.app.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class CRUDAdvice {
//	@AfterReturning("Advice.aPointcut()")
//	public void print(JoinPoint jp) { // 바인드 변수
//		System.out.println("==print");
//		String methodName = jp.getSignature().getName();
//		System.out.println("   print methodName :" + methodName);
//	}

	// 어떤 클래스일지 모르지만 DAO에서 실행될 거고, SELECTONE이 실행되므로 아래와 같이 기재
	@AfterReturning(pointcut = "Advice.bPointcut()", returning = "returnObj")
	public void aPointcut(JoinPoint jp, Object returnObj) {
		// 메서드명 추출
		String methodName = jp.getSignature().getName();
		System.out.println("SLECTONE 후 메서드명 : " + methodName);

		// 반환값이 null이 아니고 배열이 아닐 때 DTO의 클래스 이름 출력
		if (returnObj != null) {
			System.out.println("반환된 DTO: " + returnObj.getClass().getSimpleName());
		} else {
			System.out.println("반환값이 null입니다.");
		}
	}
	@AfterReturning(pointcut = "Advice.cPointcut()", returning = "returnObj")
	public void cPointcut(JoinPoint jp, Object returnObj) {
		// 메서드명 추출
		String methodName = jp.getSignature().getName();
		System.out.print("INSERT 후 메서드명 : " + methodName);
	}
}
