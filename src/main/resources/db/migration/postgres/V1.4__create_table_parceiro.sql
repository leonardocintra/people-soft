CREATE TABLE parceiro (
	id bigint GENERATED ALWAYS AS IDENTITY,
	uuid char(36) NOT NULL,
	nome varchar(100) NOT NULL,
	data_criacao TIMESTAMP(0) NOT NULL,
	data_atualizacao TIMESTAMP(0) NOT NULL,
    PRIMARY KEY (id)
);