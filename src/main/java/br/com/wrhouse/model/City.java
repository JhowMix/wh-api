package br.com.wrhouse.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "city")
@ToString(exclude = {"nome", "microrregiao", "regiaoImediata"})
@JsonIgnoreProperties({"nome", "microrregiao", "regiaoImediata"})
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ibge_code", nullable = false)
    private Long ibgeCode;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Transient
    private String nome;

    @Transient
    private Object microrregiao;

    @Transient
    @JsonAlias("regiao-imediata")
    private Object regiaoImediata;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uf_id")
    private UF uf;
}
