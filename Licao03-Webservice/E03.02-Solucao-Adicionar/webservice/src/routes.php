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
$app->post('/lista_espera', function ($request, $response) {
	//TODO(3) Recuperar o corpo da mensagem com getParsedBody
	$listaEspera = $request->getParsedBody();

	//TODO(4) Criar um vetor apenas com o nome_reserva e total_pessoas dos dados recuperados no passo anterior
	$listaEsperaInsert[] = $listaEspera['nome_reserva'];
	$listaEsperaInsert[] = $listaEspera['total_pessoas'];

	//TODO(5) Recuperar uma conexão ao BD
	$db = $this->db;

	//TODO(6) Criar um prepared statement para inserção de um registro em lista_espera
	$sth = $db->prepare("INSERT INTO lista_espera(nome_reserva, total_pessoas) VALUES (?, ?)");

	//TODO(7) Executar o prepared statement com o vetor criado no passo 4
	try{
		$sth->execute($listaEsperaInsert);
	}catch(PDOException $e){
		return $response->withStatus(404);
	}

	//TODO(8) Recuperar o último ID inserido com lastInsertId
	$lastInsertId = $db->lastInsertId();

	//TODO(9) Realizar uma consulta ao BD utilizando o ID recuperado no passo anterior
	$sth = $db->prepare("SELECT * FROM lista_espera WHERE id = ?");
	
	try{
		$sth->execute(array($lastInsertId));
		$listaEsperaDB = $sth->fetch(PDO::FETCH_OBJ);
	}catch(PDOException $e){
		return $response->withStatus(404);
	}

	//TODO(10) Retornar o registro recuperado do BD
	return $response->withJson($listaEsperaDB);
});