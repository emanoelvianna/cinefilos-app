--
-- Genero

insert into generos(nome) values('Ação');
insert into generos(nome) values('Aventura');
insert into generos(nome) values('Animação');
insert into generos(nome) values('Comédia');
insert into generos(nome) values('Romance');
insert into generos(nome) values('Suspense');
insert into generos(nome) values('Terror');
insert into generos(nome) values('Thriller');
insert into generos(nome) values('Ficção');


--
-- Idioma

insert into idiomas(nome) values('Português');
insert into idiomas(nome) values('Inglês');
insert into idiomas(nome) values('Japonês');
insert into idiomas(nome) values('Espanhol');
insert into idiomas(nome) values('Francês');
insert into idiomas(nome) values('Italiano');
insert into idiomas(nome) values('Chinês');


--
-- Filme
insert into filmes(titulo, data_lancamento, duracao, diretor, class_indicativa, imagem_cartaz_path, sinopse)
values ('Star Wars: The Force Awakens', (to_date('18/12/2016', 'DD/MM/YYYY')), '02:10:00', 'J. J. Abrams', 12, 'cartaz1.png', 'Sinopse star wars');

insert into filmes(titulo, data_lancamento, duracao, diretor, class_indicativa, imagem_cartaz_path, sinopse)
values ('Ghost In The Shell', (to_date('09/02/2017', 'DD/MM/YYYY')), '01:55:00', 'Rupert Sanders', 16, 'cartaz2.png', 'Sinopse Ghost in the shell');




--
-- Filmes / Generos

insert into filmes_generos(cod_filme, cod_genero)
values(1, 2);

insert into filmes_generos(cod_filme, cod_genero)
values(1, 9);

insert into filmes_generos(cod_filme, cod_genero)
values(2, 1);

insert into filmes_generos(cod_filme, cod_genero)
values(2, 9);




--
-- Salas

insert into salas (numero, lugares, status, fileiras)
values(1, 80, '0', 10);

insert into salas (numero, lugares, status, fileiras)
values(2, 20, '0', 4);

insert into salas (numero, lugares, status, fileiras)
values(3, 10, '0', 2);



--
-- Sessoes

insert into sessoes (horario_sessao, data_sessao, cod_filme, cod_sala, cod_idioma, legendado)
values ('14:00:00', (to_date('03/07/2017', 'DD/MM/YYYY')), 1, 1, 1, '0');

insert into sessoes (horario_sessao, data_sessao, cod_filme, cod_sala, cod_idioma, legendado)
values ('16:00:00', (to_date('03/07/2017', 'DD/MM/YYYY')), 1, 1, 1, '0');

insert into sessoes (horario_sessao, data_sessao, cod_filme, cod_sala, cod_idioma, legendado)
values ('18:00:00', (to_date('03/07/2017', 'DD/MM/YYYY')), 1, 1, 1, '0');

insert into sessoes (horario_sessao, data_sessao, cod_filme, cod_sala, cod_idioma, legendado)
values ('15:00:00', (to_date('03/07/2017', 'DD/MM/YYYY')), 2, 1, 1, '0');

insert into sessoes (horario_sessao, data_sessao, cod_filme, cod_sala, cod_idioma, legendado)
values ('17:00:00', (to_date('03/07/2017', 'DD/MM/YYYY')), 2, 1, 1, '0');

insert into sessoes (horario_sessao, data_sessao, cod_filme, cod_sala, cod_idioma, legendado)
values ('19:00:00', (to_date('03/07/2017', 'DD/MM/YYYY')), 2, 3, 2, '1');


--
-- Usuario
insert into usuarios(login, senha, permissao) VALUES ('gerente', 'senhagerente', 0);
insert into usuarios(login, senha, permissao) VALUES ('atendente', 'senhaatendente', 1);


--
-- Funcionario

insert into funcionarios(cargo, nome, data_nascimento, estado, cidade, bairro, logradouro, sexo, telefone, cod_usuario)
values ('gerente', 'gerente 1', (to_date('07/03/1982', 'DD/MM/YYYY')), 'Rio Grande do Sul', 'Porto Alegre', 'Sarandi', 'Av. Assis Brasil 5200', 'M', '5133002192', 1);

