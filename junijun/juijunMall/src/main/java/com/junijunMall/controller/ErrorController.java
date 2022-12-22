package com.junijunMall.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ErrorController {
	
	private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);
	
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex, Model model) {
		logger.error("Exception 발생 : {} " , ex.getMessage());
		model.addAttribute("msg", "다시 시도해주세요");
		return "/common/error";
	}
	
	@GetMapping("/error404") 
	public String error404(Model model) {
		logger.error("404 에러발생");
		model.addAttribute("msg", "요청하신 페이지는 없습니다.");
		return "/common/error";
	}
	
	@GetMapping("/error405") 
	public String error405(Model model) {
		logger.info("405 에러발생");
		model.addAttribute("msg", "요청된 메소드가 허용되지 않습니다.");
		return "/common/error";
	}
	
	@GetMapping("/error400") 
	public String error400(Model model) {
		logger.info("400 에러발생");
		model.addAttribute("msg", "잘못된 요청입니다.");
		return "/common/error";
	}
	
	@GetMapping("/error500") 
	public String error500(Model model) {
		logger.info("500 에러발생");
		model.addAttribute("msg", "서버에 오류가 발생했습니다.");
		return "/common/error";
	}
	
	@GetMapping("/exception") 
	public String exception(Model model) {
		logger.info("에러발생");
		model.addAttribute("msg", "예외가 발생하였습니다.");
		return "/common/error";
	}
	
	
	
	
//	@RequestMapping(value = "/exception")
//	public String exception(HttpServletRequest request, Model model) {
//		logger.info("exception");
//		pageErrorLog(request);
//		model.addAttribute("msg", "예외가 발생하였습니다.");
//				
//		return "common/error";
//	}
//	
//	@RequestMapping(value = "/400")
//	public String pageError400(HttpServletRequest request, Model model) {
//		logger.info("400 에러");
//		pageErrorLog(request);
//		model.addAttribute("msg", "잘못된 요청입니다..");
//		
//		return "common/error";
//	}
//	
//	@RequestMapping(value = "/403")
//	public String pageError403(HttpServletRequest request, Model model) {
//		logger.info("403 에러");
//		pageErrorLog(request);
//		model.addAttribute("msg", "접근이 금지되었습니다.");
//		
//		return "common/error";
//	}
//	
//	@RequestMapping(value = "/404")
//	public String pageError404(HttpServletRequest request, Model model) {
//		logger.info("404 에러");
//		pageErrorLog(request);
//		model.addAttribute("msg", "요청하신 페이지는 없습니다..");
//		
//		return "common/error";
//	}
//	
//	@RequestMapping(value = "/405")
//	public String pageError405(HttpServletRequest request, Model model) {
//		logger.info("405 에러");
//		pageErrorLog(request);
//		model.addAttribute("msg", "요청된 메소드가 허용되지 않습니다.");
//		
//		return "common/error";
//	}
//	
//	@RequestMapping(value = "/500")
//	public String pageError500(HttpServletRequest request, Model model) {
//		logger.info("500 에러");
//		pageErrorLog(request);
//		model.addAttribute("msg", "서버에 오류가 발생했습니다.");
//		
//		return "common/error";
//	}
//	
//	@RequestMapping(value = "/503")
//	public String pageError503(HttpServletRequest request, Model model) {
//		logger.info("503 에러");
//		pageErrorLog(request);
//		model.addAttribute("msg", "서비스를 이용할 수 업습니다.");
//		
//		return "common/error";
//	}
//	
	
}
