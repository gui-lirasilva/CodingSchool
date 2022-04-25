package br.com.coddingSchool.service;

import br.com.coddingSchool.dto.CourseDTO;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.repository.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Page<CourseDTO> findCoursesBySubcategory(String subcategoryCode, Pageable pageable) {
        return courseRepository.findAllDtoBySubcategory_Code(subcategoryCode, pageable);
    }

    public Course findByCode(String code) {
        return courseRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public CourseDTO findDtoByCode(String code) {
        return new CourseDTO(this.findByCode(code));
    }
}
