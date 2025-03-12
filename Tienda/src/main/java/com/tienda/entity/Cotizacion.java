package com.tienda.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cotizaciones")
public class Cotizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cotizacion;

    @Column(name = "cot_codigo", nullable = false, unique = true)
    private String codigo;

    @Column(name = "cot_fecha", nullable = false)
    private LocalDate fechaCotizacion;

    @ManyToOne
    @JoinColumn(name = "id_vendedor", nullable = false)
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal sucursal;
    
    @OneToMany(mappedBy = "cotizacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCotizacion> detalles;
    
    public Cotizacion() {
        this.codigo = generateCodigo();  // Generamos el código automáticamente
    }

    private String generateCodigo() {
        // Ejemplo de código basado en UUID
        return UUID.randomUUID().toString();  // O lógica de generación personalizada
    }
    
    // Método para calcular el total de la cotización
    public double calcularTotal() {
        return detalles.stream()
                .mapToDouble(DetalleCotizacion::getSubtotal)
                .sum();
    }
    
}
