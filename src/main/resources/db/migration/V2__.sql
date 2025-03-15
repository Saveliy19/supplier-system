ALTER TABLE products
    ADD CONSTRAINT uc_products_name UNIQUE (name);

ALTER TABLE products
    ALTER COLUMN name SET NOT NULL;