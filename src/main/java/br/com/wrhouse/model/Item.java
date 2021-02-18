package br.com.wrhouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "details", length = 300)
    private String details;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measurement_id")
    private Measurement measurement;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Image> images = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Supplier> suppliers = new HashSet<>();

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @JsonProperty
    transient List<PayloadFileWrapper> payload = new ArrayList<>();
}
