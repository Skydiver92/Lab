CREATE TABLE users
(
  id               serial PRIMARY KEY,
  email            VARCHAR(355) UNIQUE NOT NULL,
  first_name       VARCHAR(50)         NOT NULL,
  last_name        VARCHAR(50)         NOT NULL,
  password         VARCHAR(50)         NOT NULL,
  status           VARCHAR(50),
  created_at       TIMESTAMP,
  last_modified_at TIMESTAMP
);

CREATE TABLE roles
(
  id        serial PRIMARY KEY,
  role_name VARCHAR(50) NOT NULL
);

CREATE TABLE user_role
(
  user_id    INTEGER NOT NULL,
  role_id    INTEGER NOT NULL,
  PRIMARY KEY (user_id, role_id),
  FOREIGN KEY (role_id)
    REFERENCES roles (id),
  FOREIGN KEY (user_id)
    REFERENCES users (id)
);

-- drop table users;
-- drop table roles;
-- drop table user_role;

