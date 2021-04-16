package fr.bolsadeideas.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import fr.bolsadeideas.springboot.backend.apirest.models.entity.Region;

@Repository
public interface IClienteDao extends JpaRepository<Cliente, Long> {
	
	@Query("from Region")
	public List<Region> findAllRegiones();

}
