<?php

use Slim\Http\Request;
use Slim\Http\Response;

// Routes
//TODO(2) Verifique as alterações realizadas nesta rota
$app->get('/lista_espera', function ($request, $response) {
	$db = $this->db;

	try{
		$sth = $db->prepare('SELECT * FROM lista_espera ORDER BY data_cadastro');
		$sth->execute();
		while($linha = $sth->fetch()){
			$retorno['data'][] = $linha;
		}
		$retorno['message'] = 'Sucesso!';
	}catch(PDOException $e){
		$retorno['data'][] = new stdClass();;
		$retorno['message'] = 'Erro na comunicação!';
	}finally{
		return $response->withJson($retorno);
	}
});

$app->post('/lista_espera', function ($request, $response) {
	$listaEspera = $request->getParsedBody();

	$listaEsperaInsert[] = $listaEspera['nome_reserva'];
	$listaEsperaInsert[] = $listaEspera['total_pessoas'];

	$db = $this->db;

	$sth = $db->prepare("INSERT INTO lista_espera(nome_reserva, total_pessoas) VALUES (?, ?)");

	try{
		$sth->execute($listaEsperaInsert);
	}catch(PDOException $e){
		return $response->withStatus(404);
	}

	$lastInsertId = $db->lastInsertId();

	$sth = $db->prepare("SELECT * FROM lista_espera WHERE id = ?");
	
	try{
		$sth->execute(array($lastInsertId));
		$listaEsperaDB = $sth->fetch(PDO::FETCH_OBJ);
	}catch(PDOException $e){
		return $response->withStatus(404);
	}

	return $response->withJson($listaEsperaDB);
});

$app->delete('/lista_espera/{id}', function ($request, $response, $args) {
	$db = $this->db;

	$id[] = $args['id'];

	$sth = $db->prepare('DELETE FROM lista_espera WHERe id = ?');

	try{
		$sth->execute($id);
	}catch(PDOException $e){
		return $response->withStatus(404);
	}

	return $response->withStatus(200);
});

$app->put('/lista_espera/{id}', function ($request, $response, $args) {
	$db = $this->db;

	$listaEspera = $request->getParsedBody();

	$sth = $db->prepare('UPDATE lista_espera 
											    SET nome_reserva = ?
											      , total_pessoas = ?
											 WHERE id = ?');

	$listaEsperaDB[] = $listaEspera['nome_reserva'];
	$listaEsperaDB[] = $listaEspera['total_pessoas'];
	$listaEsperaDB[] = $args['id'];

	try{
		$sth->execute($listaEsperaDB);
	}catch(PDOException $e){
		return $response->withStatus(404);
	}

	return $response->withStatus(200);
});