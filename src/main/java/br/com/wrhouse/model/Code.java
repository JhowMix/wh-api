package br.com.wrhouse.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "code")
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "code_spec_id")
    private CodeSpec codeSpec;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(
            name = "name",
            length = 100,
            unique = true,
            nullable = false)
    private String name;
}
