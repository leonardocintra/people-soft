CREATE TABLE telefone (
	id bigint GENERATED ALWAYS AS IDENTITY,
	uuid char(36) NOT NULL,
	pessoa_id bigint NOT NULL,
	area varchar(3) NOT NULL,
	telefone varchar(10) NOT NULL,
	tipo varchar(10) NOT NULL,
	data_criacao TIMESTAMP(0) NOT NULL,
	data_atualizacao TIMESTAMP(0) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_pessoa_telefone
      FOREIGN KEY(pessoa_id)
	  REFERENCES pessoa(id)
	  ON DELETE SET NULL
);