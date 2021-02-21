package Entities.Modelowanie;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Vehicles {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "nazwa_pojazdu")
    private String name;
    @ManyToMany(mappedBy = "vehicles")
    private List<UserDetails> userDetailsList;

}
