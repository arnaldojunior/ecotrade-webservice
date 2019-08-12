INSERT INTO uf (uf, nome) VALUES ('SP','São Paulo')
INSERT INTO uf (uf, nome) VALUES ('RJ','Rio de Janeiro')
INSERT INTO uf (uf, nome) VALUES ('TO','Tocantins')

INSERT INTO cidade (id, nome, uf_id) VALUES (1,'Palmas','TO')
INSERT INTO cidade (id, nome, uf_id) VALUES (2,'Gurupi','TO')
INSERT INTO cidade (id, nome, uf_id) VALUES (3,'Paraíso','TO')

INSERT INTO categoria (id, nome) VALUES (1,'Eletrônicos')
INSERT INTO categoria (id, nome) VALUES (2,'Telefonia')
INSERT INTO categoria (id, nome) VALUES (3,'Informática')

INSERT INTO usuario (id, nome, cpf, telefone, email, senha) VALUES (1,'João Silva','12345678901','99988-7799','joao@gmail.com','joao')

INSERT INTO produto (id, nome, descricao) VALUES (1, 'Iphone X', 'Smartphone novo.');
INSERT INTO produto (id, nome, descricao) VALUES (2, 'Notebook Dell', 'Computador com 4GB de RAM.');
INSERT INTO produto (id, nome, descricao) VALUES (3, 'TV 29', 'Televisor de tubo da LG.');
INSERT INTO produto (id, nome, descricao) VALUES (4, 'Samsung S10', 'Smartphone da Samsung em bom estado. Pouco tempo de uso.');
INSERT INTO produto (id, nome, descricao) VALUES (5, 'Televisor Philco', 'Televisor de tela plana, 40 polegadas.');

INSERT INTO anuncio (id, produto_id, quando, logradouro, bairro, cep, categoria_id, cidade_id, finalidade, valor, anunciante_id, numero) VALUES (1, 1, now(), '400 SUL, AL 15','Plano Diretor Sul','77.777-777',2,1,'VENDA',1500, 1, 10)
INSERT INTO anuncio (id, produto_id, quando, logradouro, bairro, cep, categoria_id, cidade_id, finalidade, valor, anunciante_id, numero) VALUES (2, 2, now(), '900 SUL, AL 15','Plano Diretor Sul','77.777-777',3,1,'DOACAO',null, 1, 10)
INSERT INTO anuncio (id, produto_id, quando, logradouro, bairro, cep, categoria_id, cidade_id, finalidade, valor, anunciante_id, numero) VALUES (3, 3, now(), '200 SUL, AL 15','Plano Diretor Sul','77.777-777',1,1,'DOACAO',null, 1, 10)
INSERT INTO anuncio (id, produto_id, quando, logradouro, bairro, cep, categoria_id, cidade_id, finalidade, valor, anunciante_id, numero) VALUES (4, 4, now(), '200 SUL, AL 15','Plano Diretor Sul','77.777-777',2,1,'DOACAO',null, 1, 10)
INSERT INTO anuncio (id, produto_id, quando, logradouro, bairro, cep, categoria_id, cidade_id, finalidade, valor, anunciante_id, numero) VALUES (5, 5, now(), '200 SUL, AL 15','Plano Diretor Sul','77.777-777',1,1,'VENDA',800, 1, 10)

