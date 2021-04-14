package fr.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import fr.bolsadeideas.springboot.backend.apirest.model.services.IClienteService;
import fr.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    @Autowired
    private IClienteService iClienteService;

    @GetMapping("/clientes")
    public List<Cliente> index() {
        return iClienteService.findAll();
    }


    @GetMapping("clientes/{id}")
    public Cliente show(@PathVariable Long id) {
        return iClienteService.findByID(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente) {
        return iClienteService.save(cliente);
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente currentCliente = this.iClienteService.findByID(id);
        currentCliente.setNombre(cliente.getNombre());
        currentCliente.setApellido(cliente.getApellido());
        currentCliente.setEmail(cliente.getEmail());
        this.iClienteService.save(currentCliente);
        return currentCliente;
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        iClienteService.delete(id);
    }


}
