DELETE FROM trucks;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO trucks (name)
VALUES  ('FIRST'),
        ('SECOND');

