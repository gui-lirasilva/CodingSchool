package br.com.coddingSchool.service;

import br.com.coddingSchool.dto.CourseDTO;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.repository.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CourseService {

    public Page<CourseDTO> findCoursesBySubcategory(CourseRepository courseRepository, Subcategory subcategory,
                                                    Pageable pageable) {
        return courseRepository.findAllBySubcategory(subcategory, pageable).map(CourseDTO::new);
    }

    public Course findByCode(CourseRepository courseRepository, String code) {
        return courseRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
