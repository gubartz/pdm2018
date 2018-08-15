<?php

use Slim\Http\Request;
use Slim\Http\Response;

// Routes

$app->get('/lista_espera', function ($request, $response) {
	$db = $this->db;

	foreach($db->query('SELECT * FROM lista_espera ORDER BY data_cadastro') as $linha){
		$retorno[] = $linha;
	};

	return $response->withJson($retorno);
});

//TODO(2) Definir uma rota para o método POST lista_espera
	//TODO(3) Recuperar o corpo da mensagem com getParsedBody
	
	//TODO(4) Criar um vetor apenas com o nome_reserva e total_pessoas dos dados recuperados no passo anterior
	
	//TODO(5) Recuperar uma conexão ao BD
	
	//TODO(6) Criar um prepared statement para inserção de um registro em lista_espera
	
	//TODO(7) Executar o prepared statement com o vetor criado no passo 4
	
	//TODO(8) Recuperar o último ID inserido com lastInsertId
	
	//TODO(9) Realizar uma consulta ao BD utilizando o ID recuperado no passo anterior

	//TODO(10) Retornar o registro recuperado do BD