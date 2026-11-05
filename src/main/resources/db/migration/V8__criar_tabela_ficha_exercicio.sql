CREATE TABLE ficha_exercicio
(
    id           BIGSERIAL PRIMARY KEY,
    ficha_id     BIGINT NOT NULL REFERENCES ficha (id) ON DELETE CASCADE,
    exercicio_id BIGINT NOT NULL REFERENCES exercicio (id),
    series       INT    NOT NULL CHECK (series > 0),
    repeticoes   INT    NOT NULL CHECK (repeticoes > 0),
    carga        INT    NOT NULL CHECK (carga >= 0),
    descanso     INT    NOT NULL CHECK (descanso >= 0)
);