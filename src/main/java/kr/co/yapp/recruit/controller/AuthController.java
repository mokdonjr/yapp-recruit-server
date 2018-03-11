package kr.co.yapp.recruit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.yapp.recruit.model.User;

@Controller
public class AuthController {
	private Logger logger = LoggerFactory.getLogger(AuthController.class);

	/**
	 * @author seungchanbaeg
	 * 2018.03.10
	 * 인증 페이지
	 */
	@GetMapping(value = {"/", "/auth"})
	public String auth(HttpServletRequest request, Model model){
		User user = new User();
		model.addAttribute("user", user);
		return "auth";
	}
	
	/**
	 * @author seungchanbaeg
	 * 2018.03.10
	 * 인증 성공시 mypage
	 * 인증 실패시 auth
	 */
	@PostMapping("/auth")
	public String authPost(@Valid User user, BindingResult result, HttpServletRequest request){
		if(result.hasErrors()){
			logger.info("인증 실패 - {}", user.getUserId());
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors){
				error.getDefaultMessage();
			}
			return "auth";
		}
		return "mypage";
	}
	
	/**
	 * @author seungchanbaeg
	 * 2018.03.10
	 * 테스트 페이지. 익명 접근 가능
	 */
	@GetMapping("/test")
	public String test(){
		return "test";
	}
	
	/**
	 * @author seungchanbaeg
	 * 2018.03.10
	 * 테스트 페이지. USER 권한 접근 가능
	 */
	@GetMapping("/testSecured")
	public String testSecured(){
		return "testSecured";
	}
}
