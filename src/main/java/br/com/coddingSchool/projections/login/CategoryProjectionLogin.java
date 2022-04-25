package br.com.coddingSchool.projections.login;

import java.util.List;

public interface CategoryProjectionLogin {

    String getName();

    String getCode();

    String getIconPath();

    List<SubcategoryProjectionLogin> getSubcategories();
}
