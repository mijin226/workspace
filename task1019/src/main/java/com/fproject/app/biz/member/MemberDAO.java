package com.fproject.app.biz.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	// INSERT 쿼리
	private final String INSERT = "INSERT INTO BB_MEMBER(MEMBER_EMAIL, MEMBER_PASSWORD, MEMBER_NAME, MEMBER_PHONE, MEMBER_NICKNAME, MEMBER_PROFILE_WAY) "
			+ "VALUES(?, ?, ?, ?, ?, ?)";

	// UPDATE 쿼리들
	private final String UPDATE = "UPDATE BB_MEMBER SET MEMBER_EMAIL = ?, MEMBER_NAME = ?, MEMBER_PHONE = ?, MEMBER_NICKNAME = ?, MEMBER_PROFILE_WAY = ? WHERE MEMBER_NUM = ?";
	private final String UPDATE_PASSWORD = "UPDATE BB_MEMBER SET MEMBER_PASSWORD = ? WHERE MEMBER_NUM = ?";

	// DELETE 쿼리
	private final String DELETE = "DELETE FROM BB_MEMBER WHERE MEMBER_NUM = ?";

	// SELECTONE 쿼리들
	private final String SELECTONE_EMAIL = "SELECT MEMBER_EMAIL FROM BB_MEMBER WHERE MEMBER_EMAIL = ?";
	private final String SELECTONE_NICKNAME = "SELECT MEMBER_NICKNAME FROM BB_MEMBER WHERE MEMBER_NICKNAME = ?";
	private final String SELECTONE_PASSWORD_RESET = "SELECT MEMBER_NUM FROM BB_MEMBER WHERE MEMBER_EMAIL = ? AND MEMBER_NAME = ?";
	private final String SELECTONE_LOGIN = "SELECT MEMBER_NUM, MEMBER_EMAIL, MEMBER_NICKNAME, MEMBER_ROLE FROM BB_MEMBER WHERE MEMBER_EMAIL = ? AND MEMBER_PASSWORD = ?";
	private final String SELECTONE_INFO = "SELECT MEMBER_NUM, MEMBER_EMAIL, MEMBER_NAME, MEMBER_PHONE, MEMBER_NICKNAME, MEMBER_PROFILE_WAY, MEMBER_ROLE, MEMBER_HIREDAY FROM BB_MEMBER WHERE MEMBER_NUM = ?";
	private final String SELECTONE_PASSWORD_CHECK = "SELECT MEMBER_NUM FROM BB_MEMBER WHERE MEMBER_NUM = ? AND MEMBER_PASSWORD = ?";
	private final String SELECTONE_PROFILE = "SELECT MEMBER_PROFILE_WAY FROM BB_MEMBER WHERE MEMBER_NUM = ?";

	// 컨디션
	// selectOne
	private final String EMAIL_CONDITION = "EMAIL_SELECTONE";
	private final String NICKNAME_CONDITION = "NICKNAME_SELECTONE";
	private final String PASSWORD_RESET_CONDITION = "EMAIL_NAME_SELECTONE";
	private final String LOGIN_CONDITON = "LOGIN_SELECTONE";
	private final String INFO_CONDITION = "MEMBER_INFO_SELECTONE";
	private final String PASSWORD_CHECK_CONDITION = "PASSWORD_CHECK_SELECTONE";
	private final String PROFILE_WAY_CONDITION = "PROFILEWAY_SELECTONE";

	// update
	private final String UPDATE_CONDITION = "UPDATE";
	private final String UPDATE_PASSWORD_CONDTION = "PASSWORD_UPDATE";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insert(MemberDTO memberDTO) throws DataAccessException {
		System.out.println("log: Member insert start");
		// INSERT 쿼리문 실행 결과 result 변수로 선언
		try {// 인풋값: 이메일, 비밀번호, 이름, 전화번호, 닉네임, 프로필사진경로, 권한
			int result = jdbcTemplate.update(INSERT, memberDTO.getMemberEmail(), memberDTO.getMemberPassword(),
					memberDTO.getMemberName(), memberDTO.getMemberPhone(), memberDTO.getMemberNickname(),
					memberDTO.getMemberProfileWay());

			// insert가 정상 작동되지 못했다면 false
			if (result <= 0) {
				System.err.println("log: Member insert execute fail");
				return false;
			}
		} catch (DataAccessException e) {
			System.err.println("log: Member insert Exception fail");
			e.printStackTrace();
			return false;
		} // insert 잘 진행되었다면 true
		return true;
	}

	public boolean update(MemberDTO memberDTO) {
		System.out.println("log: Member update start");

		int result = 0;
		// UPDATE 쿼리문 실행 결과 result 변수로 선언
		try {
			if (memberDTO.getCondition().equals(UPDATE_CONDITION)) {
				// 개인정보수정(비밀번호 제외)
				// 인풋값 : 이메일, 이름, 전화번호, 닉네임, 프로필사진경로, 고유번호
				System.out.println("log: Member update start: UPDATE");
				result = jdbcTemplate.update(UPDATE, memberDTO.getMemberEmail(), memberDTO.getMemberName(), 
						memberDTO.getMemberPhone(), memberDTO.getMemberNickname(),
						memberDTO.getMemberProfileWay(), memberDTO.getMemberNum());
				System.out.println("log: Member update complete : UPDATE");

			} else if (memberDTO.getCondition().equals(UPDATE_PASSWORD_CONDTION)) {
				// 비밀번호 수정
				// 인풋값: 비밀번호, 고유번호
				System.out.println("log: Member update start : UPDATE_PASSWORD");
				result = jdbcTemplate.update(UPDATE_PASSWORD, memberDTO.getMemberPassword(), memberDTO.getMemberNum());
				System.out.println("log: Member update complete : UPDATE_PASSWORD");

			} else {// 컨디션값 오류
				System.err.println("log: Member update condition fail");
			}

			// update가 정상 작동되지 못했다면 false
			if (result <= 0) {
				System.err.println("log: Member update execute fail");
				return false;
			}
		} catch (DataAccessException e) {
			System.err.println("log: Member update Exception fail");
			e.printStackTrace();
			return false;
		} // update 잘 진행되었다면 true
		return true;
	}

	public boolean delete(MemberDTO memberDTO) {
		System.out.println("log: Member delete start");

		try {
			// 개인정보 삭제 / 인풋값: 고유번호
			int result = jdbcTemplate.update(DELETE, memberDTO.getMemberNum());

			// delete가 정상 작동되지 못했다면 false
			if (result <= 0) {
				System.err.println("log: Member delete execute fail");
				return false;
			}
		} catch (DataAccessException e) {
			System.err.println("log: Member delete Exception fail");
			e.printStackTrace();
			return false;
		} // delete 잘 진행되었다면 true
		return true;
	}

	private ArrayList<MemberDTO> selectAll(MemberDTO memberDTO) {
		System.out.println("log: Member selectAll");
		return null;
	}

	public MemberDTO selectOne(MemberDTO memberDTO) {
		System.out.println("log: Member selectOne start");

		MemberDTO data = null;
		
		try {
			if (memberDTO.getCondition().equals(EMAIL_CONDITION)) {
				// 이메일 중복조회
				System.out.println("log: Member selectOne : SELECTONE_EMAIL : " + memberDTO.getMemberEmail());
				// 인풋값 : 이메일
				Object[] args = {memberDTO.getMemberEmail()};
				// 반환값 : 이메일
				return jdbcTemplate.queryForObject(SELECTONE_EMAIL, args, new EmailMemberRowMapper()); 
			
			} else if (memberDTO.getCondition().equals(NICKNAME_CONDITION)) {
				// 닉네임 조회
				System.out.println("log: Member selectOne : SELECTONE_NICKNAME : " + memberDTO.getMemberNickname());
				// 인풋값 : 닉네임
				Object[] args = {memberDTO.getMemberNickname()};
				// 반환값 : 닉네임
				return jdbcTemplate.queryForObject(SELECTONE_NICKNAME, args, new NicknameMemberRowMapper()); 
			
			} else if (memberDTO.getCondition().equals(PASSWORD_RESET_CONDITION)) {
				// 비밀번호 조회
				System.out.println("log: Member selectOne : SELECTONE_PASSWORD_RESET EMAIL :" + memberDTO.getMemberEmail());
				System.out.println("log: Member selectOne : SELECTONE_PASSWORD_RESET NAME : " + memberDTO.getMemberName());
				// 인풋값 : 이메일, 이름
				Object[] args = {memberDTO.getMemberEmail(), memberDTO.getMemberName()};
				// 반환값 : 고유번호
				return jdbcTemplate.queryForObject(SELECTONE_PASSWORD_RESET, args, new PasswordResetMemberRowMapper()); 

			} else if (memberDTO.getCondition().equals(LOGIN_CONDITON)) {
				// 로그인
				System.out.println("log: Member selectOne : SELECTONE_LOGIN EMAIL : " + memberDTO.getMemberEmail());
				System.out.println("log: Member selectOne : SELECTONE_LOGIN PASSWORD : " + memberDTO.getMemberPassword());
				// 인풋값 : 이메일, 비밀번호
				Object[] args = {memberDTO.getMemberEmail(), memberDTO.getMemberPassword()};
				// 반환값 : 고유번호, 이메일, 닉네임, 권한
				return jdbcTemplate.queryForObject(SELECTONE_LOGIN, args, new LoginMemberRowMapper()); 
							
			} else if (memberDTO.getCondition().equals(INFO_CONDITION)) {
				// 회원정보
				System.out.println("log: Member selectOne : SELECTONE_INFO NUM : " + memberDTO.getMemberNum());
				// 인풋값 : 고유번호
				Object[] args = {memberDTO.getMemberNum()};
				// 반환값 : 고유번호, 이메일, 이름, 전화번호, 닉네임, 사진경로, 권한, 가입일자
				return jdbcTemplate.queryForObject(SELECTONE_INFO, args, new InfoMemberRowMapper());
			
			} else if (memberDTO.getCondition().equals(PASSWORD_CHECK_CONDITION)) {
				// 패스워드 확인
				System.out.println("log: Member selectOne : SELECTONE_PASSWORD_CHECK NUM: " + memberDTO.getMemberNum());
				System.out.println("log: Member selectOne : SELECTONE_PASSWORD_CHECK PASSWORD: " + memberDTO.getMemberPassword());
				// 인풋값 : 고유번호, 비밀번호
				Object[] args = {memberDTO.getMemberNum(), memberDTO.getMemberPassword()};
				// 반환값 : 고유번호
				return jdbcTemplate.queryForObject(SELECTONE_PASSWORD_CHECK, args, new PasswordCheckMemberRowMapper());
								
			} else if (memberDTO.getCondition().equals(PROFILE_WAY_CONDITION)) {
				// 프로필이미지경로
				System.out.println("log: Member selectOne : SELECTONE_PROFILE NUM: " + memberDTO.getMemberNum());
				// 인풋값 : 고유번호
				Object[] args = {memberDTO.getMemberNum()};
				// 반환값 : 사진경로
				return jdbcTemplate.queryForObject(SELECTONE_PROFILE, args, new PasswordCheckMemberRowMapper());
				
			} else {// 컨디션값 오류
				System.err.println("log: Member selectOne condition fail");
			}
		}catch(DataAccessException e) {
			System.err.println("log: Member selectOne Exception fail");
			e.printStackTrace();
		}System.out.println("log: Member selectOne return data");
		return data;//정상 실행되지 못할 경우 null반환
	}
}
// 이메일 중복조회
class EmailMemberRowMapper implements RowMapper<MemberDTO> {
	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("MemberDTO selectOne mapRow() Email start");
		MemberDTO data = new MemberDTO();
		data.setMemberEmail(rs.getString("MEMBER_EMAIL")); 				// 이메일
		System.out.println("MemberDTO selectOne mapRow() Email end");
		return data;
	}
}

