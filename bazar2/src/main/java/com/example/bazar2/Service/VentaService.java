package com.example.bazar2.Service;

import com.example.bazar2.DTO.VentaClienteDto;
import com.example.bazar2.model.Producto;
import com.example.bazar2.model.Venta;
import com.example.bazar2.Repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    IVentaRepository venRepo;

    @Override
    public List<Venta> getVentas() {
        List<Venta> listaVentas = venRepo.findAll();
        return listaVentas;
    }

    @Override
    public void saveVenta(Venta ven) {
        venRepo.save(ven);
    }

    @Override
    public void deleteVenta(Long id) {
        venRepo.deleteById(id);
    }

    @Override
    public Venta findVenta(Long id) {
        return venRepo.findById(id).orElse(null);
    }


    @Override
    public void editVenta(Long id, Venta ven) {
        ven.setCodigo_venta(id);
        this.saveVenta(ven);
    }

    @Override
    public List<Producto> getProdVenta(Long id) {
        Venta listaVenta = this.findVenta(id);
        return listaVenta.getListaProductos();
    }

    @Override
    public String getCantTotal(LocalDate fecha) {

        List<Venta> listaDeVentas = this.getVentas();
        List<Venta> listaCant = new ArrayList<>();

        for(Venta ven : listaDeVentas){
            if(ven.getFecha().equals(fecha)){
                listaCant.add(ven);
            }
        }

        int cantidadVentas = listaCant.size();
        double totalVentas = 0;

        for(Venta ven : listaCant){
            totalVentas = totalVentas + ven.getTotal();
        }
        return "La cantidad de ventas del dia son: " + cantidadVentas + " y el total recaudado del dia es: " + totalVentas;
    }

    @Override
    public VentaClienteDto getMayorVentaDto() {

        VentaClienteDto venCliDto = new VentaClienteDto();

        List<Venta> listaDeVentas = this.getVentas();

        Venta ventaMayor = null;
        double totalMayor= 0.0;

        for(Venta vent : listaDeVentas){
            if(vent.getTotal() > totalMayor){
                totalMayor = vent.getTotal();
                ventaMayor = vent;
            }
        }

        if(ventaMayor != null){
            List<Producto> listaProductos = this.getProdVenta(ventaMayor.getCodigo_venta());

            venCliDto.setTotal(totalMayor);
            venCliDto.setCodigo_venta(ventaMayor.getCodigo_venta());
            venCliDto.setCant_productos(listaProductos.size());
            venCliDto.setNombre_cliente(ventaMayor.getUnCliente().getNombre());
            venCliDto.setApellido_cliente(ventaMayor.getUnCliente().getApellido());
        }

        return venCliDto;
    }

}

