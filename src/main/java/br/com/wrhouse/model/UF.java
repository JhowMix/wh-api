package br.com.wrhouse.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "uf")
public class UF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", length = 3, nullable = false)
    private String code;

    @Column(name = "name", length = 100, nullable = false)
    private  String name;
}
