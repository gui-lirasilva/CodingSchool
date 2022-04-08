package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c.name, c.code, c.orderInSystem, c.colorCode, c.studyGuide, s.name, s.code, s.studyGuide " +
            "FROM Category c ,Subcategory s WHERE c.active = true AND s.active = true")
    List<Course> findAllByVisibleIsTrue();
}
