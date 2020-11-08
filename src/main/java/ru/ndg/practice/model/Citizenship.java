package ru.ndg.practice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Citizenship")
@Table(name = "Citizenship")
@Getter
@Setter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Citizenship that = (Citizenship) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }
}
