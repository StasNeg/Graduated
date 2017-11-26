DELETE FROM trucks;
DELETE FROM products;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO trucks (name)
VALUES  ('FIRST'),
        ('SECOND');

INSERT INTO products (name, min_temperature, max_temperature)
VALUES ('FIRST', -12, -7),
        ('SECOND', -18, -12),
        ('THIRD', -18, -12),
        ('FORTH', -5, -3),
        ('FIFTH', 2, 8),
        ('SIXTH', 8, 17);