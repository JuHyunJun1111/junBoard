package com.jun.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.domain.BoardVO;
import com.jun.domain.Criteria;
import com.jun.domain.PageMaker;
import com.jun.domain.SearchCriteria;
import com.jun.service.BoardService;

@Controller
public class BoardController {
	
	//로그
	private static Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
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
	
	//조회
	@RequestMapping(value = "/board/boardRead", method = RequestMethod.GET)
	public void getRead(@RequestParam("bno") int bno, @ModelAttribute("scri") SearchCriteria scri, Model model ) throws Exception {
		log.info("글 읽기 시작");
		
		System.out.println("bno :::" + bno);
		BoardVO vo = service.read(bno);
		
		model.addAttribute("read", vo);
		model.addAttribute("scri", scri);
	}
	
	//수정
	@RequestMapping(value = "/board/boardModify", method = RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {
		log.info("글 수정 시작");
		
		BoardVO vo = service.read(bno);
		
		model.addAttribute("modify", vo);
	}
	@RequestMapping(value = "/board/boardModify", method = RequestMethod.POST)
	public String postModify(BoardVO vo) throws Exception {
		log.info("글 수정");
		
		service.update(vo);
		
	 return "redirect:/board/boardList";
	}
		
	//삭제
	@RequestMapping(value = "/board/boardDelete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("bno") int bno) throws Exception {
		log.info("글 삭제");
		
		service.delete(bno);
		
	 return "redirect:/board/boardList";
	}
	
	

}
