CREATE TABLE endereco (
	id bigint GENERATED ALWAYS AS IDENTITY,
	uuid char(36) NOT NULL,
	pessoa_id bigint NOT NULL,
	endereco varchar(100) NOT NULL,
	numero varchar(10) NULL,
	bairro varchar(100) NOT NULL,
	cidade varchar(100) NOT NULL,
	uf char(2) NOT NULL,
	cep char(8) NOT NULL,
	complemento varchar(100) NULL,
	referencia varchar(300) NULL,
	data_criacao TIMESTAMP(0) NOT NULL,
	data_atualizacao TIMESTAMP(0) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_pessoa_endereco
      FOREIGN KEY(pessoa_id)
	  REFERENCES pessoa(id)
	  ON DELETE SET NULL
);