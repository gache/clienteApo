package fr.bolsadeideas.springboot.backend.apirest.model.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();

	public Page<Cliente> findAll(Pageable pageable);

	public Cliente findByID(Long id);

	public Cliente save(Cliente cliente);

	public void delete(Long id);

}
