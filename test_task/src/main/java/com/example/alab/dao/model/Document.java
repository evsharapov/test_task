package com.example.alab.dao.model;

import com.example.alab.config.PostgreSQLEnumType;
import com.example.alab.dto.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@Table(name = "DOCUMENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@TypeDef(name = "document_type", typeClass = PostgreSQLEnumType.class)
public class Document {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Type(type = "document_type")
    @Column(name = "DOCUMENT_TYPE")
    private DocumentType documentType;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "ACTIVE")
    private Boolean active;

}
