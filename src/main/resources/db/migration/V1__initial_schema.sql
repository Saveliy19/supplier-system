CREATE SEQUENCE IF NOT EXISTS delivery_items_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE deliveries
(
    id            INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    delivery_date date                                     NOT NULL,
    CONSTRAINT pk_deliveries PRIMARY KEY (id)
);

CREATE TABLE delivery_items
(
    id          INTEGER NOT NULL,
    weight_kg   DOUBLE PRECISION,
    delivery_id INTEGER,
    product_id  INTEGER,
    price_id    INTEGER,
    CONSTRAINT pk_delivery_items PRIMARY KEY (id)
);

CREATE TABLE prices
(
    id          INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    price       DOUBLE PRECISION                         NOT NULL,
    start_date  date                                     NOT NULL,
    end_date    date                                     NOT NULL,
    supplier_id INTEGER,
    product_id  INTEGER,
    CONSTRAINT pk_prices PRIMARY KEY (id)
);

CREATE TABLE products
(
    id   INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE suppliers
(
    id   INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_suppliers PRIMARY KEY (id)
);

ALTER TABLE delivery_items
    ADD CONSTRAINT uc_delivery_items_price UNIQUE (price_id);

ALTER TABLE suppliers
    ADD CONSTRAINT uc_suppliers_name UNIQUE (name);

ALTER TABLE delivery_items
    ADD CONSTRAINT FK_DELIVERY_ITEMS_ON_DELIVERY FOREIGN KEY (delivery_id) REFERENCES deliveries (id);

ALTER TABLE delivery_items
    ADD CONSTRAINT FK_DELIVERY_ITEMS_ON_PRICE FOREIGN KEY (price_id) REFERENCES prices (id);

ALTER TABLE delivery_items
    ADD CONSTRAINT FK_DELIVERY_ITEMS_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES products (id);

ALTER TABLE prices
    ADD CONSTRAINT FK_PRICES_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES products (id);

ALTER TABLE prices
    ADD CONSTRAINT FK_PRICES_ON_SUPPLIER FOREIGN KEY (supplier_id) REFERENCES suppliers (id);