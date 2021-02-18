package br.com.wrhouse.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "arrangement")
public class Arrangement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "code_id")
    private Code code;

    @Column(name = "physical_amount")
    private BigDecimal phyAmount;

    @Column(name = "virtual_amount")
    private BigDecimal virtAmount;
}
