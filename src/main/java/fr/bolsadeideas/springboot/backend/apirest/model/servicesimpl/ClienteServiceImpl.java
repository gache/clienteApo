package fr.bolsadeideas.springboot.backend.apirest.model.servicesimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.bolsadeideas.springboot.backend.apirest.model.services.IClienteService;
import fr.bolsadeideas.springboot.backend.apirest.models.dao.IClienteDao;
import fr.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public Cliente findByID(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

}
