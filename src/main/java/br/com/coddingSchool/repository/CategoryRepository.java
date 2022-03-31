package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
