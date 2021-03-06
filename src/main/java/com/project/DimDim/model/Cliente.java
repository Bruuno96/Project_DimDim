package com.project.DimDim.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@Table(name="TB_DIMDIM_CLIENTE")
@SequenceGenerator(allocationSize = 1, name = "seq_cliente", sequenceName = "SQ_TB_DIMDIM_CLIENTE")
public class Cliente {
	
		@Id
		@Column(name="id_cliente")
		@GeneratedValue(generator = "seq_cliente", strategy = GenerationType.IDENTITY)
		private Long idCliente;
		
		@Column(name="nm_cliente")
		private String nome;
		
		@JsonFormat(pattern = "dd/MM/yyyy")
		@Temporal(TemporalType.DATE)
		@Column(name="dt_nascimento")
		private Date dataNascimento;
		
		@Column(name = "ds_email")
		private String email;
		
		@Column(name="nr_telefone")
		private int telefone;
		
		@OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
		private List<Endereco> enderecos;

	public Cliente(Long idCliente, String nome, Date dataNascimento, String email, int telefone) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
	}

	public Cliente() {
	}
}
