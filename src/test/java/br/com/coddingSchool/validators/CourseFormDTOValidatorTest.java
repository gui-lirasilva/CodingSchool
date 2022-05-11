package br.com.coddingSchool.validators;

import br.com.coddingSchool.dto.form.CourseFormDTO;
import br.com.coddingSchool.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.validation.Errors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Mockito.*;

class CourseFormDTOValidatorTest {

    private CourseFormDTO courseFormDTO;
    private CourseFormDTOValidator courseFormDTOValidator;
    private CourseRepository courseRepository;
    private Errors errors;
    private final String codeField = "code";
    private final String nameField = "name";
    private final String courseNameMessage = "course.name.exists";
    private final String courseCodeMessage = "course.code.exists";
    private final String javaCourseName = "Java OO";
    private final String javaCourseCode = "java-oo";
    private final String gitCourseName = "Git e GitHub";
    private final String gitCourseCode = "git-github";

    @BeforeEach
    void setUp() {
        courseRepository = mock(CourseRepository.class);
        when(courseRepository.existsByName(javaCourseName)).thenReturn(true);
        when(courseRepository.existsByCode(javaCourseCode)).thenReturn(true);

        courseFormDTOValidator = new CourseFormDTOValidator(courseRepository);
        errors = mock(Errors.class);
        courseFormDTO = new CourseFormDTO();
    }

    @Test
    void validate__should_be_devolve_an_error_if_the_name_or_code_already_exists_in_database() {
        courseFormDTO.setName(javaCourseName);
        courseFormDTO.setCode(javaCourseCode);

        courseFormDTOValidator.validate(courseFormDTO, errors);

        verify(errors).rejectValue(nameField, courseNameMessage);
        verify(errors).rejectValue(codeField, courseCodeMessage);
    }

    @Test
    void validate__should_be_not_devolve_any_error_if_the_name_or_code_not_exists_in_database() {
        courseFormDTO.setName(gitCourseName);
        courseFormDTO.setCode(gitCourseCode);

        courseFormDTOValidator.validate(courseFormDTO, errors);

        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Nested
    class nameAndCodeWithId {
        @BeforeEach
        void setUp() {
            courseRepository = mock(CourseRepository.class);
            courseFormDTOValidator = new CourseFormDTOValidator(courseRepository);
            errors = mock(Errors.class);
            courseFormDTO = new CourseFormDTO();

            when(courseRepository.existsByNameAndIdNot(eq(javaCourseName), not(eq(1L)))).thenReturn(true);
            when(courseRepository.existsByCodeAndIdNot(eq(javaCourseCode), not(eq(1L)))).thenReturn(true);
        }

        @Test
        void validate__should_not_be_devolve_any_error_if_the_name_or_code_already_exists_and_the_id_is_the_same() {
            courseFormDTO.setId(1L);
            courseFormDTO.setName(javaCourseName);
            courseFormDTO.setCode(javaCourseCode);

            courseFormDTOValidator.validate(courseFormDTO, errors);
            verify(errors, never()).rejectValue(anyString(), anyString());
        }

        @Test
        void validate__should_be_devolve_an_error_if_the_name_or_code_already_exists_but_the_id_not() {
            courseFormDTO.setId(10L);
            courseFormDTO.setName(javaCourseName);
            courseFormDTO.setCode(javaCourseCode);

            courseFormDTOValidator.validate(courseFormDTO, errors);
            verify(errors).rejectValue(nameField, courseNameMessage);
            verify(errors).rejectValue(codeField, courseCodeMessage);
        }

        @Test
        void validate__should_be_not_devolve_any_error_if_the_name_or_code_not_exists_for_this_id() {
            courseFormDTO.setId(1L);
            courseFormDTO.setName(gitCourseName);
            courseFormDTO.setCode(gitCourseCode);

            courseFormDTOValidator.validate(courseFormDTO, errors);
            verify(errors, never()).rejectValue(anyString(), anyString());
        }

        @Test
        void validate__should_be_not_devolve_any_error_if_the_name_or_code_not_exists_and_the_id_is_different() {
            courseFormDTO.setId(10L);
            courseFormDTO.setName(gitCourseName);
            courseFormDTO.setCode(gitCourseCode);

            courseFormDTOValidator.validate(courseFormDTO, errors);
            verify(errors, never()).rejectValue(anyString(), anyString());
        }

    }
}