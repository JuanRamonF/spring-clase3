CREATE TABLE usuario (usuario_id INT NULL,email VARCHAR(50) NULL, password VARCHAR(50) NULL ,nombre VARCHAR(50) NOT NULL,PRIMARY KEY (usuario_id));

INSERT INTO usuario(usuario_id, nombre,email, password) VALUES (1, 'Juan Perez','juanperez@email.com', '123');
INSERT INTO usuario(usuario_id, nombre,email, password) VALUES (2, 'Pedro Paramo','pedro@email.com', '1234');