<?php

use Slim\Http\Request;
use Slim\Http\Response;

// Routes
$app->get('/lista_espera', function ($request, $response) {

	//TODO(2) Recuperar uma referência da conexão com $this->db
	
	//TODO(3) Consultar a tabela lista_espera e ordenar o resutado por data_cadastro
	//TODO(4) Armazenar cada linha em um vetor

	//TODO(5) Retornar a resposta com $response->withJson
});
