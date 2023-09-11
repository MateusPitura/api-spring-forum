CREATE DATABASE IF NOT EXISTS forum;

USE forum;

CREATE TABLE IF NOT EXISTS topicos(
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT,
    data_criacao TIMESTAMP NOT NULL,
    status BOOLEAN NOT NULL default '1',
    autor VARCHAR(255) NOT NULL,
    curso ENUM('Java', 'MySQL', 'React') NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS users(
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO users VALUES (DEFAULT, 'admin', 'admin');