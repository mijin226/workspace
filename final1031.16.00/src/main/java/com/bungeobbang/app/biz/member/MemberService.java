package com.bungeobbang.app.biz.member;

import java.util.ArrayList;

public interface MemberService {
	boolean insert(MemberDTO boardDTO);
	boolean update(MemberDTO boardDTO);
	boolean delete(MemberDTO boardDTO);
	ArrayList<MemberDTO> selectAll(MemberDTO boardDTO);
	MemberDTO selectOne(MemberDTO boardDTO);
}