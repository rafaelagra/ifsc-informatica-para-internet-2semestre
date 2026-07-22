CREATE SCHEMA IF NOT EXISTS Oficina;
USE Oficina;

-- LIMPANDO DADOS DE TESTES ANTERIORES
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE Veiculos_De_Clientes;
TRUNCATE TABLE Veiculos;
TRUNCATE TABLE Clientes;
TRUNCATE TABLE Cor;
TRUNCATE TABLE Modelo;
SET FOREIGN_KEY_CHECKS = 1;

-- Populando tabelas de apoio (cores e modelos)
INSERT INTO Cor (idCor, Nome) VALUES 
(1, 'Azul'), (2, 'Preto'), (3, 'Branco'), (4, 'Cinza'), (5, 'Vermelho');    

INSERT INTO Modelo (idModelo, Descricao) VALUES 
(1, 'Sedan'), (2, 'Hatch'), (3, 'SUV'), (4, 'Picape'), (5, 'MiniVan');

-- INCLUINDO DEZ CLIENTES
INSERT INTO Clientes (idCliente, Nome) VALUES 
(1, 'João'), (2, 'Pedro'), (3, 'Vanessa'), (4, 'Rafael'), (5, 'Miguel'),
(6, 'Fabio'), (7, 'Gisele'), (8, 'Heitor'), (9, 'Igor'), (10, 'Julia');

-- INCLUINDO VEÍCULOS
INSERT INTO Veiculos (idVeiculo, Placa, idCor, idModelo) VALUES 
(1, 'BRA2E26', 1, 1), (2, 'FLN0484', 2, 2), (3, 'SC2026X', 3, 3), 
(4, 'WEB1010', 4, 4), (5, 'SQL5050', 5, 5), (6, 'JOIN999', 1, 2),
(7, 'ABC1111', 2, 1), (8, 'XYZ2222', 3, 2), (9, 'KJM3333', 4, 3),
(10, 'LPO4444', 5, 4), (11, 'MHT5555', 2, 1);

-- VINCULANDO VEÍCULOS AOS CLIENTES
-- Critério: 5 clientes com SOMENTE UM veículo (IDs 1, 2, 3, 4, 5)
INSERT INTO Veiculos_De_Clientes (idCliente, idVeiculo) VALUES 
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5);

-- Critério: 3 clientes com MAIS DE UM veículo (IDs 6, 7 e 8)
INSERT INTO Veiculos_De_Clientes (idCliente, idVeiculo) VALUES 
(6, 6), (6, 7),  -- Cliente 6 com 2 veículos
(7, 8), (7, 9),  -- Cliente 7 com 2 veículos
(8, 10), (8, 11); -- Cliente 8 com 2 veículos

-- Critério: 2 clientes não devem ter veículo nenhum (IDs 9 e 10)
-- Não inseri registros para eles na tabela de ligação

-- CONSULTAS SQL

-- CASO 1: Lista de clientes e seus veículos
-- 1.1 Ordem alfabética
SELECT c.Nome, v.Placa 
FROM Clientes c
INNER JOIN Veiculos_De_Clientes vc ON c.idCliente = vc.idCliente
INNER JOIN Veiculos v ON vc.idVeiculo = v.idVeiculo
ORDER BY c.Nome ASC;

-- 1.2 Nome e placa apenas
SELECT c.Nome, v.Placa 
FROM Clientes c
INNER JOIN Veiculos_De_Clientes vc ON c.idCliente = vc.idCliente
INNER JOIN Veiculos v ON vc.idVeiculo = v.idVeiculo;

-- 1.3 Sem repetições e com número de veículos (Mostra também quem tem 0)
SELECT c.Nome, COUNT(vc.idVeiculo) AS Numero_de_Veiculos
FROM Clientes c
LEFT JOIN Veiculos_De_Clientes vc ON c.idCliente = vc.idCliente
GROUP BY c.Nome;

-- CASO 2: Lista completa de Veículos com Cor e Modelo
-- 2.1 e 2.2 Dados amigáveis, com ID e ordenado por Modelo
SELECT v.idVeiculo, v.Placa, m.Descricao AS Modelo, co.Nome AS Cor
FROM Veiculos v
INNER JOIN Modelo m ON v.idModelo = m.idModelo
INNER JOIN Cor co ON v.idCor = co.idCor
ORDER BY m.Descricao;

-- CASO 3: Clientes, seus Veículos e Características
-- 3.1 Dados amigáveis
SELECT c.Nome AS Proprietario, v.Placa, m.Descricao AS Modelo, co.Nome AS Cor
FROM Clientes c
INNER JOIN Veiculos_De_Clientes vc ON c.idCliente = vc.idCliente
INNER JOIN Veiculos v ON vc.idVeiculo = v.idVeiculo
INNER JOIN Modelo m ON v.idModelo = m.idModelo
INNER JOIN Cor co ON v.idCor = co.idCor;

-- 3.2 Listar somente Veículos de um determinado Modelo 
SELECT c.Nome, v.Placa, m.Descricao AS Modelo
FROM Clientes c
INNER JOIN Veiculos_De_Clientes vc ON c.idCliente = vc.idCliente
INNER JOIN Veiculos v ON vc.idVeiculo = v.idVeiculo
INNER JOIN Modelo m ON v.idModelo = m.idModelo
WHERE m.Descricao = 'Sedan';

-- 3.3 Listar somente Veículos de uma determinada Cor 
SELECT c.Nome, v.Placa, co.Nome AS Cor
FROM Clientes c
INNER JOIN Veiculos_De_Clientes vc ON c.idCliente = vc.idCliente
INNER JOIN Veiculos v ON vc.idVeiculo = v.idVeiculo
INNER JOIN Cor co ON v.idCor = co.idCor
WHERE co.Nome = 'Preto';