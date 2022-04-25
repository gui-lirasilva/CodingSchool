package br.com.coddingSchool.projections.publicView;

import org.springframework.beans.factory.annotation.Value;

public interface CourseProjectionView {

    String getName();

    int getEstimatedTime();
}
