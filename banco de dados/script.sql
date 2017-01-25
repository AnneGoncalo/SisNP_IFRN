/**
 * Author:  Fellipe
 * Created: 14/12/2016
 */
 
CREATE DATABASE sisnp;
USE sisnp;

CREATE TABLE discente (
  id int(11) NOT NULL,
  matricula varchar(45) NOT NULL,
  KEY fk_usuario_idx (id),
  CONSTRAINT fk_usuario_discente FOREIGN KEY (id) REFERENCES usuario (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE discente_projeto (
  id_discente int(11) NOT NULL,
  id_projeto int(11) NOT NULL,
  KEY fk_discente_projeto_idx (id_discente),
  KEY fk_projeto_discente_idx (id_projeto),
  CONSTRAINT fk_discente_projeto FOREIGN KEY (id_discente) REFERENCES discente (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_projeto_discente FOREIGN KEY (id_projeto) REFERENCES projeto (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE docente (
  id int(11) NOT NULL,
  siape varchar(45) NOT NULL,
  KEY fk_usuario_docente_idx (id),
  CONSTRAINT fk_usuario_docente FOREIGN KEY (id) REFERENCES usuario (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE docente_projeto (
  id_docente int(11) NOT NULL,
  id_projeto int(11) NOT NULL,
  KEY fk_docente_projeto_idx (id_docente),
  KEY fk_projeto_docente_idx (id_projeto),
  CONSTRAINT fk_docente_projeto FOREIGN KEY (id_docente) REFERENCES docente (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_projeto_docente FOREIGN KEY (id_projeto) REFERENCES projeto (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE projeto (
  id int(11) NOT NULL AUTO_INCREMENT,
  titulo varchar(45) NOT NULL,
  descricao varchar(256) DEFAULT NULL,
  concluido bit(1) DEFAULT NULL,
  id_coordenador int(11) NOT NULL,
  PRIMARY KEY (id),
  KEY fk_coordenador_idx (id_coordenador),
  CONSTRAINT fk_coordenador FOREIGN KEY (id_coordenador) REFERENCES docente (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(45) NOT NULL,
  login varchar(45) NOT NULL,
  senha varchar(45) NOT NULL,
  ativo bit(1) DEFAULT b'1',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE noticia (
	id int(11) NOT NULL AUTO_INCREMENT,
    titulo varchar(45) NOT NULL,
    texto varchar(450) NOT NULL,
    dataPublicacao date NULL,
    id_usuario int,
    PRIMARY KEY (id),
	KEY fk_usuario (id_usuario),
	CONSTRAINT fk_usario FOREIGN KEY (id_usuario) REFERENCES usuario (id) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE atividade(
	id int(11) NOT NULL AUTO_INCREMENT,
    descricao varchar(450) NOT NULL,
    inicio date NULL,
    duracao_estimada int(11) NULL,
    estado int(11) NULL,
    id_autor int,
    id_responsavel int,
    PRIMARY KEY (id),
	KEY fk_usuario_autor (id_autor),
    KEY fk_usuario_responsavel (id_responsavel),
	CONSTRAINT fk_usuario_autor FOREIGN KEY (id_autor) REFERENCES usuario (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT fk_usuario_responsavel FOREIGN KEY (id_responsavel) REFERENCES usuario (id) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE meta(
	id int(11) NOT NULL AUTO_INCREMENT,
    titulo varchar(45) NOT NULL,
    data_alvo date NULL,
    andamento double(3,1) NULL,
    id_projeto int,
    PRIMARY KEY (id),
	KEY fk_meta_projeto (id_projeto),
	CONSTRAINT fk_meta_projeto FOREIGN KEY (id_projeto) REFERENCES projeto (id) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


select * from usuario
inner join docente on docente.id = usuario.id
inner join docente_projeto on docente_projeto.id_docente = docente.id
where docente_projeto.id_projeto = 1 ;

select * from usuario
inner join discente on discente.id = usuario.id
inner join discente_projeto on discente_projeto.id_discente = discente.id
where discente_projeto.id_projeto = 1;

insert into usuario (nome, login, senha) values("Ana", "AnaG", "ana");
insert into discente(discente.id, matricula) values(1, "20151014040002");
insert into docente(id, siape) values(1, "20151014040002");
insert into projeto(projeto.titulo, projeto.descricao, projeto.id_coordenador) 
	values ("Projeto Teste", "Teste de um projeto", 1);
insert into docente_projeto(id_docente, id_projeto) values(1, 1);