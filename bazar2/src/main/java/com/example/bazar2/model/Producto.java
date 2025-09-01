package com.example.bazar2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private double costo;
    private double cant_disponible;


    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, double costo, double cant_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cant_disponible = cant_disponible;
    }


}

