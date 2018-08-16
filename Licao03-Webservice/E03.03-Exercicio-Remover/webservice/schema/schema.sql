DROP TABLE IF EXISTS lista_espera;

CREATE TABLE lista_espera(
	id int AUTO_INCREMENT PRIMARY KEY,
	nome_reserva varchar(100) NOT NULL,
	total_pessoas int NOT NULL,
	data_cadastro timestamp NOT NULL default current_timestamp
);

INSERT INTO lista_espera(nome_reserva, total_pessoas) VALUES ('José', 10);
INSERT INTO lista_espera(nome_reserva, total_pessoas) VALUES ('Maria', 5);
INSERT INTO lista_espera(nome_reserva, total_pessoas) VALUES ('Marina', 2);
INSERT INTO lista_espera(nome_reserva, total_pessoas) VALUES ('Roberto', 12);
INSERT INTO lista_espera(nome_reserva, total_pessoas) VALUES ('Cláudio', 3);
INSERT INTO lista_espera(nome_reserva, total_pessoas) VALUES ('Roberta', 4);