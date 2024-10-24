package com.koreait.app.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.app.biz.common.JDBCUtil;

@Repository
public class BoardDAO {
	// 전체조회 : 고유번호 내용 작성자 조회
	private final String SELECTALL = "SELECT BID, CONTENT,WRITER FROM BOARD";
	// 게시물 등록 : 인풋값(내용,작성자)으로 게시물 등록
	private final String INSERT = "INSERT INTO BOARD (CONTENT,WRITER) VALUES(?,?)";
	// 내용 검색 : ?내용이면 내용 모두 조회
	private final String SELECTALL_CONTENT = "SELECT CONTENT, WRITER FROM BOARD WHERE CONTENT LIKE ?";
	// 작성자 검색 : ?작성자이면 작성자 모두 조회
	private final String SELECTALL_WRITER = "SELECT CONTENT, WRITER FROM BOARD WHERE WRITER LIKE ?";
	// 상세조회 : 인풋값(내용, 작성자)일 때 고유번호, 내용, 작성자 조회
	private final String SELECTONE_ALL = "SELECT BID, CONTENT, WRITER FROM BOARD WHERE BID=?";
	// max 게시글 고유번호 찾기
	private final String SELECTONE_MAX = "SELECT MAX(BID) AS BID FROM BOARD";

	public List<BoardDTO> selectAll(BoardDTO boardDTO) {
		List<BoardDTO> datas = new ArrayList<BoardDTO>();

		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 전체 게시글 조회
			if (boardDTO.getCondition().equals("ALL")) {
				pstmt = conn.prepareStatement(SELECTALL);

			}
			// 내용 검색 결과 조회
			else if (boardDTO.getCondition().equals("CONTENT")) {
				pstmt = conn.prepareStatement(SELECTALL_CONTENT);
				pstmt.setString(1, "%" + boardDTO.getSearchContent() + "%");
				System.out.println("selectAll getContent " + boardDTO);
			} else if (boardDTO.getCondition().equals("WRITER")) {
				pstmt = conn.prepareStatement(SELECTALL_WRITER);
				pstmt.setString(1, "%" + boardDTO.getSearchContent() + "%");
				System.out.println("selectAll getWriter" + boardDTO);

			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO data = new BoardDTO();
				data.setBid(rs.getInt("BID"));
				data.setContent(rs.getString("CONTENT"));
				data.setWriter(rs.getString("WRITER"));
				datas.add(data);
				// System.out.println("selectAll "+ data.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}

	// 게시물 상세조회
	public BoardDTO selectOne(BoardDTO boardDTO) {
		System.out.println("selectOne BoardDTO start BoardDTO BID : " + boardDTO.toString());
		Connection conn = JDBCUtil.connect();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO data = null;

		// 비정상 프로그램 종료 방지 위한 try-catch 진행
		try {
			if (boardDTO.getCondition().equals("SELECTONE_ALL")) {		
				System.out.println("SELECTONE_ALL START");
				// 게시물정보 반환 위한 인풋값 내용, 작성자 넣기
				pstmt = conn.prepareStatement(SELECTONE_ALL);
				// 인풋값 게시물 데이터 넣기
				pstmt.setInt(1, boardDTO.getBid());
				System.out.println("set getBid() : "+boardDTO.getBid());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					data = new BoardDTO();
					// 게시물 정보 가져오기
					data.setBid(rs.getInt("BID")); 				// 게시물 고유번호
					data.setContent(rs.getString("CONTENT"));	// 게시물 내용
					data.setWriter(rs.getString("WRITER"));		// 게시물 작성자
				}
			}else if(boardDTO.getCondition().equals("SELECTONE_MAX")){
				//게시물 고유번호 최대값 찾기 진행
				pstmt = conn.prepareStatement(SELECTONE_MAX);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					data = new BoardDTO();
					// 게시물 고유번호 최대값 가져오기
					data.setBid(rs.getInt("BID"));  
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public boolean insert(BoardDTO boardDTO) {
		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, boardDTO.getContent());
			pstmt.setString(2, boardDTO.getWriter());

			int result = pstmt.executeUpdate();

			if (result <= 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean update(BoardDTO boardDTO) {
		return false;
	}

	public boolean delete(BoardDTO boardDTO) {
		return false;
	}
}
