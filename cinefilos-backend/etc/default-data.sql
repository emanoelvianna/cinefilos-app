--
-- Genero

insert into genero(nome) values('Ação');
insert into genero(nome) values('Aventura');
insert into genero(nome) values('Comédia');
insert into genero(nome) values('Romance');
insert into genero(nome) values('Suspense');
insert into genero(nome) values('Terror');
insert into genero(nome) values('Thriller');
insert into genero(nome) values('Ficção');


--
-- Usuario
insert into usuario(login, senha, permissao) VALUES ('gerente', 'senhagerente', 0);
insert into usuario(login, senha, permissao) VALUES ('atendente', 'senhaatendente', 1);


--
-- Funcionario

insert into funcionario (cargo, nome, data_nascimento, estado, cidade, bairro, logradouro, sexo, telefone)
values ('gerente', 'gerente 1', (to_date('07/03/1982', 'DD/MM/YYYY')), 'Rio Grande do Sul', 'Porto Alegre', 'Sarandi', 'Av. Assis Brasil 5200', 'M', 33002192);

insert into funcionario (cargo, nome, data_nascimento, estado, cidade, bairro, logradouro, sexo, telefone)
values ('atendente', 'atendente 1', (to_date('02/06/1997', 'DD/MM/YYYY')), 'Rio Grande do Sul', 'Porto Alegre', 'Cidade Baixa', 'Av. Lima e Silva 200', 'F', 32981123);


--
-- Filme
insert into filme (titulo, data_lancamento, duracao, diretor, class_indicativa, idioma, imagem_cartaz)
values ('Star Wars: The Force Awakens', (to_date('18/12/2016', 'DD/MM/YYYY')), '02:10:00', 'J. J. Abrams', 12, 'ingles', '1111111111');

insert into filme (titulo, data_lancamento, duracao, diretor, class_indicativa, idioma, imagem_cartaz)
values ('Ghost In The Shell', (to_date('09/02/2017', 'DD/MM/YYYY')), '01:55:00', 'Rupert Sanders', 14, 'japones', '1111111111');
