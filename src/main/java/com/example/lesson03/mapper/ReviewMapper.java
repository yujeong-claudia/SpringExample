package com.example.lesson03.mapper;

import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	
	// input: id 	output:Review
	public Review selectReview(int id);
	
	// input: Review
	// output: 성공한 행의 개수(int)
	public int insertReview(Review review);
}
