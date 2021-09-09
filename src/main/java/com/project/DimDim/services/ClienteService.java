package com.project.DimDim.services;

import com.project.DimDim.exception.ClienteNotFoundException;
import com.project.DimDim.model.Cliente;
import com.project.DimDim.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente save(Cliente cliente){
        if(cliente != null){
            return repository.save(cliente);
        }
        throw new ClienteNotFoundException("Nenhum usuario foi passado no corpo");
    }

    public List<Cliente> findAllClientes(){
        return repository.findAll();
    }

    public Cliente findById(Long id){
        return repository.getById(id);
    }

    public Cliente updateById(Long id, Cliente cliente){
        Cliente searchedClient = findById(id);
        if(searchedClient == null){
            throw new ClienteNotFoundException("Usuario com id " + id + " não existe");
        }
        searchedClient.setEmail(cliente.getEmail());
        searchedClient.setNome(cliente.getNome());
        searchedClient.setTelefone(cliente.getTelefone());
        searchedClient.setDataNascimento(cliente.getDataNascimento());
        return repository.save(searchedClient);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
