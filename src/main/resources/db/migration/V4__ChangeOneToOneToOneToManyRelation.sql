CREATE SEQUENCE IF NOT EXISTS delivery_items_id_seq;
ALTER TABLE delivery_items
    ALTER COLUMN id SET NOT NULL;
ALTER TABLE delivery_items
    ALTER COLUMN id SET DEFAULT nextval('delivery_items_id_seq');

ALTER SEQUENCE delivery_items_id_seq OWNED BY delivery_items.id;

ALTER TABLE delivery_items
DROP
CONSTRAINT uc_delivery_items_price;