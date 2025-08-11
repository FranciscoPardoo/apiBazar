
package com.example.bazar.service;

import com.example.bazar.DTO.VentaClienteDto;
import com.example.bazar.model.Producto;
import com.example.bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    public List<Venta> getVentas();
    
    public void saveVenta(Venta ven);
    
    public void deleteVenta(Long id);
    
    public Venta findVenta(Long id);
    
    public void editVenta(Long id, Venta ven);
    
    public List<Producto> getProdVenta(Long id);
    
    public String getCantTotal(LocalDate fecha);
    
    public VentaClienteDto getMayorVentaDto();
}
