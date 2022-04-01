CREATE TABLE clients
(
    id              BIGSERIAL PRIMARY KEY NOT NULL,
    username        VARCHAR(255),
    account_number  VARCHAR(255),
    password        VARCHAR(255),
    current_balance DECIMAL,
    is_deleted      BOOLEAN DEFAULT FALSE NOT NULL,
    bank_id         BIGINT REFERENCES banks (id)
);