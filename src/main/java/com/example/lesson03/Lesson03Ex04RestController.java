package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex04RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	//url: http://localhost/lesson03/ex04?id=24
	@RequestMapping("/lesson03/ex04")
	public String ex04(
			@RequestParam("id") int id) {
		
		//void 타입이다
		reviewBO.deleteReviewById(id);
		return "삭제 성공";
	}
	
}