insert into funcionarios(cargo, nome, data_nascimento, estado, cidade, bairro, logradouro, sexo, telefone, cod_usuario)
values ('atendente', 'atendente 1', (to_date('02/06/1997', 'DD/MM/YYYY')), 'Rio Grande do Sul', 'Porto Alegre', 'Cidade Baixa', 'Av. Lima e Silva 200', 'F', '5132981123', 2);



--
-- Formas pagamento
insert into formas_pagamento (nome) values('dinheiro');
insert into formas_pagamento (nome) values('cartao de debito');
insert into formas_pagamento (nome) values('cartao de credito');


--
-- Vendas




--
-- Ingressos

insert into ingressos (valor, no_assento, promocao, necessidades_especiais, cod_sessao)
values (30.00, 1, '0', '0', 6);

insert into ingressos (valor, no_assento, promocao, necessidades_especiais, cod_sessao)
values (30.00, 2, '0', '0', 6);

insert into ingressos (valor, no_assento, promocao, necessidades_especiais, cod_sessao)
values (30.00, 3, '0', '0', 6);

insert into ingressos (valor, no_assento, promocao, necessidades_especiais, cod_sessao)
values (30.00, 4, '0', '0', 6);

insert into ingressos (valor, no_assento, promocao, necessidades_especiais, cod_sessao)
values (30.00, 5, '0', '0', 6);

insert into ingressos (valor, no_assento, promocao, necessidades_especiais, cod_sessao)
values (30.00, 6, '0', '0', 6);

insert into ingressos (valor, no_assento, promocao, necessidades_especiais, cod_sessao)
values (30.00, 7, '0', '0', 6);



--
-- Queries

-- Retorna cod_sessao e quantidade de ingressos vendidos (por cod_sessao)
--
SELECT s.cod_sessao AS sessao, sl.numero AS sala, s.data_sessao AS data, 
  s.horario_sessao AS hora, sl.lugares AS capacidade, 
  COUNT(i.cod_ingresso) AS vendidos,
  (sl.lugares-COUNT(i.cod_ingresso)) AS livres  FROM sessoes s
LEFT OUTER JOIN ingressos i ON (s.cod_sessao = i.cod_sessao)
INNER JOIN salas sl ON (sl.cod_sala = s.cod_sala)
GROUP BY s.cod_sessao, sl.cod_sala
ORDER BY s.cod_sessao;



-- Exemplo de transacao para insercao de venda 
--

begin transaction;
insert into vendas (data_venda, hora_venda, cod_forma_pagamento, cod_funcionario, cod_cliente, nota_fiscal)
values(current_date, current_time, 1, 1, NULL, 1);

insert into ingressos (valor, no_assento, promocao, necessidades_especiais, cod_sessao)
values (100.00, 9, '0', '0', 1);

insert into ingressos_vendas (cod_venda, cod_ingresso)
values (currval('vendas_cod_venda_seq'), currval('ingressos_cod_ingresso_seq'));

commit;




-- Listagem de itens de uma venda
--
SELECT v.cod_venda, i_v.cod_ingresso AS codigo_item, fil.titulo AS item FROM vendas v
INNER JOIN ingressos_vendas i_v ON (v.cod_venda = i_v.cod_venda)
INNER JOIN ingressos ing ON (i_v.cod_ingresso = ing.cod_ingresso)
INNER JOIN sessoes sess ON (ing.cod_sessao = sess.cod_sessao)
INNER JOIN filmes fil ON (sess.cod_filme = fil.cod_filme)
union
SELECT v.cod_venda, a_v.cod_alimento AS codigo_item, al.nome AS item FROM vendas v
INNER JOIN alimentos_vendas a_v ON(v.cod_venda = a_v.cod_venda)
INNER JOIN alimentos al ON (a_v.cod_alimento = al.cod_alimento);

