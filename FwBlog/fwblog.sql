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
  UNIQUE KEY UK_users_email (email)
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
  user_id         INT(20),
  PRIMARY KEY (id),
  KEY 'posts_of_user_id' ('user_id'),
  CONSTRAINT 'posts_of_user_id' FOREIGN KEY ('user_id') REFERENCES 'users' ('id')
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS tags;
CREATE TABLE `tags` (
  `id`        BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `createdAt` DATETIME     NOT NULL,
  `updatedAt` DATETIME     NOT NULL,
  `name`      VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_tags_name` (`name`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS posts_tags;
CREATE TABLE posts_tags (
  post_id INT(20) NOT NULL,
  tag_id  INT(20) NOT NULL,
  PRIMARY KEY ('post_id', 'tag_id'),
  KEY 'FK_tag_id' ('tag_id'),
  CONSTRAINT 'FK_tag_id' FOREIGN KEY ('tag_id') REFERENCES 'tags' ('id'),
  CONSTRAINT 'FK_post_id' FOREIGN KEY ('post_id') REFERENCES 'posts' ('id')
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS settings;
CREATE TABLE `settings` (
  `id`        BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `createdAt` DATETIME     NOT NULL,
  `updatedAt` DATETIME     NOT NULL,
  `_key`      VARCHAR(255) NOT NULL,
  `_value`    LONGBLOB,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_settings_key` (`_key`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;