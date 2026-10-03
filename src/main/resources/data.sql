INSERT INTO autores (nome, nacionalidade) VALUES ('Machado de Assis', 'Brasileira');
INSERT INTO autores (nome, nacionalidade) VALUES ('J.K. Rowling', 'Britânica');
INSERT INTO autores (nome, nacionalidade) VALUES ('George Orwell', 'Britânica');
INSERT INTO autores (nome, nacionalidade) VALUES ('Clarice Lispector', 'Brasileira');
INSERT INTO autores (nome, nacionalidade) VALUES ('J.R.R. Tolkien', 'Britânica');

INSERT INTO usuarios (nome, email) VALUES ('Ana Souza', 'ana.souza@email.com');
INSERT INTO usuarios (nome, email) VALUES ('Carlos Lima', 'carlos.lima@email.com');
INSERT INTO usuarios (nome, email) VALUES ('Beatriz Alves', 'beatriz.alves@email.com');
INSERT INTO usuarios (nome, email) VALUES ('Diego Ferreira', 'diego.ferreira@email.com');
INSERT INTO usuarios (nome, email) VALUES ('Fernanda Costa', 'fernanda.costa@email.com');

INSERT INTO livros (titulo, isbn, autor_id, ano_publicacao, quantidade_estoque) VALUES ('Dom Casmurro', '978-85-359-0277-5', 1, 1899, 5);
INSERT INTO livros (titulo, isbn, autor_id, ano_publicacao, quantidade_estoque) VALUES ('Harry Potter e a Pedra Filosofal', '978-85-325-1100-4', 2, 1997, 8);
INSERT INTO livros (titulo, isbn, autor_id, ano_publicacao, quantidade_estoque) VALUES ('1984', '978-85-359-0472-4', 3, 1949, 3);
INSERT INTO livros (titulo, isbn, autor_id, ano_publicacao, quantidade_estoque) VALUES ('A Hora da Estrela', '978-85-209-2165-6', 4, 1977, 4);
INSERT INTO livros (titulo, isbn, autor_id, ano_publicacao, quantidade_estoque) VALUES ('O Senhor dos Anéis', '978-85-325-2988-7', 5, 1954, 6);

INSERT INTO emprestimos (livro_id, usuario_id, data_emprestimo, data_devolucao_prevista, data_devolucao_real, status)
VALUES (1, 1, '2026-09-01', '2026-09-15', '2026-09-14', 'DEVOLVIDO');

INSERT INTO emprestimos (livro_id, usuario_id, data_emprestimo, data_devolucao_prevista, data_devolucao_real, status)
VALUES (2, 2, '2026-09-20', '2026-10-04', NULL, 'ATIVO');

INSERT INTO emprestimos (livro_id, usuario_id, data_emprestimo, data_devolucao_prevista, data_devolucao_real, status)
VALUES (3, 3, '2026-08-15', '2026-08-29', NULL, 'ATRASADO');

INSERT INTO emprestimos (livro_id, usuario_id, data_emprestimo, data_devolucao_prevista, data_devolucao_real, status)
VALUES (4, 4, '2026-09-25', '2026-10-09', NULL, 'ATIVO');

INSERT INTO emprestimos (livro_id, usuario_id, data_emprestimo, data_devolucao_prevista, data_devolucao_real, status)
VALUES (5, 5, '2026-09-10', '2026-09-24', '2026-09-22', 'DEVOLVIDO');