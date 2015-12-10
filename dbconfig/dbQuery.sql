CREATE TABLE role
(
  id bigserial PRIMARY KEY,
  role varchar(20) DEFAULT 'ROLE_USER'
);
INSERT INTO role(role) VALUES ('ROLE_USER');
INSERT INTO role(role) VALUES ('ROLE_ADMIN');

CREATE TABLE users
(
  id bigserial PRIMARY KEY,
  name varchar(20) NOT NULL,
  surname varchar(20) NOT NULL,
  patronymic varchar(20) NOT NULL,
  passport_number varchar(20) UNIQUE NOT NULL,
  unlocked boolean DEFAULT true NOT NULL,
  login varchar(20) UNIQUE NOT NULL,
  password varchar(80) NOT NULL,
  role_id bigint NOT NULL REFERENCES role (id) ON UPDATE NO ACTION ON DELETE NO ACTION
);

INSERT INTO users(name, surname, patronymic, passport_number, unlocked, login, password, role_id)
    VALUES ('James', 'Alan', 'Hetfield', 'HC1235685', true, 'JamesAdmin', '$2a$10$KvTXTKxIvR.JVSs2GZ5YeOrYxnzwR0m2X9Spl1n7V6oDoMCK.eU5u', 2);
INSERT INTO users(name, surname, patronymic, passport_number, unlocked, login, password, role_id)
    VALUES ('Vladzislav', 'Jum', 'Egorovich', 'HB3567812', true, 'vjum', '$2a$10$tDWYYZshaDtaFIcnhUIsg.5PeOETaAIUrF9Eg.yQx6rioCfMzVwgy', 1);
INSERT INTO users(name, surname, patronymic, passport_number, unlocked, login, password, role_id)
    VALUES ('Yulia', 'Juckova', 'Ivanova', 'HV2161943', true, 'yulia', '$2a$10$DmvMxBLCHXxCsjwzrt1TC.piqT./m5HInMMlFD13ToFCnM0lJttG6', 1);
INSERT INTO users(name, surname, patronymic, passport_number, unlocked, login, password, role_id)
    VALUES ('Egor', 'Ignatenko', 'Alecksandrovna', 'HQ2461987', true, 'egor', '$2a$10$OiAEGxVg9q9SIGc0m.2quuJDSG2UYxAaagNJ2ITf2I9zFes2opEfe', 1);
INSERT INTO users(name, surname, patronymic, passport_number, unlocked, login, password, role_id)
    VALUES ('Pavel', 'Semenyako', 'Konstantinovich', 'HB2893164', true, 'pavel', '$2a$10$aJpJOPj37Nrb3/CSEEtqLOJqii64mperrt4TCxK6AHRQjXeJYabBC', 1);
INSERT INTO users(name, surname, patronymic, passport_number, unlocked, login, password, role_id)
    VALUES ('Vadim', 'Volovich', 'Andreevich', 'HK5896421', true, 'vadim', '$2a$10$CIGAu9eLdwwHdNN7jD5ez.fFjPrQwreJ4EHCg6p5fuM8Ifv00tSmq', 1);
INSERT INTO users(name, surname, patronymic, passport_number, unlocked, login, password, role_id)
    VALUES ('Vasiliy', 'Dronov', 'Alexeyevich', 'HX7965214', true, 'vasya', '$2a$10$hJvmtyWaLAgByRU.0vmiduvgjrMSiFVqTXe2r193vYLE/Vo/pTBU2', 1);

CREATE TABLE bank_account
(
  amount_of_money numeric NOT NULL,
  user_id bigint REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE,
  id bigserial PRIMARY KEY,
  account_number varchar(15) UNIQUE NOT NULL
);

INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (556425, 1000000, 2);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (856425, 3200000, 2);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (87654, 3265400, 2);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (112325, 8765400, 2);

CREATE TABLE payment_history
(
  amount_of_money numeric NOT NULL,
  id bigserial PRIMARY KEY,
  user_id bigint NOT NULL REFERENCES users (id) ON UPDATE CASCADE ON DELETE SET NULL,
  number_account_from varchar(15) NOT NULL,
  number_account_to varchar(15) NOT NULL,
  date_time timestamp without time zone NOT NULL
);

CREATE TABLE corporation
(
  id bigserial PRIMARY KEY,
  name varchar(15) UNIQUE NOT NULL,
  account_id bigint UNIQUE NOT NULL REFERENCES bank_account (id) ON UPDATE CASCADE ON DELETE SET NULL
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

INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (123789, 50000, 3);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (875436, 1800000, 3);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (239874, 55000, 4);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (148963, 235000, 4);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (5555886, 752000, 4);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (3987452, 98500, 5);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (4521518, 1393000, 5);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (3698742, 9900, 6);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (1128858, 756000, 6);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (158611, 31000, 6);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (222364, 15000, 7);
INSERT INTO bank_account(account_number, amount_of_money, user_id) VALUES (894841, 129000, 7);