USE Oficina;
-- ----------------------------------------------------------------------------------------
-- Criação das Novas Tabelas
-- ----------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Servicos (
idServico INT UNSIGNED NOT NULL AUTO_INCREMENT, 
Descricao VARCHAR(100) NOT NULL, -- texto de até 100 caracteres que descreve o serviço
ValorAtual DECIMAL(10,2) NOT NULL, -- número com até 10 dígitos, com 2 depois da vírgula.
PRIMARY KEY(idServico) -- identificador único de cada serviço
);

CREATE TABLE IF NOT EXISTS Ordem_Servicos (
idOrdemServico INT UNSIGNED NOT NULL AUTO_INCREMENT,
Numero VARCHAR(10) NOT NULL, -- número da ordem de serviço como texto
DataRealizacao DATE NOT NULL, -- data do serviço
Desconto DECIMAL(5,2) DEFAULT 0.00, -- percentual de desconto
idVeiculo INT UNSIGNED NOT NULL, -- qual veículo recebeu o serviço (liga com a tabela veículos)
PRIMARY KEY (idOrdemServico), --
UNIQUE KEY uk_numero (numero) -- garante que não terá 2 numeros de ordem de serviço iguais
);

CREATE TABLE IF NOT EXISTS Itens_servico (
idOrdemServico INT UNSIGNED NOT NULL,
idServico INT UNSIGNED NOT NULL,
ValorPraticado DECIMAL(10,2) NOT NULL, -- valor do serviço no momento da contratação
Observacoes TEXT, -- campo para anotações
PRIMARY KEY (idOrdemServico, idServico) -- formam a chave que liga as duas tabelas
);

-- ----------------------------------------------------------------------------------------------
-- Implementação dos Relacionamentos
-- ----------------------------------------------------------------------------------------------

-- Criei a chave estrangeira entre Ordem_servicos e Veiculos
ALTER TABLE Ordem_Servicos
ADD CONSTRAINT fk_ordem_veiculo
FOREIGN KEY (idVeiculo) REFERENCES Veiculos (idVeiculo);

-- Criei as chaves estrangeiras para Itens_servico 

-- Ligação com Ordem_servicos
ALTER TABLE Itens_servico
ADD CONSTRAINT fk_item_ordem
FOREIGN KEY (idOrdemServico) REFERENCES Ordem_servicos (idOrdemServico);

-- Ligação com Servicos
ALTER TABLE Itens_servico
ADD CONSTRAINT fk_item_servico
FOREIGN KEY (idServico) REFERENCES Servicos (idServico);

-- -----------------------------------------------------------------------------------------------
-- Inserção de Dados de Teste
-- -----------------------------------------------------------------------------------------------

-- Inseri serviços disponíveis
INSERT INTO Servicos (Descricao, ValorAtual) VALUES
('Lavar automóvel - serviço completo externo e interno', 30.00),
('Lavar SUV - Serviço completo para veículos grandes', 50.00),
('Troca de óleo - Óleo sintético 5W30', 120.00),
('Alinhamento e balanceamento', 89.90),
('Revisão preventiva - 10 itens de segurança', 199.00),
('Polimento e cristalização', 250.00);

-- Verificando quais veículos existem
SELECT idVeiculo, Placa FROM Veiculos;

-- Inserindo Ordens de Serviço
INSERT INTO Ordem_Servicos (Numero, DataRealizacao, Desconto, idVeiculo) VALUES
('001','2025-11-20', 0.00, 1),
('002','2025-11-25', 10.00, 2),
('003','2025-12-01', 5.00, 9),
('004','2025-12-10', 0.00, 3),
('005','2025-12-15', 15.00, 4),
('006','2026-01-05', 0.00, 5),
('007','2026-01-10', 20.00, 10),
('008','2026-01-15', 0.00, 6),
('009','2026-01-20', 10.00, 7),
('0010','2026-01-25', 0.00, 8);

-- Inserindo os Itens (serviços) de cada ordem de serviço

-- OS 0001 (veículo 1) - Serviço de lavagem simples
INSERT INTO Itens_servico (idOrdemServico, idServico, valorPraticado, Observacoes) VALUES
(1, 1, 30.00, 'Usar sabão neutro, secar com pano macio');

-- OS 0002 (veículo 2) - Serviço de lavagem SUV
INSERT INTO Itens_servico (idOrdemServico, idServico, valorPraticado, Observacoes) VALUES
(2, 2, 50.00, 'secar na sombra, atenção aos vidros');

-- OS 0003 (veículo 1) - Múltiplos serviços: lavagem + troca de óleo
INSERT INTO Itens_servico (idOrdemServico, idServico, valorPraticado, Observacoes) VALUES
(3, 1, 30.00, 'Cliente solicitou cera adicional'),
(3, 3, 120.00, 'Óleo recomendado pelo fabricante');

-- OS 0004 (veículo 3) - Alinhamento e balanceamento
INSERT INTO Itens_servico (idOrdemServico, idServico, valorPraticado, Observacoes) VALUES
(4, 4, 89.90, 'Verificar calibragem dos pneus');

-- OS 0005 (veículo 4) - Revisão completa
INSERT INTO Itens_servico (idOrdemServico, idServico, valorPraticado, Observacoes) VALUES
(5, 5, 199.00, 'Inclui troca de filtros');

-- OS 0006 (veículo 5) - Polimento
INSERT INTO Itens_servico (idOrdemServico, idServico, valorPraticado, Observacoes) VALUES
(6, 6, 250.00,'Cliente com pressa, Priorizar');

