package com.koreait.app.view.board;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.app.biz.board.BoardDTO;
import com.koreait.app.biz.board.BoardService;

@Controller("searchBoard")
public class SearchBoardController {

	@Autowired
	private BoardService boardService;
	
	//V로 이동할 경우 데이터 전달
	@RequestMapping(value="/searchBoard.do", method=RequestMethod.POST)
	public @ResponseBody List<BoardDTO> searchBoardKeyWord(@RequestBody BoardDTO boardDTO, Model model) {
		List<BoardDTO> datas = null;
		System.out.println("start searchBoardKeyWord");
		boardDTO.setCondition(boardDTO.getCondition());
		System.out.println("boardDTO.getCondition [" + boardDTO.getCondition() +"]");
		datas = boardService.selectAll(boardDTO);
		
		model.addAttribute("datas", datas);
		return datas;

	}
}
