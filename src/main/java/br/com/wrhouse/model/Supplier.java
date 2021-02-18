package br.com.wrhouse.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@DynamicUpdate
@NoArgsConstructor
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "cnpj", nullable = false, length = 14)
    private String cnpj;

    @Column(name = "state_sub", nullable = false, length = 15)
    private String stateSub;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Phone> phones = new HashSet<>();

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Address> addresses = new HashSet<>();

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
