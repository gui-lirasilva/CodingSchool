package br.com.coddingSchool.projections.publicView;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface SubcategoryProjectionView {

    String getName();

    String getCode();

    List<CourseProjectionView> getCourses();

}
