package ru.ndg.practice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Organization")
@Table(name = "Organization")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "inn", length = 12, nullable = false, unique = true)
    private String inn;

    @Column(name = "kpp", length = 9, nullable = false)
    private String kpp;

    @Column(name = "phone", length = 11)
    private String phone;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
