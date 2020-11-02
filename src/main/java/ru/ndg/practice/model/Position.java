package ru.ndg.practice.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "Position")
@Table(name = "Position")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
