ALTER TABLE users
    ADD CONSTRAINT unique_email UNIQUE (email),
    ADD CONSTRAINT unique_login UNIQUE (login);