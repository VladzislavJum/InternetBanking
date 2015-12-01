CREATE TABLE role
(
  id bigserial NOT NULL,
  role character varying(20) DEFAULT 'ROLE_USER'::character varying,
  CONSTRAINT role_pkey PRIMARY KEY (id)
);
INSERT INTO role(role) VALUES ('ROLE_USER');
INSERT INTO role(role) VALUES ('ROLE_ADMIN');

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
  role_id bigint,
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
  user_id bigint,
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

CREATE TABLE payment_history
(
  amount_of_money numeric,
  id bigserial NOT NULL,
  user_id bigint,
  number_account_from character varying(15),
  number_account_to character varying(15),
  date_time timestamp without time zone,
  CONSTRAINT payment_history_pkey PRIMARY KEY (id),
  CONSTRAINT payment_history_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE corporation
(
  id bigserial NOT NULL,
  name character varying(15),
  account_id bigint,
  CONSTRAINT corporation_pkey PRIMARY KEY (id),
  CONSTRAINT corporation_account_id_fkey FOREIGN KEY (account_id)
      REFERENCES bank_account (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT corporation_name_key UNIQUE (name),
  CONSTRAINT corporation_account_id_key UNIQUE (account_id)
);

INSERT INTO bank_account(account_number, amount_of_money) VALUES ('FlyNet111', 1000000);
INSERT INTO bank_account(account_number, amount_of_money) VALUES ('Infolan222', 1000000);
INSERT INTO bank_account(account_number, amount_of_money) VALUES ('TCM333', 1000000);
INSERT INTO bank_account(account_number, amount_of_money) VALUES ('QLINE444', 1000000);
INSERT INTO bank_account(account_number, amount_of_money) VALUES ('NetBerry555', 1000000);
INSERT INTO bank_account(account_number, amount_of_money) VALUES ('UNET666', 1000000);
INSERT INTO corporation(name, account_id) VALUES ('FlyNet', 5);
INSERT INTO corporation(name, account_id) VALUES ('Infolan', 6);
INSERT INTO corporation(name, account_id) VALUES ('TCM', 7);
INSERT INTO corporation(name, account_id) VALUES ('QLINE', 8);
INSERT INTO corporation(name, account_id) VALUES ('NetBerry', 9);
INSERT INTO corporation(name, account_id) VALUES ('UNET', 10);

INSERT INTO bank_account(account_number, amount_of_money) VALUES ('MTC111', 1000000);
INSERT INTO bank_account(account_number, amount_of_money) VALUES ('VELCOM222', 1000000);
INSERT INTO bank_account(account_number, amount_of_money) VALUES ('LIFE333', 1000000);
INSERT INTO corporation(name, account_id) VALUES ('MTC', 11);
INSERT INTO corporation(name, account_id) VALUES ('VELCOM', 12);
INSERT INTO corporation(name, account_id) VALUES ('LIFE', 13);

INSERT INTO bank_account(account_number, amount_of_money) VALUES ('gas111', 1000000);
INSERT INTO bank_account(account_number, amount_of_money) VALUES ('Water222', 1000000);
INSERT INTO bank_account(account_number, amount_of_money) VALUES ('Electricity333', 1000000);
INSERT INTO corporation(name, account_id) VALUES ('Water', 14);
INSERT INTO corporation(name, account_id) VALUES ('Gas', 15);
INSERT INTO corporation(name, account_id) VALUES ('Electricity', 16);
