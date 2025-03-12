package com.tienda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_prenda", discriminatorType = DiscriminatorType.STRING)
@Table(name = "prendas")
public abstract class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prenda;

    @Column(name = "pre_codigo", nullable = false, length = 20)
    private String codigo;

    @Column(name = "pre_nombre", nullable = false, length = 30)
    private String nombre;

    @Column(name = "pre_precio_unitario", nullable = false)
    private Double precioUnitario;

    @Column(name = "pre_cantidad", nullable = false)
    private Integer cantidadStock;

    private String calidad; // "standard" o "premium"

    public abstract double calcularPrecioFinal();
    
}
