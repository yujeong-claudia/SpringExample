package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.entity.StudentEntity;

//@Transactional
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
//		@PersistenceContext
//		private EntityManager em;
//		
//		public StudentEntity save(StudentEntity studentEntity) {
//			em.persist(studentEntity);
//			return studentEntity;
//		}
	
	// Spring data 	JPA
	
	// 기본 제공 메소드
	// 엔티티 save(엔티티) -> 1. insert(id가 null) 2.update(id가 있음)
	// Optional<엔티티객체> findById(id)
	// void delete(엔티티객체)
	// List<엔티티객체> findAll
	
	// ex02/1 - JPQL
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name);
	public List<StudentEntity> findByNameIn(List<String> names);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContaining(String email);
	public List<StudentEntity> findByNameStartingWith(String name);
	public List<StudentEntity> findByIdBetween(int startId, int endId);
	
	// ex02/2 - JPQL(Entity에 조회, db에 직접 가지않는다, entity가 대신 간다)
	// from은 테이블이 아니라 엔티티명 -> 엔티티이름이 st(별칭)로 바꼈다
	//@Query(value = "select st from StudentEntity st where st.dreamJob =:dreamJob") 
	@Query(value = "select * from new_student where dreamJob=:dreamJob", nativeQuery = true) // nativeQuery SQL 조회
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
		
}
