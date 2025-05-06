package com.electroapp.electro_app.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Proveedor")
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "Terceros_Id")
    @JsonBackReference
    Terceros TercerosId;

    @OneToOne
    @JoinColumn(name = "TipoDocumento_id")
    @JsonBackReference
    TiposDocumentos TipoDocumentoId;

    @Embedded
    Audit audit = new Audit();

    @Column(length = 50, nullable = false)
    private String DiasPlazo;

    @Column(length = 50, nullable = false)
    private String PorcentajePronto;
}
