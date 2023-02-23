DROP DATABASE pratica1;
CREATE database pratica1;
USE pratica1;
CREATE TABLE Pessoa (
  cpf BIGINT(12) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  PRIMARY KEY (cpf));