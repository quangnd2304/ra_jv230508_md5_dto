package ra.springboot_dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.springboot_dto.model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Long> {
}
