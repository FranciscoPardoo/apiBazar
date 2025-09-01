package com.example.bazar2.Service;

import com.example.bazar2.model.Cliente;
import java.util.List;


public interface IClienteService {

    public List<Cliente> getClientes();

    public void saveCliente(Cliente cli);

    public void deleteCliente(Long id);

    public Cliente findCliente(Long id);

    public void editCliente(Long id, Cliente cli);
}
