DROP TABLE IF EXISTS lista_espera;

CREATE TABLE lista_espera(
	id serial PRIMARY KEY,
	nome_reserva varchar NOT NULL,
	total_pessoas int NOT NULL,
	data_cadastro timestamp NOT NULL default current_timestamp
);

--Dados para teste inicial
INSERT INTO lista_espera VALUES (DEFAULT, 'José', 10);
INSERT INTO lista_espera VALUES (DEFAULT, 'Maria', 5);
INSERT INTO lista_espera VALUES (DEFAULT, 'Marina', 2);
INSERT INTO lista_espera VALUES (DEFAULT, 'Roberto', 12);
INSERT INTO lista_espera VALUES (DEFAULT, 'Cláudio', 3);
INSERT INTO lista_espera VALUES (DEFAULT, 'Roberta', 4);