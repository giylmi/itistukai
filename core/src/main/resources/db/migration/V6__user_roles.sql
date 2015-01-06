ALTER TABLE users
    drop COLUMN isAdmin,
    add COLUMN role INT NOT NULL DEFAULT 0;