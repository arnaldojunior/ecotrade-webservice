INSERT INTO uf (uf, nome) VALUES ('SP','São Paulo');
INSERT INTO uf (uf, nome) VALUES ('RJ','Rio de Janeiro');
INSERT INTO uf (uf, nome) VALUES ('TO','Tocantins');

INSERT INTO cidade (id, nome, uf_id) VALUES (1,'Palmas','TO');
INSERT INTO cidade (id, nome, uf_id) VALUES (2,'Gurupi','TO');
INSERT INTO cidade (id, nome, uf_id) VALUES (3,'Paraíso','TO');

INSERT INTO categoria (id, nome) VALUES (1,'Eletrônicos');
INSERT INTO categoria (id, nome) VALUES (2,'Telefonia');
INSERT INTO categoria (id, nome) VALUES (3,'Informática');

INSERT INTO usuario (id, nome, cpf, logradouro, bairro, cep, telefone, email, senha, cidade_id) VALUES (1,'João Silva','12345678901','500 SUL, AL 10','Plano Diretor Sul','7777777','99988-7799','joao@gmail.com','joao',1);

INSERT INTO produto (id, nome, descricao, logradouro, bairro, cep, categoria_id, cidade_id, finalidade, valor) VALUES (1,'Iphone X','Smartphone extremamente novo.','400 SUL, AL 15','Plano Diretor Sul','77.777-777',2,1,'VENDA',1500);
INSERT INTO produto (id, nome, descricao, logradouro, bairro, cep, categoria_id, cidade_id, finalidade, valor) VALUES (2,'Desktop Positivo','Computador da Positivo com 1GB de RAM.','900 SUL, AL 15','Plano Diretor Sul','77.777-777',3,1,'DOACAO',null);
INSERT INTO produto (id, nome, descricao, logradouro, bairro, cep, categoria_id, cidade_id, finalidade, valor) VALUES (3,'TV 29','Televisor de tubo da LG.','200 SUL, AL 15','Plano Diretor Sul','77.777-777',1,1,'DOACAO',null);

INSERT INTO anuncio (id, quando, usuario_id, produto_id) VALUES (1, now(), 1, 1);
INSERT INTO anuncio (id, quando, usuario_id, produto_id) VALUES (2, now(), 1, 2);
INSERT INTO anuncio (id, quando, usuario_id, produto_id) VALUES (3, now(), 1, 3);
