/**
 * Author:  Fellipe
 * Created: 14/12/2016
 */

CREATE TABLE `discente` (
  `id` int(11) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  KEY `fk_usuario_idx` (`id`),
  CONSTRAINT `fk_usuario_discente` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `discente_projeto` (
  `id_discente` int(11) NOT NULL,
  `id_projeto` int(11) NOT NULL,
  KEY `fk_discente_projeto_idx` (`id_discente`),
  KEY `fk_projeto_discente_idx` (`id_projeto`),
  CONSTRAINT `fk_discente_projeto` FOREIGN KEY (`id_discente`) REFERENCES `discente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_projeto_discente` FOREIGN KEY (`id_projeto`) REFERENCES `projeto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `docente` (
  `id` int(11) NOT NULL,
  `siape` varchar(45) NOT NULL,
  KEY `fk_usuario_docente_idx` (`id`),
  CONSTRAINT `fk_usuario_docente` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `docente_projeto` (
  `id_docente` int(11) NOT NULL,
  `id_projeto` int(11) NOT NULL,
  KEY `fk_docente_projeto_idx` (`id_docente`),
  KEY `fk_projeto_docente_idx` (`id_projeto`),
  CONSTRAINT `fk_docente_projeto` FOREIGN KEY (`id_docente`) REFERENCES `docente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_projeto_docente` FOREIGN KEY (`id_projeto`) REFERENCES `projeto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `projeto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `descricao` varchar(256) DEFAULT NULL,
  `concluido` bit(1) DEFAULT NULL,
  `id_coordenador` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_coordenador_idx` (`id_coordenador`),
  CONSTRAINT `fk_coordenador` FOREIGN KEY (`id_coordenador`) REFERENCES `docente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `ativo` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;