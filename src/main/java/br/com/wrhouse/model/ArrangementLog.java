package br.com.wrhouse.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "log_arrangement")
public class ArrangementLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "code_id")
    private Code code;

    @Column(name = "physical_value")
    private BigDecimal phyValue;

    @Column(name = "virtual_value")
    private BigDecimal virValue;

    @Column(name = "date")
    private LocalDateTime date;
}
