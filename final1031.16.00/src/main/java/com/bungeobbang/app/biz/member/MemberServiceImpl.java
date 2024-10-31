package com.bungeobbang.app.biz.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// BoardService의 구현체
@Service("boardService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO boardDAO;

	@Override
	public ArrayList<MemberDTO> selectAll(MemberDTO boardDTO) {
		return (ArrayList<MemberDTO>) this.boardDAO.selectAll(boardDTO);
	}

	@Override
	public MemberDTO selectOne(MemberDTO boardDTO) {
		
		return this.boardDAO.selectOne(boardDTO);
	}

	@Override
	public boolean insert(MemberDTO boardDTO) {
		
		return this.boardDAO.insert(boardDTO);
	}

	@Override
	public boolean update(MemberDTO boardDTO) {
		return this.boardDAO.update(boardDTO);
	}

	@Override
	public boolean delete(MemberDTO boardDTO) {
		return this.boardDAO.delete(boardDTO);
	}
	
	
	
}