CREATE TYPE status_pagamento AS ENUM ('PENDENTE', 'PAGO', 'VENCIDO');
CREATE TYPE forma_pagamento AS ENUM ('DINHEIRO', 'PIX', 'CARTAO_CREDITO', 'CARTAO_DEBITO');

CREATE TABLE pagamento
(
    id               BIGSERIAL PRIMARY KEY,
    valor            DOUBLE PRECISION,
    data_pagamento   DATE,
    forma_pagamento  forma_pagamento  NOT NULL,
    status           status_pagamento NOT NULL,
    usuario_plano_id BIGINT           NOT NULL UNIQUE REFERENCES usuario_plano (id)
);
