package ru.ndg.practice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Organization")
@Table(name = "Organization")
@Getter
@Setter
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

    @Column(name = "address")
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (isActive != that.isActive) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(version, that.version)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(fullName, that.fullName)) return false;
        if (!Objects.equals(inn, that.inn)) return false;
        if (!Objects.equals(kpp, that.kpp)) return false;
        if (!Objects.equals(phone, that.phone)) return false;
        return Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (inn != null ? inn.hashCode() : 0);
        result = 31 * result + (kpp != null ? kpp.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
