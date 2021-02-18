package br.com.wrhouse.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "price_list")
public class PriceList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description", length = 100)
    private String description;

}
