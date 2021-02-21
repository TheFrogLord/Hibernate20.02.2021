package Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable //wbudowywalna - te pola beda czescia klasy person
public class Address {

    // gettery i settery automatycznie
    //laczymy tabele address i person

    @Column(name = "ulica")
    private String street;
    @Column(name = "numer_domu")
    private int houseNumber;
    @Column(name = "numer_mieszkania")
    private int apartmentNumber;
    @Column(name = "numer_pietra")
    private int floorNumber;
}
