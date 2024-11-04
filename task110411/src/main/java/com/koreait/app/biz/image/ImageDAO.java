package com.koreait.app.biz.image;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDAO {
//	mysql> CREATE TABLE IMAGE(
//		   IMAGEID INT AUTO_INCREMENT PRIMARY KEY,
//		   PATH VARCHAR(5000) NOT NULL,
//		   BID INT NOT NULL,
//		   FOREIGN KEY (BID) REFERENCES BOARD(BID));
	/*
	 * private final String INSERT = "INSERT INTO IMAGE(PATH, BID) \r\n" +
	 * "VALUES (?, (SELECT MAX(BID) FROM BOARD))"; private final String SELECTONE =
	 * "SELECT PATH FROM IMAGE WHERE BID=?";
	 */
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public boolean insert(ImageDTO imageDTO) {
		int result = mybatis.insert("imageDAO.MEMBER_INSERT",imageDTO);
		if(result<=0) {
			return false;
		}return true;
	}
/*		//[1] DB 연결 객체를 conn 변수로 선언: JDBC 연결 관리하는 JDBCUtil 클래스에서 DB연결 설정 메서드 실행.
		Connection conn = JDBCUtil.connect();
		
		//[2] SQL 쿼리 미리 컴파일하는 객체 PreparedStatement를 참조하는 pstmt 변수 선언 및 초기화
		PreparedStatement pstmt;
		
		// 비정상 프로그램 종료 방지 위한 try-catch 진행
		try {
			//[3] pstmt 변수 선언 : () 안 쿼리문으로 실행 준비 완료.
			//SQL DB와 연결하여 INSERT 변수값 미리 컴파일, 실행 준비
			pstmt = conn.prepareStatement(INSERT);

			//[4] 인자값으로 받은 데이터 쿼리문에 삽입
			pstmt.setString(1, imageDTO.getImagePath());	//이미지명

			//[5] rs 변수 선언 : INSERT 쿼리문 실행
			int result = pstmt.executeUpdate();

			//[6] 예외처리 : 정상실행 되지 않았을 경우, false
			if (result <= 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(" ImageDTO INSERT Exception fail ");
			return false;
		}
		return true;
	}
	
	public boolean update(ImageDTO imageDTO) {
		return false;
	}

	public boolean delete(ImageDTO imageDTO) {
		return false;
	}
}
*/
	
	private List<ImageDTO> selectAll(ImageDTO imageDTO) {
		return null;
	}

	public ImageDTO selectOne(ImageDTO imageDTO) {
		return mybatis.selectOne("imageDAO.IMAGE_SELECTONE", imageDTO);
	}
}
/*		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ImageDTO data = null;
		
		// 비정상 프로그램 종료 방지 위한 try-catch 진행
		try {
			// 게시글에 따른 저장된 이미지 조회
			pstmt = conn.prepareStatement(SELECTONE);
			// 인풋값 이미지 쿼리문에 삽입
			pstmt.setInt(1, imageDTO.getBoardID());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				data = new ImageDTO();
				// 이미지명 가져오기
				data.setImagePath(rs.getString("PATH")); // 이미지명
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
*/
