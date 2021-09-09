package com.project.DimDim.config;

import com.project.DimDim.model.Cliente;
import com.project.DimDim.model.Endereco;
import com.project.DimDim.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Date;
import java.util.List;

@Configuration
@Profile("test")
@RequiredArgsConstructor()
public class DbInitializer {

    private final ClienteRepository clienteRepository;

    @Bean
    public boolean instantiateDatabase() {
        Cliente cliente = new Cliente(null, "Murilo Pereira da Silva",
                Date.valueOf("24/01/2001"),
                "mu-silva@outlook.com",
                125152512,
                List.of(new Endereco(null, "Rua afonso Celso", 1102, "São Paulo")));

        Cliente cliente2 = new Cliente(null, "Bruno Brito",
                Date.valueOf("04/11/2004"),
                "bruno-brito@outlook.com",
                928901285,
                List.of(new Endereco(null, "Rua brito de fragas", 302, "São Paulo")));

        Cliente cliente3 = new Cliente(null, "Bruno Ermacora",
                Date.valueOf("25/04/1994"),
                "bruno-ermacora@outlook.com",
                692871899,
                List.of(new Endereco(null, "Rua Ermacora", 1702, "São Paulo")));

        clienteRepository.saveAll(List.of(cliente, cliente2, cliente3));

        return false;
    }
}