package com.coddingSchool.builders;

import com.coddingSchool.model.Course;
import com.coddingSchool.model.Subcategory;

public class CourseBuilder {

    private String name;
    private String code;
    private int estimatedTime;
    private Boolean visible = false;
    private String target;
    private String instructor;
    private String description;
    private String developedSkills;
    private Subcategory subcategory;

    public CourseBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CourseBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public CourseBuilder withEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
        return this;
    }

    public CourseBuilder withVisible(Boolean visible) {
        this.visible = visible;
        return this;
    }

    public CourseBuilder withTarget(String target) {
        this.target = target;
        return this;
    }

    public CourseBuilder withInstructor(String instructor) {
        this.instructor = instructor;
        return this;
    }

    public CourseBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public CourseBuilder withDevelopedSkills(String developedSkills) {
        this.developedSkills = developedSkills;
        return this;
    }

    public CourseBuilder withSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
        return this;
    }

    public Course completeBuild() {
        return new Course(name, code, estimatedTime, visible, target, instructor, description, developedSkills, subcategory);
    }

    public Course build() {
        return new Course(name, code, estimatedTime, visible, instructor, subcategory);
    }
}
