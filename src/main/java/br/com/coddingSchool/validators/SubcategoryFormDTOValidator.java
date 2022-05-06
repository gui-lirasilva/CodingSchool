package br.com.coddingSchool.validators;

import br.com.coddingSchool.dto.form.SubcategoryFormDTO;
import br.com.coddingSchool.repository.SubcategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SubcategoryFormDTOValidator implements Validator {

    private final SubcategoryRepository subcategoryRepository;

    public SubcategoryFormDTOValidator(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return SubcategoryFormDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SubcategoryFormDTO form = (SubcategoryFormDTO) target;
        if (form.getId() == null) {
            if (subcategoryRepository.existsByName(form.getName())) {
                errors.rejectValue("name", "subcategory.name.exists");
            }
            if (subcategoryRepository.existsByCode(form.getCode())) {
                errors.rejectValue("code", "subcategory.code.exists");
            }
        } else {
            if (subcategoryRepository.existsByNameAndIdNot(form.getName(), form.getId())) {
                errors.rejectValue("name", "subcategory.name.exists");
            }
            if (subcategoryRepository.existsByCodeAndIdNot(form.getCode(), form.getId())) {
                errors.rejectValue("code", "subcategory.code.exists");
            }
        }
    }
}
