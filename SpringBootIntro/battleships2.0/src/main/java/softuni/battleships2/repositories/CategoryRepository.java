package softuni.battleships2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.battleships2.models.entities.Category;
import softuni.battleships2.models.enums.ShipType;

@Repository
public interface CategoryRepository extends JpaRepository<Category,  Long> {
    Category findByName(ShipType name);
}
