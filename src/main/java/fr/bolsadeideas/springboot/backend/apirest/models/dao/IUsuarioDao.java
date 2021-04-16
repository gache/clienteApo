package fr.bolsadeideas.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;

@Repository
public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

	public Usuario findByUserName(String username);

	@Query("select u from Usuario u where u.username=?1")
	public Usuario findByUserName2(String username);

}
