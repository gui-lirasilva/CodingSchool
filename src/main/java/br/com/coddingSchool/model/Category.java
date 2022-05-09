package br.com.coddingSchool.model;

import br.com.coddingSchool.dto.form.CategoryFormDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotBlank(message = "{name.empty.null}")
    private String name;

    @Setter
    @Pattern(regexp = "[a-z0-9^-]+", message = "{code.invalid.pattern}")
    private String code;

    @Setter
    @Column(name = "order_in_system")
    private int orderInSystem;

    @Setter
    @NotBlank(message = "{description.empty.null}")
    @Column(columnDefinition = "text")
    private String description;

    @Setter
    private boolean active;

    @Setter
    @NotBlank(message = "{icon.path.empty.null}")
    @Column(name = "icon_path")
    private String iconPath;

    @Setter
    @NotBlank
    @Pattern(regexp = "^#([a-fA-F0-9]){3}(([a-fA-F0-9]){3})?$", message = "{code.hexadecimal.pattern}")
    @Column(name = "color_code")
    private String colorCode;

    @Setter
    @Column(name = "study_guide", columnDefinition = "text")
    private String studyGuide;

    @Setter
    @OneToMany(mappedBy = "category")
    private List<Subcategory> subcategories;

    public Category(String name, String code, int orderInSystem, String colorCode, String studyGuide) {
        this.name = name;
        this.code = code;
        this.orderInSystem = orderInSystem;
        this.colorCode = colorCode;
        this.studyGuide = studyGuide;
    }

    public Category(String name, String code, int orderInSystem, String description, boolean active, String iconPath,
                    String colorCode, String studyGuide) {

        this.name = name;
        this.code = code;
        this.orderInSystem = orderInSystem;
        this.description = description;
        this.active = active;
        this.iconPath = iconPath;
        this.colorCode = colorCode;
        this.studyGuide = studyGuide;
    }

    public Category(Long id, String name, String code, int orderInSystem, String description, boolean active,
                    String iconPath, String colorCode, String studyGuide) {

        this.id = id;
        this.name = name;
        this.code = code;
        this.orderInSystem = orderInSystem;
        this.description = description;
        this.active = active;
        this.iconPath = iconPath;
        this.colorCode = colorCode;
        this.studyGuide = studyGuide;
    }

    public void toggleVisibility() {
        this.active = !isActive();
    }

    public void toMerge(@Valid CategoryFormDTO categoryFormDTO) {
        this.name = categoryFormDTO.getName();
        this.code = categoryFormDTO.getCode();
        this.orderInSystem = categoryFormDTO.getOrderInSystem();
        this.description = categoryFormDTO.getDescription();
        this.active = categoryFormDTO.isActive();
        this.iconPath = categoryFormDTO.getIconPath();
        this.colorCode = categoryFormDTO.getColorCode();
        this.studyGuide = categoryFormDTO.getStudyGuide();
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", studyGuide='" + studyGuide + '\'' +
                ", active=" + active +
                ", order=" + orderInSystem +
                ", icon='" + iconPath + '\'' +
                ", color='" + colorCode + '\'' +
                '}';
    }
}
