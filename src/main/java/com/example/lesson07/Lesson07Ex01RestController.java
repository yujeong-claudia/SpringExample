package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// c: create
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "윤정한";
		String phoneNumber = "010-1995-1004";
		String email = "yjh@naver.com";
		String dreamJob = "천사";
		
		// 방금 인서트된 pk id도 바로 얻어낼 수 있다.
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// u: update
	@GetMapping("/2")
	public StudentEntity udtate() {
		// id가 3번인 dreamJob 변경
		// 5, 디자이너
		
		return studentBO.updateStudentDreamJobById(5, "디자이너");
	}
	
	// d: delete
	@GetMapping("/3")
	public String delete() {
		//id:5
		studentBO.deleteStudentById(5);
		return "삭제 완료";
	}
}
