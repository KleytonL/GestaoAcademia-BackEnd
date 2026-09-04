CREATE TABLE autenticacao
(
    id         BIGSERIAL PRIMARY KEY,
    email      VARCHAR(255) NOT NULL UNIQUE,
    senha      VARCHAR(255) NOT NULL,
    usuario_id BIGINT       NOT NULL UNIQUE REFERENCES usuario (id)
);