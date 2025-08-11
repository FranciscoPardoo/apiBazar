
package com.example.bazar.service;

import com.example.bazar.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public List<Producto> getProductos();
    
    public void saveProducto( Producto prod);
    
    public void deleteProducto (Long id);
    
    public Producto findProducto(Long id);
    
    public void editProducto(Long id, Producto prod);
    
    public List<Producto> getStockCinco();
    
}
