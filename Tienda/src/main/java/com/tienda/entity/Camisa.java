package com.tienda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("CAMISA")
public class Camisa extends Prenda {
    
    @Column(name = "pre_tipo_manga")
    private String tipoManga; // "corta" o "larga"
    
    @Column(name = "pre_tipo_cuello")
    private String tipoCuello; // "mao" o "comun"
    
    @Override
    public double calcularPrecioFinal() {
        double precioFinal = getPrecioUnitario();

        // Aplicar descuento del 10% si la manga es corta (RN1)
        if ("corta".equalsIgnoreCase(tipoManga)) {
            precioFinal *= 0.9;
        }

        // Aplicar aumento del 3% si el cuello es mao (RN2)
        if ("mao".equalsIgnoreCase(tipoCuello)) {
            precioFinal *= 1.03;
        }

        // Aplicar aumento según la calidad (RN5 y RN6)
        if ("standard".equalsIgnoreCase(getCalidad())) {
            precioFinal *= 1.02; // Aumento del 2% para calidad estándar
        } else if ("premium".equalsIgnoreCase(getCalidad())) {
            precioFinal *= 1.15; // Aumento del 15% para calidad premium
        }

        return precioFinal;
    }

}
