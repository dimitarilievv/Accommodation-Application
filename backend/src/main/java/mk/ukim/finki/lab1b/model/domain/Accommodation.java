package mk.ukim.finki.lab1b.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.lab1b.model.enumerations.Category;

@Data
@Entity
public class Accommodation {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Host host;
    private Integer numRooms;

    public Accommodation() {
    }

    public Accommodation(String name, Category category, Host host, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
    }
}
