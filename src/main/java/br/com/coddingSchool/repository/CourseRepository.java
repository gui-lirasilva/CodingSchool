package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.projections.InstructorProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Long> {

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
