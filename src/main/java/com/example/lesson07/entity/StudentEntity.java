package com.example.lesson07.entity;

import java.time.ZonedDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // 객체를 출력시 필드 값이 보여진다.
@AllArgsConstructor // 파라미터가 모두 있는 생성자
@NoArgsConstructor // 파라미터가 없는 생성자
@Builder(toBuilder = true) // setter 대신에 사용 , toBuilder = true 필드값 변경 허용
@Getter
@Table(name = "new_student")
@Entity // 이 객체는 엔티티다. (JPA - DB)
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp // createAt이 null이어도 현재 시간으로 저장
	@Column(name = "createdAt", updatable = false) // 업데이트시 변경되지않도록 설정
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp // updatedAt이 null이어도 현재 시간으로 저장
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
	
	
}
