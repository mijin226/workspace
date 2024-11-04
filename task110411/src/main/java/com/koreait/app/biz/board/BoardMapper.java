package com.koreait.app.biz.board;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BoardMapper {
	List<BoardDTO> selectAll();
    List<BoardDTO> selectByContent(String searchContent);
    List<BoardDTO> selectByWriter(String searchContent);
    BoardDTO selectOneByBid(@Param("bid") int bid);  // 게시물 ID로 게시물 조회
    BoardDTO selectMaxBid();  // 최대 게시물 ID 조회
}
