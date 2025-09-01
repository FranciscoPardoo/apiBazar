package com.example.bazar2.Service;

import com.example.bazar2.model.Producto;
import com.example.bazar2.Repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    IProductoRepository prodRepo;

    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = prodRepo.findAll();
        return listaProductos;
    }

    @Override
    public void saveProducto(Producto prod) {
        prodRepo.save(prod);
    }

    @Override
    public void deleteProducto(Long id) {
        prodRepo.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id) {
        return prodRepo.findById(id).orElse(null);
    }

    @Override
    public void editProducto(Long id, Producto prod) {
        prod.setCodigo_producto(id);
        this.saveProducto(prod);
    }

    @Override
    public List<Producto> getStockCinco() {
        List<Producto> listaStock = this.getProductos();
        List<Producto> listaStockMenorCinco = new ArrayList<>();
        for(Producto prod : listaStock){
            if(prod.getCant_disponible() < 5){
                listaStockMenorCinco.add(prod);
            }
        }
        return listaStockMenorCinco;
    }




}

