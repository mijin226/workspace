package com.koreait.app.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.app.biz.board.BoardDTO;
import com.koreait.app.biz.board.BoardService;
//insertBoard.jsp에서 .do로 던져서 BoardController로 넘어옴.

@Controller("insertBoard")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/main.do")
	public String main(BoardDTO boardDTO, Model model) {
		boardDTO.setCondition("ALL");
		List<BoardDTO> datas=boardService.selectAll(boardDTO);
		model.addAttribute("datas", datas);
		System.out.println("datas" + datas);
		return "main";
	}
	
	//V로 이동할 경우 데이터 전달
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertBoard() {
		return "insertBoard";
	}
	
	//C에게 가야하는 경우, 데이터 없음.
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardDTO boardDTO) {
		boolean flag=boardService.insert(boardDTO);
		System.out.println("insertBoard ["+flag+"]");
		return "redirect:main.do";		
	}
}
