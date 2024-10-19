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
	private final String SELECTALL = "SELECT CONTENT,WRITER FROM BOARD";
	private final String INSERT = "INSERT INTO BOARD (CONTENT,WRITER) VALUES(?, ?)";
	private final String CONTENT = "SELECT CONTENT, WRITER FROM BOARD WHERE CONTENT LIKE ?";
	private final String WRITER = "SELECT CONTENT, WRITER FROM BOARD WHERE WRITER LIKE ?";

	
	public List<BoardDTO> selectAll(BoardDTO boardDTO) {
		List<BoardDTO> datas = new ArrayList<BoardDTO>();

		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 전체 게시글 조회
			if(boardDTO.getCondition().equals("ALL")) {
				pstmt = conn.prepareStatement(SELECTALL);

			}
			// 내용 검색 결과 조회
			else if (boardDTO.getCondition().equals("CONTENT")) {
				pstmt = conn.prepareStatement(CONTENT);
				pstmt.setString(1,"%" +boardDTO.getSearchContent()+"%");
				System.out.println("selectAll getContent "+boardDTO);
			}
			else if(boardDTO.getCondition().equals("WRITER")) {
				pstmt = conn.prepareStatement(WRITER);
				pstmt.setString(1,"%" +boardDTO.getSearchContent()+"%");
				System.out.println("selectAll getWriter" + boardDTO);

			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO data = new BoardDTO();
				data.setContent(rs.getString("CONTENT"));
				data.setWriter(rs.getString("WRITER"));
				datas.add(data);
				System.out.println("selectAll "+ data.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}

	public BoardDTO selectOne(BoardDTO boardDTO) {
		return null;
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
