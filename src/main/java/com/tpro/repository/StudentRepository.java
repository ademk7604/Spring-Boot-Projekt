package com.tpro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tpro.domain.Student;
import com.tpro.dto.StudentDTO;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	boolean existsByEmail(String email);
	// Spring Data JPA içinde existById() var fakat Spring Data JPA bize sondaki eki istediğimiz değişken ismi ile 
	//değiştirmemize izin veriyor, mevcut metodu bu şekilde türetebiliyoruz.

	List<Student> findByLastName(String lastName);

	// JPQL ile yazalım : 
	@Query("SELECT s from Student s WHERE s.grade=:pGrade")
	List<Student> findAllEqualsGrade(@Param("pGrade")Integer grade);
	
	// native query (SQL)
	@Query(value="SELECT * from Student s WHERE s.grade=:pGrade", nativeQuery=true)
	List<Student> findAllEqualsGradeWithSQL(@Param("pGrade")Integer grade);

	// JPQL
	@Query("SELECT new com.tpro.dto.StudentDTO(s) FROM Student s WHERE s.id=:id" ) 
	Optional<StudentDTO> findStudentDTOById(@Param("id") Long id);

}




































