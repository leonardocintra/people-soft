ALTER TABLE pessoa ADD COLUMN email varchar(100);

UPDATE pessoa set email = concat(cpf, '@seminformacao.com.br') where email is null;

ALTER TABLE pessoa ALTER COLUMN email SET NOT NULL;
ALTER TABLE pessoa ADD UNIQUE (email);

