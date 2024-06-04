insert into clientes (id, nome, email) values (1, 'Maria', 'maria@gmail.com');
insert into clientes (id, nome, email) values (2, 'Joao', 'joao@gmail.com');
insert into clientes (id, nome, email) values (3, 'Pedro', 'pedro@gmail.com');
insert into clientes (id, nome, email) values (4, 'Mateus', 'mateus@gmail.com');
insert into clientes (id, nome, email) values (5, 'Marcos', 'marcos@gmail.com');
insert into clientes (id, nome, email) values (6, 'Antonio', 'antonio@gmail.com');
insert into clientes (id, nome, email) values (7, 'Eduarda', 'eduarda@gmail.com');
insert into clientes (id, nome, email) values (8, 'Marta', 'marta@gmail.com');
insert into clientes (id, nome, email) values (9, 'Gabriel', 'gabriel@gmail.com');
insert into clientes (id, nome, email) values (10, 'Alice', 'alice@gmail.com');

insert into aplicativos (id, nome, custo_mensal) values (1, 'Netflix', 40.0);
insert into aplicativos (id, nome, custo_mensal) values (2, 'Prime Video', 20.0);
insert into aplicativos (id, nome, custo_mensal) values (3, 'HBO', 35.0);
insert into aplicativos (id, nome, custo_mensal) values (4, 'Disney', 40.5);
insert into aplicativos (id, nome, custo_mensal) values (5, 'Crunchyroll', 28.0);

insert into assinaturas (id, cliente_id, aplicativo_id, data_inicio, data_fim, status) values (1, 1, 1, '2024-01-01', '2024-02-01', 1);
insert into assinaturas (id, cliente_id, aplicativo_id, data_inicio, data_fim, status) values (2, 2, 2, '2024-01-01', '2024-02-01', 1);
insert into assinaturas (id, cliente_id, aplicativo_id, data_inicio, data_fim, status) values (3, 3, 3, '2024-01-01', '2024-02-01', 1);
insert into assinaturas (id, cliente_id, aplicativo_id, data_inicio, data_fim, status) values (4, 4, 4, '2024-01-01', '2024-02-01', 1);
insert into assinaturas (id, cliente_id, aplicativo_id, data_inicio, data_fim, status) values (5, 7, 5, '2024-01-01', '2024-02-01', 1);