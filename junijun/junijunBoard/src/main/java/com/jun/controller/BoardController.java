package com.jun.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jun.domain.BoardVO;
import com.jun.domain.Criteria;
import com.jun.domain.PageMaker;
import com.jun.domain.ReplyVO;
import com.jun.domain.SearchCriteria;
import com.jun.service.BoardService;
import com.jun.service.ReplyService;

@Controller
//@RequestMapping("/board/*")
public class BoardController {
	
	//로그
	private static Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	//댓글 의존성 주입
	@Inject
	ReplyService replyService;
	
	//작성
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public void getWrite() throws Exception {
		log.info("start write");
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String postWrite(BoardVO vo) throws Exception {
		log.info("글 작성 시작");
		
		service.write(vo);
		
		return "redirect:/board/boardList";	
	}
	
	//목록
	@RequestMapping(value = "/board/boardList", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		log.info("목록 가져오기");
		
		List<BoardVO> list = service.list();
		
		model.addAttribute("list", list);
	}
	
	//목록 + 페이징
	@RequestMapping(value = "/board/boardListPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		log.info("get list page");
		
		System.out.println("cri :::" + cri);
		
		List<BoardVO> list = service.listPage(cri);
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount());
		model.addAttribute("pageMaker", pageMaker);
	}
	
	//목록 + 페이징 + 검색
	@RequestMapping(value = "/board/boardListSearch", method = RequestMethod.GET)
	public void listSearch(@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		log.info("get list search");
		System.out.println("scri :::" + scri);
		
		List<BoardVO> list = service.listSearch(scri);
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.countSearch(scri));
		model.addAttribute("pageMaker", pageMaker);
	}
	
	//글 읽기
	@RequestMapping(value = "/board/boardRead", method = RequestMethod.GET)
	public void getRead(@RequestParam("bno") int bno, @ModelAttribute("scri") SearchCriteria scri, Model model ) throws Exception {
		log.info("글 읽기 시작");
		
		System.out.println("bno :::" + bno);
		System.out.println("scri read :::" + scri);
		
		BoardVO vo = service.read(bno);
		
		model.addAttribute("read", vo);
		model.addAttribute("scri", scri);
		
		List<ReplyVO> replyList = replyService.readReply(bno);
		
		model.addAttribute("replyList", replyList);
	}
	
	//수정
	@RequestMapping(value = "/board/boardModify", method = RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno, @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		log.info("글 수정 시작");
		
		BoardVO vo = service.read(bno);
		
		model.addAttribute("modify", vo);
		model.addAttribute("scri", scri);
	}
	//수정get
	@RequestMapping(value = "/board/boardModify", method = RequestMethod.POST)
	public String postModify(BoardVO vo, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		log.info("글 수정");
		System.out.println("scri modify :::" + scri);
		
		service.update(vo);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
	 return "redirect:/board/boardListSearch";
	}
		
	//삭제
	@RequestMapping(value = "/board/boardDelete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("bno") int bno, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		log.info("글 삭제");
		
		System.out.println("scri delete :::" + scri);
		
		service.delete(bno);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
	 return "redirect:/board/boardListSearch";
	}
	
	//댓글 작성
	@PostMapping("/board/replyWrite")
	public String replyWrite(ReplyVO replyVO, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		log.info("reply write");
		
		replyService.writeReply(replyVO);
		
		rttr.addAttribute("bno", replyVO.getBno());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/boardRead";
		
	}
	
	//댓글 수정 
	@PostMapping("/board/replyModify")
	public String replyUpdate(ReplyVO replyVO, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		log.info("댓글 수정");
			
		replyService.replyUpdate(replyVO);
		
		rttr.addAttribute("bno", replyVO.getBno());
	    rttr.addAttribute("page", scri.getPage());
	    rttr.addAttribute("perPageNum", scri.getPerPageNum());
	    rttr.addAttribute("searchType", scri.getSearchType());
	    rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/boardRead";
	}
	
	@GetMapping("/board/replyModify")
	public void getReplyUpdate(@RequestParam("rno") int rno, @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		log.info("reply update");
		
		System.out.println("reply scri 수정 :::" + scri);
	 
		ReplyVO replyVO = null;
	 
		replyVO = replyService.readReplySelect(rno);
	 
		model.addAttribute("readReply", replyVO);
		model.addAttribute("scri", scri);
	}
	
	//댓글 삭제 
	@RequestMapping(value = "/board/replyDelete", method = RequestMethod.GET)
	public String replyDelete(ReplyVO replyVO, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		log.info("댓글 삭제");
		
		System.out.println("reply scri 삭제 :::" + scri);
		
		replyService.replyDelete(replyVO);
		
		rttr.addAttribute("bno", replyVO.getBno());
	    rttr.addAttribute("page", scri.getPage());
	    rttr.addAttribute("perPageNum", scri.getPerPageNum());
	    rttr.addAttribute("searchType", scri.getSearchType());
	    rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/boardRead";
			
			
	}
	
	

}
