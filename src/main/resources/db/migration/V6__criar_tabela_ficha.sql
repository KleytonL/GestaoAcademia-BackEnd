CREATE TABLE ficha
(
    id           BIGSERIAL PRIMARY KEY,
    nome         VARCHAR(50) NOT NULL,
    descricao    VARCHAR(255),
    data_criacao DATE        NOT NULL DEFAULT CURRENT_DATE,
    usuario_id   BIGINT      NOT NULL REFERENCES usuario (id)
);