// 닉네임 중복조회
class NicknameMemberRowMapper implements RowMapper<MemberDTO> {
	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("MemberDTO selectOne mapRow() Nickname start");
		MemberDTO data = new MemberDTO();
		data.setMemberNickname(rs.getString("MEMBER_NICKNAME"));		//닉네임
		System.out.println("MemberDTO selectOne mapRow() Nickname end");
		return data;
	}
}


//비밀번호 리셋 조회
class PasswordResetMemberRowMapper implements RowMapper<MemberDTO> {
	@Override
    public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("MemberDTO selectOne mapRow() PasswordReset start");
		MemberDTO data = new MemberDTO();
        data.setMemberNum(rs.getInt("MEMBER_NUM")); 					// 멤버 번호
		System.out.println("MemberDTO selectOne mapRow() PasswordReset end");
        return data;
    }
}
//로그인 조회
class LoginMemberRowMapper implements RowMapper<MemberDTO> {
    @Override
    public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("MemberDTO selectOne mapRow() Login start");
        MemberDTO data = new MemberDTO();
        data.setMemberNum(rs.getInt("MEMBER_NUM")); 					// 멤버 번호
        data.setMemberEmail(rs.getString("MEMBER_EMAIL")); 				// 이메일
        data.setMemberNickname(rs.getString("MEMBER_NICKNAME")); 		// 닉네임
        data.setMemberRole(rs.getString("MEMBER_ROLE")); 				// 권한
		System.out.println("MemberDTO selectOne mapRow() Login end");
        return data;
    }
}
//특정 회원 조회
class InfoMemberRowMapper implements RowMapper<MemberDTO> {
    @Override
    public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("MemberDTO selectOne mapRow() InfoMember start");
        MemberDTO data = new MemberDTO();
        data.setMemberNum(rs.getInt("MEMBER_NUM")); 					// 멤버 번호
        data.setMemberEmail(rs.getString("MEMBER_EMAIL")); 				// 이메일
        data.setMemberName(rs.getString("MEMBER_NAME")); 				// 이름
        data.setMemberPhone(rs.getString("MEMBER_PHONE"));				// 전화번호
        data.setMemberNickname(rs.getString("MEMBER_NICKNAME")); 		// 닉네임
        data.setMemberProfileWay(rs.getString("MEMBER_PROFILE_WAY")); 	// 프로필 사진 경로
        data.setMemberRole(rs.getString("MEMBER_ROLE")); 				// 권한
        data.setMemberHireDay(rs.getString("MEMBER_HIREDAY"));			// 가입일자
		System.out.println("MemberDTO selectOne mapRow() InfoMember end");
        return data;
    }
}

//비밀번호 확인 조회
class PasswordCheckMemberRowMapper implements RowMapper<MemberDTO> {
	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("MemberDTO selectOne mapRow() PasswordCheck start");
        MemberDTO data = new MemberDTO();
        data.setMemberNum(rs.getInt("MEMBER_NUM")); 					// 멤버 번호
		System.out.println("MemberDTO selectOne mapRow() PasswordCheck end");
		return data;
	}
}

//프로필 이미지 조회
class ProfileWayMemberRowMapper implements RowMapper<MemberDTO> {
    @Override
    public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("MemberDTO selectOne mapRow() ProfileWay start");
        MemberDTO data = new MemberDTO();
        data.setMemberProfileWay(rs.getString("MEMBER_PROFILE_WAY")); 	// 프로필 사진 경로
		System.out.println("MemberDTO selectOne mapRow() ProfileWay end");
        return data;
    }
}