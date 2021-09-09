package com.project.DimDim.services;

import com.project.DimDim.exception.EnderecoNotFoundException;
import com.project.DimDim.model.Endereco;
import com.project.DimDim.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EndereçoRepository {

    @Autowired
    private EnderecoRepository repository;

    public Endereco save(Endereco endereco){
        if(endereco != null){
            return repository.save(endereco);
        }
        throw new EnderecoNotFoundException("Nenhum endereço foi passado no corpo");
    }

    public List<Endereco> findAllEnderecos(){
        return repository.findAll();
    }

    public Endereco findById(Long id){
        return repository.getById(id);
    }

    public Endereco updateById(Long id, Endereco endereco){
        Endereco searchedEndereco = findById(id);
        if(searchedEndereco == null){
            throw new EnderecoNotFoundException("Endereço com id " + id + " não existe");
        }
        searchedEndereco.setEstado(endereco.getEstado());
        searchedEndereco.setNumero(endereco.getNumero());
        searchedEndereco.setRua(endereco.getRua());
        return repository.save(searchedEndereco);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
