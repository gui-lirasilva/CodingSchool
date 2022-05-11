package br.com.coddingSchool.dto.form;

import br.com.coddingSchool.model.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class CategoryFormDTO {

    private Long id;

    @NotBlank(message = "{name.empty.null}")
    private String name;

    @Pattern(regexp = "[a-z0-9^-]+", message = "{code.invalid.pattern}")
    private String code;

    private int orderInSystem;

    @NotBlank(message = "{description.empty.null}")
    private String description;

    private boolean active;

    @NotBlank(message = "{icon.path.empty.null}")
    private String iconPath;

    @Pattern(regexp = "^#([a-fA-F0-9]){3}(([a-fA-F0-9]){3})?$", message = "{code.hexadecimal.pattern}")
    private String colorCode;

    private String studyGuide;

    public CategoryFormDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.code = category.getCode();
        this.active = category.isActive();
        this.description = category.getDescription();
        this.iconPath = category.getIconPath();
        this.colorCode = category.getColorCode();
        this.studyGuide = category.getStudyGuide();
    }

    public Category toEntity() {
        return new Category(name, code, orderInSystem, description, active, iconPath, colorCode, studyGuide);
    }

    public boolean hasId() {
       return this.id != null;
    }
}
