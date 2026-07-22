-- SCHEMA DE OFICINA
CREATE SCHEMA IF NOT EXISTS Oficina;
USE Oficina;

-- TABELA CLIENTES
CREATE TABLE IF NOT EXISTS Clientes (
idCliente INT UNSIGNED NOT NULL AUTO_INCREMENT,
Nome VARCHAR(45),
Celular VARCHAR(45),
Email VARCHAR(45),
DataCadastro DATE,
PRIMARY KEY (idCliente)
)
ENGINE = InnoDB;

-- TABELA MODELO
CREATE TABLE IF NOT EXISTS Modelo (
idModelo INT UNSIGNED NOT NULL AUTO_INCREMENT,
Descricao TEXT,
PRIMARY KEY (idModelo)
)
ENGINE = InnoDB;

-- TABELA COR
CREATE TABLE IF NOT EXISTS Cor (
idCor INT UNSIGNED NOT NULL AUTO_INCREMENT,
Nome VARCHAR(45),
PRIMARY KEY (idCor)
)
ENGINE = InnoDB;

-- TABELA VEICULOS
CREATE TABLE IF NOT EXISTS Veiculos (
idVeiculo INT UNSIGNED NOT NULL AUTO_INCREMENT,
Placa VARCHAR(8),
Observacoes VARCHAR(45),
idCor INT UNSIGNED NOT NULL,
idModelo INT UNSIGNED NOT NULL,
PRIMARY KEY (idVeiculo),
FOREIGN KEY (idCor) REFERENCES Cor (idCor),
FOREIGN KEY (idModelo) REFERENCES Modelo (idModelo)
)
ENGINE = InnoDB;

-- TABELA VEICULOS_DE_CLIENTES
CREATE TABLE IF NOT EXISTS Veiculos_De_Clientes (
idCliente INT UNSIGNED NOT NULL,
idVeiculo INT UNSIGNED NOT NULL,
PRIMARY KEY (idCliente, idVeiculo),
FOREIGN KEY (idCliente) REFERENCES Clientes (idCliente),
FOREIGN KEY (idVeiculo) REFERENCES Veiculos (idVeiculo)
)
ENGINE = InnoDB;

-- INSERINDO DADOS NA TABELA
INSERT INTO Cor (Nome) VALUES ('Azul'), ('Preto'), ('Branco'), ('Cinza'), ('Vermelho');

INSERT INTO Modelo (Descricao) VALUES ('Sedan'), ('Hatch'), ('SUV'), ('Picape'), ('MiniVan');

INSERT INTO Veiculos (Placa, Observacoes, idCor, idModelo)
VALUES  ('ABC1234', 'Ar Condicionado', 1, 1),
		('CFG3346', 'Motor', 2, 2),
		('ERK7893', 'Carburador', 3, 3),
		('RAF4317', 'Revisão', 4, 4),
		('LPS8420', 'Lataria Riscada', 5, 5);
        
INSERT INTO Clientes (Nome) VALUES ('João'), ('Pedro'), ('Vanessa'), ('Rafael'), ('Miguel');

INSERT INTO Clientes (Nome) VALUES ('Carlos');

INSERT INTO Veiculos_De_Clientes (idCliente, idVeiculo) VALUES (1, 1), (2, 2), (3, 3), (4, 4), (5, 5);

-- REMOVER DADOS:
-- 1- Remova linhas da tabela Clientes que não tenham Veículos
SET SQL_SAFE_UPDATES = 0;
DELETE FROM Clientes WHERE Nome = 'Carlos';
SET SQL_SAFE_UPDATES = 1;
-- RESULTADOS:
-- SET SQL_SAFE_UPDATES = 0	0 row(s) affected	0.000 sec
-- DELETE FROM Clientes WHERE Nome = 'Carlos'	1 row(s) affected	0.156 sec
-- SET SQL_SAFE_UPDATES = 1	0 row(s) affected	0.000 sec

