CREATE TABLE payments
(
    id           BIGSERIAL PRIMARY KEY NOT NULL,
    created_date DATE                  NOT NULL,
    amount       DECIMAL               NOT NULL,
    client_id    BIGINT                NOT NULL REFERENCES clients (id),
    is_deleted   BOOLEAN DEFAULT FALSE NOT NULL,
    status       VARCHAR(50)
);