package br.com.wrhouse.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "details", length = 300)
    private String details;

    @Lob
    @Column(name = "data", length = 10000)
    private byte[] data;
}
