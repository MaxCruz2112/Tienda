package com.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vendedores")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vendedor;
    
    @Column(name = "credencial", nullable = false, length = 20, unique = true)
    private String credencial;
    
    @Column(name = "ven_nombre", nullable = false, length = 30)
    private String nombre;

    @Column(name = "ven_apellido", nullable = false, length = 30)
    private String apellido;

    @Column(name = "ven_codigo", nullable = false, length = 20)
    private String codigo;

}
