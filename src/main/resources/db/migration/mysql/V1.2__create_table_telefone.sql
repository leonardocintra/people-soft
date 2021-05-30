CREATE TABLE telefone (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	uuid char(36) NOT NULL,
	pessoa_id bigint(20) NOT NULL,
	area varchar(3) NOT NULL,
	telefone varchar(10) NOT NULL,
	tipo varchar(10) NOT NULL,
	data_criacao DATETIME NOT NULL,
	data_atualizacao DATETIME NOT NULL,
    PRIMARY KEY (id),

    FOREIGN KEY fk_pessoa_telefone(pessoa_id) REFERENCES pessoa(id)
    	ON UPDATE CASCADE
       	ON DELETE RESTRICT
);