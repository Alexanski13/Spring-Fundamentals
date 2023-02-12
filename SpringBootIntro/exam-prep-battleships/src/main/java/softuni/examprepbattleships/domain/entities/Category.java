package softuni.examprepbattleships.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.examprepbattleships.domain.enums.CategoryType;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(unique = true, nullable = false)
    private CategoryType name;

    @Column(columnDefinition = "TEXT")
    private String description;
}
