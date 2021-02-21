package Entities.Modelowanie;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "miasto", nullable = true)
    private String city;
    @Column(name = "ulica", nullable = true)
    private String street;
    @OneToOne(mappedBy = "address")
    private UserDetails userDetails;

    @Override
    public String toString() {
        return id + city + street;
    }
}
