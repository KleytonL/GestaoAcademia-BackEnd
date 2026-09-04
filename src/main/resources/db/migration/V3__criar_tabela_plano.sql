CREATE TABLE plano
(
    id        BIGSERIAL PRIMARY KEY,
    nome      VARCHAR(255)     NOT NULL,
    valor     DOUBLE PRECISION NOT NULL,
    duracao   INTEGER          NOT NULL,
    descricao VARCHAR(255),
    ativo     BOOLEAN          NOT NULL DEFAULT TRUE
);