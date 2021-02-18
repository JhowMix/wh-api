package br.com.wrhouse.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "code_spec")
public class CodeSpec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

}
