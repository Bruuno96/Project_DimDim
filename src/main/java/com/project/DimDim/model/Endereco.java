package com.project.DimDim.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="TB_DIMDIM_ENDERECO")
@SequenceGenerator(allocationSize = 1, name = "seq_endereco", sequenceName = "SQ_TB_DIMDIM_ENDERECO")
public class Endereco {
	
	@Id
	@Column(name="id_endereco")
	@GeneratedValue(generator = "seq_endereco")
	private Long idEndereco;
	
	@Column(name="ds_rua")
	private String rua;
	
	@Column(name="nr_numero")
	private int numero;
	
	@Column(name="nm_estado")
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public Endereco(Long idEndereco, String rua, int numero, String estado) {
		this.idEndereco = idEndereco;
		this.rua = rua;
		this.numero = numero;
		this.estado = estado;
	}
}
