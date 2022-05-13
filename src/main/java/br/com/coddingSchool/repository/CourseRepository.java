package br.com.coddingSchool.repository;

import br.com.coddingSchool.dto.CourseDTO;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.projections.InstructorProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = """
    SELECT c.instructor as 'name',
    COUNT(*) as 'coursesNumber'
    FROM Course c
    GROUP BY c.instructor
    ORDER BY COUNT(*) DESC LIMIT 1;
    """, nativeQuery = true)
    InstructorProjection findInstructorWithMoreCourses();

    Page<Course> findAllBySubcategory_Code(String subcategoryCode, Pageable pageable);

    default Page<CourseDTO> findAllDtoBySubcategory_Code(String subcategoryCode, Pageable pageable) {
        return findAllBySubcategory_Code(subcategoryCode, pageable).map(CourseDTO::new);
    };

    Optional<Course> findByCode(String code);

    boolean existsByName(String name);

    boolean existsByCode(String code);

    boolean existsByNameAndIdNot(String name, Long id);

    boolean existsByCodeAndIdNot(String code, Long id);

}
