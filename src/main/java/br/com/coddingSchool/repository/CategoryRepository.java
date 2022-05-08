package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.projections.CategoryProjection;
import br.com.coddingSchool.projections.login.CategoryProjectionLogin;
import br.com.coddingSchool.projections.publicView.CategoryProjectionView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByOrderByName();

    List<Category> findCategoryByActiveIsTrue();

    @Query("SELECT c FROM Category c ORDER BY c.orderInSystem")
    List<Category> findAllByOrder();

    Optional<Category> findByCode(String code);

    @Query(value = """
    SELECT  ca.name AS name, COUNT(co.id) AS coursesNumber FROM Category ca
    LEFT JOIN Subcategory su ON ca.id = su.category_id
    LEFT JOIN Course co ON su.id = co.subcategory_id
    GROUP BY ca.name
    ORDER BY coursesNumber DESC;
    """, nativeQuery = true)
    List<CategoryProjection> findCategoryAndCourses();

    @Query(value = """
         select distinct c from Category c
         left join fetch c.subcategories s
         left join s.courses x
         where c.active = true and s.active = true and x.visible = true
    """)
    List<CategoryProjectionLogin> categoriesProjectionLoginPage();

    @Query("""
         select distinct c from Category c
         left join fetch c.subcategories s
         left join s.courses x
         where c.code = :code AND c.active = true and s.active = true and x.visible = true
    """)
    Optional<CategoryProjectionView> findCategoryProjectionByCode(String code);

    boolean existsByName(String name);


    boolean existsByCode(String code);

    @Deprecated
    boolean existsByNameAndIdNot(String name, Long id);

    default boolean existsByNameWithDifferentId(String name, Long id) {
        return existsByNameAndIdNot(name, id);
    }

    @Deprecated
    boolean existsByCodeAndIdNot(String code, Long id);

    default boolean existsByCodeWithDifferentId(String code, Long id) {
        return existsByCodeAndIdNot(code, id);
    }
}
