package com.project.DimDim;

import com.project.DimDim.model.Cliente;
import com.project.DimDim.model.Endereco;
import com.project.DimDim.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Date;
import java.util.List;

@SpringBootApplication(scanBasePackages = { "com.project.DimDim" })
@ComponentScan({ "com.project.DimDim.repository" })
public class DimDimApplication {
	public static void main(String[] args) {
		SpringApplication.run(DimDimApplication.class, args);
	}
}
