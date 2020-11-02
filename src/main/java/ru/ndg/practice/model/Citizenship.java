package ru.ndg.practice.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "Citizenship")
@Table(name = "Citizenship")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Citizenship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "code", nullable = false, unique = true)
    private Integer code;
}
