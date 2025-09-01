package com.example.bazar2.Controller;

import com.example.bazar2.model.Producto;
import com.example.bazar2.Service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @Autowired
    IProductoService prodServ;

    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return prodServ.getProductos();
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){
        return prodServ.findProducto(codigo_producto);
    }

    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto prod){
        prodServ.saveProducto(prod);
        return "Producto creado";
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        prodServ.deleteProducto(codigo_producto);
        return "Producto eliminado";
    }

    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editProducto(@PathVariable Long codigo_producto,
                                 @RequestBody Producto prod){
        prodServ.editProducto(codigo_producto, prod);
        return prodServ.findProducto(codigo_producto);
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> getStock(){
        return prodServ.getStockCinco();
    }
}

