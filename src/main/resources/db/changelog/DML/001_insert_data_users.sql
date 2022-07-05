--liquibase formatted sql
--changeset Alex:inset-users-01
INSERT INTO users VALUES(1, 'Alesha1', 'name1', 'lastname1', 'address1', 'email1', 'password1', '+7987654321' );
INSERT INTO users VALUES(2, 'Alesha2', 'name2', 'lastname2', 'address2', 'email2', 'password2', '+7987654320' );
