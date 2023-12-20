package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson04/ex01")
@Controller // jsp를 내리는 경우 ResponseBody가 있으면 안된다
public class Lesson04Ex01Controller {
	
	@Autowired
	private UserBO userBO;
	
	// 회원가입 화면
	// http://localhost/lesson04/ex01/add-user-view
	@RequestMapping(path = "/add-user-view", method = RequestMethod.GET)
											// 무조건 get만 허용
	public String addUserView() { 
		return "lesson04/addUser"; //jsp view의 경로
	}
	
	// 회원가입 insert => 입력 성공 화면
	@PostMapping("/add-user") // jsp의 action
	public String addUser( //jsp의 name
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required = false) String introduce) {
		
		// DB insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "/lesson04/afterAddUser";
	}
	
	// 최근에 가입된 한명의 유저
	// http://localhost/lesson04/ex01/latest-user-view
	@GetMapping("/latest-user-view")
	public String latestUserView(Model model) { // Model: view 화면에 데이터를 넘겨주는 객체
		// DB select (최신 가입자)
		User user = userBO.getLatestUser();
		
		// Model 주머니에 데이터를 담는다 => jsp에서 꺼내쓴다.
		model.addAttribute("result", user);
		model.addAttribute("title", "최근 가입된 유저 정보");
		
		return "/lesson04/latestUser"; // 결과화면 jsp
	}
}
