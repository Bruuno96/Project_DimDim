CREATE TABLE tb_dimdim_cliente
(
    id_cliente    NUMBER(38, 0) GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    nm_cliente    VARCHAR2(255),
    dt_nascimento date,
    ds_email      VARCHAR2(255),
    nr_telefone   INTEGER,
    CONSTRAINT pk_tb_dimdim_cliente PRIMARY KEY (id_cliente)
);

CREATE TABLE tb_dimdim_endereco
(
    id_endereco NUMBER(38, 0) GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    ds_rua      VARCHAR2(255),
    nr_numero   INTEGER,
    nm_estado   VARCHAR2(255),
    id_cliente  NUMBER(38, 0),
    CONSTRAINT pk_tb_dimdim_endereco PRIMARY KEY (id_endereco)
);

ALTER TABLE tb_dimdim_endereco
    ADD CONSTRAINT FK_TB_DIMDIM_ENDERECO_ON_ID_CLIENTE FOREIGN KEY (id_cliente) REFERENCES tb_dimdim_cliente (id_cliente);