package com.koreait.app.biz.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	/*
	 * // 전체조회 : 고유번호 내용 작성자 조회 private final String SELECTALL =
	 * "SELECT BID, CONTENT,WRITER FROM BOARD"; // 게시물 등록 : 인풋값(내용,작성자)으로 게시물 등록
	 * private final String INSERT =
	 * "INSERT INTO BOARD (CONTENT,WRITER) VALUES(?,?)"; // 내용 검색 : ?내용이면 내용 모두 조회
	 * private final String SELECTALL_CONTENT =
	 * "SELECT CONTENT, WRITER FROM BOARD WHERE CONTENT LIKE ?"; // 작성자 검색 : ?작성자이면
	 * 작성자 모두 조회 private final String SELECTALL_WRITER =
	 * "SELECT CONTENT, WRITER FROM BOARD WHERE WRITER LIKE ?"; // 상세조회 : 인풋값(내용,
	 * 작성자)일 때 고유번호, 내용, 작성자 조회 private final String SELECTONE_ALL =
	 * "SELECT BID, CONTENT, WRITER FROM BOARD WHERE BID=?"; // max 게시글 고유번호 찾기
	 * private final String SELECTONE_MAX = "SELECT MAX(BID) AS BID FROM BOARD"; -->
	 */
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//게시물 추가하기
	public boolean insert(BoardDTO boardDTO) {
		int result = mybatis.insert("BoardDAO.BOARD_INSERT", boardDTO);
		if(result<=0) {
			return false;
		}return true;
	}
/*
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
*/

	
	public List<BoardDTO> selectAll(BoardDTO boardDTO) {
		List<BoardDTO> datas = null;
		//전체 게시물 목록 가져오기
		if (boardDTO.getCondition().equals("ALL")) {
			datas=mybatis.selectOne("BoardDAO.SELECTALL", boardDTO);

		//검색어 내용에 따른 게시물 가져오기
		} else if (boardDTO.getCondition().equals("CONTENT")) {
			datas=mybatis.selectOne("BoardDAO.CONTENT", boardDTO);

		//검색어 작성자에 따른 게시물 가져오기
		}else if (boardDTO.getCondition().equals("WRITER")) {
			datas=mybatis.selectOne("BoardDAO.WRITER", boardDTO);
		}
		return datas;
	}
		
		
		
/*		BoardMapper mapper = mybatis.getMapper(BoardMapper.class);
        List<BoardDTO> datas;

       // 조건에 따라 적절한 MyBatis Mapper 메서드 호출
        if ("ALL".equals(boardDTO.getCondition())) {
            datas = mapper.selectAll();
        } else if ("CONTENT".equals(boardDTO.getCondition())) {
            datas = mapper.selectByContent(boardDTO.getSearchContent());
        } else if ("WRITER".equals(boardDTO.getCondition())) {
            datas = mapper.selectByWriter(boardDTO.getSearchContent());
        } else {
            datas = List.of();  // 조건이 잘못된 경우 빈 리스트 반환
        }

        return datas;
    }
*/
/*		Connection conn = JDBCUtil.connect();
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
*/

	// 게시물 상세조회
	public BoardDTO selectOne(BoardDTO boardDTO) {
		BoardDTO data = null;
		//특정 게시물 정보 가져오기
		if (boardDTO.getCondition().equals("SELECTONE_ALL")) {
			data=mybatis.selectOne("BoardDAO.SELECTONE_ALL", boardDTO);
		
		//게시물 고유번호 최대값 찾기 진행
		} else if (boardDTO.getCondition().equals("SELECTONE_MAX")) {
			data=mybatis.selectOne("BoardDAO.SELECTONE_MAX", boardDTO);
		}
		return data;
	}
/*        BoardMapper mapper = mybatis.getMapper(BoardMapper.class);
        BoardDTO data = null;

        // 조건에 따라 적절한 쿼리 호출
        if ("SELECTONE_ALL".equals(boardDTO.getCondition())) {
            System.out.println("SELECTONE_ALL START");
            data = mapper.selectOneByBid(boardDTO.getBid());  // 특정 게시물 조회
        } else if ("SELECTONE_MAX".equals(boardDTO.getCondition())) {
            data = mapper.selectMaxBid();  // 최대 BID 조회
        }
        
        return data;
	}
*/
/*		System.out.println("selectOne BoardDTO start BoardDTO BID : " + boardDTO.toString());
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
*/
		
		
	public boolean update(BoardDTO boardDTO) {
		return false;
	}

	public boolean delete(BoardDTO boardDTO) {
		return false;
	}
}
