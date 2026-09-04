CREATE TYPE status_usuario_plano AS ENUM ('ATIVO', 'INATIVO', 'CANCELADO');

CREATE TABLE usuario_plano
(
    id          BIGSERIAL PRIMARY KEY,
    data_inicio DATE,
    data_fim    DATE,
    status      status_usuario_plano NOT NULL,
    usuario_id  BIGINT               NOT NULL UNIQUE REFERENCES usuario (id),
    plano_id    BIGINT               NOT NULL UNIQUE REFERENCES plano (id)
);
