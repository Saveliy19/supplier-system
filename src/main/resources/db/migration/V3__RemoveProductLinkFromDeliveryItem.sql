ALTER TABLE delivery_items
DROP
CONSTRAINT fk_delivery_items_on_product;

ALTER TABLE delivery_items
DROP
COLUMN product_id;

DROP SEQUENCE delivery_items_seq CASCADE;

CREATE SEQUENCE IF NOT EXISTS delivery_items_id_seq;
ALTER TABLE delivery_items
    ALTER COLUMN id SET NOT NULL;
ALTER TABLE delivery_items
    ALTER COLUMN id SET DEFAULT nextval('delivery_items_id_seq');

ALTER SEQUENCE delivery_items_id_seq OWNED BY delivery_items.id;