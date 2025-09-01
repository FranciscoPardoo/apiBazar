package com.example.bazar2.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaClienteDto {

    private Long codigo_venta;
    private double total;
    private int cant_productos;
    private String nombre_cliente;
    private String apellido_cliente;

    public VentaClienteDto() {
    }

    public VentaClienteDto(Long codigo_venta, double total, int cant_productos, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cant_productos = cant_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }



}
