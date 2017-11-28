DELETE FROM averages;
DELETE FROM trips;
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


INSERT INTO trips (truck, product, trip_date)
VALUES (100000,100002, '2017-11-27T13:00'),
        (100001, 100003,'2017-11-27T13:00'),
        (100000, 100004, '2017-11-27T13:00'),
        (100001, 100005, '2017-11-27T13:00');

INSERT INTO averages (id_trip, averagetemperature, trip_date)
VALUES (100008,-12.7, '2017-11-27T13:00'),
  (100008, -14.7,'2017-11-27T13:00'),
  (100009, -2.7, '2017-11-27T13:00'),
  (100009, 12.7, '2017-11-27T13:00');

