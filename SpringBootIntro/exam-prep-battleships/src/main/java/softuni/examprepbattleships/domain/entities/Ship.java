package softuni.examprepbattleships.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ships")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Long health;

    @Column(nullable = false)
    private Long power;

    @Column(nullable = false)
    private Date created;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;
}
