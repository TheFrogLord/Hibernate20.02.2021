package Entities.Modelowanie;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class UserDetails {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "nazwa_uzytkownika", nullable = true)
    private String username;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "userDetails")
    private List<Phone> phoneList;
    @ManyToMany
    private List<Vehicles> vehicles;

    @Override
    public String toString() {
        return id + username;
    }
}
