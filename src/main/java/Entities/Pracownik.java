package Entities;

import Entities.Superclass.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dane_pracownika")
public class Pracownik extends BaseEntity {

    @Column(name = "imie", nullable = false, length = 20)
    private String firstName;
    @Column(name = "nazwisko", nullable = false)
    private String lastName;
    @Embedded
    private Dane dane;


}
