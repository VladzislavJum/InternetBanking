CREATE TABLE users
(
  id serial NOT NULL,
  username character varying(20),
  surname character varying(20),
  secondname character varying(20),
  passportnumber character varying(20),
  CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE cards
(
  id serial NOT NULL,
  pin_code integer,
  status boolean,
  user_id integer,
  CONSTRAINT cards_pkey PRIMARY KEY (id),
  CONSTRAINT cards_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);