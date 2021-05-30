CREATE TABLE pessoa (
	id bigint GENERATED ALWAYS AS IDENTITY,
	uuid char(36) NOT NULL,
	nome varchar(100) NOT NULL,
	cpf varchar(11) NOT NULL UNIQUE,
	sexo char(1) NULL,
	estado_civil varchar(50) NULL,
	data_nascimento TIMESTAMP(0) NULL,
	data_criacao TIMESTAMP(0) NOT NULL,
	data_atualizacao TIMESTAMP(0) NOT NULL,
    PRIMARY KEY (id)
);