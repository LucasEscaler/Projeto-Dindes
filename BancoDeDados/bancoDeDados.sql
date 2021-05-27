create database db_dindes;

use db_dindes;

create table tb_usuario(
	id bigint auto_increment,
    nome varchar(255) not null,
    data_nasc datetime not null,
    email varchar(255) not null,
    senha varchar(255) not null,
    telefone varchar(255) not null,
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
    tema varchar(255) not null,
    area varchar(255) not null,
    descrição varchar(500),
    primary key (id)
);

create table tb_postagem(
	id bigint auto_increment,
    texto text not null,
    curtida int,
    midia varchar(255),
    vaga boolean not null,
    titulo_vaga varchar(255),
    usuario_id bigint,
    tema_id bigint,
    primary key (id),
    foreign key (usuario_id) references tb_usuario (id),
    foreign key (tema_id) references tb_tema (id)
);
