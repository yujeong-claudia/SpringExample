package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + @ResponseBody
public class Lesson01Ex01RestController {
	
	// url: http://localhost/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "RestController를 사용해 String을 리턴해본다.";
	}
	
	// url: http://localhost/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4() {
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		
		return map; // => json
	}
	
	// url: http://localhost/lesson01/ex01/5
	@RequestMapping("/5")
	// 내가 만든 Data 클래스로 만들어줘야한다.
	public Data ex01_5() {
		Data data = new Data(); // 일반 자바 bean(객체)
		data.setId(10);
		data.setName("김유정");
		
		return data; //일반 bean 객체도 JSON으로 변환된다.
	}
	
	// url: http://localhost/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data();
		data.setId(11);
		data.setName("바다");
			
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		// 객체를 만들면서 리턴한다. 그래서 return 뒤에 new가 붙는다.
		// 뒤에 ok로 하면 200, Internal_server_error로 하면 500...
	}
	
	
	
}
