package mk.ukim.finki.lab1b.model.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Host {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    private Country country;

    public Host() {
    }

    public Host(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
