package softuni.battleships2.models.dtos;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import softuni.battleships2.models.enums.ShipType;

import java.time.LocalDate;

public class CreateShipDTO {

    @NotBlank
    @Size(min = 2, max = 10)
    private String name;

    @Positive
    private Long power;

    @Positive
    private Long health;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @Positive
    private Integer category =  -1;

    public CreateShipDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}
