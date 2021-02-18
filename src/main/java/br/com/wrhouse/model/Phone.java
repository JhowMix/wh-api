package br.com.wrhouse.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "phone")
public class Phone {

    enum Category {
        CELL, LANDLINE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", length = 15, nullable = false)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", length = 10, nullable = false)
    private Category category;
}
