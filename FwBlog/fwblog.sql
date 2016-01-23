CREATE DATABASE IF NOT EXISTS fwblog;

USE fwblog;

DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id         INT(20)   NOT NULL AUTO_INCREMENT,
  creatTime  TIMESTAMP NOT NULL DEFAULT current_timestamp,
  updateTime TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  email      VARCHAR(150)       DEFAULT NULL,
  password   VARCHAR(150)       DEFAULT NULL,
  role       VARCHAR(50)        DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE (email)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS posts;
CREATE TABLE posts (
  id              INT(20)      NOT NULL AUTO_INCREMENT,
  creatTime       TIMESTAMP    NOT NULL DEFAULT current_timestamp,
  updateTime      TIMESTAMP    NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  content         LONGTEXT              DEFAULT NULL,
  renderedContent LONGTEXT              DEFAULT NULL,
  permalink       VARCHAR(150)          DEFAULT NULL,
  postFormat      VARCHAR(150) NOT NULL,
  postStatus      VARCHAR(150) NOT NULL,
  postType        VARCHAR(150) NOT NULL,
  title           VARCHAR(150) NOT NULL,
  u_id            INT(20)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;