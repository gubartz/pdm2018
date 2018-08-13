<?php

use Slim\Http\Request;
use Slim\Http\Response;

// Routes

$app->get('/lista_espera', function ($request, $response) {
	//TODO(2) Recuperar uma referência da conexão com $this->db
	$db = $this->db;

	//TODO(3) Consultar a tabela lista_espera e ordenar o resutado por data_cadastro	
	foreach($db->query('SELECT * FROM lista_espera ORDER BY data_cadastro') as $linha){
		//TODO(4) Armazenar cada linha em um vetor
		
		$retorno[] = $linha;
	};

	//TODO(5) Retornar a resposta com $response->withJson
	return $response->withJson($retorno);
});
