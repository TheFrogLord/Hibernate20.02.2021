package Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Embeddable
public class Dane {

    @Column(name = "staz_pracy", nullable = false)
    private int experience;
    @Column(name = "pensja")
    private BigDecimal salary;
}