-- 2- Remova linhas da tabela Cor que sejam referenciadas na tabela Veiculos
DELETE FROM Cor WHERE idCor = 1;
-- RESULTADO: 
-- DELETE FROM Cor WHERE idCor = 1	Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`oficina`.`veiculos`, CONSTRAINT `veiculos_ibfk_1` FOREIGN KEY (`idCor`) REFERENCES `cor` (`idCor`))	0.375 sec

-- 3- Remova linhas da tabela Modelo que sejam referenciadas na tabela Veiculos
DELETE FROM Modelo WHERE idModelo = 1;
-- RESULTADO: 
-- DELETE FROM Modelo WHERE idModelo = 1	Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`oficina`.`veiculos`, CONSTRAINT `veiculos_ibfk_2` FOREIGN KEY (`idModelo`) REFERENCES `modelo` (`idModelo`))	0.094 sec

-- 4- Remova linhas da tabela Clientes que tenham Veículos.
DELETE FROM Clientes WHERE idCliente = 1;
-- RESULTADO: 
-- DELETE FROM Clientes WHERE idCliente = 1	Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`oficina`.`veiculos_de_clientes`, CONSTRAINT `veiculos_de_clientes_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`))	0.141 sec

-- ON DELETE CASCADE
-- 1. Alterando a tabela Veiculos (Cor e Modelo)
ALTER TABLE Veiculos DROP FOREIGN KEY veiculos_ibfk_1;
ALTER TABLE Veiculos ADD CONSTRAINT fk_cor_cascade 
    FOREIGN KEY (idCor) REFERENCES Cor (idCor) ON DELETE CASCADE;

ALTER TABLE Veiculos DROP FOREIGN KEY veiculos_ibfk_2;
ALTER TABLE Veiculos ADD CONSTRAINT fk_modelo_cascade 
    FOREIGN KEY (idModelo) REFERENCES Modelo (idModelo) ON DELETE CASCADE;

-- 2. Alterando a tabela Veiculos_De_Clientes (Cliente e Veiculo)
ALTER TABLE Veiculos_De_Clientes DROP FOREIGN KEY veiculos_de_clientes_ibfk_1;
ALTER TABLE Veiculos_De_Clientes ADD CONSTRAINT fk_cliente_vinculo_cascade 
    FOREIGN KEY (idCliente) REFERENCES Clientes (idCliente) ON DELETE CASCADE;

ALTER TABLE Veiculos_De_Clientes DROP FOREIGN KEY veiculos_de_clientes_ibfk_2;
ALTER TABLE Veiculos_De_Clientes ADD CONSTRAINT fk_veiculo_vinculo_cascade 
    FOREIGN KEY (idVeiculo) REFERENCES Veiculos (idVeiculo) ON DELETE CASCADE;
    
-- REPETIÇÃO DOS TESTES DE REMOÇÃO:
-- 1- Remova linhas da tabela Clientes que não tenham Veículos
SET SQL_SAFE_UPDATES = 0;
DELETE FROM Clientes WHERE Nome = 'Carlos';
SET SQL_SAFE_UPDATES = 1;
-- RESULTADOS:
-- SET SQL_SAFE_UPDATES = 0	0 row(s) affected	0.000 sec
-- DELETE FROM Clientes WHERE Nome = 'Carlos'	0 row(s) affected	0.000 sec
-- SET SQL_SAFE_UPDATES = 1	0 row(s) affected	0.000 sec

-- 2- Remova linhas da tabela Cor que sejam referenciadas na tabela Veiculos
DELETE FROM Cor WHERE idCor = 1;
-- RESULTADO:
-- DELETE FROM Cor WHERE idCor = 1	1 row(s) affected	0.172 sec

-- 3- Remova linhas da tabela Modelo que sejam referenciadas na tabela Veiculos
DELETE FROM Modelo WHERE idModelo = 1;
-- RESULTADO:
-- DELETE FROM Modelo WHERE idModelo = 1	1 row(s) affected	0.109 sec

-- 4- Remova linhas da tabela Clientes que tenham Veículos.
DELETE FROM Clientes WHERE idCliente = 1;
-- RESULTADO: 
-- DELETE FROM Clientes WHERE idCliente = 1	1 row(s) affected	0.047 sec