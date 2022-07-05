--liquibase formatted sql
--changeset Alex:create-user-tables

CREATE IF NOT EXISTS TABLE users(
    user_id  BIGINT PRIMARY KEY,
    login VARCHAR(60) NOT NULL,
    name VARCHAR(60) NOT NULL,
    last_name  VARCHAR(60) NOT NULL,
    address VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL,
    password VARCHAR(60) NOT NULL,
    telephone VARCHAR(60) NOT NULL,
);

-- CREATE TABLE branch(
--    id INT PRIMARY KEY,
--    name VARCHAR(40),
--    emp_id INT,
--    FOREIGN KEY(emp_id) REFERENCES employee(id) ON DELETE CASCADE
-- );
