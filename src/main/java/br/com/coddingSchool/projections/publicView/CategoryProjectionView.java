package br.com.coddingSchool.projections.publicView;

import java.util.List;

public interface CategoryProjectionView {

    String getName();

    String getIconPath();

    List<SubcategoryProjectionView> getSubcategories();
}
