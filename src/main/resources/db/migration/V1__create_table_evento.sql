-- V1_CREATE_TABLE_EVENTS.SQL
CREATE TABLE Eventos(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    identificador VARCHAR(255) NOT NULL UNIQUE,
    data_inicio_evento TIMESTAMP NOT NULL,
    data_fim_evento TIMESTAMP NOT NULL,
    local_do_evento VARCHAR(255) NOT NULL,
    capacidade INTEGER NOT NULL,
    organizador VARCHAR(255) NOT NULL,
    tipo_de_evento VARCHAR(100)
);
