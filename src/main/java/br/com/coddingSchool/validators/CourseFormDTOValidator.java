package br.com.coddingSchool.validators;

import br.com.coddingSchool.dto.form.CourseFormDTO;
import br.com.coddingSchool.repository.CourseRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CourseFormDTOValidator implements Validator {

    private final CourseRepository courseRepository;

    public CourseFormDTOValidator(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return CourseFormDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CourseFormDTO form = (CourseFormDTO) target;
        existsByNameAndExistsByCode(errors, form);
    }

    private void existsByNameAndExistsByCode(Errors errors, CourseFormDTO form) {
        if(form.hasId()) {
            existsByNameAndIdNotAndExistsByCodeAndIdNot(errors, form);
            return;
        }

        if (courseRepository.existsByName(form.getName())) {
            errors.rejectValue("name", "course.name.exists");
        }
        if (courseRepository.existsByCode(form.getCode())) {
            errors.rejectValue("code", "course.code.exists");
        }
    }

    private void existsByNameAndIdNotAndExistsByCodeAndIdNot(Errors errors, CourseFormDTO form) {
        if (courseRepository.existsByNameAndIdNot(form.getName(), form.getId())) {
            errors.rejectValue("name", "course.name.exists");
        }
        if (courseRepository.existsByCodeAndIdNot(form.getCode(), form.getId())) {
            errors.rejectValue("code", "course.code.exists");
        }
    }
}
