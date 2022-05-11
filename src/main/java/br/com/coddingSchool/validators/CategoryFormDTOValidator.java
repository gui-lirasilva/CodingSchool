package br.com.coddingSchool.validators;

import br.com.coddingSchool.dto.form.CategoryFormDTO;
import br.com.coddingSchool.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CategoryFormDTOValidator implements Validator {

    private final CategoryRepository categoryRepository;

    public CategoryFormDTOValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoryFormDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CategoryFormDTO form = (CategoryFormDTO) target;
        existsByNameAndExistsByCode(errors, form);
    }

    private void existsByNameAndExistsByCode(Errors errors, CategoryFormDTO form) {
        if(form.hasId()) {
            existsByNameAndIdNotAndExistsByCodeAndIdNot(errors, form);
            return;
        }

        if (categoryRepository.existsByName(form.getName())) {
            errors.rejectValue("name", "category.name.exists");
        }
        if (categoryRepository.existsByCode(form.getCode())) {
            errors.rejectValue("code", "category.code.exists");
        }
    }

    private void existsByNameAndIdNotAndExistsByCodeAndIdNot(Errors errors, CategoryFormDTO form) {
        if (categoryRepository.existsByNameAndIdNot(form.getName(), form.getId())) {
            errors.rejectValue("name", "category.name.exists");
        }
        if (categoryRepository.existsByCodeAndIdNot(form.getCode(), form.getId())) {
            errors.rejectValue("code", "category.code.exists");
        }
    }
}
