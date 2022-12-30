create database Projeto;
use Projeto;

CREATE TABLE usuarios(
Codigo_de_usuario INTEGER NOT NULL PRIMARY KEY,
nome TEXT NOT NULL,
nome_de_usuario TEXT NOT NULL,
senha TEXT NOT NULL
);

/*==========================================*/

CREATE TABLE produtos (
  cod INTEGER NOT NULL PRIMARY KEY,
  nome VARCHAR(50),
  preco DOUBLE,
  validade VARCHAR(8),
  quantidadeEmEstoque INT
);

/*==========================================*/

CREATE TABLE vendas (
  id_venda INTEGER PRIMARY KEY AUTO_INCREMENT,
  data DATETIME DEFAULT CURRENT_TIMESTAMP,
  nome_cliente TEXT NOT NULL,
  cpf_cliente TEXT NOT NULL,
  nome_produto TEXT NOT NULL,
  codigo_produto INTEGER NOT NULL,
  quantidade INTEGER NOT NULL,
  preco_unitario REAL NOT NULL,
  preco_total REAL NOT NULL,
  valor_bruto REAL NOT NULL,
  desconto REAL NOT NULL,
  forma_pagamento TEXT NOT NULL
);

select * from usuarios;
select * from produtos;
select * from vendas;
