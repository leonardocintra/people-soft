CREATE TABLE pessoa (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	uuid char(36) NOT NULL,
	nome varchar(100) NOT NULL,
	cpf varchar(11) NOT NULL UNIQUE,
	sexo char(1) NULL,
	estado_civil varchar(50) NULL,
	data_nascimento DATETIME NULL,
	data_criacao DATETIME NOT NULL,
	data_atualizacao DATETIME NOT NULL,
    PRIMARY KEY (id)
);