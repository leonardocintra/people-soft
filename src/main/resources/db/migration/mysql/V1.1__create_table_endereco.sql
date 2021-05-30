CREATE TABLE endereco (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	uuid char(36) NOT NULL,
	pessoa_id bigint(20) NOT NULL,
	endereco varchar(100) NOT NULL,
	numero varchar(10) NULL,
	bairro varchar(100) NOT NULL,
	cidade varchar(100) NOT NULL,
	uf char(2) NOT NULL,
	cep char(8) NOT NULL,
	complemento varchar(100) NULL,
	referencia varchar(300) NULL,
	data_criacao DATETIME NOT NULL,
	data_atualizacao DATETIME NOT NULL,
    PRIMARY KEY (id),

    FOREIGN KEY fk_pessoa_endereco(pessoa_id) REFERENCES pessoa(id)
    	ON UPDATE CASCADE
       	ON DELETE RESTRICT
);