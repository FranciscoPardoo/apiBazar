package com.example.bazar2.Controller;

import com.example.bazar2.DTO.VentaClienteDto;
import com.example.bazar2.model.Producto;
import com.example.bazar2.model.Venta;
import com.example.bazar2.Service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {

    @Autowired
    IVentaService venServ;

    @GetMapping("/ventas")
    public List<Venta> getVentas(){
        return venServ.getVentas();
    }

    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta ven){
        venServ.saveVenta(ven);
        return "Venta creada";
    }

    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
        venServ.deleteVenta(codigo_venta);
        return "Venta eliminada";
    }

    @GetMapping("/ventas/{codigo_venta}")
    public Venta findVenta(@PathVariable Long codigo_venta){
        return venServ.findVenta(codigo_venta);
    }

    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editVenta(@PathVariable Long codigo_venta,
                           @RequestBody Venta ven){
        venServ.editVenta(codigo_venta, ven);
        return venServ.findVenta(codigo_venta);
    }

    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getProdVenta(@PathVariable Long codigo_venta){
        return venServ.getProdVenta(codigo_venta);
    }

    @GetMapping("/ventas/fecha/{fecha}")
    public String getCantTotal(@PathVariable LocalDate fecha){
        return venServ.getCantTotal(fecha);
    }

    @GetMapping("/ventas/mayor_venta")
    public VentaClienteDto getMayorVenta(){
        return venServ.getMayorVentaDto();
    }
}

