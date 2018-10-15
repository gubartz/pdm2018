<?php
// DIC configuration
use GuzzleHttp\Psr7\Request;

$container = $app->getContainer();

// view renderer
$container['renderer'] = function ($c) {
    $settings = $c->get('settings')['renderer'];
    return new Slim\Views\PhpRenderer($settings['template_path']);
};

// monolog
$container['logger'] = function ($c) {
    $settings = $c->get('settings')['logger'];
    $logger = new Monolog\Logger($settings['name']);
    $logger->pushProcessor(new Monolog\Processor\UidProcessor());
    $logger->pushHandler(new Monolog\Handler\StreamHandler($settings['path'], $settings['level']));
    return $logger;
};

//database
$container['db'] = function ($c){
    $db = $c['settings']['db'];
    
    if($db['driver'] == 'mysql'){
        $pdo = new PDO("mysql:host={$db['host']};dbname={$db['dbname']};charset=utf8", $db['user'], $db['pass']);       
    }else{
        $pdo = new PDO("pgsql:host={$db['host']};dbname={$db['dbname']}", $db['user'], $db['pass']);            
    }

    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $pdo->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, PDO::FETCH_ASSOC);

    return $pdo;
};

$container['guzzle'] = function ($c){
    return new GuzzleHttp\Client();
};

$container['fcmRequest'] = function ($c){
    require_once('Notification.class.php');

    $key = $c['settings']['fcm']['key'];

    $headers = array(
            'Content-Type' => 'application/json',
            'Authorization' => "key=$key"
    );

    $notification = new Notification();

    $notification->setTitle('Dados novos');
    $notification->setMessage('Dados novos');
    $notification->setImage('');
    $notification->setAction('');
    $notification->setActionDestination('');

    $requestData = $notification->getNotification();

    $fields = array(
        'to' => '/topics/lista_espera',
        'data' => $requestData,
    ); 

    $request = new Request('POST', 'https://fcm.googleapis.com/fcm/send', $headers, json_encode($fields));

    return $request;
};