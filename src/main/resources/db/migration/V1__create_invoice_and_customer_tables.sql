CREATE TABLE Customer
(
    customer_id INTEGER  NOT NULL,
    first_name NVARCHAR(40)  NOT NULL,
    last_name NVARCHAR(20)  NOT NULL,
    company NVARCHAR(80),
    address NVARCHAR(70),
    city NVARCHAR(40),
    state NVARCHAR(40),
    country NVARCHAR(40),
    postal_code NVARCHAR(10),
    phone NVARCHAR(24),
    fax NVARCHAR(24),
    email NVARCHAR(60)  NOT NULL,
    CONSTRAINT PK_Customer PRIMARY KEY  (customer_id)
);

CREATE TABLE Invoice
(
    invoice_id INTEGER  NOT NULL,
    customer_id INTEGER  NOT NULL,
    invoice_date DATETIME  NOT NULL,
    billing_address NVARCHAR(70),
    billing_city NVARCHAR(40),
    billing_state NVARCHAR(40),
    billing_country NVARCHAR(40),
    billing_postal_code NVARCHAR(10),
    total NUMERIC(10,2)  NOT NULL,
    CONSTRAINT PK_Invoice PRIMARY KEY  (invoice_id),
    FOREIGN KEY (customer_id) REFERENCES Customer (customer_id)
);

INSERT INTO Customer VALUES(1,'Lus','Gonalves','Embraer - Empresa Brasileira de Aeronáutica S.A.','Av. Brigadeiro Faria Lima, 2170','dos Campos','SP','Brazil','12227-000','+55 (12) 3923-5555','+55 (12) 3923-5566','luisg@embraer.com.br');
INSERT INTO Customer VALUES(2, 'a','a','a','Av. Brigadeiro Faria Lima, 2170','dos Campos','SP','Brazil','12227-000','+55 (12) 3923-5555','+55 (12) 3923-5566','luisg@embraer.com.br');

INSERT INTO Invoice VALUES(1,1,'2009-01-01 00:00:00','Theodor-Heuss-Straße 34','Stuttgart',NULL,'Germany','70174',1.980000000000000071);
INSERT INTO Invoice VALUES(2,2,'2010-01-02 00:00:00','s 14','Oslo',NULL,'Norway','0171',3.9599999999999999644);
INSERT INTO Invoice VALUES(3,1,'2009-01-02 00:00:00','Ullevålsveien 14','Oslo',NULL,'Norway','0171',3.9599999999999999644);
INSERT INTO Invoice VALUES(4,1,'2010-01-02 00:00:00','s 14','Oslo',NULL,'Norway','0171',3.9599999999999999644);



CREATE TABLE Account
(
    account_id INTEGER NOT NULL AUTO_INCREMENT,
    account_type TEXT NOT NULL,
    client_id TEXT NOT NULL,
    balance DECIMAL NOT NULL,
    withdraw_allowed BOOLEAN NOT NULL,
    CONSTRAINT PK_Account PRIMARY KEY (account_id)
);

CREATE TABLE Transaction
(
    transaction_id INTEGER NOT NULL AUTO_INCREMENT,
    account_id INTEGER NOT NULL,
    amount DECIMAL NOT NULL,
    client_id TEXT NOT NULL,
    created_at DATE NOT NULL,
    CONSTRAINT PK_Transaction PRIMARY KEY (transaction_id),
    FOREIGN KEY (account_id) REFERENCES Account (account_id)
);