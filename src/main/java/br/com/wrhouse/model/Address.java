package br.com.wrhouse.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "place_desc", length = 100, nullable = false)
    private String placeDesc;

    @Column(name = "district", length = 100, nullable = false)
    private String district;

    @Column(name = "zip_code", length = 8, nullable = false)
    private String zipCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;
}
