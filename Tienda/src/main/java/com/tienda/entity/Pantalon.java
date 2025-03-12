package com.tienda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("PANTALON")
public class Pantalon extends Prenda {

    @Column(name = "pre_tipo_pantalon")
    private String tipoPantalon; // "chupin" o "comun"

    @Override
    public double calcularPrecioFinal() {
        double precioFinal = getPrecioUnitario();

        // Aplicar descuento del 12% si el pantalón es chupín (RN4)
        if ("chupin".equalsIgnoreCase(tipoPantalon)) {
            precioFinal *= 0.88;
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
