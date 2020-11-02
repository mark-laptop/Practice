package ru.ndg.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Document")
@Table(name = "Document")
@Data
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
    private Date date;

    @OneToOne
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;
}