package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	// input: X
	// output: Review
	public Review getReview(int id) {
		return reviewMapper.selectReview(id);
	}
	
	// input: Review
	// output: 성공한 행의 개수(int)
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	//addReviewAsField(4, "콤비네이션R", "이병헌", 5.0, "역시 맛있다!");
	public int addReviewAsField(
			int storeId, String menu, 
			String userName, Double point,
			String review) {
		
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	// input: id, review	output: 성공한 행의 개수
	public int updateReviewById(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}
	
	// input: id	output: X
	public void deleteReviewById(int id) {
		reviewMapper.deleteReviewById(id);
	}
}
