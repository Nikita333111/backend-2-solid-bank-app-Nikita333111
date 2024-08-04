CREATE TABLE Client
(
    client_id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    email VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE Account
(
    account_id VARCHAR(10) PRIMARY KEY,
    dtype VARCHAR(31),
    account_type VARCHAR(20) NOT NULL,
    client_id VARCHAR(10) NOT NULL REFERENCES Client(client_id),
    balance DOUBLE NOT NULL,
    withdraw_allowed BOOLEAN NOT NULL
);

CREATE TABLE Transaction
(
    transaction_id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    account_id VARCHAR(10) NOT NULL REFERENCES Account(account_id),
    amount DOUBLE NOT NULL,
    client_id VARCHAR(10) NOT NULL REFERENCES Client(client_id),
    created_at DATE NOT NULL,
    transaction_type VARCHAR(20) NOT NULL
);