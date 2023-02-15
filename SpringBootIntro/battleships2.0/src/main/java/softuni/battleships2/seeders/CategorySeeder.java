package softuni.battleships2.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.battleships2.models.entities.Category;
import softuni.battleships2.models.enums.ShipType;
import softuni.battleships2.repositories.CategoryRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategorySeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.categoryRepository.count() == 0) {
            List<Category> categories = Arrays.stream(ShipType.values())
                    .map(Category::new)
                    .collect(Collectors.toList());

            this.categoryRepository.saveAll(categories);
        }
    }
}
