package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	
	@Autowired
	private StudentBO studentBO;
	
	// 학생 추가화면
	// http://localhost/lesson04/ex02/add-student-view
	@GetMapping("add-student-view")
	public String addStudentView() {
		return "/lesson04/addStudent";
	}
	
	// 방금 가입된 학생 화면 & DB insert
	@PostMapping("/add-student")
	public String addStudent(
			@ModelAttribute Student student) { // 태그의 name 속성파라미터와 이름이 같은 필드에 매핑
		
		// DB에 insert
		studentBO.addStudent(student);
		
		// DB에서 방금 가입된 사용자 select
		int id = student.getId();
		
		// selectById => 완성하는 게 과제
		
		// Model 객체에 담는다. (jsp에서 사용하도록)
		
		// 화면 뿌리기 => 테이블로 뿌리기
		return "/lesson04/afterAddStudent";
	}
}
