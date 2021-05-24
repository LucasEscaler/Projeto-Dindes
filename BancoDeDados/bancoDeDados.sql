create database db_dindes;

use db_dindes;

create table tb_usuario(
	id bigint auto_increment,
    nome varchar(255) not null,
    idade int not null,
    email varchar(255) not null,
    senha varchar(255) not null,
    area varchar(255),
    sobre varchar(1000),
    dinde boolean not null,
    foto varchar(255),
    dinde_id bigint,
    primary key (id),
    foreign key (dinde_id) references tb_usuario (id)
);

create table tb_tema(
	id bigint auto_increment,
    nome varchar(255) not null,
    area varchar(255) not null,
    experiencia varchar(255),
    primary key (id)
);

create table tb_postagem(
	id bigint auto_increment,
    texto varchar(1000) not null,
    curtida int,
    foto varchar(255),
    vaga boolean not null,
    titulo_vaga varchar(255),
    usuario_id bigint,
    tema_id bigint,
    primary key (id),
    foreign key (usuario_id) references tb_usuario (id),
    foreign key (tema_id) references tb_tema (id)
);
