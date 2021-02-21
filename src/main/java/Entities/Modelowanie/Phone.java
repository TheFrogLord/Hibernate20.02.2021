package Entities.Modelowanie;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Entity
public class Phone {

    @Id
    @GeneratedValue
    private long id;
    private long phoneNumber;
    @ManyToOne
    private UserDetails userDetails;
}
