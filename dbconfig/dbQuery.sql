CREATE TABLE role
(
  id bigserial NOT NULL,
  role character varying(20) DEFAULT 'ROLE_USER'::character varying,
  CONSTRAINT role_pkey PRIMARY KEY (id)
);
INSERT INTO role(id, role) VALUES (1, 'ROLE_USER');
INSERT INTO role(id, role) VALUES (2, 'ROLE_ADMIN');

CREATE TABLE users
(
  id bigserial NOT NULL,
  name character varying(20),
  surname character varying(20),
  patronymic character varying(20),
  passport_number character varying(20),
  unlocked boolean DEFAULT true,
  login character varying(20),
  password character varying(80),
  role_id integer,
  CONSTRAINT users_pkey PRIMARY KEY (id),
  CONSTRAINT users_role_id_fkey FOREIGN KEY (role_id)
      REFERENCES role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT users_login_key UNIQUE (login),
  CONSTRAINT users_passport_number_key UNIQUE (passport_number)
);

INSERT INTO users(name, surname, patronymic, passport_number, unlocked, login, password, role_id)
    VALUES ('James', 'Alan', 'Hetfield', 'hc1235685', true, 'JamesAdmin', '$2a$10$KvTXTKxIvR.JVSs2GZ5YeOrYxnzwR0m2X9Spl1n7V6oDoMCK.eU5u', 2);
INSERT INTO users(name, surname, patronymic, passport_number, unlocked, login, password, role_id)
    VALUES ('Vladzislav', 'Jum', 'Egorovich', 'HB2469876', true, 'vjum', '$2a$10$tDWYYZshaDtaFIcnhUIsg.5PeOETaAIUrF9Eg.yQx6rioCfMzVwgy', 1);

CREATE TABLE bank_account
(
  amount_of_money numeric,
  user_id integer,
  id bigserial NOT NULL,
  account_number character varying(15),
  CONSTRAINT bank_account_pkey PRIMARY KEY (id),
  CONSTRAINT bank_account_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT bank_account_account_number_key UNIQUE (account_number)
);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (556425, 1000000, 2);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (856425, 3200000, 2);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (87654, 3265400, 2);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (112325, 8765400, 2);

