CREATE TABLE usuario
(
    id              BIGSERIAL PRIMARY KEY,
    nome            VARCHAR(255) NOT NULL,
    telefone        VARCHAR(255),
    cpf             VARCHAR(255) NOT NULL,
    data_nascimento DATE,
    is_admin        BOOLEAN      NOT NULL DEFAULT FALSE,
    ativo           BOOLEAN      NOT NULL DEFAULT TRUE
);