-- OS 0007 (veículo 1) - Lavagem e revisão
INSERT INTO Itens_servico (idOrdemServico, idServico, valorPraticado, Observacoes) VALUES
(7, 1, 30.00, 'Lavagem Simples'),
(7, 5, 199.00, 'Revisão dos 20.000km');

-- OS 0008 (veículo 6) - Troca de óleo e alinhamento
INSERT INTO Itens_servico (idOrdemServico, idServico, valorPraticado, Observacoes) VALUES
(8, 3, 120.00, 'Óleo Sintético'),
(8, 4, 89.90, 'Alinhar e balancear');

-- OS 0009 (veículo 7) - Apenas lavagem SUV
INSERT INTO Itens_servico (idOrdemServico, idServico, valorPraticado, Observacoes) VALUES
(9, 2, 50.00, 'Veículo muito sujo');

-- OS 0010 (veículo 8) - Revisão e polimento
INSERT INTO Itens_servico (idOrdemServico, idServico, valorPraticado, Observacoes) VALUES
(10, 5, 199.00, 'Revisão Completa'),
(10, 6, 250.00, 'Polimento com cristalização');

-- ---------------------------------------------------------------------------------------------
--  Casos de Uso (Consultas)
-- ---------------------------------------------------------------------------------------------

-- Caso 1: Mostrar todos os Serviços de uma Ordem de Serviço
SELECT -- escolhe quais colunas mostrar
	os.Numero AS 'Número OS',
    os.DataRealizacao AS 'Data',
    s.Descricao AS 'Serviço',
    it.ValorPraticado AS 'Valor Cobrado',
    it.Observacoes AS 'Observações'
FROM Ordem_Servicos os -- começa pela tabela de ordem_servicos (apelidada de "os")
INNER JOIN Itens_servico it ON os.idOrdemServico = it.idOrdemServico -- conecta as tabelas através das chaves
INNER JOIN Servicos s ON it.idServico = s.idServico -- conecta as tabelas através das chaves
WHERE os.Numero = '003'; -- filtra apenas a OS com número '0003'

-- Caso 2: Listar todas Ordens de Serviço de um determinado Veículo
SELECT
	v.Placa AS 'Placa',
    os.Numero AS 'Numero OS',
    os.DataRealizacao AS 'Data',
    os.Desconto AS 'Desconto(%)',
    COUNT(it.idServico) AS 'Qtd Serviços' -- conta quantos serviços tem em cada OS
FROM Veiculos v
INNER JOIN Ordem_Servicos os ON v.idVeiculo = os.idVeiculo
LEFT JOIN Itens_servico it ON os.idOrdemServico = it.idOrdemServico -- LEFT JOIN - garante que apareça mesmo se não houver itens
WHERE v.Placa = 'BRA2E26'
GROUP BY os.idOrdemServico; -- agrupa por OS para o COUNT funcionar

-- Caso 3: Listar todas as Ordens de Serviço de um determinado Cliente
SELECT
	c.Nome AS 'Cliente',
    v.Placa AS 'Veículo',
    os.Numero AS 'Número OS',
    os.DataRealizacao AS 'Data',
    os.Desconto AS 'Desconto(%)'
FROM Clientes c
INNER JOIN Veiculos_De_Clientes vc ON c.idCliente = vc.idCliente
INNER JOIN Veiculos v ON vc.idVeiculo = v.idVeiculo
INNER JOIN Ordem_Servicos os ON v.idVeiculo = os.idVeiculo
WHERE c.Nome = 'João'
ORDER BY os.DataRealizacao DESC; --  mostra as mais recentes primeiro

-- Caso 4: Calcular o valor total de uma Ordem de Serviço
SELECT
	os.Numero AS 'Número OS',
    SUM(it.ValorPraticado) AS 'Subtotal (R$)', -- soma todos os valores dos serviços
    os.Desconto AS 'Desconto (%)',
    ROUND(SUM(it.ValorPraticado) * (1 - os.Desconto/100), 2) AS 'Total com Desconto (R$)' -- (1 - os.Desconto/100) - converte desconto em multiplicador (ex: 10% vira 0.9)
FROM Ordem_Servicos os
INNER JOIN Itens_servico it ON os.idOrdemServico = it.idOrdemServico
WHERE os.Numero = '007'
GROUP BY os.idOrdemServico;

-- Caso 5: Listar todos os Clientes que nunca realizaram nenhum serviço
SELECT 
	c.idCliente,
    c.Nome,
    c.Celular,
    c.Email
FROM Clientes c 
LEFT JOIN Veiculos_De_Clientes vc ON c.idCliente = vc.idCliente
LEFT JOIN Veiculos v ON vc.idVeiculo = v.idVeiculo
LEFT JOIN Ordem_Servicos os ON v.idVeiculo = os.idVeiculo
WHERE os.idOrdemServico IS NULL
GROUP BY c.idCliente;

-- -----------------------------------------------------------------------------------------------------
-- Verificação e Validação
-- -----------------------------------------------------------------------------------------------------

-- Verifiquei se as tabelas foram criadas.
SHOW TABLES;

-- Verifiquei a estrutura de uma tabela
DESCRIBE Servicos;
DESCRIBE Ordem_Servicos;
DESCRIBE Itens_servico;

-- Verifiquei os relacionamentos
SELECT
	TABLE_NAME,
    CONSTRAINT_NAME,
    COLUMN_NAME,
    REFERENCED_TABLE_NAME,
    REFERENCED_COLUMN_NAME
FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE TABLE_SCHEMA = 'Oficina'
AND REFERENCED_TABLE_NAME IS NOT NULL;