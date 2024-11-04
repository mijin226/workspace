package com.koreait.app.view.board;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import com.koreait.app.biz.board.BoardDTO;
import com.koreait.app.biz.board.BoardService;
import com.koreait.app.biz.image.ImageDTO;
//insertBoard.jsp에서 .do로 던져서 BoardController로 넘어옴.
import com.koreait.app.biz.image.ImageService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller("insertBoard")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@Autowired
	private ImageService imageService;

	@RequestMapping(value = "/main.do")
	public String main(BoardDTO boardDTO, Model model) {
		System.out.println("BoardDTO :"+ boardDTO.toString());
		boardDTO.setCondition("SELECTALL");//게시물 모두 조회
		List<BoardDTO> datas = boardService.selectAll(boardDTO);
		model.addAttribute("datas", datas);
		System.out.println("datas" + datas);
		return "main";//메인으로 이동 및 model 데이터 출력 전달
	}
	// V로 이동할 경우 데이터 전달
	// 게시물 작성 페이지 이동
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public String insertBoard() {
		return "insertBoard";
	}

	// C에게 가야하는 경우, 데이터 없음.
	// 게시물 등록(인풋값 : 작성자, 내용, 이미지 고유번호)
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(HttpServletRequest request, HttpSession session, BoardDTO boardDTO, ImageDTO imageDTO)
			throws IllegalStateException, IOException {
		
		// 사용자가 보낸 내용값 받아오기
		String content = request.getParameter("content");

		// 세션에서의 작성자명 받아오기
		String writer = (String) session.getAttribute("userID");

		// null 체크
	    if (content == null || content.isEmpty() || writer == null) {
	        return "insertBoard"; // 다시 게시글 작성 페이지로 이동
	    }
		 // 이미지 변수 가져오기
	    MultipartFile file = imageDTO.getFile();
	    if (file.isEmpty()) {
	        return "insertBoard"; // 파일이 선택되지 않았을 경우 처리
	    }
		// 서버에 사진 저장
		String fileName = file.getOriginalFilename();
		System.out.println("fileName : " + fileName);
		file.transferTo(new File(
				"C:\\Users\\pc\\Desktop\\workspace3\\task1022\\src\\main\\webapp\\images\\" + fileName));

		// boardDTO 인풋값 넣기
		
		boardDTO.setContent(content);
		boardDTO.setWriter(writer);
		
		
		//[1] 게시물 저장
		// 게시물 insert 실행
		boolean flag = boardService.insert(boardDTO);
		System.out.println("insertBoard [" + flag + "]");
		System.out.println("insert complete toString: " + boardDTO.toString());
		System.out.println("insert complete toString: " + imageDTO.toString());
	    if (!flag) {
	        return "insertBoard"; // 실패하면 게시글 작성페이지로
	    }
		
		
		//[2] 게시물 고유번호 불러오기
		//이미지 insert위한 게시물 고유번호(FK) 필요. board테이블 내 고유번호 최대값 파악
	    System.out.println("selectOne_Max before" + boardDTO.toString());
	    boardDTO.setCondition("SELECTONE_MAX");//최대값 조회를 위한 컨디션 변수 설정
		boardDTO = boardService.selectOne(boardDTO);//게시물 고유번호 반환
		System.out.println("selectOne_Max after" + boardDTO.toString());
		
		//[3] 이미지테이블에 이미지&보드 저장
		// insert 실행
		imageDTO.setBoardID(boardDTO.getBid());
		imageDTO.setImagePath(fileName);
		System.out.println("insertImage() start");
		flag = imageService.insert(imageDTO);
		if (!flag) {
			System.out.println("insertImage flag :" + flag);
			return "insertBoard";// 실패하면 게시글 작성페이지로
		}
		System.out.println("insertImage flag :" + flag);
		return "redirect:main.do";
	}

	//V로 이동할 경우 데이터 전달
	//게시물 상세조회 페이지로 이동
	@RequestMapping(value = "/detailBoard.do", method = RequestMethod.GET)
	public String detailBoard(HttpServletRequest request, Model model, BoardDTO boardDTO, ImageDTO imageDTO) {
		System.out.println("start detailBoard");
		
		//[1]작성자, 내용, 이미지명 모델에 넣기
			//1.게시물 고유번호 불러오기
		int bid = Integer.parseInt(request.getParameter("bid"));//bid는 String타입으로 가져옴. 따라서 int타입으로 변환 필요
		System.out.println("detailBoard bid set before:"+ bid);
			//2.게시물 고유번호 dto에 넣기
		boardDTO.setCondition("SELECTONE_ALL");
		boardDTO.setBid(bid);
		System.out.println("detailBoard bid set after:"+ bid);
			//3. dao 실행
		boardDTO = boardService.selectOne(boardDTO);//게시물 고유번호, 작성자, 내용 반환		
		System.out.println(boardDTO.toString());
			//4. 모델에 넣기
		model.addAttribute("data", boardDTO);//게시물 정보 넣기
		
		//5. 사용자 입력값 이미지 세팅
		imageDTO.setBoardID(bid);
	
		//6. 이미지명 찾기
		imageDTO=imageService.selectOne(imageDTO);
		
		//이미지 등록한 사용자라면 해당 이미지 불러오기
		if(imageDTO!=null) {
			model.addAttribute("datas", imageDTO);
		}//이미지값 없으면 상세보기 페이지로 이동
		return "detailBoard";
		
		
	}
}

//		//C에게 가야하는 경우, 데이터 없음.
//		@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
//		public String insertBoard(BoardDTO boardDTO, ImageDTO imageDTO) {
//			boolean flag=boardService.insert(boardDTO);
//			System.out.println("insertBoard ["+flag+"]");
//			System.out.println(boardDTO.toString());
//			System.out.println(imageDTO.toString());
//			boardService.selectOne(boardDTO);
//			System.out.println(boardDTO.toString());
//			System.out.println(imageDTO.toString());
//			return "redirect:insertImage.do";
//		
//		
////이미지 추가 전		return "redirect:main.do";		
//		//V로 이동할 경우 데이터 전달
//		@RequestMapping(value="/insertImage.do", method=RequestMethod.GET)
//		public String insertImage(ImageDTO imageDTO) {//이미지 insert 후 게시물 전체 출력(메인)페이지로
//			System.out.println("insertImage() start");
//			boolean flag=imageService.insert(imageDTO);
//			if(!flag) {
//				System.out.println("insertImage flag :" + flag);
//			return "insertBoard";//실패하면 게시글 작성페이지로
//			}
//			System.out.println("insertImage flag :" + flag);
//			return "main";//main.jsp로
//	
//	}
//}
