package com.example.bazar2.Service;

import com.example.bazar2.model.Cliente;
import com.example.bazar2.Repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    IClienteRepository cliRepo;

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> listaClientes = cliRepo.findAll();
        return listaClientes;
    }

    @Override
    public void saveCliente(Cliente cli) {
        cliRepo.save(cli);
    }

    @Override
    public void deleteCliente(Long id) {
        cliRepo.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        return cliRepo.findById(id).orElse(null);
    }

    @Override
    public void editCliente(Long id, Cliente cli) {
        cli.setId_cliente(id);
        this.saveCliente(cli);
    }



}