package fr.bolsadeideas.springboot.backend.apirest.model.services;

import java.util.List;

import fr.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteService {

    public List<Cliente> findAll();

    public Cliente findByID(Long id);

    public Cliente save(Cliente cliente);

    public void delete(Long id);


}
