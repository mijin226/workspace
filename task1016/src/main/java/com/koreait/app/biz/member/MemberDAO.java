package com.koreait.app.biz.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.app.biz.common.JDBCUtil;

@Repository
public class MemberDAO {
	private final String SELECTONE_DOUBLEMID = "SELECT MID FROM MEMBER WHERE MID=?";
	private final String SELECTONE_LOGIN = "SELECT MID FROM MEMBER WHERE MID=? AND PASSWORD=?";
	private final String INSERT = "INSERT INTO MEMBER(MID, PASSWORD, NAME) VALUES (?, ?, ?);";
	
	public List<MemberDTO> selectAll(MemberDTO memberDTO) {
		return null;
	}
	public MemberDTO selectOne(MemberDTO memberDTO) {
		
		//[1] DB 연결 객체를 conn. 변수로 선언: JDBC 연결 관리하는 JDBCUtil 클래스에서 DB연결 설정 메서드 실행.
		Connection conn=JDBCUtil.connect();
		
		//[2] SQL 쿼리 미리 컴파일하는 객체 PreparedStatement를 참조하는 pstmt 변수 선언 및 초기화
		PreparedStatement pstmt = null;
		
		//변수명 상단 기재(초기화)
		MemberDTO data=null;

		try {
			//아이디 중복검사 : 인자값 아이디 들어오면 아이디값 유무에 따라 아웃풋 반환
			if(memberDTO.getCondition().equals("SELECTONE_DOUBLEMID")) {
				pstmt = conn.prepareStatement(SELECTONE_DOUBLEMID);
				pstmt.setString(1, memberDTO.getMid());
				
			//아이디 비밀번호 인자값으로 들어오면 아웃풋으로 아이디 반환
			}else if(memberDTO.getCondition().equals("SELECTONE_LOGIN")) {
				pstmt = conn.prepareStatement(SELECTONE_LOGIN);
				pstmt.setString(1, memberDTO.getMid());
				pstmt.setString(2, memberDTO.getPassword());
			}
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemberDTO();
				data.setMid(rs.getString("MID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return  data;
	}
	public boolean insert(MemberDTO memberDTO) {
		//[1] DB 연결 객체를 conn 변수로 선언: JDBC 연결 관리하는 JDBCUtil 클래스에서 DB연결 설정 메서드 실행.
		Connection conn = JDBCUtil.connect();
		
		//[2] SQL 쿼리 미리 컴파일하는 객체 PreparedStatement를 참조하는 pstmt 변수 선언 및 초기화
		PreparedStatement pstmt = null;
		
		// 비정상 프로그램 종료 방지 위한 try-catch 진행
		try { 
			//[3] pstmt 변수 선언 : () 안 쿼리문으로 실행 준비 완료.
			//SQL DB와 연결하여 INSERT 변수값 미리 컴파일, 실행 준비
			pstmt = conn.prepareStatement(INSERT);
			
			//[4] 인자값으로 받은 데이터 쿼리문에 삽입
			pstmt.setString(1, memberDTO.getMid()); 	
			pstmt.setString(2, memberDTO.getPassword()); 	
			pstmt.setString(3, memberDTO.getName()); 	
			
			//[5] rs 변수 선언 : INSERT 쿼리문 실행
			int rs = pstmt.executeUpdate(); 
			
			//[6] 예외처리 : 정상실행 되지 않았을 경우, false
			if(rs<=0) {
				return false;
			}
		} catch (Exception e) {
			System.err.println(" MemberDAO INSERT Exception fail ");
			return false;
		}
		return true;
	}
	public boolean update(MemberDTO memberDTO) {
		return false;
	}
	public boolean delete(MemberDTO memberDTO) {
		return false;
	}
}
