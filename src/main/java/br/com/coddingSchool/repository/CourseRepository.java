package br.com.coddingSchool.repository;

import br.com.coddingSchool.dto.SubcategoryDTO;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.projections.InstructorProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c.name, c.code, c.orderInSystem, c.colorCode, c.studyGuide, s.name, s.code, s.studyGuide " +
            "FROM Category c ,Subcategory s WHERE c.active = true AND s.active = true")
    List<Course> findAllByVisibleIsTrue();

    @Query(value = """
    SELECT c.instructor as 'name',
    COUNT(*) as 'coursesNumber'
    FROM Course c
    GROUP BY c.instructor
    ORDER BY COUNT(*) DESC LIMIT 1;
    """, nativeQuery = true)
    InstructorProjection findInstructorWithMoreCourses();

    Page<Course> findAllBySubcategory(Subcategory subcategory, Pageable pageable);
}
