package br.com.coddingSchool.dto.form;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Subcategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SubcategoryFormDTO {

    private Long id;
    @NotBlank(message = "{name.empty.null}")
    private String name;
    @Pattern(regexp = "[a-z0-9^-]+", message = "{code.invalid.pattern}")
    private String code;
    private boolean active;
    private int orderInSystem;
    private String studyGuide;
    @NotBlank(message = "{description.empty.null}")
    private String description;
    @NotNull(message = "{category.null}")
    private Category category;

    public SubcategoryFormDTO(Subcategory subcategory) {
        this.id = subcategory.getId();
        this.name = subcategory.getName();
        this.code = subcategory.getCode();
        this.orderInSystem = subcategory.getOrderInSystem();
        this.description = subcategory.getDescription();
        this.active = subcategory.isActive();
        this.studyGuide = subcategory.getStudyGuide();
        this.category = subcategory.getCategory();
    }

    public static List<SubcategoryFormDTO> toDTO(List<Subcategory> subcategories) {
        return subcategories.stream().map(SubcategoryFormDTO::new).toList();
    }

    public Subcategory toEntity() {
        return new Subcategory(name, code, orderInSystem, description, active, category, studyGuide);
    }

    public boolean hasId() {
        return this.id != null;
    }
}
