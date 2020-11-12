package ru.ndg.practice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.Objects;

@Entity(name = "User")
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "second_name", length = 50)
    private String secondName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(name = "phone", length = 11)
    private String phone;

    @Column(name = "is_identified")
    private Boolean isIdentified;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "citizenship_id")
    private Citizenship citizenship;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "document_id", unique = true)
    private Document document;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(id, user.id)) return false;
        if (!Objects.equals(firstName, user.firstName)) return false;
        if (!Objects.equals(secondName, user.secondName)) return false;
        if (!Objects.equals(office, user.office)) return false;
        return Objects.equals(position, user.position);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (office != null ? office.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
