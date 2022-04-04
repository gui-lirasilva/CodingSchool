package br.com.coddingSchool.model;

import br.com.coddingSchool.dto.form.UpdateCategoryForm;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{name.empty.null}")
    private String name;
    @Pattern(regexp = "[a-z0-9^-]+", message = "{code.invalid.pattern}")
    private String code;
    @Column(name = "`order`")
    private int order;
    @NotBlank(message = "The category description can't be empty or null")
    @Column(columnDefinition = "text")
    private String description;
    private boolean active;
    @NotBlank(message = "The icon path can't be empty or null")
    @Column(name = "icon_path")
    private String iconPath;
    @NotBlank
    @Pattern(regexp = "^#([a-fA-F0-9]){3}(([a-fA-F0-9]){3})?$", message = "The color code should be hexadecimal")
    @Column(name = "color_code")
    private String colorCode;
    @Column(name = "study_guide", columnDefinition = "text")
    private String studyGuide;
    @OneToMany(mappedBy = "category")
    private List<Subcategory> subcategories;

    public Category(String name, String code, int order, String colorCode, String studyGuide) {
        this.name = name;
        this.code = code;
        this.order = order;
        this.colorCode = colorCode;
        this.studyGuide = studyGuide;
    }

    public Category(String name, String code, int order, String description, boolean active, String iconPath, String colorCode, String studyGuide) {
        this.name = name;
        this.code = code;
        this.order = order;
        this.description = description;
        this.active = active;
        this.iconPath = iconPath;
        this.colorCode = colorCode;
        this.studyGuide = studyGuide;
    }

    public Category(Long id, String name, String code, int order, String description, boolean active, String iconPath, String colorCode, String studyGuide) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.order = order;
        this.description = description;
        this.active = active;
        this.iconPath = iconPath;
        this.colorCode = colorCode;
        this.studyGuide = studyGuide;
    }

    public Category() {}

    public void toggleVisibility() {
        this.active = !isActive();
    }

    public void toMerge(UpdateCategoryForm updateCategoryForm) {
        this.name = updateCategoryForm.getName();
        this.code = updateCategoryForm.getCode();
        this.order = updateCategoryForm.getOrder();
        this.description = updateCategoryForm.getDescription();
        this.active = updateCategoryForm.isActive();
        this.iconPath = updateCategoryForm.getIconPath();
        this.colorCode = updateCategoryForm.getColorCode();
        this.studyGuide = updateCategoryForm.getStudyGuide();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public void setStudyGuide(String studyGuide) {
        this.studyGuide = studyGuide;
    }

    public Long getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Integer getOrder() {
        return order;
    }

    public String getDescription() {
        return description;
    }

    public boolean getActive() {
        return active;
    }

    public String getIconPath() {
        return iconPath;
    }

    public String getColorCode() {
        return colorCode;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", studyGuide='" + studyGuide + '\'' +
                ", active=" + active +
                ", order=" + order +
                ", icon='" + iconPath + '\'' +
                ", color='" + colorCode + '\'' +
                '}';
    }
}
