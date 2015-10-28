CREATE TABLE role
(
  id bigserial NOT NULL,
  role character varying(20) DEFAULT 'ROLE_USER'::character varying,
  CONSTRAINT role_pkey PRIMARY KEY (id)
);
INSERT INTO role(id, role) VALUES (1, 'ROLE_USER');
INSERT INTO role(id, role) VALUES (2, 'ROLE_ADMIN');


CREATE TABLE type_account
(
  id bigserial NOT NULL,
  type character varying(20),
  CONSTRAINT type_account_pkey PRIMARY KEY (id)
);
INSERT INTO type_account(id, type) VALUES (1, 'private');
INSERT INTO type_account(id, type) VALUES (2, 'commercial');

CREATE TABLE users
(
  id bigserial NOT NULL,
  name character varying(20),
  surname character varying(20),
  patronymic character varying(20),
  passport_number character varying(20),
  enabled boolean DEFAULT true,
  login character varying(20),
  password character varying(40),
  role_id integer,
  CONSTRAINT users_pkey PRIMARY KEY (id),
  CONSTRAINT users_role_id_fkey FOREIGN KEY (role_id)
      REFERENCES role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT users_login_key UNIQUE (login),
  CONSTRAINT users_passport_number_key UNIQUE (passport_number)
);

INSERT INTO users(name, surname, patronymic, passport_number, enabled, login, password, role_id)
    VALUES ('James', 'Alan', 'Hetfield', 'hc123566985', true, 'JamesAdmin', 'admin', 2);
INSERT INTO users(name, surname, patronymic, passport_number, enabled, login, password, role_id)
    VALUES ('Vladzislav', 'Jum', 'Egorovich', 'fd84846', true, 'user', 'user', 1);



CREATE TABLE bank_account
(
  account_number integer,
  amount_of_money numeric,
  user_id integer,
  id bigserial NOT NULL,
  type_id integer,
  CONSTRAINT bank_account_pkey PRIMARY KEY (id),
  CONSTRAINT bank_account_type_id_fkey FOREIGN KEY (type_id)
      REFERENCES type_account (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT bank_account_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT bank_account_account_number_key UNIQUE (account_number)
);
INSERT INTO bank_account(account_number, amount_of_money, user_id, type_id) VALUES (556425, 1000000, null, 2);
INSERT INTO bank_account(account_number, amount_of_money, user_id, type_id) VALUES (856425, 3200000, null, 2);

INSERT INTO bank_account(account_number, amount_of_money, user_id, type_id) VALUES (87654, 3265400, 2, 1);
INSERT INTO bank_account(account_number, amount_of_money, user_id, type_id) VALUES (112325, 8765400, 2, 1);

