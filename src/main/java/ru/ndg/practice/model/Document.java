package ru.ndg.practice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "Document")
@Table(name = "Document")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "number", length = 20, nullable = false)
    private String number;

    @Column(name = "date", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date date;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (!Objects.equals(id, document.id)) return false;
        if (!Objects.equals(number, document.number)) return false;
        if (!Objects.equals(date, document.date)) return false;
        return Objects.equals(documentType, document.documentType);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (documentType != null ? documentType.hashCode() : 0);
        return result;
    }
}