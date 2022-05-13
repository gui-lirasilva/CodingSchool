package br.com.coddingSchool.validators;

import br.com.coddingSchool.DatabaseTestEnvironment;
import br.com.coddingSchool.dto.form.SubcategoryFormDTO;
import br.com.coddingSchool.repository.SubcategoryRepository;
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
class SubcategoryFormDTOValidatorTest extends DatabaseTestEnvironment {

    private SubcategoryRepository subcategoryRepository;
    private SubcategoryFormDTOValidator subcategoryFormDTOValidator;
    private SubcategoryFormDTO subcategoryFormDTO;
    private Errors errors;
    private final String javaName = "Java";
    private final String javaCode = "java";
    private final String kotlinName = "Kotlin";
    private final String kotlinCode = "kotlin";
    private final String codeField = "code";
    private final String nameField = "name";
    private final String subcategoryNameMessage = "subcategory.name.exists";
    private final String subcategoryCodeMessage = "subcategory.code.exists";

    @BeforeEach
    void setup() {
        subcategoryRepository = mock(SubcategoryRepository.class);
        when(subcategoryRepository.existsByName(javaName)).thenReturn(true);
        when(subcategoryRepository.existsByCode(javaCode)).thenReturn(true);

        subcategoryFormDTOValidator = new SubcategoryFormDTOValidator(subcategoryRepository);
        errors = mock(Errors.class);
        subcategoryFormDTO = new SubcategoryFormDTO();
    }

    @Test
    void validate__should_be_devolve_an_error_if_the_name_or_code_already_exists_in_database() {
        subcategoryFormDTO.setName(javaName);
        subcategoryFormDTO.setCode(javaCode);

        subcategoryFormDTOValidator.validate(subcategoryFormDTO, errors);

        verify(errors).rejectValue(nameField, subcategoryNameMessage);
        verify(errors).rejectValue(codeField, subcategoryCodeMessage);
    }

    @Test
    void validate__should_be_not_devolve_any_error_if_the_name_or_code_not_exists_in_database() {
        subcategoryFormDTO.setName(kotlinName);
        subcategoryFormDTO.setCode(kotlinCode);

        subcategoryFormDTOValidator.validate(subcategoryFormDTO, errors);

        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Nested
    class nameAndCodeWithId {
        @BeforeEach
        void setUp() {
            subcategoryRepository = mock(SubcategoryRepository.class);
            subcategoryFormDTOValidator = new SubcategoryFormDTOValidator(subcategoryRepository);
            errors = mock(Errors.class);
            subcategoryFormDTO = new SubcategoryFormDTO();

            when(subcategoryRepository.existsByNameAndIdNot(eq(javaName), not(eq(1L)))).thenReturn(true);
            when(subcategoryRepository.existsByCodeAndIdNot(eq(javaCode), not(eq(1L)))).thenReturn(true);
        }

        @Test
        void validate__should_not_be_devolve_any_error_if_the_name_or_code_already_exists_and_the_id_is_the_same() {
            subcategoryFormDTO.setId(1L);
            subcategoryFormDTO.setName(javaName);
            subcategoryFormDTO.setCode(javaCode);

            subcategoryFormDTOValidator.validate(subcategoryFormDTO, errors);

            verify(errors, never()).rejectValue(anyString(), anyString());
        }

        @Test
        void validate__should_be_devolve_an_error_if_the_name_or_code_already_exists_but_the_id_not() {
            subcategoryFormDTO.setId(10L);
            subcategoryFormDTO.setName(javaName);
            subcategoryFormDTO.setCode(javaCode);

            subcategoryFormDTOValidator.validate(subcategoryFormDTO, errors);

            verify(errors).rejectValue(nameField, subcategoryNameMessage);
            verify(errors).rejectValue(codeField, subcategoryCodeMessage);
        }

        @Test
        void validate__should_be_not_devolve_any_error_if_the_name_or_code_not_exists_for_this_id() {
            subcategoryFormDTO.setId(1L);
            subcategoryFormDTO.setName(kotlinName);
            subcategoryFormDTO.setCode(kotlinCode);

            subcategoryFormDTOValidator.validate(subcategoryFormDTO, errors);

            verify(errors, never()).rejectValue(anyString(), anyString());
        }

        @Test
        void validate__should_be_not_devolve_any_error_if_the_name_or_code_not_exists_and_the_id_is_different() {
            subcategoryFormDTO.setId(10L);
            subcategoryFormDTO.setName(kotlinName);
            subcategoryFormDTO.setCode(kotlinCode);

            subcategoryFormDTOValidator.validate(subcategoryFormDTO, errors);

            verify(errors, never()).rejectValue(anyString(), anyString());
        }
    }
}