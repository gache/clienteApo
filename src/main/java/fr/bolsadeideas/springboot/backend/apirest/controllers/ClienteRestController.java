package fr.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> show(@PathVariable Long id) {

		Cliente cliente = null;
		Map<String, Object> response = new HashMap<String, Object>();

		try {

			cliente = iClienteService.findByID(id);

		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}

		if (cliente == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat("no existe en la base de datos !")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
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
