CREATE TABLE exercicio
(
    id        BIGSERIAL PRIMARY KEY,
    nome      VARCHAR(100) NOT NULL UNIQUE,
    grupo     VARCHAR(50)  NOT NULL,
    descricao VARCHAR(255)
);