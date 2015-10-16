CREATE TABLE users
(
  cardID serial NOT NULL,
  username character varying(20),
  surname character varying(20),
  secondname character varying(20),
  passportnumber character varying(20),
  CONSTRAINT users_pkey PRIMARY KEY (cardID)
);

CREATE TABLE cards
(
  cardID serial NOT NULL,
  pin_code integer,
  status boolean,
  user_id integer,
  CONSTRAINT cards_pkey PRIMARY KEY (cardID),
  CONSTRAINT cards_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES users (cardID) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);