package Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PERSON_DATA")
public class Person {

    @Id // musimy nadać identyfikator według wyjątku
    @GeneratedValue // generowanie identyfikatora
    private long id;
    @Column(name = "imie", nullable = true, length = 50) //pozwala na zmiane nazwy kolumny
    private String firstName;
    @Column(name = "nazwisko", nullable = true)
    private String lastName;
    @Column(name = "numer_pesel", nullable = true)
    private long pesel;
    @Column(name = "wiek")
    private int age;
    @Embedded
    private Address address;

}
