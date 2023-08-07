CREATE DATABASE IF NOT EXISTS forum;

USE forum;

CREATE TABLE IF NOT EXISTS topicos(
    id bigint not null auto_increment,
    titulo varchar(255) not null,
    mensagem text,
    data_criacao timestamp not null,
    status boolean not null default '1',
    autor varchar(255) not null,
    curso enum('Java', 'MySQL', 'React') not null,
    primary key(id)
);

