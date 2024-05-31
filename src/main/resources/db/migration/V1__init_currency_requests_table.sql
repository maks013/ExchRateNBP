CREATE TABLE currency_requests
(
    id             BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    currency       VARCHAR(3) NOT NULL,
    name           VARCHAR(255) NOT NULL,
    date           TIMESTAMP  NOT NULL,
    currency_value DOUBLE PRECISION
);
