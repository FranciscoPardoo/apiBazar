package com.example.bazar2.Controller;

import com.example.bazar2.model.Cliente;
import com.example.bazar2.Service.IClienteService;
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
public class ClienteController {

    @Autowired
    IClienteService cliServ;

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return cliServ.getClientes();
    }

    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cli){
        cliServ.saveCliente(cli);
        return "Cliente creado";
    }

    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        cliServ.deleteCliente(id_cliente);
        return "Cliente eliminado";
    }

    @GetMapping("/clientes/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente){
        return cliServ.findCliente(id_cliente);
    }

    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editCliente(@PathVariable Long id_cliente,
                               @RequestBody Cliente cli){
        cliServ.editCliente(id_cliente, cli);
        return cliServ.findCliente(id_cliente);

    }

}

