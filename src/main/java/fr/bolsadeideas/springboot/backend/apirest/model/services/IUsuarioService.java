package fr.bolsadeideas.springboot.backend.apirest.model.services;

import fr.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);

}
