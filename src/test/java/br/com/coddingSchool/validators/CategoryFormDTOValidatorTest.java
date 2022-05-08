package br.com.coddingSchool.validators;

import br.com.coddingSchool.dto.form.CategoryFormDTO;
import br.com.coddingSchool.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.validation.Errors;

import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Mockito.*;

@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CategoryFormDTOValidatorTest {

    private CategoryRepository categoryRepository;
    private CategoryFormDTOValidator categoryFormDTOValidator;
    private Errors errors;
    private CategoryFormDTO categoryFormDTO;
    private final String programmingName = "Programação";
    private final String programmingCode = "programacao";
    private final String devopsName = "DevOps";
    private final String devopsCode = "devops";
    private final String nameField = "name";
    private final String codeField = "code";
    private final String categoryNameMessage = "category.name.exists";
    private final String categoryCodeMessage = "category.code.exists";



    @BeforeEach
    void setUp() {
        categoryRepository = mock(CategoryRepository.class);
        when(categoryRepository.existsByName(programmingName)).thenReturn(true);
        when(categoryRepository.existsByCode(programmingCode)).thenReturn(true);

        categoryFormDTOValidator = new CategoryFormDTOValidator(categoryRepository);
        errors = mock(Errors.class);
        categoryFormDTO = new CategoryFormDTO();
    }

    @Test
    void validate__should_be_devolve_an_error_if_the_category_name_or_code_already_exists_in_database() {
        categoryFormDTO.setName(programmingName);
        categoryFormDTO.setCode(programmingCode);

        categoryFormDTOValidator.validate(categoryFormDTO, errors);

        verify(errors).rejectValue(nameField, categoryNameMessage);
        verify(errors).rejectValue(codeField, categoryCodeMessage);
    }

    @Test
    void validate__should_be_not_devolve_any_error_if_the_category_name_or_code_not_exists_in_database() {
        categoryFormDTO.setName(devopsName);
        categoryFormDTO.setCode(devopsCode);

        categoryFormDTOValidator.validate(categoryFormDTO, errors);

        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Nested
    class nameAndCodeWithId {

        @BeforeEach
        void setUp() {
            categoryRepository = mock(CategoryRepository.class);
            categoryFormDTOValidator = new CategoryFormDTOValidator(categoryRepository);
            errors = mock(Errors.class);
            categoryFormDTO = new CategoryFormDTO();

            when(categoryRepository.existsByNameWithDifferentId(eq(programmingName), not(eq(1L))))
                    .thenReturn(true);

            when(categoryRepository.existsByCodeWithDifferentId(eq(programmingCode), not(eq(1L))))
                    .thenReturn(true);
        }

        @Test
        void validate__should_not_be_devolve_any_error_if_the_name_or_code_already_exists_and_the_id_is_the_same() {
            categoryFormDTO.setId(1L);
            categoryFormDTO.setName(programmingName);
            categoryFormDTO.setCode(programmingCode);

            categoryFormDTOValidator.validate(categoryFormDTO, errors);

            verify(errors, never()).rejectValue(anyString(), anyString());
        }

        @Test
        void validate__should_be_devolve_an_error_if_the_name_or_code_already_exists_but_the_id_not() {
            categoryFormDTO.setId(10L);
            categoryFormDTO.setName(programmingName);
            categoryFormDTO.setCode(programmingCode);

            categoryFormDTOValidator.validate(categoryFormDTO, errors);

            verify(errors).rejectValue(nameField, categoryNameMessage);
            verify(errors).rejectValue(codeField, categoryCodeMessage);
        }

        @Test
        void validate__should_be_not_devolve_any_error_if_the_name_or_code_not_exists_for_this_id() {
            categoryFormDTO.setId(1L);
            categoryFormDTO.setName(devopsName);
            categoryFormDTO.setCode(devopsCode);

            categoryFormDTOValidator.validate(categoryFormDTO, errors);

            verify(errors, never()).rejectValue(anyString(), anyString());
        }

        @Test
        void validate__should_be_not_devolve_any_error_if_the_name_or_code_not_exists_and_the_id_is_different() {
            categoryFormDTO.setId(10L);
            categoryFormDTO.setName(devopsName);
            categoryFormDTO.setCode(devopsCode);

            categoryFormDTOValidator.validate(categoryFormDTO, errors);

            verify(errors, never()).rejectValue(anyString(), anyString());
        }
    }
}