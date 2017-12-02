DROP TABLE IF EXISTS averages;
DROP TABLE IF EXISTS warn;
DROP TABLE IF EXISTS trips;
DROP TABLE IF EXISTS trucks;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;
DROP SEQUENCE IF EXISTS global_seq_user;

CREATE SEQUENCE global_seq START 100000;
CREATE SEQUENCE global_seq_user START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq_user'),
  name       VARCHAR                  NOT NULL,
  email      VARCHAR                  NOT NULL,
  password   VARCHAR                  NOT NULL,
  registered TIMESTAMP DEFAULT now()  NOT NULL,
  enabled    BOOL DEFAULT TRUE        NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);


CREATE TABLE products
(
  id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name            VARCHAR NOT NULL,
  max_temperature INTEGER NOT NULL,
  min_temperature INTEGER NOT NULL

);
CREATE UNIQUE INDEX products_unique_name_idx
  ON products (name);

CREATE TABLE trucks
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name            VARCHAR NOT NULL
);
CREATE UNIQUE INDEX truck_unique_name_idx
  ON trucks (name);

CREATE TABLE trips
(
  id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  truck     INTEGER   ,
  product   INTEGER   ,
  trip_date TIMESTAMP NOT NULL
);

CREATE TABLE averages
(
  id                 INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  id_trip            INTEGER          NOT NULL,
  averageTemperature DOUBLE PRECISION NOT NULL,
  trip_date          TIMESTAMP        NOT NULL
);

CREATE TABLE warn
(
  id                 INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  id_trip            INTEGER NOT NULL,
  exceed_temperature INTEGER,
  lower_temperature  INTEGER,
  trip_date          TIMESTAMP NOT NULL
);



