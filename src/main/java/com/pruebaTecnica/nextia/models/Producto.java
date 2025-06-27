package com.pruebaTecnica.nextia.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="productos")
public class Producto {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String decripcion;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "peso")
    private Integer peso;
}
