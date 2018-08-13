<?php
return [
    'settings' => [
        'displayErrorDetails' => true, // set to false in production
        'addContentLengthHeader' => false, // Allow the web server to send the content-length header

        // Renderer settings
        'renderer' => [
            'template_path' => __DIR__ . '/../templates/',
        ],

        // Monolog settings
        'logger' => [
            'name' => 'slim-app',
            'path' => isset($_ENV['docker']) ? 'php://stdout' : __DIR__ . '/../logs/app.log',
            'level' => \Monolog\Logger::DEBUG,
        ],
        
        //Todo(1) Verificar se os dados para conexão ao BD estão corretos.
        //database
        'db' => [
            'host'   => 'localhost',
            'dbname' => 'lista_espera',
            'user'   => 'postgres',
            'pass'   => ''
        ]
    ],
];
